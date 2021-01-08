package tw.com.bruce.rsocket.persist.entity

import javax.persistence.*

@Entity
@Table(name = "demo_member")
data class DemoMemberEntity(
        /** member id. */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long = 0,
        /** member name. */
        @Column
        val name: String = "",
        /** member email. */
        @Column
        val email: String = ""
)
