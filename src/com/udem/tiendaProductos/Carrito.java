package com.udem.tiendaProductos;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Item> items = new ArrayList<>();

    public void agregarItem(Producto producto, int cantidad, ReglaPrecio regla) {
        items.add(new Item(producto, cantidad, regla));
    }

    public void borrarItem(Item item) {
        items.remove(item);
    }

    public float calcularTotal() {
        float total = 0;
        for (Item item : items) {
            total += item.calcularTotal();
        }
        return total;
    }

    public List<Item> getItems() {
        return items;
    }
}
