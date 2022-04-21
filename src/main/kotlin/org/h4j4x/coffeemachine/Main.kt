@file:JvmName("Main")

package org.h4j4x.coffeemachine

import org.h4j4x.coffeemachine.error.InsufficientIngredientError
import org.h4j4x.coffeemachine.model.CoffeeType

fun main() {
    val coffeeMachine = CoffeeMachine()
    var option: String
    do {
        print("Write action (buy, fill, take, remaining, exit): ")
        option = readln().trim().lowercase()
        println()
        when (option) {
            "buy" -> buy(coffeeMachine)
            "fill" -> fill(coffeeMachine)
            "take" -> take(coffeeMachine)
            "remaining" -> printStatus(coffeeMachine)
            "exit" -> {}
            else -> {
                println("Invalid action!")
                println()
            }
        }
    } while (option != "exit")
}

fun take(coffeeMachine: CoffeeMachine) {
    println("I gave you $${coffeeMachine.moneyUsd()}")
    coffeeMachine.resetMoneyUsd()
    println()
}

fun printStatus(coffeeMachine: CoffeeMachine) {
    println("The coffee machine has:")
    println("${coffeeMachine.waterMl()} ml of water")
    println("${coffeeMachine.milkMl()} ml of milk")
    println("${coffeeMachine.beansG()} g of coffee beans")
    println("${coffeeMachine.disposableCups()} disposable cups")
    println("$${coffeeMachine.moneyUsd()} of money")
    println()
}

fun fill(coffeeMachine: CoffeeMachine) {
    print("Write how many ml of water do you want to add: ")
    coffeeMachine.addWaterMl(readln().toInt())
    print("Write how many ml of milk do you want to add: ")
    coffeeMachine.addMilkMl(readln().toInt())
    print("Write how many grams of coffee beans do you want to add: ")
    coffeeMachine.addBeansG(readln().toInt())
    print("Write how many disposable cups of coffee do you want to add: ")
    coffeeMachine.addDisposableCups(readln().toInt())
    println()
}

fun buy(coffeeMachine: CoffeeMachine) {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    val option = when(readln().trim()) {
        "1" -> CoffeeType.ESPRESSO
        "2" -> CoffeeType.LATTE
        "3" -> CoffeeType.CAPPUCCINO
        else -> null
    }
    if (option != null) {
        try {
            coffeeMachine.make(option)
            println("I have enough resources, making you a coffee!")
        } catch (e: InsufficientIngredientError) {
            println(e.message)
        }
        println()
    }
}
