package com.udem.tiendaProductos;

public class ReglaPrecioEspecial implements ReglaPrecio {
    private String sku;
    private float precioEspecial;
    private int cantidadMinima;
    
    public ReglaPrecioEspecial(String sku, float precioEspecial, int cantidadMinima) {
        this.sku = sku;
        this.precioEspecial = precioEspecial;
        this.cantidadMinima = cantidadMinima;
    }
    
    @Override
    public Boolean esAplicable(String sku) {
        return this.sku.equals(sku);
    }
    
    @Override
    public float calcularTotal(int cantidad, float precio) {
        if (cantidad >= cantidadMinima) {
            return cantidad * precioEspecial;
        } else {
            return cantidad * precio;
        }

    }        //return cantidad * precio; // Si no se cumple la regla, se aplica el precio normal

}
