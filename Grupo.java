package Mundial_de_futbol;

import java.util.List;
import java.util.ArrayList;


public class Grupo {
    private String nombre;
    private List<Equipo> equipos;

    public Grupo(String nombre, List<Equipo> equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void agregarEquipo(Equipo equipo) {
        if (equipos == null) {
            equipos = new ArrayList<>();
        }
        equipos.add(equipo);
    }
}
