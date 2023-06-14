package cl.ucn.disc.pa.pokedex.services;
import cl.ucn.disc.pa.pokedex.models.Pokemon;
public class NodoNexoDoble {
    private Pokemon pokemon;
    private NodoNexoDoble previo;
    private NodoNexoDoble siguiente;

    public NodoNexoDoble(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.previo = null;
        this.siguiente = null;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public NodoNexoDoble getPrevio() {
        return previo;
    }

    public void setPrevio(NodoNexoDoble previo) {
        this.previo = previo;
    }

    public NodoNexoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoNexoDoble siguiente) {
        this.siguiente = siguiente;
    }
}
