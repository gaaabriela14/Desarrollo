/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ProfesionalDao;
import java.util.ArrayList;
import VO.Profesional;

/**
 *
 * @author compaq
 */
public class ControladorProfesional {

    ArrayList<Profesional> usuarios;
    private final ProfesionalDao dao;

    public ControladorProfesional() {
        usuarios = new ArrayList<>();
        dao = new ProfesionalDao();

    }

    public Profesional buscarProfesional(String ced) {

        dao.conectar();
        for (int i = 0; i < dao.obtenerProfesionals().size(); i++) {
            String ce = dao.obtenerProfesionals().get(i).getCedula();
            if (ce.equals(ced)) {
                return dao.obtenerProfesionals().get(i);
            }
        }
        dao.desconectar();
        return null;

    }

    public boolean RegistrarProfesional(Profesional p) {

        dao.conectar();
        boolean ban = dao.insertarProfesional(p);
        dao.desconectar();
        return ban;
    }

//    public boolean modificarProfesional(Profesional p) {
//        dao.conectar();
//        boolean ban = dao.modificarProfesional(p);
//        dao.desconectar();
//        return ban;
//    }

    public boolean eliminarProfesional(String ced) {
        dao.conectar();
        boolean ban = dao.eliminarProfesional(ced);
        dao.desconectar();
        return ban;
    }

    public ArrayList<Profesional> obtenerProfesionals() {
        dao.conectar();
        ArrayList<Profesional> us = dao.obtenerProfesionals();
        dao.desconectar();
        return us;
    }
}
