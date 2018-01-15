package com.vestasoft.proxynator.web

import org.springframework.web.bind.annotation.*
import com.vestasoft.proxynator.domain.Country
import com.vestasoft.proxynator.domain.Proxy
import com.vestasoft.proxynator.service.CountryRepo
import com.vestasoft.proxynator.service.ProxyRepo
import org.springframework.beans.factory.annotation.Autowired

@RestController
open class MainController {

    @Autowired
    lateinit var proxyRepo: ProxyRepo

    @Autowired
    lateinit var countryRepo: CountryRepo

    @GetMapping("/countries")
    open fun findCountries(): List<Country> = countryRepo.findAll()

    @GetMapping("/proxies")
    @ResponseBody
    open fun findProxies(@RequestParam countryid: Int): List<Proxy> = proxyRepo.findAllByCountryid(countryid)

    @GetMapping("/newproxy")
    @ResponseBody
    open fun newProxy(
            @RequestParam city: String,
            @RequestParam country: String,
            @RequestParam host: String,
            @RequestParam port: String): String {

        var countryDb = countryRepo.findAllByCountrytitle(country)

        if (countryDb.isNotEmpty()) {

            val proxyDb = proxyRepo.findAllByCountryid(countryDb[0].countryid)

            if (proxyDb.isNotEmpty()){

                var ex = false

                for (value in proxyDb){
                    if ((value.host.equals(host)) && (value.port.equals(port))){
                        ex = true
                    }
                }

                if (!ex){
                    proxyRepo.save(Proxy(countryDb[0].countryid, city, host, port, "", false))
                }

            } else{
                proxyRepo.save(Proxy(countryDb[0].countryid, city, host, port, "", false))
            }

        } else {

            countryRepo.save(Country(country, false))
            countryDb = countryRepo.findAllByCountrytitle(country)
            proxyRepo.save(Proxy(countryDb[0].countryid, city, host, port, "", false))

        }

        return city
    }

    @GetMapping("/delproxy")
    @ResponseBody
    open fun delProxy(@RequestParam host: String,
                      @RequestParam port: String) {
        proxyRepo.deleteProxyByHostAndPort(host, port)
    }
}