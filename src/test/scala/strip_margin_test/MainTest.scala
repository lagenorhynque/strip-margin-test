package strip_margin_test

import org.scalatest.{FunSuite, Matchers}

class MainTest extends FunSuite with Matchers {
  test("StringLike#stripMargin") {
    """def factorial(n: Int): Int = {
         if (n == 0) 1
         else n * factorial(n - 1)
       }""".stripMargin shouldBe """def factorial(n: Int): Int = {
         if (n == 0) 1
         else n * factorial(n - 1)
       }"""

    """def factorial(n: Int): Int = {
      |  if (n == 0) 1
      |  else n * factorial(n - 1)
      |}""".stripMargin shouldBe """def factorial(n: Int): Int = {
  if (n == 0) 1
  else n * factorial(n - 1)
}"""

    """|def factorial(n: Int): Int = {
       |  if (n == 0) 1
       |  else n * factorial(n - 1)
       |}""".stripMargin shouldBe """def factorial(n: Int): Int = {
  if (n == 0) 1
  else n * factorial(n - 1)
}"""

    """def factorial(n: Int): Int = {
      ;  if (n == 0) 1
      ;  else n * factorial(n - 1)
      ;}""".stripMargin(';') shouldBe """def factorial(n: Int): Int = {
  if (n == 0) 1
  else n * factorial(n - 1)
}"""
  }
}
