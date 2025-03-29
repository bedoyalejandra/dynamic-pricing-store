package com.udem.tiendaProductos;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Producto> productos;
    private float totalVentas;

    public Tienda() {
        productos = new ArrayList<>();
        this.totalVentas = 0;
            productos.add(new Producto("EA001", "Arroz Diana", "Arroz blanco", 100, 2500));
            productos.add(new Producto("WE002", "Queso parmesano", "Queso por peso", 50, 0.02f)); // precio por gramo
            productos.add(new Producto("SP003", "Cereal Azucarado", "Caja de cereal", 30, 5000));
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

    public List<Producto> getProductos() {
        return productos;
    }

    public float getTotalVentas() {
        return totalVentas;
    }
}
