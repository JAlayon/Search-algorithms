/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.problems.rompecabezas;

import static com.alayon.algorithms.AlgoritmoBusqueda.*;

/**
 *
 * @author jairsauceda
 */
public class BusquedaRompecabezas {
    
    public static void main(String[] args) {
        int matrizInicial[][] = { {1,2,3}, {8,6,0}, {7,5,4}};
        int matrizMeta[][] = {{1,2,3},{8,0,4},{7,6,5}};
        ProblemaRompecabezas problema = new ProblemaRompecabezas(new Rompecabezas(matrizInicial), new Rompecabezas(matrizMeta));
        System.out.println("Estado inicial = " + problema.getEstadoInicial());
        System.out.println("Estado Meta = " + problema.getEstadoMeta());
        problema.buscarSolucion(BUSQUEDA_POR_AMPLITUD, SIN_REPETICION);
    }
}
