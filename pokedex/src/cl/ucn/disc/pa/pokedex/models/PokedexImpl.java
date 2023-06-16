package cl.ucn.disc.pa.pokedex.models;
import cl.ucn.disc.pa.pokedex.services.NodoNexoDoble;
import cl.ucn.disc.pa.pokedex.services.Pokedex;
import cl.ucn.disc.pa.pokedex.utils.ListaNodoNexoDoble;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * La clase PokedexImpl implementa la interfaz Pokedex y representa una aplicación de Pokédex.
 * Esta clase se encarga de la gestión de los Pokemones y proporciona métodos para interactuar
 * con la Pokédex.
 */
public class PokedexImpl implements Pokedex {

    private ListaNodoNexoDoble listaPokemons;
    private ArrayList<NodoNexoDoble> contenedor;
    private LinkedList<Pokemon> linkedList;

    /**
     * Crea una nueva instancia de PokedexImpl.
     * Inicializa los atributos listaPokemons, contenedor y linkedList.
     */
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
                    int id;
                    String nombre;
                    String etapa;
                    String evolucion1;
                    String evolucion2;
                    String evolucion3;
                    String evolucionAnterior;
                    String tipo1;
                    String tipo2;

                    if (datos.length == 7){
                        id = Integer.parseInt(datos[0].trim());
                        nombre = datos[1].trim();
                        etapa = datos[2].trim();
                        evolucion1 = datos[3].trim();
                        evolucionAnterior = datos[4].trim();
                        tipo1 = datos[5].trim();
                        tipo2 = datos[6].trim();
                        Pokemon pokemon = new Pokemon(id, nombre, etapa, evolucion1, evolucionAnterior, tipo1, tipo2);
                        listaPokemons.insertar(pokemon);
                    }
                    else if (datos.length==8){
                        id = Integer.parseInt(datos[0].trim());
                        nombre = datos[1].trim();
                        etapa = datos[2].trim();
                        evolucion1 = datos[3].trim();
                        evolucion2 = datos[4].trim();
                        evolucion3 = datos[5].trim();
                        tipo1 = datos[6].trim();
                        tipo2 = datos[7].trim();
                        Pokemon pokemon = new Pokemon(id,nombre,etapa,evolucion1,evolucion2,evolucion3,tipo1,tipo2);
                        listaPokemons.insertar(pokemon);
                    }
                    else if (datos.length==5){
                        id = Integer.parseInt(datos[0].trim());
                        nombre = datos[1].trim();
                        etapa = datos[2].trim();
                        tipo1 = datos[3].trim();
                        tipo2 = datos[4].trim();
                        Pokemon pokemon = new Pokemon(id,nombre,etapa,tipo1,tipo2);
                        listaPokemons.insertar(pokemon);
                    }
                    else if (datos.length==6){
                        id = Integer.parseInt(datos[0].trim());
                        nombre = datos[1].trim();
                        etapa = datos[2].trim();
                        evolucion1 = datos[3].trim();
                        tipo1 = datos[4].trim();
                        tipo2 = datos[5].trim();
                        Pokemon pokemon = new Pokemon(id,nombre,etapa,evolucion1,tipo1,tipo2);
                        listaPokemons.insertar(pokemon);

                    }




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
    /**
     * Busca un Pokémon por su ID y muestra su información si se encuentra en la Pokédex.
     * @param id El ID del Pokémon a buscar.
     */
    private void buscarPokemon(int id) {
        if (listaPokemons.buscarPokemon(id)){

            System.out.println(listaPokemons.obtenerPokemon(id).toString());
        }else{
            System.out.println("El pokemon no se encuentra en la Pokedex.");
        }

    }
    /**
     * Muestra todos los Pokemones de primera evolución ordenados por su ID en orden decreciente.
     */
    private void mostrarPokemonesPrimeraEvolucion() {
        ordenarId(listaPokemons);
        this.contenedor = listaPokemons.buscarPorPrimeraEvolucion();
        for (int i = contenedor.size()-1;i>-1;i--){
            System.out.println(contenedor.get(i).getPokemon().toString());
        }
    }
    /**
     * Muestra los Pokemones de un tipo específico.
     * @param tipo El tipo del Pokémon a mostrar.
     */
    private void mostrarPokemonesTipo(String tipo) {
        if (listaPokemons.buscarPorTipo(tipo)!= null){
            this.linkedList = listaPokemons.buscarPorTipo(tipo);
            for(Pokemon pokemon : linkedList){
                System.out.println(pokemon.toString());
            }
        }
        System.out.println("algo salio mal, vuelva a intentarlo.");

    }
    /**
     * Muestra todos los Pokemones ordenados alfabéticamente.
     */
    private void mostrarPokemonesAlfabeticamente() {
        listaPokemons.ordenarAlfabeticamente();
        listaPokemons.mostrar();
    }
    /**
     * Muestra los Pokemones en un rango de números dado.
     * @param rangoInicio El número inicial del rango.
     * @param rangoFin El número final del rango.
     */
    public void mostrarPokemonesRango(int rangoInicio, int rangoFin) {

        ordenarId(listaPokemons);
        this.contenedor = listaPokemons.buscarEnUnRango(rangoInicio,rangoFin);

        for (NodoNexoDoble nodoNexoDoble : contenedor) {
            System.out.println(nodoNexoDoble.getPokemon().toString());
        }

    }

    //metodo creado basado en bubblesort
    /**
     * Ordena la lista de Pokemones por su ID en orden ascendente.
     * @param lista La lista de Pokemones a ordenar.
     */
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
    /**
     * Cambia la posición de dos nodos en la lista.
     * @param lista La lista en la que se encuentran los nodos.
     * @param nodo1 El primer nodo a intercambiar.
     * @param nodo2 El segundo nodo a intercambiar.
     */
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


