package com.acme.scala

import org.junit.runner.RunWith
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MortgageSpec extends Spec {
  it ("should calculate the down payment, mortgage payment & total monthly cost") {
    val m1 = new Mortgage(
        price = 195000,
        percentDown = 20,
        monthlyMaintenanceFee = 410,
        monthlyRealEstateTax = 100,
        term = 30,
        rate = 5)
    expect(156000.00) { m1.principal }
    expect(39000.00) { m1.downPayment }
    expect(837) { math.round(m1.monthlyFixedRateMortgagePayment) }
    expect(1347) { math.round(m1.totalMonthlyCost) }

    val m2 = new Mortgage(
        price = 195000,
        percentDown = 20,
        monthlyMaintenanceFee = 410)
    expect(156000.00) { m2.principal }
    expect(39000.00) { m2.downPayment }
    expect(701) { math.round(m2.monthlyFixedRateMortgagePayment) }
    expect(1111) { math.round(m2.totalMonthlyCost) }

    val m3 = new Mortgage(
        price = 500000,
        percentDown = 12,
        monthlyMaintenanceFee = 523,
        monthlyRealEstateTax = 100)
    expect(440000.00) { m3.principal }
    expect(60000.00) { m3.downPayment }
    expect(1976) { math.round(m3.monthlyFixedRateMortgagePayment) }
    expect(2599) { math.round(m3.totalMonthlyCost) }
  }
  
  it ("should print as a string without blowing up") {
    // Not blowing up on the sting format rules is harder than it looks... :\
    new Mortgage(
        price = 195000,
        percentDown = 20,
        monthlyMaintenanceFee = 410,
        monthlyRealEstateTax = 100,
        term = 30,
        rate = 5).toString()
  }
}
