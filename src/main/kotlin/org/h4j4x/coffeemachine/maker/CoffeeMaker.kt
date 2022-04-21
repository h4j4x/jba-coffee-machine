package org.h4j4x.coffeemachine.maker

import org.h4j4x.coffeemachine.model.CoffeeMachineData
import org.h4j4x.coffeemachine.model.CoffeeType
import org.h4j4x.coffeemachine.error.InsufficientIngredientError

abstract class CoffeeMaker {
    abstract fun canMake(coffeeType: CoffeeType): Boolean
    abstract fun waterMl(): Int
    abstract fun milkMl(): Int
    abstract fun beansG(): Int
    abstract fun price(): Int

    fun make(data: CoffeeMachineData, amount: Int = 1): CoffeeMachineData {
        if (data.waterMl < waterMl() * amount) {
            throw InsufficientIngredientError("Sorry, not enough water!")
        }
        data.waterMl -= waterMl() * amount
        if (data.milkMl < milkMl() * amount) {
            throw InsufficientIngredientError("Sorry, not enough milk!")
        }
        data.milkMl -= milkMl() * amount
        if (data.beansG < beansG() * amount) {
            throw InsufficientIngredientError("Sorry, not enough coffee beans!")
        }
        data.beansG -= beansG() * amount
        if (data.disposableCups < amount) {
            throw InsufficientIngredientError("Sorry, not enough cups!")
        }
        data.disposableCups -= amount
        data.moneyUsd += price() * amount
        return data
    }
}
