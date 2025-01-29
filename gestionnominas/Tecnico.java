/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnominas;

/**
 *
 * @author jaimeperdiguero
 */
public class Tecnico extends Persona {

    public Tecnico(String nombre, String telefono, Fecha fechaDeNacimiento, String dni, String banco, CuentaBancaria cuenta, Contrato contrato) {
        super(nombre, telefono, fechaDeNacimiento, dni, banco, cuenta, contrato);
    }

   

    @Override
    public String toString() {
        return super.toString();
    }

}
