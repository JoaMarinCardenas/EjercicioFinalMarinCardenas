import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ControlVuelos {
    private List<Itinerario> itinerarios;

    public ControlVuelos() {
        itinerarios = new ArrayList<>();
    }

    public void agregarItinerario(Itinerario itinerario) throws Exception {
        // Verificar si el piloto está disponible y no hay traslapes de horario
        for (Itinerario existente : itinerarios) {
            if (existente.getPiloto() == itinerario.getPiloto()) {
                if (existente.verificarTraslape(itinerario)) {
                    throw new Exception("El piloto " + itinerario.getPiloto().getNombre() + " tiene un traslape de horario.");
                }
            }
        }

        itinerarios.add(itinerario);
    }

    public static void main(String[] args) {
        ControlVuelos control = new ControlVuelos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("          | Aerolinea Rewards |");
        System.out.println("=================================================== ");
        System.out.println("Ingrese la cantidad de itinerarios que desea crear: ");
        int cantidadItinerarios = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadItinerarios; i++) {
            System.out.println("=================================================== ");
            System.out.println("Itinerario " + (i + 1));
            System.out.print("Ingrese la ciudad de origen: ");
            String origen = scanner.nextLine();

            System.out.print("Ingrese la ciudad de destino: ");
            String destino = scanner.nextLine();

            System.out.print("Ingrese la hora de inicio: ");
            int horaInicio = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese la hora de fin: ");
            int horaFin = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese el nombre del avión: ");
            String nombreAvion = scanner.nextLine();
            Avion avion = new Avion(nombreAvion);

            System.out.print("Ingrese el nombre del piloto: ");
            String nombrePiloto = scanner.nextLine();
            Piloto piloto = new Piloto(nombrePiloto);

            Itinerario itinerario = new Itinerario(origen, destino, horaInicio, horaFin);
            itinerario.asignarAvion(avion);
            itinerario.setPiloto(piloto);

            try {
                control.agregarItinerario(itinerario);
                System.out.println("Itinerario agregado correctamente.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        System.out.println("Lista de itinerarios:");
        for (Itinerario itinerario : control.itinerarios) {
            System.out.println(itinerario.toString());
        }
    }
}
