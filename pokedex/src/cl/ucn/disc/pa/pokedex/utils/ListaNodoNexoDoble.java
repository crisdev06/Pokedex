package cl.ucn.disc.pa.pokedex.utils;
import cl.ucn.disc.pa.pokedex.services.ListaNexoDoble;
import cl.ucn.disc.pa.pokedex.models.Pokemon;
import cl.ucn.disc.pa.pokedex.services.NodoNexoDoble;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * La clase ListaNodoNexoDoble implementa la interfaz ListaNexoDoble y representa
 * una lista con nexo doble de Pokemones.
 */
public class ListaNodoNexoDoble implements ListaNexoDoble {
    private NodoNexoDoble head;
    private NodoNexoDoble tail;
    /**
     * Crea una nueva instancia de ListaNodoNexoDoble.
     * Inicializa los atributos head y tail como null.
     */
    public ListaNodoNexoDoble() {
        this.head = null;
        this.tail = null;

    }
    @Override
    public void insertar(Pokemon pokemon) {
        NodoNexoDoble nuevoNodo = new NodoNexoDoble(pokemon);

        if (this.head == null) {
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
            head.setSiguiente(null);
            tail.setPrevio(null);
        }
        head.setPrevio(null);
        tail.setSiguiente(null);
        NodoNexoDoble aux = this.head;
        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nuevoNodo);
        nuevoNodo.setPrevio(aux);
        setTail(nuevoNodo);


    }
    @Override
    public void mostrar() {
        NodoNexoDoble aux = head;
        while (aux != null) {
            System.out.println(aux.getPokemon().toString());
            aux = aux.getSiguiente();
        }
    }
    @Override
    public void ordenarAlfabeticamente(){
        if (isVacia()){
            return;
        }
        NodoNexoDoble aux = this.head;
        while(aux.getSiguiente()!=null){
            Pokemon aux1;
            Pokemon aux2;
            if (aux.getPokemon().getNombre().toLowerCase().compareTo(aux.getSiguiente().getPokemon().getNombre().toLowerCase()) > 0) {
                aux1 = aux.getPokemon();
                aux2 = aux.getSiguiente().getPokemon();
                aux.setPokemon(aux2);
                aux.getSiguiente().setPokemon(aux1);
            }
            aux = aux.getSiguiente();
        }
    }
    @Override
    public LinkedList<Pokemon> buscarPorTipo(String tipo ){

        LinkedList<Pokemon> ordenadosPorTipo = new LinkedList<>();
        if (isVacia()){
            return null;
        }
        NodoNexoDoble aux = this.head;
        while (aux.getSiguiente() !=null){

            if (aux.getPokemon().getTipoUno().equalsIgnoreCase(tipo) || aux.getPokemon().getTipoDos().equalsIgnoreCase(tipo)){
                ordenadosPorTipo.add(aux.getPokemon());
            }
            aux = aux.getSiguiente();
        }

        return ordenadosPorTipo;
    }
    @Override
    public ArrayList<NodoNexoDoble> buscarEnUnRango(int inicio, int fin){

        ArrayList<NodoNexoDoble> rango = new ArrayList<>();
        if(isVacia()){
            return null;
        }
        NodoNexoDoble aux = this.head;
        while (aux.getSiguiente() != null){
            if ((aux.getPokemon().getId()==inicio || aux.getPokemon().getId()>=inicio) && (aux.getPokemon().getId()==fin || aux.getPokemon().getId()<=fin)){
                rango.add(aux);
            }
            aux=aux.getSiguiente();
        }
        return rango;
    }
    @Override
    public boolean buscarPokemon(int id){

        if (isVacia()){
            System.out.println("la lista esta vacia.");
            return false;
        }
        NodoNexoDoble aux = this.head;
        while(aux.getSiguiente() != null){
            if (aux.getPokemon().getId()==id){
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    public boolean isVacia(){
        if (this.head==null){
            return true;
        }
        return false;
    }
    @Override
    public ArrayList<NodoNexoDoble> buscarPorPrimeraEvolucion(){
        ArrayList<NodoNexoDoble> listaPrimeraEvolucion = new ArrayList<>();
        if (isVacia()){
            return null;
        }
        NodoNexoDoble aux = this.head;
        while (aux.getSiguiente()!=null){
            if (aux.getPokemon().getEtapa().equalsIgnoreCase("primera Evolucion")){
                listaPrimeraEvolucion.add(aux);
            }
            aux = aux.getSiguiente();
        }
        return listaPrimeraEvolucion;
    }
    @Override
    public Pokemon obtenerPokemon(int id){

        NodoNexoDoble aux = this.head;
        while (aux.getSiguiente()!= null){
            if (aux.getPokemon().getId()==id){
                return aux.getPokemon();
            }
            aux=aux.getSiguiente();
        }
        return null;
    }

    //gets y setters de la clase
    public NodoNexoDoble getHead() {
        return head;
    }

    public void setHead(NodoNexoDoble head) {
        this.head = head;
    }

    public NodoNexoDoble getTail() {
        return tail;
    }

    public void setTail(NodoNexoDoble tail) {
        this.tail = tail;
    }
}