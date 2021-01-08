package tw.com.bruce.rsocket.service

import reactor.core.publisher.Mono
import tw.com.bruce.rsocket.messages.DemoMemberDto

interface DemoMemberService {
    fun getAllDemoMembers(): Mono<List<DemoMemberDto>>
}