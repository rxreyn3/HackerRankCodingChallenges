

object Fibonacci {
  def fibonacci(x: Int): Int = {
    if (x <= 1) {
      return x;
    }
    val left = fibonacci(x - 1);
    val right = fibonacci(x - 2);
    val total = left + right;
    println("Left: " + left + " Right: " + right + " Total: " + total);
    return fibonacci(x - 1) + fibonacci(x - 2);
  }

  def main(args: Array[String]) {
    println(fibonacci(scala.io.StdIn.readInt()))
  }
}