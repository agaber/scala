package com.acme.scala

import org.junit.runner.RunWith
import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RationalSpec extends Spec {
  it ("should use equal") {
    assert(new Rational(1, 2) == new Rational(1, 2))
    assert(new Rational(1, 2).equals(new Rational(1, 2)))

    // TODO: Why doesn't implicit conversion work?
    // assert(new Rational(2, 1) == 2)
    // assert(2 == new Rational(2, 1))
  }

  it ("should add rationals") {
    expect(new Rational(7, 6)) {
      new Rational(1, 2) + new Rational(2, 3)
    }
  }

  it("should add ints") {
    expect(new Rational(8, 3)) {
      new Rational(2, 3) + 2
    }
  }

  it("should subtract rationals") {
    expect(new Rational(5, 1)) {
      new Rational(20, 3) - new Rational(5, 6)
    }
  }

  it("should subtract ints") {
    expect(new Rational(14, 3)) {
      new Rational(20, 3) - 2
    }
  }

  it("should multiply rationals") {
    expect(new Rational(50, 9)) {
      new Rational(20, 3) * new Rational(5, 6)
    }
  }

  it("should multiply ints") {
    expect(new Rational(40, 3)) {
      new Rational(20, 3) * 2
    }
  }

  it("should divide rationals") {
    expect(new Rational(8, 1)) {
      new Rational(20, 3) / new Rational(5, 6)
    }
  }

  it("should divide ints") {
    expect(new Rational(10, 3)) {
      new Rational(20, 3) / 2
    }
  }
}
