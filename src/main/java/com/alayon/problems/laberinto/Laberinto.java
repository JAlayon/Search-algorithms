/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alayon.problems.laberinto;

import com.alayon.models.Estado;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;

/**
 *
 * @author jairsauceda
 */
public final class Laberinto extends Estado {

    private Point pActual;
    private final int matriz[][];

    public Laberinto(int matriz[][]) {
        this.matriz = matriz;
        pActual = getUbicacion(-1);
    }

    public Laberinto copiar() {
        int x = matriz.length;
        int y = matriz[0].length;
        int copia[][] = new int[x][y];
        for (int i = 0; i < x; i++) {
            System.arraycopy(matriz[i], 0, copia[i], 0, y);
        }
        return new Laberinto(copia);
    }

    public Point getPosicionActual() {
        return pActual;
    }

    public Point getUbicacion(int valor) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == valor) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public void moverHorizontal(int x) {
        matriz[pActual.x][pActual.y] = matriz[pActual.x][pActual.y + x];
        matriz[pActual.x][pActual.y + x] = -1;
        this.pActual.y += x;
    }

    public void moverVertical(int y) {
        matriz[pActual.x][pActual.y] = matriz[pActual.x + y][pActual.y];
        matriz[pActual.x + y][pActual.y] = -1;
        this.pActual.x += y;
    }

    public Dimension getDimension() {
        return new Dimension(matriz.length, matriz[0].length);
    }

    public int[][] getMatriz() {
        return matriz;
    }

    @Override
    public String getInfo() {
         String datos = "";
        for (int[] fila : matriz) {
            datos += Arrays.toString(fila).replace(" ", "");
        }
        return datos;
    }
    
}
