package com.example.crypto.DataSource

import com.example.crypto.Repo.CryptoStats
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.round

class LiveSource {


    fun getSummary() : List<CryptoStats> {

        val list = ArrayList<CryptoStats>()
        var response = get("https://api.coincap.io/")

        if(response.isSuccessful) {
            var cryptoN = JSONObject(response.body).optJSONArray("data")

            cryptoN?.let {
                for (i in 0 until cryptoN.length()){
                    list.add(CryptoStats(
                        cryptoN.getJSONObject(i).getString("symbol"),
                        cryptoN.getJSONObject(i).getString("name"),
                        cryptoN.getJSONObject(i).getString("priceUsd")
                    ))
                }
            }
        }

        return  list
    }




    private fun get(endpointURL: String): HTTPResponse {

        val url = URL(endpointURL)
        val connection = url.openConnection() as HttpURLConnection
        try {
            connection.requestMethod = "GET"

            connection.connect()

            val stream = if (connection.responseCode in 200..300) connection.inputStream else connection.errorStream

            val responseBody = try {
                stream.bufferedReader(Charsets.UTF_8).use { it.readText() }
            } catch (e: Throwable) {
                ""
            }

            return HTTPResponse(connection.responseCode, responseBody)
        } catch (e: Throwable) {
            return HTTPResponse(connection.responseCode, "")
        } finally {
            connection.disconnect()
        }
    }


    class HTTPResponse (private val statusCode: Int, val body : String) {
        val isSuccessful = statusCode in 200..300
    }
}