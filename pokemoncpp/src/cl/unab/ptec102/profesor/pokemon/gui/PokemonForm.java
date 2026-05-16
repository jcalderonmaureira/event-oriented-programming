package cl.unab.ptec102.profesor.pokemon.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonForm {
    private JTextField tfNombre;
    private JButton btAgregarPokemon;
    private JTextField tfHp;
    private JTextArea taListaPokemones;
    private JPanel panelPrincipal;

    public PokemonForm(){
        JFrame frame = new JFrame("Pokemon Form");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        btAgregarPokemon.addActionListener(e->{
           agregarPokemonOpcionIII();
        });
    }

    private void agregarPokemonOpcionIII(){
        String texto = this.taListaPokemones.getText() + "\n Nombre: " + this.tfNombre.getText() + " - HP: " + this.tfHp.getText();
        this.taListaPokemones.setText(texto);
    }



}
