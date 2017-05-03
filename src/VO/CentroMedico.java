/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.util.ArrayList;

/**
 *
 * @author 416pc01
 */
public class CentroMedico {

    private ArrayList<Cita> citasMedicas;
    private Profesional[] medicos;

    public CentroMedico() {
        citasMedicas = new ArrayList<Cita>();
        medicos = new Profesional[4];
    }

    public ArrayList<Cita> getCitasMedicas() {
        return citasMedicas;
    }

    public Profesional[] getMedicos() {
        return medicos;
    }

    /**
     * busca un medico por identificacion
     *
     * @param ced del medico a buscar
     * @return si se encontro o no el medico
     */
    public Profesional buscarMedico(String ced) {
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null) {
                if (medicos[i].getCedula().equals(ced)) {
                    return medicos[i];
                }
            }
        }
        return null;
    }

    /**
     * registra un medico
     *
     * @param m medico que se va a registrar
     * @return si el medico se registro o no
     */
    public String registrarMedico(Profesional m) {
        Profesional med = buscarMedico(m.getCedula());
        if (med == null) {
            for (int i = 0; i < medicos.length; i++) {
                if (medicos[i] == null) {
                    medicos[i] = m;
                    return "el medico ha quedado registrado";
                }
            }
            return "no es posible registrar mas medicos";
        }
        return "el medico con numero de cedula " + m.getCedula() + "ya se encuentra registrado";
    }

    /**
     * busca una cita
     *
     * @param id identificacion
     * @param f fecha
     * @param hora hora
     * @return si se encuentra la cita o no
     */
    public Cita buscarCitaPaciente(String id, Fecha f, String hora) {
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).getNumId().equals(id)
                    && citasMedicas.get(i).getHora().equals(hora)
                    && citasMedicas.get(i).getFecha().equals(f)) {
                return citasMedicas.get(i);
            }
        }
        return null;
    }

    public ArrayList obtenerFechaCitaPaciente(String id) {

        ArrayList<String> fechas = new ArrayList<String>();
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).getNumId().equals(id)) {
                fechas.add(citasMedicas.get(i).getFecha().toString() + " , " + citasMedicas.get(i).getHora());

            }
        }

        return fechas;
    }

    public ArrayList<Cita> obtenerCitaPaciente(String id) {
        ArrayList<Cita> citas = new ArrayList<Cita>();
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).getNumId().equals(id)) {
                citas.add(citasMedicas.get(i));
            }

        }
        return citas;
    }

    /**
     * buscar una cita
     *
     * @param nombre nombre del medico
     * @param f fecha de la cita
     * @param hora hora de la cita
     * @return retorna se se encuentra en caso contrario null
     */
    public Cita buscarCitaMedica(String nombre, Fecha f, String hora) {

        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).getMedico().getNombre().equals(nombre)
                    && citasMedicas.get(i).getHora().equals(hora)
                    && citasMedicas.get(i).getFecha().equals(f)) {
                return citasMedicas.get(i);
            }
        }
        return null;
    }

    /**
     * asigna una cita
     *
     * @param c cita que se va asignar
     * @return si se asigno o no la cita
     */
    public String asignarCita(Cita c) {
        Cita cita = buscarCitaPaciente(c.getNumId(), c.getFecha(), c.getHora());
        if (cita == null) {
            Cita citaM = buscarCitaMedica(c.getMedico().getNombre(), c.getFecha(), c.getHora());
            if (citaM == null) {
                citasMedicas.add(c);
                return "La cita ha sido asignada";
            }
            return "El Dr." + c.getMedico().getNombre() + " ya tiene una cita " + " el mismo dia a la misma hora";
        }
        return "El paciente " + c.getUsuario() + " ya tiene una cita el mismo dia " + " a la misma horas";
    }

    /**
     * cuenta las citas de un medico en un día especifico
     *
     * @param nombre del medico
     * @param f fecha del dia en que se van a contar las citas
     * @return la cantidad de citas de un medico
     */
    public int citasMedico(String nombre, Fecha f) {
        int can = 0;

        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).getMedico().getNombre().equals(nombre)
                    && citasMedicas.get(i).getFecha().equals(f)) {
                can++;
            }
        }
        return can;

    }

    /**
     * Eliminar cita de la agenda de profesionales.
     *
     * @param c, citas que se va a eliminar.
     * @return true si la cita se eliminó, de lo contrario false.
     */
    public boolean cancelarRegistro(Cita c) {
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).equals(c)) {
                citasMedicas.remove(citasMedicas.get(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Eliminar cita de la agenda de profesionales.
     *
     * @param c,cita que se va a eliminar.
     * @return true si la cita se eliminó, de lo contrario false.
     */
    public boolean eliminarCita(Cita c) {
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).equals(c)) {
                citasMedicas.remove(citasMedicas.get(i));
                return true;
            }
        }
        return false;
    }

    public Cita buscarCitaPorIdenti(String num) {
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).getNumId().equalsIgnoreCase(num)) {
                return citasMedicas.get(i);
            }
        }
        return null;
    }

    /**
     * obtiene los nombres de los medicos
     *
     * @return los nombres de los medicos que se registran
     */
    public ArrayList<String> obtenerNombresMedicos() {
        ArrayList<String> nombres = new ArrayList<String>();
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null) {
                nombres.add(medicos[i].getNombre());
            }
        }
        return nombres;
    }

    /**
     * Buscar un medico en el centro medico
     *
     * @param n nombre del medico a buscar
     * @return si se encontro o no el nombre del medico
     */
    public Profesional buscarMedicoNombre(String n) {
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null) {
                if (medicos[i].getNombre().equals(n)) {
                    return medicos[i];
                }
            }

        }
        return null;
    }

    public ArrayList<Cita> obtenerCitasPaciente(String id) { // YO
        ArrayList<Cita> citas = new ArrayList<Cita>();
        for (int i = 0; i < citasMedicas.size(); i++) {
            if (citasMedicas.get(i).getNumId().equals(id)) {
                citas.add(citasMedicas.get(i));
            }
        }
        return citas;
    }

}
