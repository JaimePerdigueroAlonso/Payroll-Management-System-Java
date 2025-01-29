/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnominas;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author jaimeperdiguero
 */
public abstract class Persona implements Serializable {

    String nombre;
    String telefono;
    Fecha fechaDeNacimiento;
    String dni;
    String banco;
    double irpf;
    double salarioMes;
    double desempleo;
    double contingencias;
    double sueldoDia;
    double trienios;
    CuentaBancaria cuenta;
    Contrato contrato;

    public Persona(String nombre, String telefono, Fecha fechaDeNacimiento, String dni, String banco, CuentaBancaria cuenta, Contrato contrato) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.dni = dni;
        this.banco = banco;
        this.cuenta = cuenta;
        this.contrato = contrato;
        this.irpf = (contrato.deducciones.irpf / 100) * (contrato.salarioBase / 12);
        this.salarioMes = contrato.salarioBase / 12;
        this.desempleo = (contrato.salarioBase / 12) * (1.6 / 100);
        this.contingencias = (contrato.salarioBase / 12) * (4.7 / 100);
        this.sueldoDia = contrato.salarioBase / 365;
        this.trienios = contrato.calculaTrienios() * 500 / 12;
    }

    void añadirHorasExtras(int mes, int año, int num) {
        contrato.añadirHorasExtra(mes, año, num);
    }

    void añadirDiasDeBaja(int mes, int año, int num) {
        contrato.añadirDiasDeBaja(mes, año, num);
    }

    void generaNomina(int mes, int año, double bonus) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "es"));
        double baja = contrato.calculaDiasDeBaja(mes, año) * sueldoDia;
        double horasExtras = contrato.calculaHorasExtra(mes, año) * 15;
        double salarioFinal = (contrato.salarioBase / 12) + horasExtras + bonus + trienios - irpf - desempleo - contingencias - baja;
        if (contrato.fechaDeAlta.getAnno() <= año || contrato.fechaDeAlta.getAnno() == año && contrato.fechaDeAlta.getMes() <= mes) {
            System.out.println("---------------------------------------------------");
            System.out.println(nombre + " " + dni + "\nCuenta: " + cuenta.getIban() + "\nPuesto: " + contrato.puesto
                    + "\nSalario mes: " + nf.format(salarioMes) + "\n+Por Trienios " + nf.format(trienios)
                    + "\n+Horas Extras: " + nf.format(horasExtras) + "\n+Por jefe: " + nf.format(bonus) + "\n-IRPF: " + nf.format(irpf)
                    + "\n-Desempleo: " + nf.format(desempleo) + "\n-Contingencias: " + nf.format(contingencias) + "\nA Percibir: " + nf.format(salarioFinal));

        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Fecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Fecha fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", telefono: " + telefono + ", fecha de nacimiento: " + fechaDeNacimiento + ", dni: " + dni;
    }

}
