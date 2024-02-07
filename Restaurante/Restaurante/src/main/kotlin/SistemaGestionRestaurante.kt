/**
 * Clase Sistemas Gestion Restaurante
 * @property mesas :List<Mesa> lista con las mesas
 */
class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    /**
     * Asocia un nuevo pedido a una mesa. Verifica que la mesa esté ocupada antes de asociar el pedido.
     * @param numeroMesa :Int numero de la mesa a la que se le va a asociar el pedido
     * @param pedido :Pedido pedido que se le va a asociar a la mesa
     */
    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {
       if (mesas.find { it.estado == "ocupado" } == null){
            mesas.find { it.numero == numeroMesa }?.agregarPedido(pedido)
        }
    }

    /**
     * Si el númeroPedido es null, cambia el estado del último pedido de una mesa a "servido".
     * Si le llega un numeroPedido busca el pedido con dicho número y cambiar su estado a "servido".
     * @param numeroMesa :Int numero de la mesa
     * @param numeroPedido :Int? numero del pedido
     */
    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        if (numeroPedido == null) mesas.find { it.numero == numeroMesa }?.estado = "servido"
        else mesas.find{ it.numero == numeroMesa }?.pedidos?.find { it.numero == numeroPedido }?.estado = "servido"
    }

    /**
     * Si todos los pedidos están servidos, libera la mesa.
     * @param numeroMesa :Int numero de la mesa
     */
    fun cerrarMesa(numeroMesa: Int) {
        if (mesas.find{ it.numero == numeroMesa }?.pedidos?.find { it.estado == "servido" } != null) mesas.find{ it.numero == numeroMesa }?.liberarMesa()
    }

    /**
     * Retorna una lista con el nombre de los platos pedidos. Si no hay ninguno retorna null.
     * @return List<String> lista con los platos pedidos
     */
    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    /**
     * Cuenta el número de veces que se ha pedido un plato. Si no hay ninguno retorna null.
     * @param nombre :String nombre del plato
     * @return Int? numero de veces
     */
    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }

    /**
     * Busca y retorna el o los platos más pedidos. Si no hay ninguno retorna null. Utiliza los dos métodos anteriores.
     * @return List<String> lista con los platos mas pedidos
     */
    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}