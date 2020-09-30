package com.rms.coroutinesstudy.pubsub

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

val eventHandler = EventHandler()
val submitManager = SubmitManager(listOf("cpf", "email", "cep"), eventHandler)

fun main() = runBlocking {
//    eventHandler.createNewTopic("cpf")
//    eventHandler.createNewTopic("email")
//    eventHandler.createNewTopic("cep")
//
//    eventHandler.subscribeOnTopic("cpf") { o, arg ->
//        println("CPF is Changed $arg")
//    }
//
//    eventHandler.subscribeOnTopic("cpf") { o, arg ->
//        println("CPF2 is Changed $arg")
//    }
//
//    eventHandler.subscribeOnTopic("email") { o, arg ->
//        println("EMAIL is Changed $arg")
//    }
//
//    eventHandler.subscribeOnTopic("cep") { o, arg ->
//        println("CEP is Changed $arg")
//    }

    delay(1000)
    eventHandler.publishOnTopic("cpf", Field("cpf", "000.000.000.00"))
    delay(1000)
    eventHandler.publishOnTopic("email", Field("email", "teste@email.com"))
    delay(1000)
    eventHandler.publishOnTopic("cep", Field("cep", "00000-000"))

    delay(1000)
    eventHandler.publishOnTopic("cpf", Field("cpf", "000.000.000.00", true))
    delay(1000)
    eventHandler.publishOnTopic("email", Field("email", "teste@email.com", true))
    delay(1000)
    eventHandler.publishOnTopic("cep", Field("cep", "00000-000", true))

}

