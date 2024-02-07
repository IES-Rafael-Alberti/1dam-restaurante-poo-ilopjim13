/**
 * Clase plato
 * @property nombre :String nombre de plato
 * @property precio :Double precio del plato
 * @property tiempoPreparacion :Int tiempo que tarda el plato en prepararse
 * @property igredientes :MutableList<String> lista con todos los ingredientes del plato
 */
class Plato(nombre: String, precio:Double, tiempoPreparacion: Int, private var ingredientes:MutableList<String>) {

    var nombre = nombre
        set(value) {
            require(value.isNotBlank()) { "El nombre no puede estar vacío" }
            field = value
        }
    var precio = precio
        set(value) {
            require(value > 0.0) { "El precio debe ser mayor a 0" }
            field = value
        }
    var tiempoPreparacion = tiempoPreparacion
        set(value) {
            require(value > 1) { "El tiempo de espera debe ser mayor a 1" }
            field = value
        }


    init {
        require(this.nombre.isNotBlank()) {"El nombre no puede estar vacío"}
        require(this.precio > 0.0) {"El precio debe ser mayor a 0"}
        require(this.tiempoPreparacion > 1) {"El tiempo de espera debe ser mayor a 1"}
        require(this.ingredientes.isNotEmpty()) {"La lista no puede estar vacía"}
    }

    /**
     * Agrega un ingrediente al plato
     * @param ingrediente :String ingrediente que se le va a agregar al plato
     */
    fun agregarIngrediente(ingrediente: String) {
        require(ingrediente.isNotBlank()) {"No se puede agregar un ingrediente vacío."}
        ingredientes.add(ingrediente)
    }

    /**
     * Imprime la informacion del plato
     */
    override fun toString(): String {
        return "${this.nombre} (${this.tiempoPreparacion} min.) -> ${this.precio}€ (${this.ingredientes.joinToString(", ")})"
    }
}