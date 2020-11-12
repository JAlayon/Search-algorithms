package com.alayon.searchalgorithms.modelos;

import java.util.ArrayList;

/**
 *
 * @author jairsauceda
 */
public abstract class ProblemaBusqueda<T extends Estado> {
    protected final T estadoInicial;
    protected final T estadoMeta;
    
    public ProblemaBusqueda(T estadoInicial, T estadoMeta){
        this.estadoInicial = estadoInicial;
        this.estadoMeta = estadoMeta;
    }
    
    public abstract double getCosto(T estadoActual, T estadoSucesor);
    public abstract double getCostoEstimado(T estadoActual);
    public abstract ArrayList<T> getSucesores(T estadoActual);

    public T getEstadoInicial() {
        return estadoInicial;
    }

    public T getEstadoMeta() {
        return estadoMeta;
    }
    
    
    
}
