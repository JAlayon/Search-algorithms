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
public class BusquedaBestFirst extends AlgoritmoBusqueda{

    public BusquedaBestFirst(ProblemaBusqueda problemaBusqueda) {
        super(problemaBusqueda);
        nombreEstrategia = "BUSQUEDA BEST FIRST";
    }

    @Override
    public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
        for (Estado sucesor : sucesores) {
            if (validar(sucesor)) {
                sucesor.setPredecesor(estadoActual);
                double costo = problema.getCostoEstimado(sucesor);
                sucesor.setCostoEstimado(costo);
                colaBusqueda.encolarConPrioridad(sucesor, costo);
            }
        }
    }
    
}
