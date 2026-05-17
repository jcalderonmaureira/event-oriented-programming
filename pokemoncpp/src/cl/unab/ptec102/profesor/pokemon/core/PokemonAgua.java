package cl.unab.ptec102.profesor.pokemon.core;

public class PokemonAgua extends Pokemon {

    public PokemonAgua(int id, String nombre, int hp) {
        super(id, nombre, hp);
    }

    @Override
    public void atacar(Pokemon otroPokemon){
        IO.println(this.getNombre() + " ataca de manera especifica a " + otroPokemon.getNombre());
        otroPokemon.setHp(otroPokemon.getHp() - 10);
    }
}
