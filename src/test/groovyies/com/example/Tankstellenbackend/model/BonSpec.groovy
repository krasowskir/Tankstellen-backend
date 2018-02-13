package com.example.Tankstellenbackend.model

import spock.lang.Specification

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class BonSpec extends Specification {

    ValidatorFactory myFactory
    Validator myValidator

    def setup(){
        myFactory = Validation.buildDefaultValidatorFactory()
        myValidator = myFactory.getValidator()
    }

    def "creating a bon should work as expected"(){

        given: "bon creation"
        def bon = new Bon("testBon", 12, 13, 14)


        when: "validating"
        Set<ConstraintViolation<Bon>> violations = myValidator.validate(bon)

        then: "no violations should occur"
        violations.isEmpty()
    }

}
