package cl.unab.ptec102.profesor.pokemon.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Gimnasio {

    private ArrayList<Pokemon> registroPokemones;
    private Connection conn;

    public Gimnasio() {
        this.registroPokemones = new ArrayList<>();
        this.conectarDB();
        this.crearEsquema();
        this.cargarRegistro(true); //se saca carga archivo CSV
    }

    public void conectarDB(){

        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:sqlite:identifier.sqlite"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearEsquema() {
        String sql = """
            CREATE TABLE IF NOT EXISTS pokemones (
                id      INTEGER PRIMARY KEY AUTOINCREMENT,
                id_pokedex INTEGER NOT NULL,
                nombre  TEXT    NOT NULL,
                hp  TEXT        NOT NULL
            )
            """;
        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cargarRegistro(boolean desdeDB){

        try {
            if(desdeDB){

                List<String[]> pokemonesDB = this.listar();
                for(String[] pokemonDB : pokemonesDB){
                    this.agregarPokemon(Integer.parseInt(pokemonDB[0]), pokemonDB[1], Integer.parseInt(pokemonDB[2]), false);
                }
            }
            else {
                BufferedReader reader = new BufferedReader(new FileReader("pokemones.csv"));

                String linea = reader.readLine();
                while (linea != null) {
                    String[] datos = linea.split(",");
                    this.agregarPokemon(Integer.parseInt(datos[1]), datos[0], Integer.parseInt(datos[2]), false);
                    linea = reader.readLine();
                }
                reader.close();
            }
        } catch (Exception e) {
            IO.println(e.getMessage());
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
            try {
                this.insertarPokemonDB(id,nombre,hp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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

    // CREATE
    public void insertarPokemonDB(int id, String nombre, int hp)
            throws SQLException {
        String sql = "INSERT INTO pokemones (id_pokedex, nombre, hp) VALUES (?, ?, ?)";
        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setInt(3, hp);
            ps.executeUpdate();
        }
    }

    public List<String[]> listar() throws SQLException {
        List<String[]> lista = new ArrayList<>();
        String sql = "SELECT id_pokedex,nombre,hp FROM pokemones";
        try(Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new String[]{
                        rs.getString("id_pokedex"),
                        rs.getString("nombre"),
                        rs.getString("hp")
                });
            }
        }
        return lista;
    }

}
