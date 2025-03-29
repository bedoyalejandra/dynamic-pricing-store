package com.udem.tiendaProductos;

public class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private int unidadesDisponibles;
    private float precioUnitario;

    public Producto(String sku, String nombre, String descripcion, int unidadesDisponibles, float precioUnitario) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadesDisponibles = unidadesDisponibles;
        this.precioUnitario = precioUnitario;
    }

    public boolean tieneUnidades(int cantidad) {
        return unidadesDisponibles >= cantidad;
    }

    public void descontarUnidades(int cantidad) {
        unidadesDisponibles -= cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public String getSku() {
        return sku;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }
    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }


}
