import java.time.LocalDate

//Clase Isla tiene datos sobre el nombre de donde se encuentra, un id para diferencairla, una fecha de creacion,
//un booleano si esta esta en funcionamiento y arreglo de bono con todos los bonos de produccion que tiene esta isla
class Isla(
    val nombre: String,
    val id: Int,
    val fechaCreacion: LocalDate,
    val activo: Boolean,
    val bono: Float) {

    //Agregar una lista mutable con los productos que existen en esta isla
    val productos: MutableList<Producto> = mutableListOf()

    //Funcion Create para añadir un producto a la isla
    fun createProducto(producto: Producto) {
        productos.add(producto)
    }

    //Funcion Read para leer los productos registrados en la isla (en la lista mutable)
    fun readProductos() {
        if (productos.isEmpty()) {
            println("No hay productos en esta isla.")
        } else {
            productos.forEach { it.imprimirProducto() }
        }
    }

    //Funcion Update para actualizar datos de un producto de la isla
    fun updateProducto(id: Int, productoActualizado: Producto) {
        val index = productos.indexOfFirst { it.id_p == id }
        if (index != -1) {
            productos[index] = productoActualizado
            println("Producto actualizado correctamente.")
        } else {
            println("No se encontró ningún producto con el ID proporcionado.")
        }
    }

    //Funcion Delete para eliminar un producto de la isla
    fun deleteProducto(id: Int) {
        val index = productos.indexOfFirst { it.id_p == id }
        if (index != -1) {
            productos.removeAt(index)
            println("Producto eliminado correctamente.")
        } else {
            println("No se encontró ningún producto con el ID proporcionado.")
        }
    }

    //Funcion para imprimir los datos de la isla
    fun imprimirIsla() {
        println("Nombre: $nombre")
        println("ID: $id")
        println("Fecha de Creación: $fechaCreacion")
        println("Activo: $activo")
        println("Bono: $bono")
        println("Productos:")

        //Adicionamente imprimir los datos de los productos de esta isla en cuestion
        //productos.forEach { it.imprimirProducto() }
    }


}