package ru.sber.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import ru.sber.services.FirstService

@Configuration
@ComponentScan("ru.sber.services")
class ServicesConfig

@Configuration
@ComponentScan("ru.sber.services")
class AnotherServicesConfig