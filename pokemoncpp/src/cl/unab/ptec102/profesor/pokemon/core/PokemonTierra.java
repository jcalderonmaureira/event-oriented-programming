package cl.unab.ptec102.profesor.pokemon.core;

public class PokemonTierra extends Pokemon {

    public PokemonTierra(int id, String nombre, int hp) {
        super(id, nombre, hp);
    }

    @Override
    public void atacar(Pokemon otroPokemon) {
        IO.println("--------------------------------------------");
        IO.println(this.getNombre() + " atacando especificamente (Tierra) a: " + otroPokemon.getNombre());
        IO.println("--------------------------------------------");
        otroPokemon.setHp(otroPokemon.getHp()-10);
    }
}
