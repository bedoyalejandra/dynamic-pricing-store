package com.udem.tiendaProductos;

public class ReglaPrecioNormal implements ReglaPrecio {

    @Override
    public Boolean esAplicable(String sku) {
        return sku.startsWith("EA");
    }

    @Override
    public float calcularTotal(int cantidad, float precio) {
        return cantidad * precio;
    }
}
