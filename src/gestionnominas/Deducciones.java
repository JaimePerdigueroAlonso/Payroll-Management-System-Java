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
public class Deducciones implements Serializable{

    double irpf;
    ArrayList<DiasDeBaja> diasDeBaja;

    public Deducciones() {
        irpf = 0;
        diasDeBaja = new ArrayList<>();
    }

    public Deducciones(double irpf) {
        this.irpf = irpf;
        diasDeBaja = new ArrayList<>();
    }

    void añadirDiasDeBaja(int mes, int año, int num) {
        DiasDeBaja di = new DiasDeBaja(mes, año, num);
        diasDeBaja.add(di);
    }

    int calcularDiasDeBaja(int mes, int año) {
        int num = 0;
        for (DiasDeBaja e : diasDeBaja) {
            if (e.getMes() == mes && e.getAño() == año) {
                num = e.getNumero() + num;
            }
        }
        return num;
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }

}
