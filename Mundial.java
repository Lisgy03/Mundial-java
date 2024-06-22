package Mundial_de_futbol;

import java.util.ArrayList;
import java.util.List;

public class Mundial {
    private List<Equipo> equipos;
    private List<Grupo> grupos;
    private List<Estadio> estadios;
    private List<Partido> fixture;

    public Mundial() {
        this.equipos = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.estadios = new ArrayList<>();
        this.fixture = new ArrayList<>();
    }

    public void registrarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void registrarGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    public void registrarEstadio(Estadio estadio) {
        estadios.add(estadio);
    }

    public void generarFixture() {
        List<Equipo> equiposCopy = new ArrayList<>(equipos);

        while (equiposCopy.size() > 1) {
            Equipo equipo1 = equiposCopy.remove(0);
            for (Equipo equipo2 : equiposCopy) {
                Partido partido = new Partido(equipo1, equipo2);
                fixture.add(partido);
            }
        }
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public List<Estadio> getEstadios() {
        return estadios;
    }

    public List<Partido> getFixture() {
        return fixture;
    }
}
