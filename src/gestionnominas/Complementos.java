/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnominas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jaimeperdiguero
 */
public class Complementos implements Serializable{

    int trienios;
    ArrayList<HorasExtras> horasExtra;

    public Complementos() {
        trienios = 0;
        horasExtra = new ArrayList<>();
    }

    void añadirHorasExtra(int mes, int año, int num) {
        HorasExtras h = new HorasExtras(mes, año, num);
        horasExtra.add(h);
    }

    int calculaHorasExtra(int mes, int año) {
        int num = 0;
        for (HorasExtras e : horasExtra) {
            if (e.getMes() == mes && e.getAnno() == año) {
                num = e.getNumero() + num;
            }
        }
        return num;
    }

    public int getTrienios() {
        return trienios;
    }

    public void setTrienios(int trienios) {
        this.trienios = trienios;
    }

}
