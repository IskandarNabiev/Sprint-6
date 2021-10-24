package ru.sber.services

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service


@Service
class FirstService {
    override fun toString(): String {
        return "I am firstService"
    }
}

@Service
class SecondService {
    override fun toString(): String {
        return "I am secondService"
    }
}

@Service
class ThirdService {
    override fun toString(): String {
        return "I am thirdService"
    }
}

@Service
class FourthService {
    override fun toString(): String {
        return "I am fourthService"
    }
}