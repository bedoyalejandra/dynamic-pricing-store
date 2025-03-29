package com.udem.tiendaProductos;

public class Item {
    ManejadorReglas manejador = new ManejadorReglas();

    private Producto producto;
    private int cantidad;
    private ReglaPrecio reglaPrecio;

    public Item(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.reglaPrecio = manejador.obtenerReglaPrecio(producto.getSku());
    }

    public float calcularTotal() {
        return reglaPrecio.calcularTotal(cantidad, producto.getPrecioUnitario());
    }

    public Producto getProducto() {
        return producto;
    }
}
