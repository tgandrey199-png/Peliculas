public class ListaSeries {
        private Nodo cabeza;

        public ListaSeries() {
            cabeza = null;
        }

        // Agregar una serie
        public void agregar(Serie serie) {
            Nodo nuevo = new Nodo(serie);

            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Nodo actual = cabeza;

                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }

                actual.siguiente = nuevo;
            }

            System.out.println("Serie agregada correctamente.");
        }

        // Mostrar las series
        public void mostrar() {
            if (cabeza == null) {
                System.out.println("No hay series registradas.");
                return;
            }

            Nodo actual = cabeza;
            int contador = 1;

            while (actual != null) {
                System.out.println("Serie #" + contador);
                actual.serie.mostrarInformacion();

                actual = actual.siguiente;
                contador++;
            }
        }

        // Buscar una serie
        public Serie buscar(String nombre) {
            Nodo actual = cabeza;

            while (actual != null) {
                if (actual.serie.getNombre()
                        .equalsIgnoreCase(nombre)) {
                    return actual.serie;
                }

                actual = actual.siguiente;
            }

            return null;
        }

        // Eliminar una serie
        public boolean eliminar(String nombre) {
            if (cabeza == null) {
                return false;
            }

            if (cabeza.serie.getNombre()
                    .equalsIgnoreCase(nombre)) {
                cabeza = cabeza.siguiente;
                return true;
            }

            Nodo actual = cabeza;

            while (actual.siguiente != null) {
                if (actual.siguiente.serie.getNombre()
                        .equalsIgnoreCase(nombre)) {
                    actual.siguiente = actual.siguiente.siguiente;
                    return true;
                }

                actual = actual.siguiente;
            }

            return false;
        }

        // Operación adicional: calcular promedio de temporadas
        public double calcularPromedioTemporadas() {
            if (cabeza == null) {
                return 0;
            }

            int suma = 0;
            int cantidad = 0;
            Nodo actual = cabeza;

            while (actual != null) {
                suma += actual.serie.getTemporadas();
                cantidad++;

                actual = actual.siguiente;
            }

            return (double) suma / cantidad;
        }

        // Contar las series
        public int contarSeries() {
            int contador = 0;
            Nodo actual = cabeza;

            while (actual != null) {
                contador++;
                actual = actual.siguiente;
            }

            return contador;
        }
}
