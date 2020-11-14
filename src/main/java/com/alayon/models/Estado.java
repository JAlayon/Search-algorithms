    package com.alayon.models;

/**
 *
 * @author jairsauceda
 */
public abstract class Estado {
    private static long contador;
    private final long id;
    private Estado predecesor;
    private double costoAcumulado;
    private double costoEstimado;
    
    public Estado(){
        this.id = contador++;
    }
    
    public long getId(){
        return id;
    }

    public Estado getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(Estado predecesor) {
        this.predecesor = predecesor;
    }

    public double getCostoAcumulado() {
        return costoAcumulado;
    }

    public void setCostoAcumulado(double costoAcumulado) {
        this.costoAcumulado = costoAcumulado;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }
    
    public double getCostoCombinado(){
        return costoAcumulado + costoEstimado;
    }
    
    public abstract String getInfo();

    @Override
    public String toString() {
        double costoTotal = costoAcumulado + costoEstimado;
        return this.getInfo() + (costoTotal > 0 ? String.format("(%.2f)",costoTotal):"");
    }
    
    
    
    
}
