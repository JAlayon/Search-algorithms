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
public class BusquedaAEstrella extends AlgoritmoBusqueda {

    public BusquedaAEstrella(ProblemaBusqueda problemaBusqueda) {
        super(problemaBusqueda);
        nombreEstrategia = "BUSQUEDA A ESTRELLA";
    }

    @Override
    public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
        double costoAcumulado = estadoActual.getCostoAcumulado();
        for (Estado sucesor : sucesores) {
            if (validar(sucesor)) {
                double acumulado = costoAcumulado + problema.getCosto(estadoActual, sucesor);
                sucesor.setCostoAcumulado(acumulado);
                double estimado = problema.getCostoEstimado(estadoActual);
                sucesor.setCostoEstimado(estimado);
                sucesor.setPredecesor(estadoActual);
                colaBusqueda.encolarConPrioridad(sucesor, acumulado + estimado);
            }
        }
    }
    
}
