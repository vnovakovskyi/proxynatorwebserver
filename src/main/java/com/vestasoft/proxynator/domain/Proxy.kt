package com.vestasoft.proxynator.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Proxy (
        var countryid: Int = 0,
        var citytitle: String = "",
        var host: String = "",
        var port: String = "",
        var lastseen: String = "",
        var starred: Boolean = false,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var proxyid: Int = 0)
