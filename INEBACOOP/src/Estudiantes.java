
    public class Estudiantes {

        public class Estudiante{

            private String nombreEstudiante;
            private String Constrasena;

            public Estudiante(String nombreEstudiante, String constrasena) {
                this.nombreEstudiante = nombreEstudiante; // Corregido
                this.Constrasena = constrasena; // Corregido
            }

            public String getUsuario() {
                return nombreEstudiante;
            }

            public String getConstrasena() {
                return Constrasena;
            }
        }

    }
