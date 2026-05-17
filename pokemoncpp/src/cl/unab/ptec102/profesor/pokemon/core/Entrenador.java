package cl.unab.ptec102.profesor.pokemon.core;

import java.util.ArrayList;
import java.util.Random;

public class Entrenador {

    private String nombre;
    private ArrayList<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    public void agregarPokemon(Pokemon pokemon) {
        this.pokemones.add(pokemon);
    }

    public void ataqueMasivo(Pokemon pobrePokemom){
        for(Pokemon pokemon : this.pokemones){
            pokemon.atacar(pobrePokemom);
        }
    }

    private void ataqueMasivoEntrenador(Entrenador otroEntrenador){
        this.ataqueMasivo(otroEntrenador.retornarPokemonRandom());
    }

    public Pokemon retornarPokemonRandom(){
        Random rand = new Random();
        int pos = rand.nextInt(pokemones.size());
        return this.pokemones.get(pos);
    }
}
