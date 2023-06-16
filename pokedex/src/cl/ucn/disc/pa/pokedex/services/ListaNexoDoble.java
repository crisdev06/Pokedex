package cl.ucn.disc.pa.pokedex.services;
import cl.ucn.disc.pa.pokedex.models.Pokemon;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * La interfaz ListaNexoDoble define las operaciones básicas que se pueden realizar
 * en una lista con nexo doble de Pokemones.
 */
public interface ListaNexoDoble {
    /**
     * Inserta un Pokemon en la lista.
     *
     * @param pokemon el Pokemon a insertar.
     */
    void insertar(Pokemon pokemon);
    /**
     * Muestra los Pokemones almacenados en la lista.
     */
    void mostrar();
    /**
     * Ordena los Pokemones alfabéticamente por su nombre.
     */
    void ordenarAlfabeticamente();
    /**
     * Busca los Pokemones que coincidan con un tipo específico.
     *
     * @param tipo el tipo de Pokemon a buscar.
     * @return una lista enlazada (LinkedList) de los Pokemones encontrados.
     */
    LinkedList<Pokemon> buscarPorTipo(String tipo );
    /**
     * Busca los Pokemones cuyos IDs se encuentren en un rango específico.
     *
     * @param inicio el valor de inicio del rango.
     * @param fin el valor de fin del rango.
     * @return un ArrayList de nodos (NodoNexoDoble) que contienen los Pokemones encontrados.
     */
    ArrayList<NodoNexoDoble> buscarEnUnRango(int inicio, int fin);
    /**
     * Verifica si un Pokemon con el ID especificado existe en la lista.
     *
     * @param id el ID del Pokemon a buscar.
     * @return true si se encuentra el Pokemon, false en caso contrario.
     */
    boolean buscarPokemon(int id);
    /**
     * Busca los Pokemones que tienen una primera evolución.
     *
     * @return un ArrayList de nodos (NodoNexoDoble) que contienen los Pokemones de primera evolución.
     */
    ArrayList<NodoNexoDoble> buscarPorPrimeraEvolucion();
    /**
     * Obtiene un Pokemon en base a su ID.
     *
     * @param id el ID del Pokemon a obtener.
     * @return el Pokemon correspondiente al ID especificado, o null si no se encuentra.
     */
    Pokemon obtenerPokemon(int id);

}
