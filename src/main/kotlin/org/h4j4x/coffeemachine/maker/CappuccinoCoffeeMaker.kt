package org.h4j4x.coffeemachine.maker

import org.h4j4x.coffeemachine.model.CoffeeType

// For the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
class CappuccinoCoffeeMaker : CoffeeMaker() {
    override fun canMake(coffeeType: CoffeeType) = CoffeeType.CAPPUCCINO == coffeeType

    override fun waterMl() = 200

    override fun milkMl() = 100

    override fun beansG() = 12

    override fun price() = 6
}
