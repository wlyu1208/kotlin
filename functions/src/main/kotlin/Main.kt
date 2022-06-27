fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String="Info"){
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int{
    return x + y
}

fun multiply(x: Int, y:Int) = x * y

fun func1(){
    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix("Log", "Hello")
    println(sum(1, 2))
    println(multiply(2, 4))
}

class Person(val name: String){
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {likedPeople.add(other)}
}

fun func2(){
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")

    val pair = "Ferrari" to "Lamborghini"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}

fun func3(){
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive you enemies; nothing annoys them so much"
    println(str[0..14])
}

fun func4(){
    fun printAll(vararg messages: String){
        for (m in messages) println(m)
    }
    printAll("Hello", "Hola", "Hi", "Salut")

    fun printAllWithPrefix(vararg messages: String, prefix: String){
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix("Hello", "Hola", prefix = "Greeting: ")

    fun log(vararg entries: String){
        printAll(*entries)
    }

    log("Does", "This", "Work")
}

fun main(args: Array<String>) {
    func1()
    func2()
    func3()
    func4()
}