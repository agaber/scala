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
  }

  it ("should add") {
    expect(new Rational(7, 6)) {
      new Rational(1, 2) + new Rational(2, 3)
    }
  }

  it("should add ints") {
    expect(new Rational(8, 3)) {
      new Rational(2, 3) + 2
    }
  }
}
