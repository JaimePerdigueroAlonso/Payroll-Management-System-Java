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
public class DiasDeBaja implements Serializable{

    int mes;
    int año;
    int numero;

    public DiasDeBaja(int mes, int año, int numero) {
        this.mes = mes;
        this.año = año;
        this.numero = numero;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
