public class Serie {
        private String nombre;
        private String genero;
        private int temporadas;
        private int anioEstreno;

        public Serie(String nombre, String genero,
                     int temporadas, int anioEstreno) {
            this.nombre = nombre;
            this.genero = genero;
            this.temporadas = temporadas;
            this.anioEstreno = anioEstreno;
        }

        public String getNombre() {
            return nombre;
        }

        public String getGenero() {
            return genero;
        }

        public int getTemporadas() {
            return temporadas;
        }

        public int getAnioEstreno() {
            return anioEstreno;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public void setTemporadas(int temporadas) {
            this.temporadas = temporadas;
        }

        public void setAnioEstreno(int anioEstreno) {
            this.anioEstreno = anioEstreno;
        }

        public void mostrarInformacion() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Género: " + genero);
            System.out.println("Temporadas: " + temporadas);
            System.out.println("Año de estreno: " + anioEstreno);
            System.out.println("----------------------------");
        }
}
