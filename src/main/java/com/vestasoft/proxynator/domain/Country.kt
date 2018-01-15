package com.vestasoft.proxynator.domain

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Country (
        @JsonProperty("countrytitle")
        var countrytitle:String = "",
        @JsonProperty("countrystarred")
        var countrystarred:Boolean = false,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var countryid:Int = 0)
