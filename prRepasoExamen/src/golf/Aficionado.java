package golf;

public class Aficionado extends Jugador{
    private int handicap;
    public Aficionado(String nombre, int hnp){
        super(nombre);
        handicap = hnp;
        if(!(handicap <= 54 && handicap >= 1)){
            throw new RuntimeException("Handicap no valido");
        }
    }

    @Override
    public int puntuacion(){
        return super.puntuacion() - handicap;
    }

    @Override
    public String toString(){
        return("nombre= "+super.getNombre()+", golpes="+super.puntuacion()+", handicap="+handicap);
    }


}
