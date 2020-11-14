/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.problems.rompecabezas;

import com.alayon.algorithms.AlgoritmoBusqueda;
import com.alayon.algorithms.BusquedaAEstrella;
import com.alayon.algorithms.BusquedaAmplitud;
import com.alayon.algorithms.BusquedaBestFirst;
import com.alayon.algorithms.BusquedaCostoUniforme;
import com.alayon.algorithms.BusquedaProfundidad;
import com.alayon.models.Estado;
import com.alayon.problems.ProblemaBusqueda;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author jairsauceda
 */
public class ProblemaRompecabezas extends ProblemaBusqueda<Rompecabezas> {

    //Diferentes formas de calcular el costo estimado de este problema
    private static final int DIFERENTES = 0;
    private static final int DISTANCIA_MANHATTAN = 1;
    private static final int DISTANCIA_EUCLIDIANA = 2;
    
    private final int tipoCostoEstimado;
    
    public ProblemaRompecabezas(Rompecabezas estadoInicial, Rompecabezas estadoMeta, int tipoCostoEstimado) {
        super(estadoInicial, estadoMeta);
        this.tipoCostoEstimado = tipoCostoEstimado;
    }
    
    public ProblemaRompecabezas(Rompecabezas estadoInicial, Rompecabezas estadoMeta){
        this(estadoInicial,estadoMeta,DIFERENTES);
    }

    @Override
    public double getCosto(Rompecabezas estadoActual, Rompecabezas estadoSucesor) {
        return 1;
    }

    @Override
    public double getCostoEstimado(Rompecabezas estadoActual) {
        int n = estadoActual.getDimension();
        double costoEstimado = 0;
        for (int i = 1; i < n*n; i++) {
            Point pActual = estadoActual.getUbicacion(i);
            Point pMeta = estadoMeta.getUbicacion(i);
            switch (tipoCostoEstimado) {
                case DIFERENTES:
                    if (pActual.distance(pMeta) != 0) {
                        costoEstimado++;
                    }
                    break;
                case DISTANCIA_MANHATTAN:
                    int dx = Math.abs(pActual.x - pMeta.x);
                    int dy = Math.abs(pActual.y - pMeta.y);
                    costoEstimado += dx + dy;
                    break;
                case DISTANCIA_EUCLIDIANA:
                    costoEstimado += pActual.distance(pMeta);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return costoEstimado;
    }

    @Override
    public ArrayList<Rompecabezas> getSucesores(Rompecabezas estadoActual) {
        ArrayList<Rompecabezas> sucesores = new ArrayList<>();
        int n = estadoActual.getDimension();
        Point cero = estadoActual.getUbicacion(0);
        int izq = cero.x - 1;
        int der = cero.x + 1;
        int sup = cero.y - 1;
        int inf = cero.y + 1;
        if (izq >= 0) {// mueve a la izquierda
            Rompecabezas estadoSucesor = estadoActual.copiar();
            estadoSucesor.moverHorizontal(cero, izq);
            sucesores.add(estadoSucesor);
        }
        if (der < n) { //mueve a la derecha
            Rompecabezas estadoSucesor = estadoActual.copiar();
            estadoSucesor.moverHorizontal(cero, der);
            sucesores.add(estadoSucesor);
        }
        if (sup >= 0) { // mieve arriba
            Rompecabezas estadoSucesor = estadoActual.copiar();
            estadoSucesor.moverVertical(cero, sup);
            sucesores.add(estadoSucesor);
        }
        if (inf < n) { // mueve abajo
            Rompecabezas estadoSucesor = estadoActual.copiar();
            estadoSucesor.moverVertical(cero, inf);
            sucesores.add(estadoSucesor);
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
