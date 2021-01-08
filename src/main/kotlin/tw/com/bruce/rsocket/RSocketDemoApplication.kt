package tw.com.bruce.rsocket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RSocketDemoApplication

fun main(args: Array<String>) {
    runApplication<RSocketDemoApplication>(*args)
}
