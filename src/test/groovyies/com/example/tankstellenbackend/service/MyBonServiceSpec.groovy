package com.example.tankstellenbackend.service

import com.example.tankstellenbackend.model.Bon
import com.example.tankstellenbackend.persistence.BonRepository
import spock.lang.Specification


class MyBonServiceSpec extends Specification {

    def bonRepository = Mock(BonRepository)

    def myBonService = new MyBonService(bonRepository)

    def bon = new Bon("Aral", 1.25, 44.5, 55.625)

    def 'calling add saves the entity with the bonrepository'() {
        given:
        bon

        when:
        myBonService.add(bon)

        then:
        1 * bonRepository.save(bon)
    }

    def 'callind delete removes an existing bon within bonRepository'() {
        given:
        1 * bonRepository.findOne(_) >> bon

        when:
        myBonService.deleteById(bon.id)

        then:
        1 * bonRepository.delete(_)
    }

    def 'calling update fetches the bon from db and changes its attributes and persists'() {

        given:
        def newBon = new Bon("Shell", 1.5, 20, 30)
        1 * bonRepository.findOne(_) >> bon

        when:
        myBonService.update(newBon)

        then:
        1 * bonRepository.save(_)

    }
}
