package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

/**
 * Created by eni7 on 07/01/2016.
 */
public class Producto {

    private int cantidad;
    private double precio;
    private String nombre,extra,tamaño;

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Producto(double precio, int cantidad, String nombre, String extra,String tamaño) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.extra = extra;
        this.tamaño = tamaño;

    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public double getPrecio() {return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getExtra() {
        return extra;
    }
}
