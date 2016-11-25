package service

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import java.text.DecimalFormat

@RunWith(classOf[JUnitRunner])
class CheckoutServiceSpec extends FlatSpec with Matchers{

  val discountItems = "Apple" :: "Orange" :: Nil
  val df = new DecimalFormat("0.00");
  
	"Cart price without discount" should "have zero price " in {
		val shoppingCart = Nil 
		assertResult(df.format(CheckoutService.getCartPrice(shoppingCart, Nil)))("0.00")
	}

	it should "have 60 pence price" in {
		val shoppingCart = "Apple" :: Nil  
		assertResult(df.format(CheckoutService.getCartPrice(shoppingCart, Nil)))("0.60")
	}

	it should "have 85 pence price" in {
		val shoppingCart = "Apple" :: "Orange" :: Nil 
		assertResult(df.format(CheckoutService.getCartPrice(shoppingCart, Nil)))("0.85")
	}

	it should "have 2.05 pounds price" in {
		val shoppingCart = "Apple" :: "Apple" :: "Orange" :: "Apple" :: Nil
		assertResult(df.format(CheckoutService.getCartPrice(shoppingCart, Nil)))("2.05")
	}

	"Cart price with discount" should "have 60 pence price" in {
		val shoppingCart = "Apple" :: "Apple" :: Nil
		assertResult(CheckoutService.getCartPrice(shoppingCart, discountItems))(0.60)
	}

	it should "have 85 pence price" in {
		val shoppingCart = "Apple" :: "Apple" :: "Orange" :: Nil
		assertResult(df.format(CheckoutService.getCartPrice(shoppingCart, discountItems)))("0.85")
	}

	it should "have 1.70 pounds price" in {
		val shoppingCart = "Apple" :: "Apple" :: "Orange" :: "Orange" :: "Orange" :: "Apple" :: Nil 
		val discountItems = "Apple" :: "Orange" :: Nil
		
		assertResult(df.format(CheckoutService.getCartPrice(shoppingCart, discountItems)))("1.70")
	}
}