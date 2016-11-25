package service

import domain.Item
import domain.Apple
import domain.Orange
import domain.Discount
import java.text.DecimalFormat

object CheckoutService {
  
  def getCartPrice(cartList: List[String], discountList : List[String]): Double = {
    Item.apply(cartList).map(_.price).sum - Discount.discountPrice(cartList, discountList)
  }    
}