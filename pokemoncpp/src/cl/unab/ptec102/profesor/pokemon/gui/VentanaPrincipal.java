package cl.unab.ptec102.profesor.pokemon.gui;
import cl.unab.ptec102.profesor.pokemon.core.*;
import cl.unab.ptec102.profesor.pokemon.gui.listeners.AgregarPokemonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private Gimnasio backend;
    private JTextField nombre;
    private JTextField hp;
    private JButton botonOp1;
    private JButton botonOp2;
    private JButton botonOp3;
    private JTextArea textArea;

    public VentanaPrincipal(Gimnasio backend) {
        super("Pokemon Ventana");
        this.backend = backend;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,800);
        setVisible(true);
        configurarInterfazGrafica();
    }

    private void configurarInterfazGrafica(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Campo Nombre
        this.nombre = new JTextField();
        this.nombre.setEditable(true);
        this.nombre.setSize(400,20);
        this.nombre.setText("Coloque el nombre del pokemon");
        panel.add(this.nombre);
        //Campo HP
        this.hp = new JTextField();
        this.hp.setText("Coloque el hp");
        this.hp.setSize(400,20);
        panel.add(this.hp);
        //  boton Agregar Pokemon
        this.botonOp1 = new JButton("Agregar Pokemon (Listener JFrame)");
        this.botonOp1.addActionListener(this);
        panel.add(this.botonOp1);
        this.botonOp2 = new JButton("Agregar Pokemon (Listener Otra Clase)");
        this.botonOp2.addActionListener(new AgregarPokemonListener(this));
        panel.add(this.botonOp2);
        this.botonOp3 = new JButton("Agregar Pokemon (Listener Embebido - Método Anónimo)");
        this.botonOp3.addActionListener(e-> {
            this.agregarPokemonOpcionIII();
        });
        panel.add(this.botonOp3);
        // TextArea lista de pokemons
        this.textArea = new JTextArea();
        this.textArea.setSize(400,400);
        this.textArea.setEditable(true);
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        scrollPane.setSize(400,200);
        panel.add(scrollPane);
        panel.setVisible(true);
        this.setContentPane(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = this.textArea.getText() + "\n Nombre: " + this.nombre.getText() + " - HP: " + this.hp.getText();
        this.textArea.setText(texto);
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getHp() {
        return hp;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    private void agregarPokemonOpcionIII(){
        String texto = this.textArea.getText() + "\n Nombre: " + this.nombre.getText() + " - HP: " + this.hp.getText();
        this.textArea.setText(texto);
    }
}
