package com.udem.tiendaProductos;

public class Item {
    private int cantidad;
    
    public Item(Producto producto, int cantidad) {
        this.cantidad = cantidad;
    }

    public float calculartotal() {
        return cantidad;
    }    

}
