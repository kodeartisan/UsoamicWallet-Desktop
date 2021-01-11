package io.usoamic.wallet.domain.models.withdraw

import io.usoamic.usoamickt.enumcls.TxSpeed
import java.math.BigDecimal
@Deprecated("Move to separate library")
data class WithdrawData(
    val password: String,
    val to: String,
    val value: BigDecimal,
    val txSpeed: TxSpeed
)

enum class WithdrawCoin {
    ETH,
    USO
}