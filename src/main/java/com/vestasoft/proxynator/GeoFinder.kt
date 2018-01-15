package com.vestasoft.proxynator

import com.maxmind.geoip2.DatabaseReader
import java.io.File
import java.net.InetAddress




class GeoFinder {

    fun findIp(ip:String): List<String> {

        val database = File("src/main/java/com/vestasoft/proxynator/GeoLite2-City.mmdb")
        val dbReader = DatabaseReader.Builder(database).build()

        val ipAddress = InetAddress.getByName(ip)
        val response = dbReader.city(ipAddress)

        val countryName = response.getCountry().getName()
        val cityName = response.getCity().getName()

        println(countryName)
        println(cityName)

        var request = listOf<String>(countryName, cityName)

        return request
    }
}