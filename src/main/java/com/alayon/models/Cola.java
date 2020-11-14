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
public class Cola extends ArrayList<Estado>{
    
    public void encolarAlInicio(Estado estado){
        this.add(0,estado);
    }
    public void encolarAlFinal(Estado estado){
        this.add(estado);
    }
    
    public void encolarConPrioridad(Estado sucesor, double costo){
        for (int i = 0; i < size(); i++) {
            double costoTotal = get(i).getCostoCombinado();
            if(costoTotal > costo){
                add(i,sucesor);
                return;
            }
        }
        add(sucesor);
    }
    
    public Estado desencolar(){
        if(!isEmpty()){
            return this.remove(0);
        }
        return null;
    }
}
