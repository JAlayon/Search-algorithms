package com.alayon.searchalgorithms.modelos;

import java.util.ArrayList;

/**
 *
 * @author jairsauceda
 */
public class BusquedaAmplitud extends AlgoritmoBusqueda{

    public BusquedaAmplitud(ProblemaBusqueda problemaBusqueda) {
        super(problemaBusqueda);
        nombreEstrategia = "BUSQUEDA POR AMPLITUD";
    }

    @Override
    public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
        for(Estado sucesor: sucesores){
            if (validar(sucesor)) {
                sucesor.setPredecesor(estadoActual);
                colaBusqueda.encolarAlFinal(sucesor);
            } 
        }
    }
    
}
