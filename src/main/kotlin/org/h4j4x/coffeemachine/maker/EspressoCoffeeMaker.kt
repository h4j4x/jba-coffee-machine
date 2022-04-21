package org.h4j4x.coffeemachine.maker

import org.h4j4x.coffeemachine.model.CoffeeType

// For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
class EspressoCoffeeMaker : CoffeeMaker() {
    override fun canMake(coffeeType: CoffeeType) = CoffeeType.ESPRESSO == coffeeType

    override fun waterMl() = 250

    override fun milkMl() = 0

    override fun beansG() = 16

    override fun price() = 4
}
