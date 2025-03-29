package com.udem.tiendaProductos;

import java.util.ArrayList;
import java.util.List;

public class ManejadorReglas {

    private List<ReglaPrecio> reglas;

    public ManejadorReglas() {
        reglas = new ArrayList<>();
        // Registrar las reglas existentes
        reglas.add(new ReglaPrecioNormal());
        reglas.add(new ReglaPrecioPorPeso());
        reglas.add(new ReglaPrecioEspecial());
    }

    public ReglaPrecio obtenerReglaPrecio(String sku) {
        for (ReglaPrecio regla : reglas) {
            if (regla.esAplicable(sku)) {
                return regla;
            }
        }
        return null; // Si no hay ninguna regla aplicable
    }
}
