package com.acme.scala

import scopt.mutable.OptionParser

object Main {
  def main(args: Array[String]) {
    val config = parseCommandLineOptions(args)
   
    if (config.mode == "mortgage_calculator") {
      doMortgageCalculator(config)
    } else {
      doRentCalculator(config)
    }
  }
 
  def doMortgageCalculator(config: Config) {
    println(new Mortgage(
        config.price,
        config.percentDown,
        config.monthlyMaitenanceFee,
        config.monthlyRealEstateTax,
        config.term,
        config.rate))
  }
 
  def doRentCalculator(config: Config) {
    val rent = RentCalculator.calculate(config.rent, config.biweeklyIncome, config.feeRate)
    printf(
        ("%nrent: $%1.2f%n" +
        "bi-weekly income: $%1.2f%n" +
        "broker's fee rate: %1.2f%n" +
        "------------------------%n" +
        "two month's rent: $%1.2f%n" +
        "broker's fee: $%1.2f%n" +
        "total amount needed to move: $%1.2f%n" +
        "It would take you %d pay cycles to save that much money.%n").format(
        config.rent,
        config.biweeklyIncome,
        config.feeRate,
        rent("twoMonthsRent"),
        rent("fee"),
        rent("total"),
        rent("payCycles")))
  }

  def parseCommandLineOptions(args: Array[String]): Config = {
    val config: Config = new Config()

    val parser = new OptionParser("sandbox", "1.0") {
      opt(
        "m",
        "mode",
        "rent_calculator or mortgage_calculator",
        { v: String => config.mode = v })
     
     
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
         
       doubleOpt(
          "rent",
          "<rent>",
          "the monthly rent",
          { v: Double => config.rent = v })
         
       doubleOpt(
          "biweeklyIncome",
          "<income>",
          "how much income earned every 2 weeks",
          { v: Double => config.biweeklyIncome = v })
         
       doubleOpt(
          "feeRate",
          "<fee>",
          "broker's fee percentage of year's worth of rent",
          { v: Double => config.feeRate = v })
    }

    if (parser.parse(args)) {
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
  var mode: String = "rent_calculator"
 
  // mortgage_calculator props
  var price: Double = 0
  var percentDown: Double = 0
  var monthlyMaitenanceFee: Double = 0
  var monthlyRealEstateTax: Double = 0
  var term: Int = 30
  var rate: Double = 0
 
  // rent_calculator props
  var rent = 0.0
  var biweeklyIncome = 0.0
  var feeRate = 0.0
}

