package ru.sber.services

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("singleton")
class SingletonService

@Component
@Scope("prototype")
class PrototypeService