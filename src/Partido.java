public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String equipo_local, String equipo_visitante, int goles_local, int goles_visitante){
    equipoLocal = equipo_local;
    equipoVisitante = equipo_visitante;
    golesLocal = goles_local;
    golesVisitante = goles_visitante;
    }

    public String getLocal(){
        return equipoLocal;
    }

    public String getVisitante(){
        return equipoVisitante;
    }

    public int getGolesLocal(){
        return golesLocal;
    }

    public int getGolesVisitante(){
        return golesVisitante;
    }
}
