/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.searchalgorithms.modelos;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author jairsauceda
 */
public abstract class AlgoritmoBusqueda {

    public static final int BUSQUEDA_POR_AMPLITUD = 1;
    public static final int BUSQUEDA_POR_PROFUNDIDAD = 2;
    public static final int BUSQUEDA_POR_COSTO_UNIFORME = 3;
    public static final int BUSQUEDA_BEST_FIRST = 4;
    public static final int BUSQUEDA_A_ESTRELLA = 5;
    public static final boolean CON_REPETICION = true;
    public static final boolean SIN_REPETICION = false;

    protected boolean conRepeticion;
    protected final Cola colaBusqueda;
    protected final Arbol arbolBusqueda;
    protected final ProblemaBusqueda problema;
    protected String nombreEstrategia;

    public AlgoritmoBusqueda(ProblemaBusqueda problemaBusqueda) {
        this.problema = problemaBusqueda;
        this.colaBusqueda = new Cola();
        this.arbolBusqueda = new Arbol();
    }

    public abstract void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores);

    public Estado realizarBusqueda(boolean repeticion) {
        System.out.println(nombreEstrategia);
        colaBusqueda.clear();
        arbolBusqueda.clear();
        conRepeticion = repeticion;
        colaBusqueda.encolarAlInicio(problema.estadoInicial);
        int i = 0;
        while (!colaBusqueda.isEmpty()) {
            System.out.println("" + (i++) + " " + colaBusqueda);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error de interrupción");
                System.exit(-1);
            }

            Estado estadoActual = colaBusqueda.desencolar();
            arbolBusqueda.insertar(estadoActual);
            if (estadoActual.getInfo().equals(problema.estadoMeta.getInfo())) {
                return estadoActual;
            }
            ArrayList<Estado> sucesores = problema.getSucesores(estadoActual);
            encolarSucesores(estadoActual, sucesores);
        }
        return null;
    }

    protected boolean validar(Estado sucesor) {
        if (!conRepeticion) {
            return arbolBusqueda.contine(sucesor);
        }
        return true;
    }

    public String getRuta(Estado estado) {
        return "RUTA = " + arbolBusqueda.getRuta(estado).toString();
    }
}


