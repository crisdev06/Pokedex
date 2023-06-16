package cl.ucn.disc.pa.pokedex.models;

/**
* La clase Pokemon representa un Pokémon en la Pokédex.
* Contiene atributos como ID, nombre, etapa de evolución, evoluciones anteriores/siguientes y tipos.
*/
public class Pokemon {
    private int id;
    private String nombre;
    private String etapa;
    private String evolucionSiguienteUno;
    private String evolucionSiguienteDos;
    private String evolucionSiguienteTres;
    private String evolucionAnterior;
    private String tipoUno;
    private String tipoDos;

    //constructor de la clase pokemon con los atributos basicos.\
    /**
     * Constructor de la clase Pokemon con atributos básicos.
     * @param id El ID del Pokémon.
     * @param nombre El nombre del Pokémon.
     * @param etapa La etapa de evolución del Pokémon.
     * @param evolucionSiguienteUno El nombre de la primera evolución siguiente del Pokémon.
     * @param evolucionAnterior El nombre de la evolución anterior del Pokémon.
     * @param tipoUno El primer tipo del Pokémon.
     * @param tipoDos El segundo tipo del Pokémon.
     */
    public Pokemon(int id, String nombre, String etapa, String evolucionSiguienteUno, String evolucionAnterior, String tipoUno, String tipoDos) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguienteUno = evolucionSiguienteUno;
        this.evolucionAnterior = evolucionAnterior;
        this.tipoUno = tipoUno;
        this.tipoDos = tipoDos;
    }


    // constructor de la clase pokemon para Eevee.
    /**
     * Constructor de la clase Pokemon para Eevee.
     * @param id El ID del Pokémon.
     * @param nombre El nombre del Pokémon.
     * @param etapa La etapa de evolución del Pokémon.
     * @param evolucionSiguienteUno El nombre de la primera evolución siguiente de Eevee.
     * @param evolucionSiguienteDos El nombre de la segunda evolución siguiente de Eevee.
     * @param evolucionSiguienteTres El nombre de la tercera evolución siguiente de Eevee.
     * @param tipoUno El primer tipo del Pokémon.
     * @param tipoDos El segundo tipo del Pokémon.
     */
    public Pokemon(int id, String nombre, String etapa, String evolucionSiguienteUno, String evolucionSiguienteDos,
                   String evolucionSiguienteTres, String tipoUno, String tipoDos){
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguienteUno = evolucionSiguienteUno;
        this.evolucionSiguienteDos = evolucionSiguienteDos;
        this.evolucionSiguienteTres = evolucionSiguienteTres;
        this.tipoUno = tipoUno;
        this.tipoDos = tipoDos;
    }



    //constructor de la clase pokemon, basicos y con un tipo.
    /**
     * Constructor de la clase Pokemon con atributos básicos y un tipo.
     * @param id El ID del Pokémon.
     * @param nombre El nombre del Pokémon.
     * @param etapa La etapa de evolución del Pokémon.
     * @param tipoUno El primer tipo del Pokémon.
     * @param tipoDos El segundo tipo del Pokémon.
     */

    public Pokemon(int id, String nombre, String etapa, String tipoUno, String tipoDos){
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.tipoUno = tipoUno;
        this.tipoDos = tipoDos;

    }
    //constructor de la clase pokemon, basico , con una evolucion y sus tipos
    /**
     * Constructor de la clase Pokemon con ID, nombre, etapa, primera evolución siguiente, primer tipo y segundo tipo.
     * @param id El ID del Pokémon.
     * @param nombre El nombre del Pokémon.
     * @param etapa La etapa de evolución del Pokémon.
     * @param evolucionSiguienteUno El nombre de la primera evolución siguiente del Pokémon.
     * @param tipoUno El primer tipo del Pokémon.
     * @param tipoDos El segundo tipo del Pokémon.
     */
    public Pokemon(int id, String nombre, String etapa, String evolucionSiguienteUno, String tipoUno, String tipoDos){
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguienteUno = evolucionSiguienteUno;
        this.tipoUno = tipoUno;
        this.tipoDos = tipoDos;

    }
    

    //get`s() y setter`s()

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public String getEvolucionSiguienteUno() {
        return evolucionSiguienteUno;
    }

    public String getEvolucionSiguienteDos() {
        return evolucionSiguienteDos;
    }

    public String getEvolucionSiguienteTres() {
        return evolucionSiguienteTres;
    }

    public String getEvolucionAnterior() {
        return evolucionAnterior;
    }

    public String getTipoUno() {
        return tipoUno;
    }

    public String getTipoDos() {
        return tipoDos;
    }
    /**
     * Representación en forma de cadena de texto del objeto Pokemon.
     * @return La representación en forma de cadena de texto del objeto Pokemon.
     */

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", etapa='" + etapa + '\'' +
                ", evolucionSiguienteUno='" + evolucionSiguienteUno + '\'' +
                ", evolucionAnterior='" + evolucionAnterior + '\'' +
                ", tipoUno='" + tipoUno + '\'' +
                ", tipodos='" + tipoDos + '\'' +
                '}';
    }
}
