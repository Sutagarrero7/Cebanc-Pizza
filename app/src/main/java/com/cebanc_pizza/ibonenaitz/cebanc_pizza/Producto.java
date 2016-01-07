package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

/**
 * Created by eni7 on 07/01/2016.
 */
public class Producto {

    private int precio,cantidad;
    private String nombre,extra;

    public Producto(int precio, int cantidad, String nombre, String extra) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.extra = extra;
    }

    public void setPrecio(int precio) {
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

    public int getPrecio() {

        return precio;
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
