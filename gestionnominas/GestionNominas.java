/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionnominas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Jaime Perdiguero, Borja Higuero, Ignacio Higuero, Edudardo Ros,
 * Joaquín de la Hoz, Jerónimo Carnés.
 */
public class GestionNominas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Persona> conjunto = new ArrayList<>();
        try {
            Persona p1 = new Administrador("Jaime", "668246092", new Fecha(13, 2, 1998), "65201628X", "BBVA",
                    new CuentaBancaria("Jaime", "ES0405040504050405"), new Contrato("Administrador", 60000,
                            new Fecha(1, 5, 2019), new Deducciones(20)));
            conjunto.add(p1);

            Persona p2 = new Administrador("Luis", "653927385", new Fecha(9, 11, 1966), "93870645C", "Santander",
                    new CuentaBancaria("Luis", "ES7382987093546289"), new Contrato("Administrador", 70000,
                            new Fecha(12, 7, 1990), new Deducciones(26)));
            conjunto.add(p2);

            Persona p3 = new Tecnico("Teresa", "683719356", new Fecha(3, 5, 1980), "839874923B", "BBVA",
                    new CuentaBancaria("Teresa", "ES7583973849226785"), new Contrato("Tecnico", 50000,
                            new Fecha(10, 10, 2000), new Deducciones(16)));
            conjunto.add(p3);

            Persona p4 = new JefeDeGrupo("Equipo1", "Juan", "746648378", new Fecha(1, 5, 1960), "74835793G", "Santander",
                    new CuentaBancaria("Juan", "ES3739273846283915"), new Contrato("Jefe de Grupo", 80000,
                            new Fecha(4, 8, 1980), new Deducciones(30)));
            conjunto.add(p4);

        } catch (Exception e) {
            System.out.println("Fecha mal introducida");;
        }

        int opcion = 1;
        do {

            opcion = menu();
            switch (opcion) {
                case 1:
                    darDeAlta(conjunto);
                    break;
                case 2:
                    darDeBaja(conjunto);
                    break;
                case 3:
                    añadirTecnicoEquipo(conjunto);
                    break;
                case 4:
                    quitarTecnicoEquipo(conjunto);
                    break;
                case 5:
                    añadirHorasExtras(conjunto);
                    break;
                case 6:
                    añadirDiasBaja(conjunto);
                    break;
                case 7:
                    listadoEmpleados(conjunto);
                    break;
                case 8:
                    listadoEmpleadosBaja(conjunto);
                    break;
                case 9:
                    listadoEmpleadosAdmin(conjunto);
                    break;
                case 10:
                    listadoEquipos(conjunto);
                    break;
                case 11:
                    generarNomina(conjunto);
                    break;
                case 12:
                    generarNominas(conjunto);
                    break;
                case 13:
                    crearArchivoEmpleados(conjunto);
                    break;
                case 14:
                    leerArchivoEmpleado();
                    break;
                case 15:
                    generaArchivoNomina(conjunto);
                    break;
                case 16:
                    generaArchivosNominas(conjunto);
                    break;
            }
        } while (opcion != 0);
    }

    public static int menu() {
        int opcion;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Menú: ");
        System.out.println("1.- Dar de alta un contrato");
        System.out.println("2.- Dar de baja un contrato");
        System.out.println("3.- Añadir un tecnico al equipo");
        System.out.println("4.- Quitar un tecnico de un  equipo");
        System.out.println("5.- Añadir horas extras a un empleado");
        System.out.println("6.- Añadir dias de baja");
        System.out.println("7.- Listado de los empleados");
        System.out.println("8.- Listado de empleados dados de baja");
        System.out.println("9.- Listado de los empleados de administracion");
        System.out.println("10.- Listado de equipos");
        System.out.println("11.- Generar una nomina");
        System.out.println("12.- Generar nominas");
        System.out.println("13.- Crear un archivo de datos con la informacion de los empleados");
        System.out.println("14.- Leer la informacion del archivo de datos con los empleados");
        System.out.println("15.- Crear un archivo con la nomina de un trabajador");
        System.out.println("16.- Crear un archivo por cada nomina de cada trabajador");
        System.out.println("0.- Salir");
        System.out.print("Elige una opción: ");
        opcion = teclado.nextInt();

        return opcion;
    }

    private static void darDeAlta(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para dar de alta un contrato: ");
        System.out.print("Nombre: ");
        String nombre = teclado.next();
        System.out.print("Telefono: ");
        String telefono = teclado.next();
        System.out.println("Fecha de nacimiento-> ");
        System.out.print("Dia: ");
        int dia = teclado.nextInt();
        System.out.print("Mes: ");
        int mes = teclado.nextInt();
        System.out.print("Año: ");
        int año = teclado.nextInt();
        System.out.print("DNI: ");
        String dni = teclado.next();
        System.out.print("IBAN: ");
        String iban = teclado.next();
        System.out.print("Banco de deposito: ");
        String banco = teclado.next();
        int puesto = 0;
        do {
            System.out.println("Puesto-> ");
            System.out.println("1.- Adminitrador");
            System.out.println("2.- Tecnico");
            System.out.println("3.- Jefe de grupo");
            System.out.print("Elige: ");
            puesto = teclado.nextInt();
        } while (puesto < 1 || puesto > 3);
        System.out.print("Salario base: ");
        double salariobase = teclado.nextDouble();
        System.out.println("Fecha de alta-> ");
        System.out.print("Dia: ");
        int diaalta = teclado.nextInt();
        System.out.print("Mes: ");
        int mesalta = teclado.nextInt();
        System.out.print("Año: ");
        int añoalta = teclado.nextInt();
        int irpf = 5;
        do {
            System.out.print("IRPF (entre el 2% y 30%): ");
            irpf = teclado.nextInt();
        } while (irpf < 2 || irpf > 30);

        try {
            switch (puesto) {
                case 1:
                    String puesto1 = "Administrador";
                    Persona a = new Administrador(nombre, telefono, new Fecha(dia, mes, año), dni, banco, new CuentaBancaria(nombre, iban),
                            new Contrato(puesto1, salariobase, new Fecha(diaalta, mesalta, añoalta), new Deducciones(irpf)));
                    conjunto.add(a);
                    break;
                case 2:
                    String puesto2 = "Tecnico";
                    Persona b = new Tecnico(nombre, telefono, new Fecha(dia, mes, año), dni, banco, new CuentaBancaria(nombre, iban),
                            new Contrato(puesto2, salariobase, new Fecha(diaalta, mesalta, añoalta), new Deducciones(irpf)));
                    conjunto.add(b);
                    break;
                case 3:
                    String puesto3 = "Jefe de grupo";
                    System.out.println("Nombre del equipo: ");
                    String nombreDelEquipo = teclado.next();
                    Persona c = new JefeDeGrupo(nombreDelEquipo, nombre, telefono, new Fecha(dia, mes, año), dni, banco,
                            new CuentaBancaria(nombre, iban), new Contrato(puesto3, salariobase, new Fecha(diaalta, mesalta, añoalta),
                                    new Deducciones(irpf)));
                    conjunto.add(c);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Valor de las fechas mal introducido");
        }
    }

    private static void darDeBaja(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para dar de baja un contrato: ");
        System.out.print("DNI: ");
        String dni = teclado.next();
        System.out.println("Fecha de baja->");
        System.out.print("Dia: ");
        int dia = teclado.nextInt();
        System.out.print("Mes: ");
        int mes = teclado.nextInt();
        System.out.print("Año: ");
        int año = teclado.nextInt();
        try {
            for (Persona p : conjunto) {
                if (dni.equals(p.dni)) {
                    p.contrato.fechaDeBaja = new Fecha(dia, mes, año);
                }
            }
        } catch (Exception e) {
            System.out.println("Fecha mal introducida");
        }
    }

    private static void añadirTecnicoEquipo(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para añadir un tecnico a un equipo: ");
        System.out.print("DNI: ");
        String dni = teclado.next();
        System.out.print("Nombre del equipo: ");
        String equipo = teclado.next();
        for (Persona p : conjunto) {
            if (p instanceof JefeDeGrupo) {
                JefeDeGrupo e = (JefeDeGrupo) p;
                if (e.nombreDelEquipo.equals(equipo)) {
                    e.añadirEquipo(dni, conjunto);
                }
            }
        }
    }

    private static void quitarTecnicoEquipo(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para quitar un tecnico de un equipo: ");
        System.out.print("DNI: ");
        String dni = teclado.next();
        System.out.print("Nombre del equipo: ");
        String equipo = teclado.next();
        for (Persona p : conjunto) {
            if (p instanceof JefeDeGrupo) {
                JefeDeGrupo e = (JefeDeGrupo) p;
                if (e.nombreDelEquipo.equals(equipo)) {
                    e.quitarEquipo(dni, conjunto);
                }
            }
        }
    }

    private static void añadirHorasExtras(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para añadir horas extras: ");
        System.out.print("DNI: ");
        String dni = teclado.next();
        System.out.print("Horas realizadas: ");
        int horas = teclado.nextInt();
        System.out.print("Mes en el que se han ralizado: ");
        int mes = teclado.nextInt();
        System.out.print("Año en el que se han realizado: ");
        int año = teclado.nextInt();

        for (Persona p : conjunto) {
            if (dni.equals(p.dni)) {
                p.añadirHorasExtras(mes, año, horas);
            }
        }

    }

    private static void añadirDiasBaja(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para añadir dias de baja: ");
        System.out.print("DNI: ");
        String dni = teclado.next();
        System.out.print("Dias de baja: ");
        int horas = teclado.nextInt();
        System.out.print("Mes en el que se han ralizado: ");
        int mes = teclado.nextInt();
        System.out.print("Año en el que se han realizado: ");
        int año = teclado.nextInt();

        for (Persona p : conjunto) {
            if (dni.equals(p.dni)) {
                p.añadirDiasDeBaja(mes, año, horas);
            }
        }
    }

    private static void listadoEmpleados(ArrayList<Persona> conjunto) {
        for (Persona p : conjunto) {
            if (p.contrato.fechaDeBaja == null) {
                System.out.println(p.toString());
            }
        }
    }

    private static void listadoEmpleadosBaja(ArrayList<Persona> conjunto) {
        for (Persona p : conjunto) {
            if (p.contrato.fechaDeBaja != null) {
                System.out.println(p.toString());
            }
        }
    }

    private static void listadoEmpleadosAdmin(ArrayList<Persona> conjunto) {
        for (Persona p : conjunto) {
            if (p instanceof Administrador) {
                if (p.contrato.fechaDeBaja == null) {
                    System.out.println(p.toString());
                }
            }
        }
    }

    private static void listadoEquipos(ArrayList<Persona> conjunto) {
        for (Persona p : conjunto) {
            if (p instanceof JefeDeGrupo) {
                JefeDeGrupo a = (JefeDeGrupo) p;
                System.out.println("Equipo: " + a.nombreDelEquipo);
                if (a.equipo == null || a.equipo.size() == 0) {
                    System.out.println("No hay ningun técnico en el " + a.nombreDelEquipo);
                } else {
                    for (int i = 0; i < a.equipo.size(); i++) {
                        System.out.println(a.equipo.get(i));
                    }

                }
            }
        }
    }

    private static void generarNomina(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para crear una nómina: ");
        System.out.print("DNI: ");
        String dni = teclado.next();
        System.out.print("Mes: ");
        int mes = teclado.nextInt();
        System.out.print("Año: ");
        int año = teclado.nextInt();

        for (Persona p : conjunto) {
            if (dni.equals(p.dni)) {
                if (p instanceof JefeDeGrupo) {
                    JefeDeGrupo j = (JefeDeGrupo) p;
                    if (j.equipo != null) {
                        int bonus = j.equipo.size() * 2 / 100;
                        double bonusFinal = j.contrato.salarioBase * bonus;
                        p.generaNomina(mes, año, bonusFinal);
                    } else {
                        p.generaNomina(mes, año, 0);
                    }
                } else {
                    p.generaNomina(mes, año, 0);
                }
            }
        }
    }

    private static void generarNominas(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para generar todas las nóminas: ");
        System.out.print("Mes: ");
        int mes = teclado.nextInt();
        System.out.print("Año: ");
        int año = teclado.nextInt();

        for (Persona p : conjunto) {
            if (p.contrato.fechaDeBaja == null) {
                if (p instanceof JefeDeGrupo) {
                    JefeDeGrupo j = (JefeDeGrupo) p;
                    if (j.equipo != null) {
                        int bonus = j.equipo.size() * 2;
                        double bonusFinal = j.contrato.salarioBase * bonus / 100;
                        p.generaNomina(mes, año, bonusFinal);
                    } else {
                        p.generaNomina(mes, año, 0);
                    }
                } else {
                    p.generaNomina(mes, año, 0);
                }
            }
        }
    }

    private static void crearArchivoEmpleados(ArrayList<Persona> conjunto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contrato.out"))) {
            oos.writeObject(conjunto);
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede abrir el archivo");
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el archivo.");
            System.out.println(ex);
        }
        System.out.println("Archivo creado con exito");
    }

    private static void leerArchivoEmpleado() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contrato.out"))) {
            Object o = ois.readObject();
            if (o instanceof ArrayList) {
                ArrayList<Persona> nuevos = (ArrayList<Persona>) o;
                for (Persona p : nuevos) {
                    System.out.println(p.toString());
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido abrir el archivo.");
        } catch (IOException ex) {
            System.out.println("No se ha podido leer el archivo.");
        } catch (ClassNotFoundException ex) {
            System.out.println("No es la misma clase.");
        }
    }

    private static void generaArchivoNomina(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para crear un archivo: ");
        System.out.print("DNI: ");
        String dni = teclado.next();
        System.out.print("Mes: ");
        int mes = teclado.nextInt();
        System.out.print("Año: ");
        int año = teclado.nextInt();
        double bonusFinal;
        for (Persona p : conjunto) {
            if (p.dni.equals(dni)) {
                if (p instanceof JefeDeGrupo) {
                    JefeDeGrupo a = (JefeDeGrupo) p;
                    int bonus = a.equipo.size() * 2;
                    bonusFinal = a.contrato.salarioBase * bonus / 100;
                } else {
                    bonusFinal = 0;
                }
                if (p.contrato.fechaDeAlta.getAnno() <= año || p.contrato.fechaDeAlta.getAnno() == año && p.contrato.fechaDeAlta.getMes() <= mes) {
                    try (PrintWriter pw = new PrintWriter(año + "_" + mes + "_" + p.nombre + ".nomina.txt")) {
                        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "es"));
                        pw.println("Nombre: " + p.nombre + "             Puesto: " + p.contrato.puesto);
                        pw.println("DNI: " + p.dni);
                        pw.println("Banco de abono: " + p.banco);
                        pw.println("----------------------------------------------------------");
                        pw.println("|Concepto:         |" + "|  Complementos  " + "    Deducciones|   ");
                        pw.println("----------------------------------------------------------");
                        pw.println("|Salario mes:      |" + "  " + nf.format(p.contrato.salarioBase));
                        pw.println("|Por trienios:     |" + "  " + nf.format(p.trienios));
                        pw.println("|Horas extras:     |" + "  " + nf.format(p.contrato.calculaHorasExtra(mes, año) * 15));
                        pw.println("|Por Jefe:         |" + "  " + nf.format(bonusFinal));
                        pw.println("|IRPF:             |" + "                       " + nf.format(p.irpf));
                        pw.println("|Desempleo:        |" + "                       " + nf.format(p.desempleo));
                        pw.println("|Contingencias:    |" + "                       " + nf.format(p.contingencias));
                        pw.println("----------------------------------------------------------");
                        pw.println("|A percibir:                                  " + nf.format((p.contrato.salarioBase / 12)
                                + p.contrato.calculaHorasExtra(mes, año) * 15 + bonusFinal + p.trienios - p.irpf - p.desempleo
                                - p.contingencias - p.contrato.calculaDiasDeBaja(mes, año) * p.sueldoDia) + "|");
                        pw.println("----------------------------------------------------------");

                    } catch (FileNotFoundException ex) {
                        System.out.println("No lo puedo crear");
                    }
                    System.out.println("Archivo creado con éxito");
                }else{
                    System.out.println("No se ha podido generar la nómina porque " + p.nombre + " no tenía contrato en estas fechas");
                }
            }
        }

    }

    private static void generaArchivosNominas(ArrayList<Persona> conjunto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los siguentes datos para crear todos los archivo: ");
        System.out.print("Mes: ");
        int mes = teclado.nextInt();
        System.out.print("Año: ");
        int año = teclado.nextInt();
        double bonusFinal;
        for (Persona p : conjunto) {

            if (p instanceof JefeDeGrupo) {
                JefeDeGrupo a = (JefeDeGrupo) p;
                int bonus = a.equipo.size() * 2;
                bonusFinal = a.contrato.salarioBase * bonus / 100;
            } else {
                bonusFinal = 0;
            }
            if (p.contrato.fechaDeAlta.getAnno() <= año || p.contrato.fechaDeAlta.getAnno() == año && p.contrato.fechaDeAlta.getMes() <= mes) {
                try (PrintWriter pw = new PrintWriter(año + "_" + mes + "_" + p.nombre + ".nomina.txt")) {
                    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "es"));
                    pw.println("Nombre: " + p.nombre + "             Puesto: " + p.contrato.puesto);
                    pw.println("DNI: " + p.dni);
                    pw.println("Banco de abono: " + p.banco);
                    pw.println("----------------------------------------------------------");
                    pw.println("|Concepto:         |" + "|  Complementos  " + "    Deducciones   ");
                    pw.println("----------------------------------------------------------");
                    pw.println("|Salario mes:      |" + "  " + nf.format(p.contrato.salarioBase));
                    pw.println("|Por trienios:     |" + "  " + nf.format(p.trienios));
                    pw.println("|Horas extras:     |" + "  " + nf.format(p.contrato.calculaHorasExtra(mes, año) * 15));
                    pw.println("|Por Jefe:         |" + "  " + nf.format(bonusFinal));
                    pw.println("|IRPF:             |" + "                       " + nf.format(p.irpf));
                    pw.println("|Desempleo:        |" + "                       " + nf.format(p.desempleo));
                    pw.println("|Contingencias:    |" + "                       " + nf.format(p.contingencias));
                    pw.println("----------------------------------------------------------");
                    pw.println("|A percibir:                                  " + nf.format((p.contrato.salarioBase / 12)
                            + p.contrato.calculaHorasExtra(mes, año) * 15 + bonusFinal + p.trienios - p.irpf - p.desempleo
                            - p.contingencias - p.contrato.calculaDiasDeBaja(mes, año) * p.sueldoDia));
                    pw.println("----------------------------------------------------------");

                } catch (FileNotFoundException ex) {
                    System.out.println("No lo puedo crear");
                }
            }
        }

    }

}
