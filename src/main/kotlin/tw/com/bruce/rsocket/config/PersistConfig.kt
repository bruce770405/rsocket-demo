package tw.com.bruce.rsocket.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionTemplate

@Configuration
class PersistConfig
    @Bean
    fun transactionTemplate(transactionManager: PlatformTransactionManager?): TransactionTemplate? {
        return TransactionTemplate(transactionManager!!)
    }
