package Mundial_de_futbol;

import java.util.List;

public class Equipo {
    private String nombre;
    private String entrenador;
    private List<String> jugadores;

    public Equipo(String nombre, String entrenador, List<String> jugadores) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public List<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<String> jugadores) {
        this.jugadores = jugadores;
    }
}
