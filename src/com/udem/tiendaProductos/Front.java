package com.udem.tiendaProductos;

import java.util.Scanner;
import java.util.List;

public class Front {

    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Usuario usuario = new Usuario();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BIENVENIDO A LA TIENDA ===");

        boolean continuar = true;

        while (continuar) {
            // Mostrar productos
            List<Producto> productosDisponibles = tienda.getProductos();
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

            tienda.agregarProductoACarrito(usuario, productoSeleccionado, cantidad);

            // Mostrar resumen
            usuario.getCarrito().imprimirResumen();

            boolean repetirMenu = true;
            while (repetirMenu) {
                System.out.println("\n¿Qué desea hacer a continuación?");
                System.out.println("1. Agregar otro producto");
                System.out.println("2. Eliminar un producto");
                System.out.println("3. Finalizar compra");
                System.out.print("Seleccione una opción: ");
                int respuesta = scanner.nextInt();

                switch (respuesta) {
                    case 1:
                        repetirMenu = false; // Salimos del submenú para volver a agregar
                        break;

                    case 2:
                        List<Item> items = usuario.getCarrito().getItems();
                        if (items.isEmpty()) {
                            System.out.println("El carrito está vacío.");
                            break;
                        }

                        System.out.println("\n¿Qué item desea eliminar?: ");
                        int itemIndex = scanner.nextInt();

                        if (itemIndex < 1 || itemIndex > items.size()) {
                            System.out.println("Opción no válida.");
                        } else {
                            Item itemSeleccionado = items.get(itemIndex - 1);
                            tienda.eliminarItemDeCarrito(usuario, itemSeleccionado);
                            int cantidadProducto = productoSeleccionado.getUnidadesDisponibles();
                            productoSeleccionado.setUnidadesDisponibles(cantidadProducto+cantidad);
                            System.out.println("Producto eliminado correctamente.");

                            // Mostrar resumen actualizado
                            usuario.getCarrito().imprimirResumen();
                        }
                        // Volver a mostrar el menú principal
                        break;

                    case 3:
                        continuar = false;
                        repetirMenu = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        }

        // Mostrar total final
        System.out.println("\n=== RESUMEN DEL CARRITO ===");
        tienda.finalizarCompra(usuario);
        System.out.println("¡Gracias por su compra!");
        scanner.close();
    }
}
