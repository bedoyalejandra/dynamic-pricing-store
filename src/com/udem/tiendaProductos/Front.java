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
    
            // Actualizar unidades disponibles
            usuario.getCarrito().imprimirResumen();
            System.out.print("\n1. ¿Desea agregar otro producto?: ");
            System.out.print("\n2. ¿Desea eliminar un producto?: ");
            System.out.print("\n3. Finalizar compra: ");
            int respuesta = scanner.nextInt();
            if (respuesta == 1) {
               continuar = true;
            }
            else 
            if (respuesta == 2) {
              System.out.println("\n¿Que item desea eliminar?: ");
              int itemIndex = scanner.nextInt();
              List <Item> items = usuario.getCarrito().getItems();
              if (itemIndex < 1 || itemIndex > items.size()) {
                System.out.println("Opción no válida.");
                continue;
            }
            Item itemSeleccionado = items.get(itemIndex);
            tienda.eliminarItemDeCarrito(usuario, itemSeleccionado);
            System.out.print("\n Finalizar compra: s/n");
            String respuestaDos = scanner.next();
            continuar = respuestaDos.equalsIgnoreCase("s");
            }
            else 
            if(respuesta == 3) {
               continuar = false;
            }
        }

        // Mostrar total final
        System.out.println("\n=== RESUMEN DEL CARRITO ===");
        tienda.finalizarCompra(usuario);
        System.out.println("¡Gracias por su compra!");
        scanner.close();
    }
}
