package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

public class Persona {
    private int telefono;
    private String nombre,direccion;

    public Persona(int telefono, String nombre, String direccion) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setTelefono(int telefono) {

        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
