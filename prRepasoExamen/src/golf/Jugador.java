package golf;

public class Jugador{
    private String nombre;
    private int numGolpes;

    public Jugador(String nombre){
        this.nombre = nombre;
        numGolpes = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public int puntuacion(){
        return numGolpes;
    }

    public void agregaGolpes(int glp){
        numGolpes += glp;
    }

    @Override
    public String toString(){
        return ("nombre= "+ nombre + ", golpes= "+numGolpes);
    }
}
