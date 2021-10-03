package io.workcale.consulspringboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class SpacityController {

    @Autowired
    private val properties: SpacityProperties? = null


    @GetMapping("/spacity/mission")
    fun getMissionName(): String? {
        return properties?.mission
    }

}