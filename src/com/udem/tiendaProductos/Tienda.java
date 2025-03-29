package com.udem.tiendaProductos;



public class Tienda {
    private Float total_ventas;

    public static void agregarProductoCarrito(Usuario usuario, Producto producto, int cantidad) {
        // Implementar la lógica para agregar un producto al carrito
        Item item = new Item(producto, cantidad);
        
    }

    public void eliminarItemDeCarrito(Usuario usuario, Item item) {
        // Implementar la lógica para eliminar un producto del carrito
    }
    public static void finalizarCompra(Usuario usuario) {
        // Implementar la lógica para finalizar la compra
    }
}
