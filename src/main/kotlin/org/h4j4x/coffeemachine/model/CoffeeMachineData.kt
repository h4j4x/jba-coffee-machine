package org.h4j4x.coffeemachine.model

data class CoffeeMachineData(var waterMl: Int = 400,
                             var milkMl: Int = 540,
                             var beansG: Int = 120,
                             var disposableCups: Int = 9,
                             var moneyUsd: Int = 550,) {
}
