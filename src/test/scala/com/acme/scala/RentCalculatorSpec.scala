package com.acme.scala

import org.junit.runner.RunWith
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RentCalculatorSpec extends Spec {
  it ("should calculate the rent values") {
    val result = RentCalculator.calculate(1500, 2000, 15)
    expect(3000.0) { result("twoMonthsRent") }
    expect(2700.0) { result("fee") }
    expect(5700.0) { result("total") }
    expect(3) { result("payCycles") }
  }
  
  it ("should calculate the rent values without a fee") {
    val result = RentCalculator.calculate(1500, 2000, 0)
    expect(3000.0) { result("twoMonthsRent") }
    expect(0.0) { result("fee") }
    expect(3000.0) { result("total") }
    expect(2) { result("payCycles") }
  }
}
