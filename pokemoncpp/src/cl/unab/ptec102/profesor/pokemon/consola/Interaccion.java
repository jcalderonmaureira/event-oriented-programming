package cl.unab.ptec102.profesor.pokemon.consola;
import cl.unab.ptec102.profesor.pokemon.core.*;

public class Interaccion {

    public void comenzar() {
        PokemonTierra p1 = new PokemonTierra(1, "Bulbasaur", 100);
        PokemonTierra p2 = new PokemonTierra(2, "Pikachu", 100);
        PokemonTierra p3 = new PokemonTierra(3, "Charmander", 100);

        Entrenador ash = new Entrenador("Ash");
        ash.agregarPokemon(p1);
        ash.agregarPokemon(p2);

        ash.ataqueMasivo(p3);

        String nombre = IO.readln("Ingresa tu nombre pokemon");
        String hp = IO.readln("Ingresa tu hp pokemon");
        int valor = Integer.parseInt(hp);


        PokemonTierra pnuevo = new PokemonTierra(4,nombre,valor);
        ash.agregarPokemon(pnuevo);
        ash.ataqueMasivo(pnuevo);

    }
}
