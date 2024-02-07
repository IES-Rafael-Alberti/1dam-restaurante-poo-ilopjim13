/**
 * Clase mesa
 * @property numero :Int numero identificativo de la mesa
 * @property capacidad :Int capacidad maxima de personas en una mesa
 */
class Mesa(var numero:Int, var capacidad:Int) {
    var estado:String = "libre"
    val pedidos = mutableListOf<Pedido>()

    init {
        require(capacidad in 1..6) {"Solo exiten mesas de 1 a 6 comensales"}
    }

    /**
     * Cambia el estado de la mesa de libre a ocupada
     */
    fun ocuparMesa() {
        if (this.estado == "libre") this.estado = "ocupada"
    }

    /**
     * Cambia el estado de la mesa de reservada a ocupada
     */
    fun ocuparReserva() {
        if (this.estado == "reservada") this.estado = "ocupada"
    }

    /**
     * Cambia el estado de la mesa a libre
     */
    fun liberarMesa() {
        this.estado = "libre"
    }

    /**
     * Agrega un pedido a la lista de pedidos de la mesa
     */
    fun agregarPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }

    /**
     * Imprime la informacion de la mesa
     */
    override fun toString(): String {
        println("Mesa $numero: $estado")
        pedidos.forEach { p -> p.platos.forEach { println(it) } }
        return "Estado: ${this.estado}"
    }

}