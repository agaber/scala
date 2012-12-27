package com.acme.scala

object RentCalculator {
  def calculate(rent: Double, biweeklyIncome: Double, feeRate: Double = 15): Map[String, Any] = {
    require(rent > 0, "rent must be greater than zero")
    require(biweeklyIncome > 0, "biweeklyIncome must be greater than zero")
    require(feeRate >= 0, "rent must be greater than or equal to zero")
    val twoMonthsRent = rent * 2
    val fee = if (feeRate > 0) rent * 12 * (feeRate / 100) else 0
    val total = twoMonthsRent + fee
    val payCycles = math.ceil(total / biweeklyIncome).toInt
    Map(
      "twoMonthsRent" -> twoMonthsRent,
      "fee" -> fee,
      "total" -> total,
      "payCycles" -> payCycles)
  }
}

