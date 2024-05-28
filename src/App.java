import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        // Carga de equipos
        torneo.cargarEquipo("Team A", 100);
        torneo.cargarEquipo("Team B", 200);
        torneo.cargarEquipo("Team C", 300);
        torneo.cargarEquipo("Team D", 400);
        torneo.cargarEquipo("Team E", 500);
        torneo.cargarEquipo("Team F", 600);
        torneo.cargarEquipo("Team G", 700);
        torneo.cargarEquipo("Team H", 800);
        // Fecha 1 - 4/11
        torneo.cargarPartido("Team A", "Team B", LocalDate.of(2023, 11, 4), 2, 0);
        torneo.cargarPartido("Team C", "Team D", LocalDate.of(2023, 11, 4), 2, 1);
        torneo.cargarPartido("Team E", "Team F", LocalDate.of(2023, 11, 4), 2, 2);
        torneo.cargarPartido("Team G", "Team H", LocalDate.of(2023, 11, 4), 2, 3);
        // Fecha 2 - 12/11
        torneo.cargarPartido("Team B", "Team A", LocalDate.of(2023, 11, 12), 1, 1);
        torneo.cargarPartido("Team C", "Team D", LocalDate.of(2023, 11, 12), 3, 0);
        torneo.cargarPartido("Team F", "Team E", LocalDate.of(2023, 11, 12), 1, 2);
        torneo.cargarPartido("Team H", "Team G", LocalDate.of(2023, 11, 12), 0, 0);
        // Punto b.4
        torneo.mostrarPartidosFecha(LocalDate.of(2023,11,12));
        // Punto b.5
        //torneo.mostrarTabla();
    }
}
