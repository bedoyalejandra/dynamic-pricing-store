package com.udem.tiendaProductos;

public class Item {
    private Producto producto;
    private int cantidad;
    private ReglaPrecio reglaPrecio;

    public Item(Producto producto, int cantidad, ReglaPrecio reglaPrecio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.reglaPrecio = reglaPrecio;
    }

    public float calcularTotal() {
        return reglaPrecio.calcularTotal(cantidad, producto.getPrecioUnitario());
    }

    public Producto getProducto() { return producto; }
}

