package tw.com.bruce.rsocket.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tw.com.bruce.rsocket.messages.DemoMemberDto
import tw.com.bruce.rsocket.messages.DemoMessageDto
import tw.com.bruce.rsocket.service.DemoMemberService

@Controller
class DemoController(@Autowired val demoMemberService: DemoMemberService) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @MessageMapping("request-response")
    fun requestResponse(requestMessageDto: DemoMessageDto): Mono<DemoMessageDto> {
        return Mono.defer { Mono.just(DemoMessageDto("hello , you said :" + requestMessageDto.getMessage())) }
    }

    @MessageMapping("stream-get-all-members")
    fun getAllDemoMembers(): Flux<DemoMemberDto> {
        return demoMemberService.getAllDemoMembers()
    }

    @MessageMapping("channel-get-member-by-id")
    fun getDemoMemberById(fluxIds: Flux<Long>): Flux<DemoMemberDto> {
        return fluxIds.flatMap { id: Long -> demoMemberService.getDemoMember(id) }
    }

    @MessageMapping("fire-forget-log-health")
    fun registerClientHealth(clientId: String): Mono<Void> {
        logger.info(clientId)
        return Mono.empty()
    }
}
