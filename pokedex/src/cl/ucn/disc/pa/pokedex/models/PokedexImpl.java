package cl.ucn.disc.pa.pokedex.models;
import cl.ucn.disc.pa.pokedex.services.NodoNexoDoble;
import cl.ucn.disc.pa.pokedex.services.Pokedex;
import cl.ucn.disc.pa.pokedex.utils.ListaNodoNexoDoble;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class PokedexImpl implements Pokedex {

    private ListaNodoNexoDoble listaPokemons;
    private ArrayList<NodoNexoDoble> contenedor;
    private LinkedList<Pokemon> linkedList;


    public PokedexImpl(){
        this.listaPokemons= new ListaNodoNexoDoble();
        this.contenedor= new ArrayList<>();
        this.linkedList= new LinkedList<>();


    }

    @Override
    public void lecturaArchivo() {

        try {
            Scanner scanner = new Scanner(new File("kanto.txt"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) {
                    String[] datos = linea.split(",");

                    if (datos.length != 7){
                        continue;
                    }
                    if (datos[1].toLowerCase().trim().equals("eevee")){
                        /**Pokemon eevee = new Pokemon( int id = Integer.parseInt(datos[0]),"Eevee",
                                String etap = datos[2],"Flareon","Vaporeon","Jolteon","normal","normal");*/
                        System.out.println("soy un eevee");
                        continue;
                    }
                    String idLetra = datos[0].trim();

                    int id = Integer.parseInt(idLetra);
                    String nombre = datos[1].trim();
                    String etapa = datos[2].trim();
                    String primeraEvolucion = datos[3].trim();
                    String segundaEvolucion = datos[4].trim();
                    String tipo1 = datos[5].trim();
                    String tipo2 = datos[6].trim();

                    Pokemon pokemon = new Pokemon(id, nombre, etapa, primeraEvolucion, segundaEvolucion, tipo1, tipo2);
                    listaPokemons.insertar(pokemon);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("---------- Pokédex ----------");
            System.out.println("1. Mostrar Pokémon por rango de números");
            System.out.println("2. Mostrar todos los Pokémon ordenados alfabéticamente");
            System.out.println("3. Mostrar Pokémon por tipo");
            System.out.println("4. Mostrar todos los Pokémon de primera evolución");
            System.out.println("5. Búsqueda personalizada");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el rango de números (inicio-fin): ");
                    String rango = scanner.nextLine();
                    String[] numeros = rango.split("-");
                    int rangoInicio = Integer.parseInt(numeros[0]);
                    int rangoFin = Integer.parseInt(numeros[1]);
                    mostrarPokemonesRango(rangoInicio, rangoFin);
                    break;
                case "2":
                    mostrarPokemonesAlfabeticamente();
                    break;
                case "3":
                    System.out.println("Ingrese el tipo: ");
                    String tipo = scanner.nextLine();
                    mostrarPokemonesTipo(tipo);
                    break;
                case "4":
                    mostrarPokemonesPrimeraEvolucion();
                    break;
                case "5":
                    System.out.println("Ingrese el ID del Pokémon: ");
                    int id = scanner.nextInt();
                    buscarPokemon(id);
                    break;
                case "6":
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (!opcion.equals("6"));
    }

    private void buscarPokemon(int id) {
        if (listaPokemons.buscarPokemon(id)){

            System.out.println(listaPokemons.obtenerPokemon(id).toString());
        }else{
            System.out.println("El pokemon no se encuentra en la Pokedex.");
        }

    }

    private void mostrarPokemonesPrimeraEvolucion() {
        listaPokemons.mostrar();
    }

    private void mostrarPokemonesTipo(String tipo) {
    }

    private void mostrarPokemonesAlfabeticamente() {
        listaPokemons.ordenarAlfabeticamente();
        listaPokemons.mostrar();
    }

    public void mostrarPokemonesRango(int rangoInicio, int rangoFin) {

        ordenarId(listaPokemons);
        this.contenedor = listaPokemons.buscarEnUnRango(rangoInicio,rangoFin);

        for (NodoNexoDoble nodoNexoDoble : contenedor) {
            System.out.println(nodoNexoDoble.getPokemon().toString());
        }

    }

    //metodo creado basado en bubblesort
    public void ordenarId(ListaNodoNexoDoble lista) {

        if (lista.isVacia()) {
            System.out.println("La lista está vacía.");
        }

        boolean intercambioRealizado;
        NodoNexoDoble actual;
        NodoNexoDoble siguiente;

        do {
            intercambioRealizado = false;
            actual = lista.getHead();

            while (actual != null && actual.getSiguiente() != null) {
                siguiente = actual.getSiguiente();

                if (actual.getPokemon().getId() > siguiente.getPokemon().getId()) {
                    // Intercambiar los nodos
                    cambiarNodos(lista, actual, siguiente);
                    intercambioRealizado = true;
                }

                actual = siguiente;
            }
        } while (intercambioRealizado);
    }
    //metodo para facilitar el cambio de nodos
    private void cambiarNodos(ListaNodoNexoDoble lista, NodoNexoDoble nodo1, NodoNexoDoble nodo2) {

        NodoNexoDoble anteriorNodo1 = nodo1.getPrevio();
        NodoNexoDoble siguienteNodo2 = nodo2.getSiguiente();

        // Actualizar el enlace del nodo anterior al nodo1
        if (anteriorNodo1 != null) {
            anteriorNodo1.setSiguiente(nodo2);
        } else {
            lista.setHead(nodo2);
        }
        nodo2.setPrevio(anteriorNodo1);

        // Actualizar el enlace del nodo1 al nodo2
        nodo1.setPrevio(nodo2);
        nodo1.setSiguiente(siguienteNodo2);

        // Actualizar el enlace del nodo2 al nodo1
        nodo2.setSiguiente(nodo1);
        if (siguienteNodo2 != null) {
            siguienteNodo2.setPrevio(nodo1);
        }
    }

}


