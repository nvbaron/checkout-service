package domain

/**
 * @author nvijayar
 */

sealed trait Item {
  val price : Double
}

case object Apple extends Item{
  val price = 0.60
}

case object Orange extends Item{
  val price = 0.25
}

object Item {
  def apply(name : String) : Item = {
    name match {
      case "Apple" => Apple
      case "Orange" => Orange
    }
  }
  
  def apply(items: List[String]): List[Item] = items.map(apply)
 
}

