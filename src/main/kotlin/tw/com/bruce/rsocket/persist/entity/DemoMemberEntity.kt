package tw.com.bruce.rsocket.persist.entity

import javax.persistence.*

@Entity
@Table(name = "demo_member")
data class DemoMemberEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long = 0,
        @Column
        val name: String = "",
        @Column
        val email: String = ""
)
