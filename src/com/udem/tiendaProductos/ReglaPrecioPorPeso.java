package com.udem.tiendaProductos;

public class ReglaPrecioPorPeso implements ReglaPrecio {

    private static final String SKU = "WE";

    @Override
    public Boolean esAplicable(String sku) {
        return sku.startsWith(SKU);
    }

    @Override
    public float calcularTotal(int cantidad, float precioUnitario) {
        return cantidad * precioUnitario; // cantidad en gramos
    }
}
