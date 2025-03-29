package com.udem.tiendaProductos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Front {

    private static final List<Producto> productosDisponibles = new ArrayList<>();

    static {
        productosDisponibles.add(new Producto("EA001", "Arroz Diana", "Arroz blanco", 100, 2500));
        productosDisponibles.add(new Producto("WE002", "Queso parmesano", "Queso por peso", 50, 0.02f)); // precio por
                                                                                                         // gramo
        productosDisponibles.add(new Producto("SP003", "Cereal Azucarado", "Caja de cereal", 30, 5000));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Item> carrito = new ArrayList<>();
        System.out.println("=== BIENVENIDO A LA TIENDA ===");

        boolean continuar = true;

        while (continuar) {
            // Mostrar productos
            System.out.println("\nProductos disponibles:");
            for (int i = 0; i < productosDisponibles.size(); i++) {
                Producto p = productosDisponibles.get(i);
                System.out.println(
                        (i + 1) + ". " + p.getNombre() + " (SKU: " + p.getSku() + ") - $" + p.getPrecioUnitario());
            }

            System.out.print("Seleccione un producto por número: ");
            int opcion = scanner.nextInt();
            if (opcion < 1 || opcion > productosDisponibles.size()) {
                System.out.println("Opción no válida.");
                continue;
            }

            Producto productoSeleccionado = productosDisponibles.get(opcion - 1);

            System.out.print("Ingrese la cantidad");
            if (productoSeleccionado.getSku().startsWith("WE")) {
                System.out.print(" (en kilogramos): ");
            } else {
                System.out.print(" (en unidades): ");
            }

            int cantidad = scanner.nextInt();

            if (cantidad > productoSeleccionado.getUnidadesDisponibles()) {
                System.out.println("No hay suficientes unidades disponibles.");
                continue;
            }

            // Crear ítem (usa internamente el manejador de reglas)
            Item item = new Item(productoSeleccionado, cantidad);
            carrito.add(item);

            // Actualizar unidades disponibles
            productoSeleccionado.descontarUnidades(cantidad);

            System.out.println("Producto agregado: " + productoSeleccionado.getNombre() + " x" + cantidad);
            System.out.printf("Subtotal: $%.2f%n", item.calcularTotal());

            System.out.print("\n¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("s");
        }

        // Mostrar total final
        float total = 0;
        System.out.println("\n=== RESUMEN DEL CARRITO ===");
        for (Item item : carrito) {
            float subtotal = item.calcularTotal();
            System.out.println(item.getProducto().getNombre() + ": $" + subtotal);
            total += subtotal;
        }

        System.out.printf("TOTAL COMPRA: $%.2f%n", total);
        System.out.println("¡Gracias por su compra!");
        scanner.close();
    }
}
