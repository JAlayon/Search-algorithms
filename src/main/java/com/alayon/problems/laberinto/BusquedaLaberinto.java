/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.problems.laberinto;

import static com.alayon.algorithms.AlgoritmoBusqueda.BUSQUEDA_POR_AMPLITUD;
import static com.alayon.algorithms.AlgoritmoBusqueda.SIN_REPETICION;

/**
 *
 * @author jairsauceda
 */
public class BusquedaLaberinto {

    public static void main(String[] args) {
        /** 
         * -1: posición actual
         *  1: movimiento válido
         *  2: meta
         * 
         * Estado inicial:
            * |0 -1 0 1 0|
            * |0  1 1 1 0|
            * |0  1 0 1 2|
            * |0  1 0 1 0|
            * |0  1 1 1 0|
         *
         */
        int matrizInicial[][] = {{0, -1, 0, 1, 0}, {0, 1, 1, 1, 0}, {0, 1, 0, 1, 2}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        int matrizFinal[][] = {{0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}, {0, 1, 0, 2, -1}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        ProblemaLaberinto problema = new ProblemaLaberinto(new Laberinto(matrizInicial), new Laberinto(matrizFinal));
        System.out.println("Estado inicial = " + problema.getEstadoInicial());
        System.out.println("Estado Meta = " + problema.getEstadoMeta());
        problema.buscarSolucion(BUSQUEDA_POR_AMPLITUD, SIN_REPETICION);
    }
}
