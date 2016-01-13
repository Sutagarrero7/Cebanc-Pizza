package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by eni7 on 12/01/2016.
 */
public class GestionaPedido {
    static ArrayList<Producto> lista_productos;
    static Persona cliente;
    static Producto p;
    static Producto pAux;
    public static void añadirProducto(String nombre, int cantidad, String precio,String extra,String tamano){
        int i = buscarProducto(nombre,extra,tamano);
        double pvp = Double.parseDouble(precio.substring(8, 12).toString());

        if (i == -1){
            p = new Producto(pvp,cantidad,nombre,extra,tamano);
            lista_productos.add(p);
        }else{
            pAux = lista_productos.get(i);
            if (pAux.getExtra().equals(extra) && pAux.getTamano().equals(tamano)){
                cantidad = pAux.getCantidad() + cantidad;
                pAux.setCantidad(cantidad);
                lista_productos.set(i,pAux);
            }else{
                p = new Producto(pvp,cantidad,nombre,extra,tamano);
                lista_productos.add(p);
            }
        }
    }

    public static void eliminarProducto(Producto p){
        String nombre, extra, tamano;
        nombre = p.getNombre();
        extra = p.getExtra();
        tamano = p.getTamano();
        int i = buscarProducto(nombre,extra,tamano);
        if (i != -1){
            lista_productos.remove(i);
        }
    }

    public static void borrarPedido(){
        int i ;
        for (i = 0; i < lista_productos.size(); i++){
            lista_productos.remove(i);
        }
    }

    public static ArrayList<Producto> todoPedido(){
        return lista_productos;
    }

    public static void crearPedido(Persona pers){
        cliente = pers;
        lista_productos = new ArrayList<Producto>();
    }

    public static Persona getCliente() {
        return cliente;
    }

    public static double precioTotalPedido(){
        double total = 0;
        if (lista_productos.size() != 0) {
            for (int i = 0; i < lista_productos.size(); i++) {
                Producto p = lista_productos.get(i);
                total += p.getPrecio() * p.getCantidad();
            }
        }
        return total;
    }
    public static int buscarProducto(String nombre, String extra,String tamano){
        int indice = -1;
        if (lista_productos.size() != 0) {
            for (int i = 0; i < lista_productos.size(); i++) {
                Producto p = lista_productos.get(i);
                if (p.getExtra().equals(extra) && p.getTamano().equals(tamano) && p.getNombre().equals(nombre)){
                    indice = i;
                }
            }
        }
        return indice;
    }
}
