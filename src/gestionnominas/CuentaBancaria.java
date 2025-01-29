/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnominas;

import java.io.Serializable;

/**
 *
 * @author jaimeperdiguero
 */
public class CuentaBancaria implements Serializable{

    String nombreEntidad;
    String iban;

    public CuentaBancaria(String nombreEntidad, String iban) {
        this.nombreEntidad = nombreEntidad;
        this.iban = iban;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public String getIban() {
        return iban;
    }

}
