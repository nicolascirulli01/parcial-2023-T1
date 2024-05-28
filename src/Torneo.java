import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
///import javax.net.ssl.CertPathTrustManagerParameters;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private Map<LocalDate, Set<Partido>> partidos;
    private Set<Equipo> equipos;
    private Map<String, Integer[]> tabla;

    public Torneo(){
        equipos = new HashSet<>();
        partidos = new HashMap<>();
        tabla = new HashMap<>();
    }

    public void cargarEquipo(String nombre, int fans){
        Equipo equipo = new Equipo(nombre, fans);
        equipos.add(equipo);
        tabla.put(nombre, new Integer[8]);
    }

    public void cargarPartido(String local, String visitante, LocalDate fecha, int goles_local, int goles_visitante){
        /**if (!(equipos.contains(local))) {
            throw new IllegalArgumentException(local + " no está en el torneo");
        }
        if (!(equipos.contains(visitante))) {
            throw new IllegalArgumentException(visitante + " no está en el torneo");
        }**/
        Partido partido = new Partido(local, visitante, goles_local, goles_visitante);
        if(!partidos.containsKey(fecha)){
            partidos.put(fecha, new HashSet<>());
        }
        partidos.get(fecha).add(partido);
    }

    public void mostrarPartidosFecha(LocalDate fecha){
        if (!(partidos.containsKey(fecha))){
            System.out.println("No hubo partidos el dia: " + fecha);
        } else {
            for (Partido partido : partidos.get(fecha)){
                System.out.println("Fecha: " + fecha.toString() + "," + partido.getLocal() + " (" + partido
                .getGolesLocal() + ") - " +  partido.getVisitante() + " (" + partido.getGolesVisitante() + ")");
            }
        }
    }
}
