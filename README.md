# Distributed configurations  Consul-springboot

Distribution configuration allows synchronizing the configuration among all the services and decoupling source code from configuration lifecycle.
It also offers a flexible way to change application properties properly without committing, deploying and restarting the service.  

## Run Consul server

We need a Consul server up and running before starting our spring boot application. 
Execute the docker compose file with the following command
`docker compose -f compose-consul.yaml up`

## Create a property `mission`

Create a new property in the KEY/VALUE dic in Consul at `config/config-consul-springboot/spacity/mission` with value *AURORA 1*

## Run the application 

`mvn spring-boot:run`

## Checkout the service in Consul registration

Alongside the distributed configuration feature, Consul provides also a service discovery. Our application is registred 
in the Consul service discovery through the configuration below. We can check the registration of our service in Consult through 
the url `http://localhost:8500/ui/dc1/services`, that list the service with some additional useful information such as 
health checks.

```yaml
spring:
  cloud:
    Consul:
      discovery:
        instanceId: ${spring.application.name}:${random.value}
```

## Check out the loaded configuration from Consul 
At start, the application will look for the properties from Consul at `/config/config-consul-springboot`. We already 
defined in a previous step a property called the `mission`. 

The binding properties class should be annotated with `@RefreshScope` and concerned attributes prefixed by the `var`keyword to 
permit the modification of its values at runtime by spring. 

```kotlin
@ConstructorBinding
@RefreshScope
@ConfigurationProperties("spacity")
class SpacityProperties {
    var mission: String? = null
}
```
Call the url `curl http://localhost:8080/spacity/mission` that returns the `mission` property's value. The value should be *AURORA 1*

## Change property value without restarting the application 

Now if we change the value of `mission` property, Consul will watch for any configuration changes and then trigger the update of all the services.
The value should be changed in the api `http://localhost:8080/spacity/mission` without restarting the application. 
