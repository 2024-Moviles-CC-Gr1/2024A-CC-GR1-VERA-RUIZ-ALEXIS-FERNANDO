import java.util.*
import kotlin.collections.ArrayList
import java.time.LocalDate

fun main(){
    //println("Hola Mundo")

    //Crear una instancia de Isla
    val isla = Isla("Thetford", 1, LocalDate.of(2024, 3, 2), true, 0.1f)

    //Menú
    var continuar = true
    while (continuar) {
        println("Menú:")
        println("1. Agregar Producto")
        println("2. Leer Productos")
        println("3. Actualizar Producto")
        println("4. Eliminar Producto")
        println("5. Salir")
        print("Seleccione una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            //Agregar producto
            1 -> {
                println("Ingrese los datos del producto:")
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("ID: ")
                val id = readLine()?.toIntOrNull() ?: 0
                print("Fecha de Siembra (yyyy-mm-dd): ")
                val fechaSiembra = LocalDate.parse(readLine())
                print("Foco (true/false): ")
                val foco = readLine()?.toBoolean() ?: false
                print("Semilla: ")
                val semilla = readLine()?.toFloatOrNull() ?: 0.0f

                val producto = Producto(nombre, id, fechaSiembra, foco, semilla)
                isla.createProducto(producto)
                println("Producto agregado correctamente.")
            }

            //Leer producto
            2 -> {
                println("Productos asociados a la isla de '${isla.nombre}':")
                isla.readProductos()
            }

            //Actualizar producto
            3 -> {
                println("Ingrese el ID del producto a actualizar: ")
                val id = readLine()?.toIntOrNull() ?: 0
                val producto = isla.productos.find { it.id_p == id }
                if (producto != null) {
                    println("Ingrese los nuevos datos del producto:")
                    print("Nombre: ")
                    val nombre = readLine() ?: ""
                    print("Fecha de Siembra (yyyy-mm-dd): ")
                    val fechaSiembra = LocalDate.parse(readLine())
                    print("Foco (true/false): ")
                    val foco = readLine()?.toBoolean() ?: false
                    print("Semilla: ")
                    val semilla = readLine()?.toFloatOrNull() ?: 0.0f

                    val productoActualizado = Producto(nombre, id, fechaSiembra, foco, semilla)
                    isla.updateProducto(id, productoActualizado)
                    println("Producto actualizado correctamente.")
                } else {
                    println("No se encontró ningún producto con el ID proporcionado.")
                }
            }

            //Eliminar producto
            4 -> {
                println("Ingrese el ID del producto a eliminar: ")
                val id = readLine()?.toIntOrNull() ?: 0
                isla.deleteProducto(id)
            }

            //Cerrar el meno
            5 -> {
                println("Saliendo.")
                continuar = false
            }
            else -> println("Opción no válida.")
        }
        println() // Línea en blanco para mejor legibilidad
    }

    /*
    //INMUTABLES (No se reasigna "=")
    val inmutable: String = "Alexis"

    //Variable MUTABLE
    var mutable: String = "Juan"
    mutable = "Jose"

    val ejemploVariable = "Juan Jose"
    val edadEjemplo: Int = 12

    ejemploVariable.trim()



    //Variables primitivas
    val nombreProfesor: String = "Adrian"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'C'
    val mayorEdad: Boolean = true

    //Clases en Java
    val fechaNacimiento: Date = Date()

    //When (Switch)
    val estadoCivilWhen = "C"
    when (estadoCivilWhen){
        ("C") -> {
            println("Casado")
        }
        "S" -> {
            println("Soltero")
        }
        else -> {
            println("No sabemos")
        }
    }

    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No"


    //////////////////////////////////
    // Clase 10/05/2024
    /////////////////////////////////








    //////////////////////////////////
    // Clase 16/05/2024
    /////////////////////////////////

    //arreglo estatico
    val arregloEstatico: Array<Int> = arrayOf<Int>(1,2,3)
    println(arregloEstatico);

    //arreglo dinamico
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(
        1,2,3,4,5,6,7,8,9,10
    )
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)


    //FOR EACHO -> Unit
    //Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico
        .forEach{ valorActual: Int -> //- > =>
            println("Valor actual: ${valorActual}");
        }

    //"it" (en ingles "eso") significa el elemento iterado
    arregloDinamico.forEach{ println("Valor actual (it): ${it}")}

    //Operador MAP -> MUTA(modifica, cambia) el arreglo
    //1) Enviamos el nuevo valor de la iteracion
    //2) No devuelve un nuevo arreglo con valores de la iteraciones
    val respuestaMap: List<Double> = arregloDinamico
        .map {valorActual: Int ->
            return@map valorActual.toDouble()+100.00
        }
    println(respuestaMap)

    val respuestaMapDos = arregloDinamico.map { it + 15 }
    println(respuestaMapDos)


    //Filter -> Filtrar el arreglo
    //1) devolver una expresion true o false
    //2) Nuevo arreglo filtrado

    val respuestaFilter: List<Int> = arregloDinamico
        .filter { valorActual:Int ->
        val mayoresCinco: Boolean =valorActual > 5
        return@filter mayoresCinco

        }

    val respuestaFilterDos = arregloDinamico.filter { it <= 5 }
    println(respuestaFilter)
    println(respuestaFilterDos)


    //Operador OR y AND
    //OR -> any (alguno cumple?)
    //and - all (todos cumplen?)

    val respuestaAny :Boolean = arregloDinamico
        .any{valorActual:Int ->
            return@any (valorActual > 5)
        }
    println(respuestaAny) //true

    val respuestaAll :Boolean = arregloDinamico
        .all{valorActual:Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll) //false


    //Operador reduce (devulve el valor acumulado)
    //Valor acumulado = 0 (siempre empieza en cero en kotlin)
    //[1,2,3,4,5] -> acumular "SUMAR" estos valores del arreglo
    //valorIteracion1 = valorEmpieza + 1 = 0 + 1 = 1 iteracion1
    //valor Iteracion2 = valorAcumuladoIteracion1 + 2 = 1+ 2 = 3 -> Iteracion2
    //..... etc

    val respuestaReduce: Int = arregloDinamico
        .reduce{ acumulado:Int, valorActual:Int ->
            return@reduce(acumulado + valorActual)
        }
    println(respuestaReduce);
    //return@reduce acumulado + (itemCarrito.cantidad * itemCarrito.Precio)

    */

}