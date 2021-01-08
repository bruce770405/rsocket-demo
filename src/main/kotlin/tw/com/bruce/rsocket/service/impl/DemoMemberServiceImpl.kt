package tw.com.bruce.rsocket.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tw.com.bruce.rsocket.messages.DemoMemberDto
import tw.com.bruce.rsocket.persist.entity.DemoMemberEntity
import tw.com.bruce.rsocket.persist.repository.DemoMemberRepository
import tw.com.bruce.rsocket.service.DemoMemberService

@Service
class DemoMemberServiceImpl(@Autowired var demoMemberRepository: DemoMemberRepository) : DemoMemberService {

    override fun getAllDemoMembers(): Mono<List<DemoMemberDto>> {
        return Mono.defer {
            Flux.fromIterable(demoMemberRepository.findAll())
                    .map { t: DemoMemberEntity? -> DemoMemberDto(t!!.id, t.name, t.email) }.collectList()
        }
    }
}