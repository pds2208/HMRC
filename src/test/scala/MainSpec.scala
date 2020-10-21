import Main.{APPLE_COST, Apple, Fruit, ORANGE_COST, Orange}
import org.scalatest.funsuite.AnyFunSuite

import scala.math.BigDecimal.RoundingMode


class MainSpec extends AnyFunSuite {

  def round(d: BigDecimal): BigDecimal = d.setScale(4, RoundingMode.HALF_UP)

  test("oranges cart") {
    val cart: List[Fruit] = Orange :: Orange :: Orange :: Nil
    val total = Main.calculateCart(cart)
    assert(total == ORANGE_COST * 3)
  }

  test("apples cart") {
    val cart: List[Fruit] = Apple :: Apple :: Apple :: Nil
    val total = Main.calculateCart(cart)
    assert(total == round(APPLE_COST * 3))
  }

  test("mixed cart") {
    val cart: List[Fruit] = Orange :: Apple :: Orange :: Orange :: Apple :: Apple :: Orange :: Orange :: Orange :: Apple :: Apple :: Nil
    val total = Main.calculateCart(cart)
    assert(total == round(ORANGE_COST * 6 + APPLE_COST * 5))
  }

  test("oranges special") {
    val cart: List[Fruit] = Orange :: Orange :: Orange :: Nil
    val total = Main.calculateSpecial(cart)
    assert(total == ORANGE_COST * 2)
  }

  test("oranges special 1") {
    val cart: List[Fruit] = Orange :: Orange :: Orange :: Orange :: Nil
    val total = Main.calculateSpecial(cart)
    assert(total == ORANGE_COST * 2 + ORANGE_COST)
  }

  test("apples special") {
    val cart: List[Fruit] = Apple :: Apple :: Apple :: Apple :: Nil
    val total = Main.calculateSpecial(cart)
    assert(total == APPLE_COST * 2)
  }

  test("apples special 1") {
    val cart: List[Fruit] = Apple :: Apple :: Apple :: Apple :: Apple :: Nil
    val total = Main.calculateSpecial(cart)
    assert(total == APPLE_COST * 2 + APPLE_COST)
  }
}
