package cl.unab.ptec102.profesor.pokemon.core;

public class Pokemon {

    private int id;
    private String nombre;
    private int hp;

    public Pokemon(int id, String nombre, int hp) {
        this.id = id;
        this.nombre = nombre;
        this.hp = hp;
    }

    public int getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public void atacar(Pokemon otroPokemon) {
        IO.println("--------------------------------------------");
        IO.println(this.nombre + " atacando genericamente a: " + otroPokemon.getNombre());
        IO.println("--------------------------------------------");
    }
}
