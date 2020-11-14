
package com.alayon.algorithms;

import com.alayon.algorithms.AlgoritmoBusqueda;
import com.alayon.models.Estado;
import com.alayon.problems.ProblemaBusqueda;
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
