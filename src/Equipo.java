import java.util.Objects;
public class Equipo {
    private String nombre;
    private int fans;

    public Equipo(String nombre, int fans){
        this.nombre = nombre;
        this.fans = fans;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public boolean equals(Object otro) {
    if (this == otro) {
        return true;
    }

    if (otro == null || this.getClass() != otro.getClass()) {
        return false;
    }

    Equipo otro2 = (Equipo) otro;
    return this.nombre.equals(otro2.nombre);
}

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}