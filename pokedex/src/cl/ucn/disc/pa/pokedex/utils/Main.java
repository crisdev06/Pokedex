package cl.ucn.disc.pa.pokedex.utils;
import cl.ucn.disc.pa.pokedex.models.PokedexImpl;

public class Main {
    public static void main(String[] args) {
        PokedexImpl app = new PokedexImpl();
        app.lecturaArchivo();
        app.menu();

    }
}