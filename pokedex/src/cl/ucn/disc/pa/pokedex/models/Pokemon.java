package cl.ucn.disc.pa.pokedex.models;

public class Pokemon {
    private int id;
    private String nombre;
    private String etapa;
    private String evolucionSiguienteUno;
    private String evolucionSiguienteDos;
    private String evolucionSiguienteTres;
    private String evolucionAnterior;
    private String tipoUno;
    private String tipodos;

    //constructor de la clase pokemon con los atributos basicos.
    public Pokemon(int id, String nombre, String etapa, String evolucionSiguienteUno, String evolucionAnterior, String tipoUno, String tipodos) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguienteUno = evolucionSiguienteUno;
        this.evolucionAnterior = evolucionAnterior;
        this.tipoUno = tipoUno;
        this.tipodos = tipodos;
    }


    // constructor de la clase pokemon para Eevee.
    public Pokemon(int id, String nombre, String etapa, String evolucionSiguienteUno, String evolucionSiguienteDos,
                   String evolucionSiguienteTres, String tipoUno, String tipodos){
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguienteUno = evolucionSiguienteUno;
        this.evolucionSiguienteDos = evolucionSiguienteDos;
        this.evolucionSiguienteTres = evolucionSiguienteTres;
        this.tipoUno = tipoUno;
        this.tipodos = tipodos;
    }



    //constructor de la clase pokemon, basicos y con un tipo.

    public Pokemon(int id, String nombre, String etapa, String tipoUno, String tipodos){

    }
    
    //constructor de la clase pokemon con un solo tipo, evolucion siguiente, evolucion anterior.
    public Pokemon(int id, String nombre, String etapa, String evolucionSiguienteUno,String evolucionAnterior, String tipoUno){
        this.id = id;
        this.nombre=nombre;
        this.etapa= etapa;
        this.evolucionSiguienteUno=evolucionSiguienteUno;
        this.evolucionAnterior=evolucionAnterior;
        this.tipoUno=tipoUno;
    }

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

    public String getTipodos() {
        return tipodos;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", etapa='" + etapa + '\'' +
                ", evolucionSiguienteUno='" + evolucionSiguienteUno + '\'' +
                ", evolucionAnterior='" + evolucionAnterior + '\'' +
                ", tipoUno='" + tipoUno + '\'' +
                ", tipodos='" + tipodos + '\'' +
                '}';
    }
}
