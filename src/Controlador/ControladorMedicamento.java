/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.MedicamentoDAO;
import java.util.ArrayList;
import VO.Medicamento;

/**
 *
 * @author HP GABY
 */
public class ControladorMedicamento {

    ArrayList<Medicamento> medicamentos;
    private final MedicamentoDAO daoM;

    public ControladorMedicamento() {
        medicamentos = new ArrayList<>();
        daoM = new MedicamentoDAO();

    }

    public Medicamento buscarMedicamento(String nom) {

        daoM.conectar();
        for (int i = 0; i < daoM.obtenerMedicamentos().size(); i++) {
            String ce = daoM.obtenerMedicamentos().get(i).getNombre();
            if (ce.equals(nom)) {
                return daoM.obtenerMedicamentos().get(i);
            }
        }
        daoM.desconectar();
        return null;

    }

    public boolean RegistrarMedicamento(Medicamento m) {

        daoM.conectar();
        boolean ban = daoM.insertarMedicamento(m);
        daoM.desconectar();
        return ban;
    }

    public boolean modificarMedicamento(Medicamento m) {
        daoM.conectar();
        boolean ban = daoM.modificarMedicamento(m);
        daoM.desconectar();
        return ban;
    }

    public boolean eliminarMedicamento(String nom) {
        daoM.conectar();
        boolean ban = daoM.eliminarMedicamento(nom);
        daoM.desconectar();
        return ban;
    }

    public ArrayList<Medicamento> obtenerMedicamento() {
        daoM.conectar();
        ArrayList<Medicamento> us = daoM.obtenerMedicamentos();
        daoM.desconectar();
        return us;
    }

}
