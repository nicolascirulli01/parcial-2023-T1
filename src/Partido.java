public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(Equipo equipo_local, Equipo equipo_visitante, int goles_local, int goles_visitante){
    equipoLocal = equipo_local;
    equipoVisitante = equipo_visitante;
    golesLocal = goles_local;
    golesVisitante = goles_visitante;
    }

    public boolean empate(){
        return golesLocal == golesVisitante;
    }

    public String ganador(){
        if (golesLocal > golesVisitante) {
            return equipoLocal.getNombre();
        } else{
            return equipoVisitante.getNombre();
        }
    }


    public String perdedor(){
        if (golesLocal < golesVisitante) {
            return equipoLocal.getNombre();
        } else{
            return equipoVisitante.getNombre();
        }
    }

    public String getLocal(){
        return equipoLocal.getNombre();
    }

    public String getVisitante(){
        return equipoVisitante.getNombre();
    }

    public int getGolesLocal(){
        return golesLocal;
    }

    public int getGolesVisitante(){
        return golesVisitante;
    }

    @Override
    public String toString() {
        return equipoLocal.getNombre() + " (" + golesLocal + ") - " + equipoVisitante.getNombre() + " (" + golesVisitante + ")";
    }

}
