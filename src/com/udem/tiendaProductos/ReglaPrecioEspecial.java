package com.udem.tiendaProductos;

public class ReglaPrecioEspecial implements ReglaPrecio {
    private static final String SKU = "SP";
    private static final float DESCUENTO_POR_TRES = 0.2f;     // 20%
    private static final float DESCUENTO_MAXIMO = 0.5f;       // 50%

    @Override
    public Boolean esAplicable(String sku) {
        return sku.startsWith(SKU);
    }

    @Override
    public float calcularTotal(int cantidad, float precioUnitario) {
        int setsOfThree = cantidad / 3;
        float porcentajeDescuento = Math.min(setsOfThree * DESCUENTO_POR_TRES, DESCUENTO_MAXIMO);
        return cantidad * precioUnitario * (1 - porcentajeDescuento);
    }
}
