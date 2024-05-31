import java.time.LocalDate

//Clase Producto tiene datos sobre el nombre del producto, un id para diferencairlo, una fecha de siembra,
//un booleano si le aplicaron foco y flotante con el bono de produccion de semilla base (es decir sin foco)
class Producto(
    val nombre_p: String,
    val id_p: Int,
    val fechaSiembra: LocalDate,
    val foco: Boolean,
    val semilla: Float) {

    //Funcion para imprimir los detalles de cada producto
    fun imprimirProducto() {
        println("Nombre del Producto: $nombre_p")
        println("ID del Producto: $id_p")
        println("Fecha de Siembra: $fechaSiembra")
        println("Foco: $foco")
        println("Semilla: $semilla")
    }
}