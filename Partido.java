package Mundial_de_futbol;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private boolean jugado;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
        this.jugado = false;
    }

    public void jugarPartido(int golesEquipo1, int golesEquipo2) {
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.jugado = true;
    }

    public String mostrarResultado() {
        if (jugado) {
            return equipo1.getNombre() + " " + golesEquipo1 + " - " + golesEquipo2 + " " + equipo2.getNombre();
        } else {
            return equipo1.getNombre() + " vs " + equipo2.getNombre() + " - Aún no se ha jugado";
        }
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public Equipo getGanador() {
        if (golesEquipo1 > golesEquipo2) {
            return equipo1;
        } else if (golesEquipo2 > golesEquipo1) {
            return equipo2;
        } else {
            return null;
        }
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public boolean isJugado() {
        return jugado;
    }
}
