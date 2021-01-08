package tw.com.bruce.rsocket.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono
import tw.com.bruce.rsocket.messages.DemoMemberDto
import tw.com.bruce.rsocket.messages.DemoMessage
import tw.com.bruce.rsocket.service.DemoMemberService

@Controller
class DemoController(@Autowired var demoMemberService: DemoMemberService) {

    @MessageMapping("request-response")
    fun requestResponse(requestMessage: DemoMessage): Mono<DemoMessage> {
        return Mono.defer { Mono.just(DemoMessage("hello , you said :" + requestMessage.getMessage())) }
    }

    @MessageMapping("get-all-members")
    fun getAllDemoMembers(): Mono<List<DemoMemberDto>> {
        return demoMemberService.getAllDemoMembers()
    }
}
