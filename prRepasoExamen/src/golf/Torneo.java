package golf;

import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private List<Jugador> inscritos;
    private int parCampo;

    public Torneo(List<Jugador> jugadores, int parCampo){
        inscritos = jugadores;
        this.parCampo = parCampo;
    }

    private int busca(String nombre){
        int pos = -1;
        boolean encontrado = false;
        for(int i = 0; i < inscritos.size() && !encontrado; i++){
            if(inscritos.get(i).getNombre().equals(nombre)){
                encontrado = true;
                pos = i;
            }
        }
        return pos;
    }

    public void agregaGolpes(String nombre, int glp){
        int pos = busca(nombre);
        if(pos != -1){
            inscritos.get(pos).agregaGolpes(glp);
        }else{
            throw new RuntimeException("El jugador no se encuentra en la lista");
        }
    }

    public int tarjetaDe(String nombre){
        int pos = busca(nombre);
        int tarjeta = 0;
        if(pos != -1){
             tarjeta = inscritos.get(pos).puntuacion() - parCampo;
        }else{
            throw new RuntimeException("El jugador no se encuentra en la lista");
        }
        return tarjeta;
    }

    private int mejorTarjeta(List<String> aux){
        int menorTarjeta = tarjetaDe(aux.get(0));
        String nombre1 = null;
        for(String nombre: aux){
            if(busca(nombre) != -1 && tarjetaDe(nombre) < menorTarjeta){
                nombre1 = nombre;
            }
        }
        return busca(nombre1);
    }

    public List<Jugador> clasificacion(){
        List<Jugador> aux = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        while(!aux.isEmpty()){
            int pos = mejorTarjeta(nombres);
            aux.add(inscritos.get(busca(nombres.get(pos))));
            nombres.remove(inscritos.get(busca(nombres.get(pos))));
        }
        return aux;
    }
}
