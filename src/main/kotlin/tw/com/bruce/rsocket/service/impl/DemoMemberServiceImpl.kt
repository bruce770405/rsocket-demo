package tw.com.bruce.rsocket.service.impl

import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tw.com.bruce.rsocket.messages.DemoMemberDto
import tw.com.bruce.rsocket.persist.entity.DemoMemberEntity
import tw.com.bruce.rsocket.persist.repository.DemoMemberRepository
import tw.com.bruce.rsocket.service.DemoMemberService
import java.lang.Exception
import java.util.*

@Service
class DemoMemberServiceImpl(@Autowired var demoMemberRepository: DemoMemberRepository) : DemoMemberService {

    override fun getAllDemoMembers(): Flux<DemoMemberDto> {
        return Flux
            .fromIterable(demoMemberRepository.findAll())
            .map { t: DemoMemberEntity? -> DemoMemberDto(t!!.id, t.name, t.email) }
    }

    override fun getDemoMember(id: Long): Mono<DemoMemberDto> {
        return Mono.defer {
            Mono.just(demoMemberRepository.findById(id))
                .map { t: Optional<DemoMemberEntity> -> t.get() }
                .map { t: DemoMemberEntity -> DemoMemberDto(t.id, t.name, t.email) }
                .doOnError { Mono.just(NotFoundException("id :$id is not exist")) }
        }
    }
}