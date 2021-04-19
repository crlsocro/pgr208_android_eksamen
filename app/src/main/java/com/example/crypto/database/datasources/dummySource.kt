package com.example.crypto.database.datasources

import com.example.crypto.models.CryptoStats


class dummySource {
    fun getSummary(): List<CryptoStats>{
        var list = ArrayList<CryptoStats>()

        list.add(CryptoStats("Bitcoint", "BTC", 3333555))
        list.add(CryptoStats("Bitcoin", "BTC", 3333555))
        list.add(CryptoStats("Bitcoisdfsdft", "BTC", 3333555))
        list.add(CryptoStats("Bifftcont", "BTC", 3333555))
        list.add(CryptoStats("Bitodfsdint", "BTC", 3333555))
        list.add(CryptoStats("Btcoint", "BTC", 3333555))
        list.add(CryptoStats("itcoifdsfnt", "BTC", 3333555))
        list.add(CryptoStats("Bcoint", "BTC", 3333555))

        return list
    }
}