package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

public class Producto {

    private int cantidad;
    private double precio;
    private String nombre,extra,tamano;

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public Producto(double precio, int cantidad, String nombre, String extra,String tamano) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.extra = extra;
        this.tamano = tamano;

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
