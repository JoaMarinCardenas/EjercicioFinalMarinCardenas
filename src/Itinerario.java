public class Itinerario {
        private String origen, destino;
        private int horaInicio, horaFin;
        private Avion avion;
        Piloto piloto;

        public Itinerario(String origen, String destino, int horaInicio, int horaFin) {
            this.origen = origen;
            this.destino = destino;
            this.horaInicio = horaInicio;
            this.horaFin = horaFin;
        }

        public void asignarAvion(Avion avion) {
            this.avion = avion;
        }

        public void asignarPiloto(Piloto piloto) {
            this.piloto = piloto;
        }

        public boolean verificarTraslape(Itinerario otro) {
            if (horaInicio >= otro.horaFin || horaFin <= otro.horaInicio) {
                return false; // No hay traslape
            }
            return true; // Hay traslape
        }

        public String toString() {
            return "Itinerario de " + origen + " a " + destino + ", Hora: " + horaInicio + "-" + horaFin + ", Avión: " + avion.getNombre() + ", Piloto: " + piloto.getNombre();
        }
    }

