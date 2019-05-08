package com.xyzcorp

import cats._
import cats.implicits._
import org.scalatest.{FunSpec, Matchers}

class ShowSpec extends FunSpec with Matchers {
  describe("Show is like toString") {
    it("""has a default String implementation which
        |  is just the String representation""".stripMargin) {
      Show[String].show("Hello") should be("Hello")
    }

    it("""has power with your own implementations for Show""") {
      class Person(val firstName: String, val lastName: String)

      object Person {
        implicit val firstThenLastShow: Show[Person] =
          (t: Person) => s"Person(${t.firstName}, ${t.lastName})"
        implicit val lastThenFirstShow: Show[Person] =
          (t: Person) => s"Person(${t.lastName}, ${t.firstName})"
      }

      import Person.lastThenFirstShow
      val result = Show[Person].show(new Person("Jon", "Snow"))
      result should be("Person(Snow, Jon)")
    }
  }
}
