package com.example.tankstellenbackend.controller

import com.example.tankstellenbackend.model.Bon
import com.example.tankstellenbackend.service.BonService
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import spock.lang.Specification

class BonControllerSpec extends Specification {

    def bonService = Mock(BonService)
    def bonController = new BonController(bonService);

    def 'an http request on path /bons leads to save in bonRepository and successedBon'() {
        given:
        def validBon = new Bon("Aral", 1.25, 38, 47.5)

        and:
        def bindingResult = Mock(BindingResult){
            hasErrors() >> false
        }
        def model = Mock(Model)

        when:
        def result = bonController.saveBon(validBon, bindingResult, model)

        then:
        1 * bonService.add(validBon)

        and:
        result == "successedBon"
    }

    def 'an http request on path /bons with invalid bon causes no save and redirect to /bons'() {
        given:
        def faultyBon = new Bon()
        faultyBon.setTankstellenName("Aral")
        faultyBon.setBenzinPreis(2.5)
        faultyBon.setDatum(null)
        faultyBon.setTankVolumen(38)
        faultyBon.setEndPreis(44)

        and:
        def bindingResult = Mock(BindingResult){
            hasErrors() >> true
        }
        def model = Mock(Model)

        when:
        def result = bonController.saveBon(faultyBon, bindingResult, model)

        then:
        0 * bonService.add(_)

        and:
        result == "redirect:/bons"
    }
}
