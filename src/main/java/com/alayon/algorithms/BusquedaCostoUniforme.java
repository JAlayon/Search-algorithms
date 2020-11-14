/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.algorithms;

import com.alayon.algorithms.AlgoritmoBusqueda;
import com.alayon.models.Estado;
import com.alayon.problems.ProblemaBusqueda;
import java.util.ArrayList;

/**
 *
 * @author jairsauceda
 */
public class BusquedaCostoUniforme extends AlgoritmoBusqueda{

    public BusquedaCostoUniforme(ProblemaBusqueda problemaBusqueda) {
        super(problemaBusqueda);
        nombreEstrategia="BUSQUEDA POR COSTO UNIFORME";
    }

    @Override
    public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
        double costoAcumulado = estadoActual.getCostoAcumulado();
        for (Estado sucesor : sucesores) {
            if (validar(sucesor)) {
                double costo = costoAcumulado+problema.getCosto(estadoActual, sucesor);
                sucesor.setCostoAcumulado(costo);
                sucesor.setPredecesor(estadoActual);
                colaBusqueda.encolarConPrioridad(sucesor, costo);
            }
        }
    }
    
}
