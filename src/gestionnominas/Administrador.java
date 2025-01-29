/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnominas;

/**
 *
 * @author jaimeperdiguero
 */
public class Administrador extends Persona {

    public Administrador(String nombre, String telefono, Fecha fechaDeNacimiento, String dni, String banco, CuentaBancaria cuenta, Contrato contrato) {
        super(nombre, telefono, fechaDeNacimiento, dni, banco, cuenta, contrato);
    }

 

    @Override
    public String toString() {
        return super.toString();
    }

}
