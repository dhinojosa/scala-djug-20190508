package com.xyzcorp
import org.scalatest.{FunSpec, Matchers}

class EqSpec extends FunSpec with Matchers {
  describe("Eq") {
    it("is a type class that has the following definition") {
      trait Eq[A] {
        def eqv(a: A, b: A): Boolean
      }
    }

    it("is available with Cats via import") {
      import cats._
      import cats.implicits._
      val eqInt = Eq[Int]
      eqInt.eqv(4, 5) should be (false)
      eqInt.eqv(4, 4) should be (true)
    }

    it("""has power with your own implementations for Show""") {
      import cats._
      import cats.implicits._

      class Person(val firstName: String, val lastName: String)
      object Person {
        implicit val firstEq: Eq[Person] = new Eq[Person] {
          override def eqv(x: Person, y: Person): Boolean =
            x.firstName == y.firstName
        }
        implicit val lastEq: Eq[Person] = new Eq[Person] {
          override def eqv(x: Person, y: Person): Boolean =
            x.lastName == y.lastName
        }
        implicit val firstAndLastEq: Eq[Person] = new Eq[Person] {
          override def eqv(x: Person, y: Person): Boolean =
            x.firstName == y.firstName && x.lastName == y.lastName
        }
      }

      import Person.firstEq

      val mayaRudolph = new Person("Maya", "Rudolph")
      val mayaAngelou = new Person("Maya", "Angelou")

      Eq[Person].eqv(mayaAngelou, mayaRudolph) should be (true)
    }
  }
}
