package com.vestasoft.proxynator.service

import org.springframework.data.jpa.repository.JpaRepository
import com.vestasoft.proxynator.domain.Proxy

interface ProxyRepo : JpaRepository<Proxy, Int> {

    fun findAllByCountryid(countryid: Int): List<Proxy>
    fun findAllByProxyid(proxyid: Int): List<Proxy>
    fun deleteProxyByHostAndPort(host: String, port: String)
}
