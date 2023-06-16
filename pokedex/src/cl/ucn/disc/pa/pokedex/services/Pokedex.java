package cl.ucn.disc.pa.pokedex.services;
/**
 * Interfaz que define los métodos básicos de una Pokedex.
 */

public interface Pokedex {
    /**
     * Realiza la lectura del archivo de datos de la Pokedex.
     */
    void lecturaArchivo();
    /**
     * Muestra el menú principal de la Pokedex y permite interactuar con ella.
     */
    void menu();


}
