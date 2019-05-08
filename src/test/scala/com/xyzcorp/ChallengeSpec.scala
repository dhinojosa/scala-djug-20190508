package com.xyzcorp

import org.scalatest.{FunSuite, Matchers}

class ChallengeSpec extends FunSuite with Matchers {
  test("""Functional challenge. Using the fuctions we covered, write
         |  factorial functionally. No loops, no recursion. Hint: Most of the
         |  methods in BigInt are the same as Int so you can keep it simple.
         |  """.stripMargin) {


    pending

    def fromBigInt(x:BigInt):Stream[BigInt] = ???
    def factorial(x: BigInt): BigInt = ???
    factorial(5) should be (25)
  }

  test(
    """More Advanced Challenge: create a grid. If provided a size,
      |   create a grid with (size x size) dimensions. See the test for what is
      |   expected. You will need to look through the API for ways to do this.
      |   There is a method we haven't covered yet. If you give up,
      |   the answer is available here, but try your best:
      |   https://bit.ly/2zxPS9k""".stripMargin) {

    pending

    def grid(size: Int): String = ???

    grid(2) should be(
      """1,2
        |3,4""".stripMargin)

    grid(3) should be(
      """1,2,3
        |4,5,6
        |7,8,9""".stripMargin
    )

    grid(4) should be(
      """01,02,03,04
        |05,06,07,08
        |09,10,11,12
        |13,14,15,16""".stripMargin
    )
  }

  test(
    """Super Boss Advanced Challenge: No way you are going to solve this during class.
      |  Given the following cube:
      |
      |  TODD
      |  OMAR
      |  DAVE
      |  DREW
      |
      |  Notice that TODD is across in the first row and down in the first
      |  column. Notice how OMAR is across on 2nd row and down on 2nd column
      |  Notice the same for DAVE and DREW. Find the female equivalent cube that
      |  works the same way. Find a list of female names on the web. Use
      |  functional programming, NOT imperative programming.""".stripMargin) {
    pending
  }
}
