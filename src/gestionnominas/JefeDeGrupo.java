/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnominas;

import java.util.ArrayList;

/**
 *
 * @author jaimeperdiguero
 */
public class JefeDeGrupo extends Tecnico {

    String nombreDelEquipo;
    ArrayList<Persona> equipo;

    public JefeDeGrupo(String nombreDelEquipo, String nombre, String telefono, Fecha fechaDeNacimiento, String dni,String banco, CuentaBancaria cuenta, Contrato contrato) {
        super(nombre, telefono, fechaDeNacimiento, dni,banco, cuenta, contrato);
        this.nombreDelEquipo = nombreDelEquipo;
        equipo = new ArrayList<>();
    }

    void añadirEquipo(String dni, ArrayList<Persona> conjunto) {
        for (Persona p : conjunto) {
            if (p instanceof Tecnico) {
                Tecnico b = (Tecnico) p;
                if (b.dni.equals(dni)) {
                    equipo.add(b);
                }
            }
        }
    }

    void quitarEquipo(String dni, ArrayList<Persona> conjunto) {
        for (Persona p : conjunto) {
            if (p instanceof Tecnico) {
                Tecnico b = (Tecnico) p;
                if (b.dni.equals(dni)) {
                    equipo.remove(b);
                }
            }
        }
    }

    public String getNombreDelEquipo() {
        return nombreDelEquipo;
    }

    public ArrayList<Persona> getEquipo() {
        return equipo;
    }

}
