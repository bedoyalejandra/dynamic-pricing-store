package com.udem.tiendaProductos;
import java.util.List;

public class Tienda {
    private List<Producto> productos;
    private float totalVentas;

    public Tienda(List<Producto> productos) {
        this.productos = productos;
        this.totalVentas = 0;
    }

    public void agregarProductoACarrito(Usuario usuario, Producto producto, int cantidad) {
        if (producto.tieneUnidades(cantidad)) {
            usuario.agregarItemACarrito(producto, cantidad);
            producto.descontarUnidades(cantidad);
        } else {
            System.out.println("No hay suficientes unidades disponibles");
        }
    }

    public void eliminarItemDeCarrito(Usuario usuario, Item item) {
        usuario.borrarItemDeCarrito(item);
    }

    public void finalizarCompra(Usuario usuario) {
        float total = usuario.getCarrito().calcularTotal();
        totalVentas += total;
        System.out.println("Compra finalizada. Total: $" + total);
    }
}
