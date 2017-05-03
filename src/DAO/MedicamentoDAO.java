/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import VO.Medicamento;

/**
 *
 * @author HP GABY
 */
public class MedicamentoDAO {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public void conectar() {
        System.out.println("metodo conectar");
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Registro exitoso");

            String database = "agendamedica";
            String usuario = "admin";
            String clave = "admin";
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/" + database + "?"
                    + "user=" + usuario + "&password=" + clave);

        } catch (Exception e) {

            System.out.println("Error en la conexion" + e);
        }

    }

    public boolean insertarMedicamento(Medicamento m) {
        boolean ban = false;
        try {

            String sql = "INSERT INTO medicamento VALUES('" + m.getNombre()
                    + "','" + m.getCantidad()+ "')";
            stm = con.createStatement();
            ban = stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DAO.MedicamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ban;
    }

    public boolean modificarMedicamento(Medicamento m) {

        try {

            String sql = "UPDATE medicamento SET cantidad = '"
                    + m.getCantidad()+ "' WHERE nombre ='"
                    + m.getNombre()+ "'";
            System.out.print(sql);
            stm = con.createStatement();
            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DAO.MedicamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false ;
        }

        return true;
    }

    public boolean eliminarMedicamento(String nom) {
        boolean ban = false;
        try {

            String sql = "DELETE FROM medicamento WHERE nombre = '" + nom + "'";
            stm = con.createStatement();
            ban = stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DAO.MedicamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ban;
    }

    public ArrayList<Medicamento> obtenerMedicamentos() {
        ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
        try {

            String sql = "SELECT * FROM medicamento";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {

                String nombre = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                Medicamento me = new Medicamento(nombre, cantidad);
                medicamentos.add(me);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.MedicamentoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return medicamentos;
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.MedicamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
