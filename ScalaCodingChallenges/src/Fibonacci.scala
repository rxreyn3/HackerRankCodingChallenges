

object Fibonacci {
  def fibonacci(x: Int): Int = {
    if(x <= 1)
    {
      return x;
    }
    return fibonacci(x -1) + fibonacci(x - 2);

  }

  def main(args: Array[String]) {
    /** This will handle the input and output**/
    println(fibonacci(scala.io.StdIn.readInt()))

  }
}