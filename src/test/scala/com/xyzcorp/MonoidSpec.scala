package com.xyzcorp

import cats._
import cats.implicits._
import org.scalatest.{FunSpec, Matchers}

import scala.language.reflectiveCalls

class MonoidSpec extends FunSpec with Matchers {
  describe("A Monoid") {

    it("is an operation `combine` with type (A, A) => A") {
      val r = Monoid.apply[String].combine("Few", "Between")
      val s = Monoid[String].combine("Few", "Between")
      r should be("FewBetween")
      r should be(s)
    }

    it("is an operation `empty` with type A") {
      Monoid[String].empty should be("")
      Monoid[Float].empty should be(0F)
    }

    it(
      """contains a |+| operator that is a synonym
        |  of combine from the
        |  Semigroup type class.""".stripMargin) {
      val total = 1 |+| 2 |+| Monoid[Int].empty
      total should be(3)
    }
  }
}