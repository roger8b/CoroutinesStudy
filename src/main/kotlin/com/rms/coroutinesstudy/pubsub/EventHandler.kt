package com.rms.coroutinesstudy.pubsub

import java.util.*

class EventHandler {
    private val topics: MutableMap<String, Topic> = mutableMapOf()

    fun createNewTopic(key: String) {
        topics[key] = Topic()
    }

    fun subscribeOnTopic(key: String, observer: Observer) {
        topics[key]?.addObserver(observer)
    }

    fun publishOnTopic(key: String, value: Any) {
        topics[key]?.value = value
    }
}