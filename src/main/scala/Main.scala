import scala.math.Integral.Implicits.infixIntegralOps

object Main { // could do this  extends App {

  val APPLE_COST = .6
  val ORANGE_COST = .25
  val Apple: Fruit = Fruit(APPLE_COST)
  val Orange: Fruit = Fruit(ORANGE_COST)
  val cart: List[Fruit] = Orange :: Apple :: Orange :: Orange :: Apple :: Apple :: Orange :: Orange :: Orange :: Apple :: Apple :: Nil

  def main(args: Array[String]): Unit = {
    println(s"Total: ${calculateCart(cart)}")
    println(s"Total special: ${calculateSpecial(cart)}")
  }

  def calculateCart(basket: List[Fruit]): BigDecimal = basket.map(_.price).sum

  def calculateSpecial(xs: List[Fruit]): BigDecimal = {
    val (oq, or) = xs.count(a => a.price == ORANGE_COST) /% 3
    val (aq, ar) = xs.count(a => a.price == APPLE_COST) /% 2
    (oq * (ORANGE_COST * 2) + or * ORANGE_COST) + (aq * APPLE_COST + ar * APPLE_COST)
  }

  case class Fruit(price: BigDecimal)

}
