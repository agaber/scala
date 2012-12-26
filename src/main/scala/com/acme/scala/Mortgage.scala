package com.acme.scala

/**
 * Describes the properties of a mortgage given certain parameters.
 * 
 * <p>This is initially based of the Mortgage Calculator on the New York Times
 * real estate site.
 * 
 * @param price the asking price for the unit
 * @param percentDown the percentage paid up front
 * @param monthlyMaintenanceFee monthly fee for the unit
 * @param monthlyRealEstateTax taxes paid monthly
 * @param term the number of years the loan must be paid back. Usually 15 or 30.
 * @param rate the monthly mortgage rate
 * 
 * TODO: Factor home insurance.
 * TODO: Calculate estimated tax instead.
 * TODO: Adjustable Rate. 
 */
class Mortgage(
    val price: Double = 0.0,
    val percentDown: Double = 0.0,
    val monthlyMaintenanceFee: Double = 0.0,
    val monthlyRealEstateTax: Double = 0.0,
    val term: Int = 30,
    val rate: Double = 3.5) {
  require(price > 0, "principal must be greater than zero")
  require(percentDown >= 0, "percentDown must be greater than or equal to zero")
  require(monthlyMaintenanceFee >= 0, "monthlyMaintenanceFee must be greater than or equal to zero")
  require(monthlyRealEstateTax >= 0, "monthlyRealEstateTax must be greater than or equal to zero")
  require(term >= 0, "term must be greater than or equal to zero")
  require(rate >= 0, "rate must be greater than or equal to zero")

  /**
   * The amount of money needed to pay paid up front.
   */
  val downPayment = price * (percentDown / 100)

  /**
   * The amount of money loaned after the down payment.
   */
  val principal = price - downPayment

  /**
   * The amount of money needed to be paid towards the loan each month,
   * assuming a fixed rate mortgage payment type.
   */
  val monthlyFixedRateMortgagePayment = calculateFixedRateMonthlyMortgagePayment(
      principal,
      term,
      rate)

  /**
   * The minimum amount you need to pay every month, all things considered.
   */
  val totalMonthlyCost = 
      monthlyFixedRateMortgagePayment + monthlyMaintenanceFee + monthlyRealEstateTax

  override def toString(): String = {
    ("price: $%1.2f%n" +
    "percent down: $%1.1f%%%n" +
    "monthly maintenance fee: $%1.2f%n" +
    "monthly real estate tax: $%1.2f%n" +
    "term in years: %d%n" +
    "rate: %1.1f%%%n" +
    "------------------------------%n" +
    "down payment: $%1.2f%n" +
    "loan amount: $%1.2f%n" +
    "monthly mortgage payment (fixed rate): $%1.2f%n" +
    "total monthly payment: $%1.2f").format(
    price,
    percentDown,
    monthlyMaintenanceFee,
    monthlyRealEstateTax,
    term,
    rate,
    downPayment,
    principal,
    monthlyFixedRateMortgagePayment,
    totalMonthlyCost)
  }

  /**
   * Calculates the money needed to be paid towards the mortgage each month
   * using a fixed rate mortgage type.
   * 
   * M = P (i(1 + i)^n) / ((1 + i)^n - 1)
   * M = The monthly payment
   * P = The principal, or the amount of money being borrowed
   * i = The interest for each compounding period, or the interest per month for a standard mortgage
   * n = The number of compounding periods, or the number of months for a standard mortgage
   */
  private def calculateFixedRateMonthlyMortgagePayment(p: Double, term: Int, rate: Double) = {
    val i = (rate / 100) / 12
    val n = 12 * term
    val power = math.pow(1 + i, n) 
    p * (i * power) / (power - 1)
  }
}
