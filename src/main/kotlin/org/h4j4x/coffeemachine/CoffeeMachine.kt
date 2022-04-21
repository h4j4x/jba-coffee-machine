package org.h4j4x.coffeemachine

import org.h4j4x.coffeemachine.maker.CappuccinoCoffeeMaker
import org.h4j4x.coffeemachine.maker.CoffeeMaker
import org.h4j4x.coffeemachine.maker.EspressoCoffeeMaker
import org.h4j4x.coffeemachine.maker.LatteCoffeeMaker
import org.h4j4x.coffeemachine.model.CoffeeMachineData
import org.h4j4x.coffeemachine.model.CoffeeType

class CoffeeMachine {
    private val coffeeMakers: Array<CoffeeMaker> = arrayOf(
        EspressoCoffeeMaker(), LatteCoffeeMaker(), CappuccinoCoffeeMaker()
    )
    private var data = CoffeeMachineData()

    fun make(coffeeType: CoffeeType, amount: Int = 1) {
        val coffeeMaker = coffeeMaker(coffeeType)
        if (coffeeMaker != null) {
            data = coffeeMaker.make(data, amount)
        }
    }

    private fun coffeeMaker(coffeeType: CoffeeType): CoffeeMaker? {
        for (coffeeMaker in coffeeMakers) {
            if (coffeeMaker.canMake(coffeeType)) {
                return coffeeMaker
            }
        }
        return null
    }

    fun moneyUsd() = data.moneyUsd
    fun waterMl() = data.waterMl
    fun milkMl() = data.milkMl
    fun beansG() = data.beansG
    fun disposableCups() = data.disposableCups

    fun addWaterMl(value: Int) {
        data.waterMl += value
    }

    fun addMilkMl(value: Int) {
        data.milkMl += value
    }

    fun addBeansG(value: Int) {
        data.beansG += value
    }

    fun addDisposableCups(value: Int) {
        data.disposableCups += value
    }

    fun resetMoneyUsd() {
        data.moneyUsd = 0
    }
}
