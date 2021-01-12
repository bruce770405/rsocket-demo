package tw.com.bruce.rsocket.messages

import java.time.Instant

class DemoMessageDto {
    private var message: String? = null
    private var created: Long = Instant.now().epochSecond

    constructor() {
    }

    constructor(message: String?) {
        this.message = message
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun getCreated(): Long {
        return created
    }

    fun setCreated(created: Long) {
        this.created = created
    }
}