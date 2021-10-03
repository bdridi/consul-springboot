package io.workcale.consulspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan

class ConsulSpringbootApplication

fun main(args: Array<String>) {
    runApplication<ConsulSpringbootApplication>(*args)
}
