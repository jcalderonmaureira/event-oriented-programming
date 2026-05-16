package cl.unab.ptec102.profesor.pokemon.gui.listeners;

import cl.unab.ptec102.profesor.pokemon.gui.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Opcion II Listeners
public class AgregarPokemonListener implements ActionListener {

    private VentanaPrincipal miVentana;

    public AgregarPokemonListener(VentanaPrincipal miVentana) {
        this.miVentana = miVentana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = this.miVentana.getTextArea().getText() + "\n Nombre: " + this.miVentana.getNombre().getText() + " - HP: " + this.miVentana.getHp().getText();
        this.miVentana.getTextArea().setText(texto);
    }


}
