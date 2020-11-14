/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.models;

import java.util.ArrayList;

/**
 *
 * @author jairsauceda
 */
public class NodoArbol<T extends Estado> {
    
    private final T estado;
    private NodoArbol padre;
    private final ArrayList<NodoArbol> hijos;
    
    public NodoArbol(T estado){
        this.estado = estado;
        hijos = new ArrayList<>();
    }

    public NodoArbol getPadre() {
        return padre;
    }
    
    public void setPadre(NodoArbol padre){
        this.padre = padre;
    }

    public T getEstado() {
        return estado;
    }

    public ArrayList<NodoArbol> getHijos() {
        return hijos;
    }
    
}
