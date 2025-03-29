package com.udem.tiendaProductos;

public class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private int unidadesDisponibles;
    private float precioUnitario;

    public Boolean tieneUnidades(int cantidad) {
        // Verifica si hay suficientes unidades disponibles para la cantidad solicitada
        if (cantidad <= 0) {
            return false; // La cantidad solicitada debe ser mayor que cero
        }
        if (unidadesDisponibles < cantidad) {
            return false; // No hay suficientes unidades disponibles
        }   
        return unidadesDisponibles > 0;
    }

    public void descontarUnidades(int cantidad) {
        // Reduce la cantidad de unidades disponibles en el inventario
        if (cantidad > 0 && unidadesDisponibles >= cantidad) {
            unidadesDisponibles -= cantidad;
        } else {
            throw new IllegalArgumentException("Cantidad no válida o insuficientes unidades disponibles.");
        }
    }

}
