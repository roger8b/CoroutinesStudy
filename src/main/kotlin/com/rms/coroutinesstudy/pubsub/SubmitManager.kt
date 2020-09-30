package com.rms.coroutinesstudy.pubsub

import java.util.*

class SubmitManager(private val keys: List<String>, private val eventHandler: EventHandler) : Observer {

    private val fields: MutableMap<String, Field?> = mutableMapOf()

    init {
        keys.forEach { key ->
            eventHandler.createNewTopic(key)
            eventHandler.subscribeOnTopic(key, this)
            fields[key] = null
        }
    }

    override fun update(o: Observable?, arg: Any?) {
        val field: Field? = arg as? Field
        field?.run {
            fields[field.key] = this
        }
        println("SubmitManager Field is Changed $arg")
        println("All field is valid? ${checkAllFieldsIsValid()}")
    }

    private fun checkAllFieldsIsValid(): Boolean {
        return fields.any { it.value?.isValid == false }.not()
    }
}