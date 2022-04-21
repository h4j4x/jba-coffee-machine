package org.h4j4x.coffeemachine.maker

import org.h4j4x.coffeemachine.model.CoffeeType

// For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
class LatteCoffeeMaker : CoffeeMaker() {
    override fun canMake(coffeeType: CoffeeType) = CoffeeType.LATTE == coffeeType

    override fun waterMl() = 350

    override fun milkMl() = 75

    override fun beansG() = 20

    override fun price() = 7
}
