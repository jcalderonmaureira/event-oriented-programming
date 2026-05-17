package cl.unab.ptec102.profesor.pokemon.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Gimnasio {

    private ArrayList<Pokemon> registroPokemones;

    public Gimnasio() {
        this.registroPokemones = new ArrayList<>();
        this.cargarRegistro();
    }

    public void cargarRegistro(){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("pokemones.csv"));

            String linea = reader.readLine();
            while (linea != null) {
                String[] datos = linea.split(",");
                this.agregarPokemon(Integer.parseInt(datos[1]),datos[0],Integer.parseInt(datos[2]),false);
                linea = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            IO.println("Archivo no encontrado");
        }

    }

    public void guardarRegistro() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("pokemones.csv"));
            String linea = "";
            for(Pokemon p:this.registroPokemones){
                linea = p.getNombre() + "," + p.getId() + "," + p.getHp() + "\n";
                writer.write(linea);
            }
            writer.close();


        } catch (Exception e) {
            IO.println("Archivo no encontrado");
        }
    }

    public void agregarPokemon(int id, String nombre, int hp, boolean guardarRegistro){
        Pokemon nuevo = new Pokemon(id,nombre,hp);
        this.registroPokemones.add(nuevo);
        if(guardarRegistro){
            this.guardarRegistro();
        }
    }

    public String getListaPokemonesString(){
        String lista = "";

        for(Pokemon p:this.registroPokemones){
            lista += "Id: " + p.getId() + " - Nombre: " + p.getNombre() + " - HP: " + p.getHp() + "\n";
        }
        return lista;
    }

    public void comenzarBatalla(){

        PokemonAgua p1 = new PokemonAgua(2,"Pikachu",150);
        PokemonTierra p2 = new PokemonTierra(3,"Charizard",300);

        Entrenador e1 = new Entrenador("Ash");
        e1.agregarPokemon(p1);
        e1.agregarPokemon(p2);

        PokemonTierra pobre = new PokemonTierra(8,"Charmander",100);

        e1.ataqueMasivo(pobre);

    }
}
