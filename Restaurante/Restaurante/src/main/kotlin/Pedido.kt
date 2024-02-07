/**
 * Clase pedido
 */
class Pedido {

    val numero :Int

    val platos = mutableListOf<Plato>()

    var estado = "pendiente"

    init {
        this.numero = ++contPedido
    }

    companion object {
        var contPedido: Int = 0
    }
    /**
     * Agrega un plato a la lista de platos del pedido
     * @param plato :Plato plato que se va a agregar
     */
    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }

    /**
     * Elimina un plato de la lista de platos del pedido
     * @param nombrePlato :String nombre del plato que se va a eliminar
     */
    fun eliminarPlato(nombrePlato: String) {
        val eliminar = platos.find { it.nombre == nombrePlato }
        eliminar?.let{ platos.remove(eliminar) }
    }

    /**
     * Calcula el precio total de los platos
     */
    fun calcularPrecio() {
        var suma = 0.0
        platos.map { suma += it.precio }
    }

    /**
     * Calcula el tiempo total del tiempo de preparacion de cada plato
     */
    fun calcularTiempo() {
        var tiempo = 0
        platos.map { tiempo += it.tiempoPreparacion + tiempo }
    }

    /**
     * Imprime la informacion de los pedidos
     */
    override fun toString(): String {
        platos.forEach{ println(it)}
        return "Estado: ${this.estado}"
    }

}