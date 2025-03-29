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
                System.out.println((i + 1) + ". " + p.getNombre() + " (SKU: " + p.getSku() + ") - $" + p.getPrecioUnitario());
            }

            System.out.print("Seleccione un producto por número: ");
            int opcion = scanner.nextInt();
            if (opcion < 1 || opcion > productosDisponibles.size()) {
                System.out.println("Opción no válida.");
                continue;
            }

            Producto productoSeleccionado = productosDisponibles.get(opcion - 1);

            System.out.print("Ingrese la cantidad (en kilogramos si es por peso): ");
            int cantidad = scanner.nextInt();

            tienda.agregarProductoACarrito(usuario, productoSeleccionado, cantidad);
    
            // Actualizar unidades disponibles
            usuario.getCarrito().imprimirResumen();
            System.out.print("\n¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("s");
        }

        // Mostrar total final
        System.out.println("\n=== RESUMEN DEL CARRITO ===");
        tienda.finalizarCompra(usuario);
        System.out.println("¡Gracias por su compra!");
        scanner.close();
    }
}
