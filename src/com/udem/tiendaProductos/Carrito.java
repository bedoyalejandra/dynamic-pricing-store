package com.udem.tiendaProductos;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Item> items = new ArrayList<>();

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new Item(producto, cantidad));
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

    public void imprimirResumen() {
        System.out.println("Resumen del carrito:");
        System.out.println("--------------------");

        int index = 1; // Índice para cada ítem
        for (Item item : items) {
            Producto producto = item.getProducto();
            float precioUnitario = producto.getPrecioUnitario();
            int cantidad = item.getCantidad();
            float totalItem = item.calcularTotal();

            System.out.printf("[%d] Producto: %s%n", index, producto.getNombre());
            System.out.printf("    SKU: %s%n", producto.getSku());
            System.out.printf("    Cantidad: %d%n", cantidad);
            System.out.printf("    Precio unitario: $%.2f%n", precioUnitario);
            System.out.printf("    Total por producto: $%.2f%n", totalItem);
            System.out.println("--------------------");
            
            index++; // Incrementamos el índice
        }

        System.out.printf("TOTAL A PAGAR: $%.2f%n", calcularTotal());
    }
} 

