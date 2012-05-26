package com.acme.scala

object Main {
  def main(args: Array[String]) {
    // args.foreach(arg => printf("%s ", arg))
    printf("max of 10 and 20 is %d%n", max(10, 20))
    printf("max of 32 and 11 is %d%n", max(32, 11))

    println(new Rational(2, 5))
    // println(new Rational(5, 0))

    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    println(oneHalf + twoThirds)

    println(new Rational(66, 42))

    println(new Rational(2, 3) + 2)
    // println(2 * new Rational(2, 3))
  }

  def max(x: Int, y: Int) = {
    if (x > y) x else y
  }
}
