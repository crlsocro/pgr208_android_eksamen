package com.example.crypto

class Coin(symbol : String, name : String, amount : Double) {
    var symbol : String = ""
    var name : String = ""
    var amount : Double = 0.0

    fun getCoin(symbol : String): Coin {
        return Coin(symbol, name, amount)
    }

    fun createCoin(symbol: String, name : String, amount: Double): Coin {
        return Coin(symbol, name, amount)
    }
}