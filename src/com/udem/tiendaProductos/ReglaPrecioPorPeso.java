package com.udem.tiendaProductos;

public class ReglaPrecioPorPeso implements ReglaPrecio {
    private static final String SKU = "PESO";
    private static final float PRECIO_POR_KILO = 10.0f; // Precio por kilo

    @Override
    public Boolean esAplicable(String sku) {
        return SKU.equals(sku);
    }

    @Override
    public float calcularTotal(int cantidad, float precio) {
        return cantidad * PRECIO_POR_KILO;
    }

}
