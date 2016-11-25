package domain

sealed trait Discount {
  def getPrice(items: List[String]) : Double
}

object AppleDiscount extends Discount{
  override def getPrice(items : List[String]): Double = items.count(_ == "Apple") / 2 * Apple.price
}


object OrangeDiscount extends Discount{
  override def getPrice(items : List[String]): Double = items.count(_ == "Orange") / 3 * Orange.price
}

object Discount {
  def apply(item : String) : Discount = {
    item match {
      case "Apple" => AppleDiscount
      case "Orange" => OrangeDiscount    }
  }
  
  def discountPrice(cartItems : List[String], discountItems : List[String]) : Double = 
    if(discountItems != null) 
      discountItems.map { x => apply(x).getPrice(cartItems) }.sum
    else
      0.0
}