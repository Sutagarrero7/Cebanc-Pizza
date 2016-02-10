package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.sql.SQLData;
import java.util.ArrayList;

public class GestionaPedido {
    static ArrayList<Producto> lista_productos;
    static int usuarioID;
    static Producto p;
    static Producto pAux;
    static Producto prod;
    static Store bbdd;
    static SQLiteDatabase db;
    static Persona pers;
    public static void aniadirUsuario(String nombre_pop,String usuario_pop,String pass_pop,String direccion_pop,String tlf_pop) {
        db.execSQL("INSERT INTO Usuarios(Nombre,Usuario,Pass,Direccion,Telefono) VALUES ('"+nombre_pop+"','"+usuario_pop+"','"+pass_pop+"','"+direccion_pop+"','"+tlf_pop+"')");
    }
    public static void startBBDD(Context c){
        //Crear o instanciar BBDD
        bbdd = new Store(c);
        db = bbdd.getReadableDatabase();
    }

    public static boolean iniciarSesion(String usr,String pwd){
        boolean ok = false;
        String sql = "SELECT * FROM Usuarios WHERE UPPER(Usuario) = ? AND Pass = ?";
        Cursor c = db.rawQuery(sql, new String[]{usr, pwd});
        if (c.getCount() > 0){
            c.moveToFirst();
            ok = true;
            usuarioID = c.getInt(0);
        }

        return ok;
    }
    //Metodo que añade a un array de objeto (Producto) cada producto que seleccione el usuario
    public static void añadirProducto(String nombre, int cantidad, String precio,String extra,String tamano){
        int i = buscarProducto(nombre,extra,tamano);
        double pvp = Double.parseDouble(precio.substring(8, 12).toString());
        //Si el producto no existe lo crea
        if (i == -1){
            p = new Producto(pvp,cantidad,nombre,extra,tamano);
            lista_productos.add(p);
            //Si ya existe modifica el valor de cantidad
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
    //Elimina el producto del array
    public static void eliminarProducto(Producto p){
        String nombre, extra, tamano;
        nombre = p.getNombre();
        extra = p.getExtra();
        tamano = p.getTamano();
        int i = buscarProducto(nombre, extra, tamano);
        if (i != -1){
            lista_productos.remove(i);
        }
    }
    //Devuelve el array completo de productos
    public static ArrayList<Producto> todoPedido(){
        return lista_productos;
    }

    //Asigna el cliente al objeto Persona
    public static void crearPedido(){
        lista_productos = new ArrayList<Producto>();
    }

    public static Persona getCliente() {
        String sql = "SELECT * FROM Usuarios WHERE UsuarioID = ?";
        Cursor c = db.rawQuery(sql,new String[]{Integer.toString(usuarioID)});
        if (c.getCount() > 0){
            c.moveToFirst();
            pers=new Persona(Integer.parseInt(c.getString(4)),c.getString(2),c.getString(3));

        }
        return pers;
    }

    public static boolean insertaPedido(){
        //Insertar cabecera
        int pedidocabeceraid;
        String sql = "INSERT INTO PedidoCabecera(UsuarioID) VALUES ("+usuarioID+")";
        db.execSQL(sql);
       //Cursor cur = db.rawQuery("SELECT PedidoCabeceraID FROM PedidoCabecera WHERE PedidoCabeceraID IN (SELECT MAX(PedidoCabeceraID) FROM PedidoCabecera)",null);
        Cursor cur = db.rawQuery("SELECT last_insert_rowid() FROM PedidoCabecera",null);
        if (cur.moveToFirst()){
            cur.moveToFirst();
            pedidocabeceraid = cur.getInt(0);
            cur.close();
            //Insertar lineas
            for (int i = 0; i < lista_productos.size(); i++) {
                prod = lista_productos.get(i);
                sql = "INSERT INTO PedidoLinea(PedidoCabeceraID,Cantidad,Extra,Precio,NombreArticulo) VALUES (?,?,?,?,?)";
                db.rawQuery(sql,new String[]{Integer.toString(pedidocabeceraid),Integer.toString(prod.getCantidad()),prod.getExtra(),Double.toString(prod.getPrecio()),prod.getNombre()});
                return true;
            }
            return true;
        }else{
           return false;
        }
    }

    //Devuelve el precio total del pedido
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

    //Metodo que busca en el array si existe el producto. Devuelve el indice del mismo
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
