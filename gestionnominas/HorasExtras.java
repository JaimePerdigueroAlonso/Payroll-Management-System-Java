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
public class HorasExtras implements Serializable{

    int numero;
    int mes;
    int anno;

    public HorasExtras(int mes, int año, int numero) {
        this.numero = numero;
        this.mes = mes;
        this.anno = año;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return " " + numero;
    }

}
