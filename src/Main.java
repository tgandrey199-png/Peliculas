
import java.util.Scanner;

public class Main {
    private static final Scanner teclado = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }

    public static void main(String[] args) {
        ListaSeries lista = new ListaSeries();
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE SERIES =====");
            System.out.println("1. Agregar serie");
            System.out.println("2. Mostrar todas las series");
            System.out.println("3. Eliminar serie");
            System.out.println("4. Buscar serie");
            System.out.println("5. Editar serie");
            System.out.println("6. Calcular promedio de temporadas");
            System.out.println("7. Contar series registradas");
            System.out.println("0. Salir");

            opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {
                case 1: {
                    System.out.println("\n--- Registrar serie ---");

                    System.out.print("Nombre de la serie: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Género: ");
                    String genero = teclado.nextLine();

                    int temporadas;
                    do {
                        temporadas = leerEntero("Número de temporadas: ");
                        if (temporadas <= 0) {
                            System.out.println(
                                    "Debe ser mayor que cero.");
                        }
                    } while (temporadas <= 0);

                    int anio;
                    do {
                        anio = leerEntero("Año de estreno: ");
                        if (anio <= 0) {
                            System.out.println(
                                    "Ingresa un año válido.");
                        }
                    } while (anio <= 0);

                    Serie nueva = new Serie(
                            nombre, genero, temporadas, anio);

                    lista.agregar(nueva);
                    break;
                }

                case 2:
                    System.out.println("\n--- Series registradas ---");
                    lista.mostrar();
                    break;

                case 3: {
                    System.out.print(
                            "Nombre de la serie que deseas eliminar: ");
                    String nombre = teclado.nextLine();

                    if (lista.eliminar(nombre)) {
                        System.out.println(
                                "Serie eliminada correctamente.");
                    } else {
                        System.out.println(
                                "No se encontró esa serie.");
                    }
                    break;
                }

                case 4: {
                    System.out.print(
                            "Nombre de la serie que deseas buscar: ");
                    String nombre = teclado.nextLine();

                    Serie encontrada = lista.buscar(nombre);

                    if (encontrada != null) {
                        System.out.println("\nSerie encontrada:");
                        encontrada.mostrarInformacion();
                    } else {
                        System.out.println(
                                "No se encontró esa serie.");
                    }
                    break;
                }

                case 5: {
                    System.out.print(
                            "Nombre de la serie que deseas editar: ");
                    String nombre = teclado.nextLine();

                    Serie serie = lista.buscar(nombre);

                    if (serie == null) {
                        System.out.println(
                                "No se encontró esa serie.");
                        break;
                    }

                    System.out.println(
                            "Deja un campo vacío para conservar su valor.");

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = teclado.nextLine();
                    if (!nuevoNombre.trim().isEmpty()) {
                        serie.setNombre(nuevoNombre);
                    }

                    System.out.print("Nuevo género: ");
                    String nuevoGenero = teclado.nextLine();
                    if (!nuevoGenero.trim().isEmpty()) {
                        serie.setGenero(nuevoGenero);
                    }

                    System.out.print("Nuevas temporadas: ");
                    String textoTemporadas = teclado.nextLine();

                    if (!textoTemporadas.trim().isEmpty()) {
                        try {
                            int nuevasTemporadas =
                                    Integer.parseInt(textoTemporadas);

                            if (nuevasTemporadas > 0) {
                                serie.setTemporadas(nuevasTemporadas);
                            } else {
                                System.out.println(
                                        "Temporadas inválidas; se conserva el valor anterior.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(
                                    "Número inválido; se conserva el valor anterior.");
                        }
                    }

                    System.out.print("Nuevo año de estreno: ");
                    String textoAnio = teclado.nextLine();

                    if (!textoAnio.trim().isEmpty()) {
                        try {
                            int nuevoAnio = Integer.parseInt(textoAnio);

                            if (nuevoAnio > 0) {
                                serie.setAnioEstreno(nuevoAnio);
                            } else {
                                System.out.println(
                                        "Año inválido; se conserva el valor anterior.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(
                                    "Año inválido; se conserva el valor anterior.");
                        }
                    }

                    System.out.println("Serie actualizada correctamente.");
                    break;
                }

                case 6:
                    if (lista.contarSeries() == 0) {
                        System.out.println(
                                "No hay series para calcular el promedio.");
                    } else {
                        System.out.printf(
                                "Promedio de temporadas: %.2f%n",
                                lista.calcularPromedioTemporadas());
                    }
                    break;

                case 7:
                    System.out.println(
                            "Total de series registradas: "
                                    + lista.contarSeries());
                    break;

                case 0:
                    System.out.println(
                            "Saliendo del sistema. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println(
                            "Opción no válida. Intenta nuevamente.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}

