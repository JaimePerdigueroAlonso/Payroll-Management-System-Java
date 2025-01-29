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
public class Contrato implements Serializable{

    String puesto;
    double salarioBase;
    Fecha fechaDeAlta;
    Fecha fechaDeBaja;
    Complementos complementos;
    Deducciones deducciones;

    public Contrato(String puesto, double salarioBase, Fecha fechaDeAlta, Deducciones deducciones) {
        this.puesto = puesto;
        this.salarioBase = salarioBase;
        this.fechaDeAlta = fechaDeAlta;
        this.deducciones = deducciones;
        complementos = new Complementos();
    }

    public Contrato(String puesto, double salarioBase, Fecha fechaDeAlta, Fecha fechaDeBaja) {
        this.puesto = puesto;
        this.salarioBase = salarioBase;
        this.fechaDeAlta = fechaDeAlta;
        this.fechaDeBaja = fechaDeBaja;
        complementos = new Complementos();
    }

    void añadirHorasExtra(int mes, int año, int num) {
        complementos.añadirHorasExtra(mes, año, num);
    }

    int calculaHorasExtra(int mes, int año) {
        return complementos.calculaHorasExtra(mes, año);
    }

    void añadirDiasDeBaja(int mes, int año, int num) {
        deducciones.añadirDiasDeBaja(mes, año, num);
    }

    int calculaDiasDeBaja(int mes, int año) {
        return deducciones.calcularDiasDeBaja(mes, año);
    }

    double calculaTrienios() {
        int mesAtla = fechaDeAlta.getMes();
        int añoAlta = fechaDeAlta.getAnno();
        int mesBaja = 6;
        int añoBaja = 2022;
        int añosTotales = (((12 - mesAtla) + mesBaja) / 12) + (añoBaja - añoAlta);
        return complementos.trienios = añosTotales / 3;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Fecha getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Fecha fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Fecha getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(Fecha fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public Complementos getComplementos() {
        return complementos;
    }

    public void setComplementos(Complementos complementos) {
        this.complementos = complementos;
    }

    public Deducciones getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(Deducciones deducciones) {
        this.deducciones = deducciones;
    }

}
