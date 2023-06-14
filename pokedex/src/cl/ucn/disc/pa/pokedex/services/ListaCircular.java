package cl.ucn.disc.pa.pokedex.services;
import cl.ucn.disc.pa.pokedex.models.Pokemon;

public interface ListaCircular {
    void insertar(Pokemon pokemon);
    void mostrar();
    void ordenarAlfabeticamente();
}
