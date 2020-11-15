/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.problems.laberinto;

import com.alayon.algorithms.AlgoritmoBusqueda;
import com.alayon.algorithms.BusquedaAEstrella;
import com.alayon.algorithms.BusquedaAmplitud;
import com.alayon.algorithms.BusquedaBestFirst;
import com.alayon.algorithms.BusquedaCostoUniforme;
import com.alayon.algorithms.BusquedaProfundidad;
import com.alayon.models.Estado;
import com.alayon.problems.ProblemaBusqueda;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jairsauceda
 */
public class ProblemaLaberinto extends ProblemaBusqueda<Laberinto> {

    private static final int DISTANCIA_MANHATTAN = 1;
    private static final int DISTANCIA_EUCLIDIANA = 2;

    private final int tipoCostoEstimado;

    public ProblemaLaberinto(Laberinto estadoInicial, Laberinto estadoMeta, int tipoCostoEstimado) {
        super(estadoInicial, estadoMeta);
        this.tipoCostoEstimado = tipoCostoEstimado;
    }

    public ProblemaLaberinto(Laberinto estadoInicial, Laberinto estadoMeta) {
        this(estadoInicial, estadoMeta, DISTANCIA_EUCLIDIANA);
    }

    @Override
    public double getCosto(Laberinto estadoActual, Laberinto estadoSucesor) {
        return 1;
    }

    @Override
    public double getCostoEstimado(Laberinto estadoActual) {
        double costoEstimado;
        Point pActual = estadoActual.getPosicionActual();
        Point pMeta = estadoActual.getUbicacion(-2);
        costoEstimado = pActual.distance(pMeta);
        return costoEstimado;
    }

    @Override
    public ArrayList<Laberinto> getSucesores(Laberinto estadoActual) {
        ArrayList<Laberinto> sucesores = new ArrayList<>();
        int mActual[][] = estadoActual.getMatriz();
        Point pActual = estadoActual.getPosicionActual();
        Dimension dimension = estadoActual.getDimension();
        int izq = pActual.y - 1;
        int der = pActual.y + 1;
        int sup = pActual.x - 1;
        int inf = pActual.x + 1;
        //verificar que no se salga de los limites del arreglo y que el valor en la matriz sea 1 o la meta
        if (izq >= 0 && (mActual[pActual.x][izq] == 1 || mActual[pActual.x][izq] == 2)) {
            Laberinto sucesor = estadoActual.copiar();
            sucesor.moverHorizontal(-1);
            sucesores.add(sucesor);
        }
        //verificar que el mov a la derecha sea menor que el tamaño del arreglo y que el valor en la matriz sea 1 o la meta
        if (der < dimension.width && (mActual[pActual.x][der] == 1 || mActual[pActual.x][der] == 2)) {
            Laberinto sucesor = estadoActual.copiar();
            sucesor.moverHorizontal(1);
            sucesores.add(sucesor);
        }

        //verificar que el mov hacia arriba no salga del arreglo y que el valor en la matriz sea 1 o la meta
        if (sup >= 0 && (mActual[sup][pActual.y] == 1 || mActual[sup][pActual.y] == 2)) {
            Laberinto sucesor = estadoActual.copiar();
            sucesor.moverVertical(-1);
            sucesores.add(sucesor);
        }

        if (inf < dimension.height && (estadoActual.getMatriz()[inf][pActual.y] == 1 || estadoActual.getMatriz()[inf][pActual.y] == 2)) {
            Laberinto sucesor = estadoActual.copiar();
            sucesor.moverVertical(1);
            sucesores.add(sucesor);
        }
        
        return sucesores;
    }
    
     public void buscarSolucion(int tipoAlgortimo, boolean repeticion){
        AlgoritmoBusqueda algoritmo = null;
        switch (tipoAlgortimo) {
            case AlgoritmoBusqueda.BUSQUEDA_POR_AMPLITUD:
                algoritmo = new BusquedaAmplitud(this);
                break;
            case AlgoritmoBusqueda.BUSQUEDA_POR_PROFUNDIDAD:
                algoritmo = new BusquedaProfundidad(this);
                break;
            case AlgoritmoBusqueda.BUSQUEDA_POR_COSTO_UNIFORME:
                algoritmo = new BusquedaCostoUniforme(this);
                break;
            case AlgoritmoBusqueda.BUSQUEDA_BEST_FIRST:
                algoritmo = new BusquedaBestFirst(this);
                break;
            case AlgoritmoBusqueda.BUSQUEDA_A_ESTRELLA:
                algoritmo = new BusquedaAEstrella(this);
                break;
            default:
                throw new AssertionError();
        }
        if(algoritmo != null){
            Estado solucion = algoritmo.realizarBusqueda(repeticion);
            System.out.println(algoritmo.getRuta(solucion));
        }else{
            System.out.println("Algoritmo no definido");
        }
    }
}
