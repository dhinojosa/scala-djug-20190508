package com.xyzcorp

import cats._
import cats.implicits._
import org.scalatest.{FunSpec, Matchers}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.language.{postfixOps, reflectiveCalls}

class FunctorSpec extends FunSpec with Matchers {

  describe("Functor") {
    it("is a map that uses a type class") {
      val result = Functor[List].fmap(List(1, 2, 3, 4))(x => x + 30)
      result should be(List(31, 32, 33, 34))
    }

    it("can be used with an Option") {
      val result = Functor[Option].fmap(Some(13))(10 *)
      result should be(Some(130))
    }

    it("can be used with a Function and used for composition") {
      import cats.instances.function._
      import cats.syntax.functor._

      val func1 = (a: Int) => a + 1
      val func2 = (a: Int) => a * 2
      val func3 = (a: Int) => a + "!"
      val func4 = func1.map(func2).map(func3)

      func4(123)
    }

    it("can be used with Futures") {
      val future = Future {
        40 * 10
      }
      val result = Functor[Future].fmap(future)(x => x / 2)
      result.foreach(_ should be(200))
      Await.ready(result, 3 seconds)
    }

    it("can be used with a type class of your choosing") {
      case class Box[A](contents: A)

      implicit val boxFunctor: Functor[Box] = new Functor[Box] {
        override def map[A, B](fa: Box[A])(f: A => B): Box[B] = Box(
          f(fa.contents))
      }

      val box = Box(100)
      val result = Functor[Box].fmap(box)(x => x + 100)
      result should be(Box(200))
    }
  }
}
