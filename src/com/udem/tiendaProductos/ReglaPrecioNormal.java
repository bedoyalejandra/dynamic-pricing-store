package com.udem.tiendaProductos;

public class ReglaPrecioNormal implements ReglaPrecio {
    private static final String SKU = "EA";

    @Override
    public Boolean esAplicable(String sku) {
        return sku.startsWith(SKU);
    }

    @Override
    public float calcularTotal(int cantidad, float precio) {
        return cantidad * precio;
    }
}
