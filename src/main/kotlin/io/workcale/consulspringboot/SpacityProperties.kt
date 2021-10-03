package io.workcale.consulspringboot

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.cloud.context.config.annotation.RefreshScope


@ConstructorBinding
@RefreshScope
@ConfigurationProperties("spacity")
class SpacityProperties {
    var mission: String? = null
}

