package com.acme.scala

import scopt.mutable.OptionParser

object Main {
  def main(args: Array[String]) {
    val config = parseMortgageCalculatorCommandLineOptions(args)
    println(new Mortgage(
        config.price,
        config.percentDown,
        config.monthlyMaitenanceFee,
        config.monthlyRealEstateTax,
        config.term,
        config.rate))
  }

  def parseMortgageCalculatorCommandLineOptions(args: Array[String]): Config = {
    val config: Config = new Config()

    val parser = new OptionParser("mortgage_calculator", "1.0") {
      doubleOpt(
          "p", 
          "price",
          "<price>",
          "the asking price for the unit", 
          { v: Double => config.price = v })

      doubleOpt(
          "d",
          "percentDown",
          "<percentDown>",
          "the percentage paid up front", 
          { v: Double => config.percentDown = v })

      doubleOpt(
          "f", 
          "monthlyMaintenanceFee",
          "<monthlyMaintenanceFee>",
          { v: Double => config.monthlyMaitenanceFee = v })

      doubleOpt(
          "t", 
          "monthlyRealEstateTax", 
          "<monthlyRealEstateTax>",
          { v: Double => config.monthlyRealEstateTax = v })
      
      intOpt(
          "y", 
          "term",
          "<term>",
          "the number of years the loan must be paid back. Usually 15 or 30.", 
          { v: Int => config.term = v })

      doubleOpt(
          "r",
          "rate",
          "<rate>",
          "the monthly mortgage rate", 
          { v: Double => config.rate = v })
    }

    if (parser.parse(args)
        && (config.price > 0 
        && config.percentDown >= 0
        && config.monthlyMaitenanceFee >= 0
        && config.monthlyRealEstateTax >= 0
        && config.term > 0
        && config.rate >= 0)) {
      return config
    }

    parser.showUsage
    System.exit(1)
    return null
  }

  def test() {
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

class Config {
  var price: Double = 0
  var percentDown: Double = 0
  var monthlyMaitenanceFee: Double = 0
  var monthlyRealEstateTax: Double = 0
  var term: Int = 30
  var rate: Double = 0
}
