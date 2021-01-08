package tw.com.bruce.rsocket.persist.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import tw.com.bruce.rsocket.persist.entity.DemoMemberEntity

@Repository
interface DemoMemberRepository : CrudRepository<DemoMemberEntity, Long> {
}