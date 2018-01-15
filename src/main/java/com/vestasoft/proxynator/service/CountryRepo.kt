package com.vestasoft.proxynator.service

import org.springframework.data.jpa.repository.JpaRepository
import com.vestasoft.proxynator.domain.Country

interface CountryRepo : JpaRepository<Country, Int>{

    fun findAllByCountrytitle(countrytitle:String):List<Country>

}