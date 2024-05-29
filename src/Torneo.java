import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

public class Torneo {
    private Map<LocalDate, Set<Partido>> partidos;
    private Map<String, Equipo> equipos;

    public Torneo(){
        equipos = new HashMap<>();
        partidos = new HashMap<>();
    }

    public void cargarEquipo(String nombre, int fans){
        Equipo equipo = new Equipo(nombre, fans);
        equipos.put(nombre, equipo);
    }

    public void cargarPartido(String local, String visitante, LocalDate fecha, int goles_local, int goles_visitante){
        if (!(equipos.containsKey(local))) {
            throw new IllegalArgumentException(local + " no está en el torneo");
        }
        if (!(equipos.containsKey(visitante))) {
            throw new IllegalArgumentException(visitante + " no está en el torneo");
        }
        Partido partido = new Partido(equipos.get(local), equipos.get(visitante), goles_local, goles_visitante);
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
                System.out.println("Fecha: " + fecha.toString() + "," + partido);
            }
        }
    }
    public void mostrarTabla() {
        String salida = "Equipo | Ju | Pu | Ga | Em | Pe | GF | GC | DG |";
        Map<String, Integer[]> tabla = new HashMap<>();

        for (String equipo : equipos.keySet()){
            Integer[] estadistica_equipo = new Integer[8];
            
            for (int i = 0; i < estadistica_equipo.length; i++) {
                estadistica_equipo[i] = 0;
            }

            tabla.put(equipo,estadistica_equipo);
        }
        //sumo puntos goles etc a tabla
        for (LocalDate fecha : partidos.keySet()){
            for (Partido partido : partidos.get(fecha)){
                if (partido.empate()) {
                    tabla.get(partido.getLocal())[1] += 1;
                    tabla.get(partido.getVisitante())[1] += 1; //columna puntos

                    tabla.get(partido.getLocal())[3] += 1;
                    tabla.get(partido.getVisitante())[3] += 1; //columna empates
                } else {
                    tabla.get(partido.ganador())[1] += 3; //puntos
                    tabla.get(partido.ganador())[2] += 1; //columna ganados

                    tabla.get(partido.perdedor())[4] += 1; //columna perdidos
                    
                }
                tabla.get(partido.getLocal())[0] += 1; 
                tabla.get(partido.getVisitante())[0] += 1; //jugados

                tabla.get(partido.getLocal())[5] += partido.getGolesLocal();
                tabla.get(partido.getLocal())[6] += partido.getGolesVisitante(); 

                tabla.get(partido.getVisitante())[5] += partido.getGolesVisitante();
                tabla.get(partido.getVisitante())[6] += partido.getGolesLocal(); 

                tabla.get(partido.getLocal())[7] = tabla.get(partido.getLocal())[5] - tabla.get(partido.getLocal())[6]; //diff de gol
                tabla.get(partido.getVisitante())[7] = tabla.get(partido.getVisitante())[5] - tabla.get(partido.getVisitante())[6]; //diff de gol
            } //armado de la tabla
        }
        //printeo de la tabla
        for (String equipo : tabla.keySet()){
            salida += "\n";
            salida += equipo + " | ";
            for (Integer i : tabla.get(equipo)){
                salida += i + " | ";
            }
        }
        System.out.println(salida);
    }
}
/*
Equipo | Ju | Pu | Ga | Em | Pe | GF | GC | DG
Team C | 2 | 6 | 2 | 0 | 0 | 5 | 1 | 4 |
Team A | 2 | 4 | 1 | 1 | 0 | 3 | 1 | 2 |
Team H | 2 | 4 | 1 | 1 | 0 | 3 | 2 | 1 |
Team E | 2 | 4 | 1 | 1 | 0 | 4 | 3 | 1 |
Team F | 2 | 1 | 0 | 1 | 1 | 3 | 4 | -1 |
Team G | 2 | 1 | 0 | 1 | 1 | 2 | 3 | -1 |
Team B | 2 | 1 | 0 | 1 | 1 | 1 | 3 | -2 |
Team D | 2 | 0 | 0 | 0 | 2 | 1 | 5 | -4 |
*/