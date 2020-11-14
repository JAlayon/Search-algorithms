/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.problems.rompecabezas;

import com.alayon.models.Estado;
import java.awt.Point;
import java.util.Arrays;

/**
 *
 * @author jairsauceda
 */
public class Rompecabezas extends Estado{
    
    private final int matriz [][];

    public Rompecabezas(int matriz[][]){
        this.matriz = matriz;
    }
    
    public Rompecabezas(String matriz){
        String [] tokens = matriz.split(",");
        int n = (int)Math.sqrt(tokens.length);
        this.matriz = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                this.matriz[i][j] = Integer.parseInt(tokens[i*n+j]);
            }
        }
    }
    
    public Rompecabezas copiar(){
        int n = matriz.length;
        int copia[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matriz[i], 0, copia[i], 0, n);
        }
        return new Rompecabezas(copia);
    }
    
    public Point getUbicacion(int valor){
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matriz[i][j] == valor)
                    return new Point(i, j);
            }
        }
        return null;
    }
    
    public void moverHorizontal(Point cero, int x){
        matriz[cero.x][cero.y] = matriz[x][cero.y];
        matriz[x][cero.y] = 0;
    }
    
    public void moverVertical(Point cero, int y){
        matriz[cero.x][cero.y] = matriz[cero.x][y];
        matriz[cero.x][y] = 0;
    }
    
    
    public int[][] getMatriz(){
        return matriz;
    }
    
    public int getDimension(){
        return matriz.length;
    }
    
    @Override
    public String getInfo() {
        String datos = "";
        for(int[]fila:matriz){
            datos+=Arrays.toString(fila).replace(" ", "");
        }
        return datos;
    }
    
}
