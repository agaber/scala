package com.acme.scala

class Rational(n: Int, d: Int) {
  require(d != 0, "Rational numbers may not have a 0 denominator.")
  private val g = gcd(n, d)
  val numerator = n / g
  val denominator = d / g

  // Second constructor that defaults to n/1.
  def this(n: Int) = this(n, 1)

  def +(that: Rational) = {
    new Rational(
        this.numerator * that.denominator + that.numerator + this.denominator,
        this.denominator * that.denominator)
  }

  def +(i: Int): Rational = {
    new Rational(this.numerator + i * this.denominator, this.denominator)
  }

  def -(that: Rational) = {
    new Rational(
        this.numerator * that.denominator - that.numerator * that.denominator,
        denominator * that.denominator)
  }

  def -(i: Int) = {
    new Rational(this.numerator - i * this.denominator, this.denominator)
  }

  def *(that: Rational) = {
    new Rational(
        this.numerator * that.numerator,
        this.denominator * that.denominator)
  }

  def *(i: Int) = {
    new Rational(this.numerator * i, this.denominator)
  }

  def /(that: Rational) = {
    new Rational(this.numerator * that.denominator, this.denominator * that.numerator)
  }

  def /(i: Int) = {
    new Rational(this.numerator, this.denominator * i)
  }

  implicit def intToRational(x: Int) = {
    new Rational(x)
  }

  override def equals(that: Any) = {
    (that != null
        && that.isInstanceOf[Rational]
        && this.numerator == that.asInstanceOf[Rational].numerator
        && this.denominator == that.asInstanceOf[Rational].denominator)
  }

  // TODO: hashcode

  override def toString() = {
    if (this.denominator == 1) {
      this.numerator.toString() 
    } else {
      this.numerator + "/" + this.denominator
    }
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else this.gcd(b, a % b)
  }
}
