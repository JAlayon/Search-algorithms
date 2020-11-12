
package com.alayon.searchalgorithms.modelos;

import java.util.ArrayList;

/**
 *
 * @author jairsauceda
 */
public class BusquedaProfundidad extends AlgoritmoBusqueda{

    public BusquedaProfundidad(ProblemaBusqueda problemaBusqueda) {
        super(problemaBusqueda);
        nombreEstrategia = "BUSQUEDA POR PROFUNIDDAD";
    }

    @Override
    public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
        for (Estado sucesor : sucesores) {
            if (validar(sucesor)) {
                sucesor.setPredecesor(estadoActual);
                colaBusqueda.encolarAlInicio(sucesor);
            }
        }
    }
    
}
