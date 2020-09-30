package com.rms.coroutinesstudy.pubsub

import java.util.*

class Topic : Observable() {
    var value: Any = Any()
        set(value) {
            setChanged()
            notifyObservers(value)
        }
}