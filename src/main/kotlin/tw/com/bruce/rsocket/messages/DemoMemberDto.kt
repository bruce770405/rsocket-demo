package tw.com.bruce.rsocket.messages

data class DemoMemberDto(
        /** id. */
        val id: Long,
        /** name. */
        val name: String,
        /** email. */
        val email: String?
)