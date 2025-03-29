package com.udem.tiendaProductos;

public interface ReglaPrecio {

    public Boolean esAplicable(String sku);
    public float calcularTotal( int cantidad, float precio);
    
}
