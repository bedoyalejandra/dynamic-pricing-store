package com.udem.tiendaProductos;

public class Usuario {
    private Carrito carrito = new Carrito();

    public void agregarItemACarrito(Producto producto, int cantidad, ReglaPrecio regla) {
        carrito.agregarItem(producto, cantidad, regla);
    }

    public void borrarItemDeCarrito(Item item) {
        carrito.borrarItem(item);
    }

    public Carrito getCarrito() {
        return carrito;
    }
}

