import cl.unab.ptec102.profesor.pokemon.consola.*;
import cl.unab.ptec102.profesor.pokemon.core.Gimnasio;
import cl.unab.ptec102.profesor.pokemon.gui.PokemonForm;
import cl.unab.ptec102.profesor.pokemon.gui.VentanaPokemon;
import cl.unab.ptec102.profesor.pokemon.gui.VentanaPrincipal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //Interaccion interaccion = new Interaccion();
    //interaccion.comenzar();
    //Gimnasio backend = new Gimnasio();
    //VentanaPrincipal miVentana = new  VentanaPrincipal(backend);
    //miVentana.setVisible(true);
    //PokemonForm ventana = new PokemonForm();
    Gimnasio backend = new Gimnasio();
    VentanaPokemon ventanaPokemon = new VentanaPokemon(backend);
}
