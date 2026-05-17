package cl.unab.ptec102.profesor.pokemon.gui;

import cl.unab.ptec102.profesor.pokemon.core.Gimnasio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPokemon {
    private JPanel panelPrincipal;
    private JTextField tfNombre;
    private JTextField tfId;
    private JTextField tfHp;
    private JButton btCrearPokemon;
    private JTextArea taListaPokemones;
    private Gimnasio elGimnasio;

    public VentanaPokemon(Gimnasio elGimnasio) {
        this.elGimnasio = elGimnasio;
        JFrame frame = new JFrame("Pokemon Ventana");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.taListaPokemones.setText(this.elGimnasio.getListaPokemonesString());
        btCrearPokemon.addActionListener(e->{
            btCrearPokemonListener();
        });
    }

    public void btCrearPokemonListener(){
        String nombre = tfNombre.getText();
        int id = Integer.parseInt(tfId.getText());
        int hp = Integer.parseInt(tfHp.getText());
        this.elGimnasio.agregarPokemon(id, nombre, hp, true);
        this.taListaPokemones.setText(this.elGimnasio.getListaPokemonesString());
    }
}
