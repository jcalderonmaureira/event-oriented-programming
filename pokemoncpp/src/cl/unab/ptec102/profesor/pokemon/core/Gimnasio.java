package cl.unab.ptec102.profesor.pokemon.core;

import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Pokemon> pokemons;

    public Gimnasio(){
        Entrenador entrenadorPorDefecto = new Entrenador();
        this.entrenadores = new ArrayList<>();
        this.entrenadores.add(entrenadorPorDefecto);
        this.pokemons = new ArrayList<>();
    }
    public void agregarPokemon(String Nombre, int id, int hp){
        Pokemon nuevoPokemon = new Pokemon(id, Nombre, hp);
        this.pokemons.add(nuevoPokemon);

    }

    public String getListaPokemons(){
        String listaPokemons = "";
        for(Pokemon pokemon : this.pokemons){
            listaPokemons += "Nombre: " + pokemon.getNombre() + " - Id:  " + pokemon.getId() + " - HP: " + pokemon.getHp() + "\n";
        }
        return listaPokemons;
    }

    Entrenador getEntrenadorPorDefecto(){
        if(!this.entrenadores.isEmpty())
            return this.entrenadores.getFirst();
        else
            return null;
    }
}
