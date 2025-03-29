package com.udem.tiendaProductos;

public class ReglaPrecioPorPeso implements ReglaPrecio {
    private static final String SKU_PREFIX = "WE";
    private static final int GRAMOS_POR_KILO = 1000;

    @Override
    public Boolean esAplicable(String sku) {
        return sku.startsWith(SKU_PREFIX);
    }

    @Override
    public float calcularTotal(int cantidadEnKilos, float precioPorGramo) {
        int cantidadEnGramos = cantidadEnKilos * GRAMOS_POR_KILO;
        return cantidadEnGramos * precioPorGramo;
    }
}
