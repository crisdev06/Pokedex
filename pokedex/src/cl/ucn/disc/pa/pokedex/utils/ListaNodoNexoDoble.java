package cl.ucn.disc.pa.pokedex.utils;
import cl.ucn.disc.pa.pokedex.services.ListaCircular;
import cl.ucn.disc.pa.pokedex.models.Pokemon;
import cl.ucn.disc.pa.pokedex.services.NodoNexoDoble;

import java.util.ArrayList;


public class ListaNodoNexoDoble implements ListaCircular {
    private NodoNexoDoble head;
    private NodoNexoDoble tail;

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
            head.setSiguiente(tail);
            tail.setPrevio(head);
        }
        head.setPrevio(null);
        tail.setSiguiente(null);
        NodoNexoDoble aux = this.head;
        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nuevoNodo);
        nuevoNodo.setPrevio(aux);
        this.tail = nuevoNodo;


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
            System.out.println("la lista esta vaica.");
            return;
        }

        NodoNexoDoble actual = this.head;
        System.out.println(tail.getPokemon().getNombre());
        do {
            NodoNexoDoble siguiente = actual.getSiguiente();

            while (siguiente != null) {
                if (actual.getPokemon().getNombre().compareToIgnoreCase(siguiente.getPokemon().getNombre()) > 0) {
                    // Intercambiar los datos
                    NodoNexoDoble temp = actual;
                    actual=siguiente;
                    siguiente=temp;
                }

                siguiente = siguiente.getSiguiente();
            }

            actual = actual.getSiguiente();
        } while (actual != null);
    }

    public ArrayList<NodoNexoDoble> buscarEnUnRango(int inicio, int fin){

        ArrayList<NodoNexoDoble> rango = new ArrayList<>();
        if(isVacia()){
            System.out.println("la lista esta vaica.");
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