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

    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }

    fun eliminarPlato(nombrePlato: String) {
        val eliminar = platos.find { it.nombre == nombrePlato }
        eliminar.let{ platos.remove(eliminar) }
    }

    fun calcularPrecio() {
        val suma = 0.0
        val sumaTotal = platos.map { it.precio + suma }
    }

    fun calcularTiempo() {
        val tiempo = 0
        val tiempoTotal = platos.map { it.tiempoPreparacion + tiempo }
    }

    override fun toString(): String {
        platos.forEach{ return it.toString()}
        return ""
    }

}