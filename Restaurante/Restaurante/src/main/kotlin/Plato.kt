class Plato(val nombre: String, val precio:Double, val tiempoPreparacion: Int, val ingredientes:MutableList<String>) {

    init {
        require(this.nombre.isNotBlank()) {"El nombre no puede estar vacío"}
        require(this.precio > 0.0) {"El precio debe ser mayor a 0"}
        require(this.tiempoPreparacion > 1) {"El precio debe ser mayor a 0"}
    }


    fun agregarIngrediente(ingrediente: String) {
        require(ingrediente.isNotBlank()) {"No se puede agregar un ingrediente vacío."}
        ingredientes.add(ingrediente)
    }

    override fun toString(): String {
        return "${this.nombre} (${this.tiempoPreparacion} min.) -> ${this.precio}€ (${this.ingredientes.joinToString(", ")})"
    }
}