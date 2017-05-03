/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import VO.Profesional;

public class ProfesionalDao {

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

    public boolean insertarProfesional(Profesional p) {
        boolean ban = false;
        try {

            String sql = "INSERT INTO profesional VALUES('" + p.getNombre()
                    + "','" + p.getCedula() + "','" + p.getNumCel() + "','"
                    + p.getRm() + "','" + p.getEspecializacion() + "')";
            stm = con.createStatement();
            ban = stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ban;
    }
//
//    public boolean modificarProfesional(Profesional p) {
//
//        try {
//
//            String sql = "UPDATE profesional SET nombre = '"
//                    + p.getNombre() + "',cedula = '"
//                    + p.getCedula() + "',numCel= '"
//                    + p.getNumCel() + "',rm ="
//                    + p.getRm() + ", especializacion = '"
//                    + p.getEspecializacion() + "' WHERE cedula ='"
//                    + p.getCedula() + "'";
//            System.out.print(sql);
//            stm = con.createStatement();
//            stm.execute(sql);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//
//        return true;
//    }

    public boolean eliminarProfesional(String ced) {
        boolean ban = false;
        try {

            String sql = "DELETE FROM profesional WHERE cedula = '" + ced + "'";
            stm = con.createStatement();
            ban = stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ban;
    }

    public ArrayList<Profesional> obtenerProfesionals() {
        ArrayList<Profesional> profesionales = new ArrayList<Profesional>();
        try {

            String sql = "SELECT * FROM profesional";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String cedula = rs.getString("cedula");
                String numCel = rs.getString("numCel");
                String rm = rs.getString("rm");
                String especializacion = rs.getString("especializacion");
                Profesional pro = new Profesional(nombre, cedula, numCel, rm, especializacion);
                profesionales.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return profesionales;
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
