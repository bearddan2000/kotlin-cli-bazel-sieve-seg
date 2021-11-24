package example;

import kotlin.rem

fun isPrime(n:Int, prime:List<Int>, id:Int, result:Int):Int {
    if (n >= 4)
        return result

    val r = result or if (id == prime[n]) 1 else 0
    return isPrime(n+1, prime, id, r);
}

fun isPrimeFactor(n:Int, prime:List<Int>, id:Int, result:Int):Int {
    if (n >= 4)
        return result

    val r = result and if (id.rem(prime[n]) != 0) 1 else 0
    return isPrimeFactor(n+1, prime, id, r);
}

fun mapPrime(id:Int):Int {
    val result = 1
    val prime = listOf(2,3,5,7)
    if (isPrime(0, prime, id, 0) == 1)
        return if (result == 1) id else 0
    val b = Math.sqrt(id.toDouble())
    var r = isPrimeFactor(0, prime, id, 1)
    r = r and if (b != 0.toDouble()) 1 else 0
    return if (r == 1) id else 0
}
fun main() {
  val low: Int = 10
  val high: Int = 20
  val X = MutableList(high+1){0..high}
        .flatten()
        .map{mapPrime(it)}
        .filterIndexed{index, _ -> (index in low..high) }
        .filter{it > 0}
  println("[INPUT] low $low, high $high")
  println("[OUTPUT] " + X)
}
