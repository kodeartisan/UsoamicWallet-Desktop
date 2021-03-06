package io.usoamic.wallet.ui.main.dashboard

import java.math.BigDecimal
import java.math.BigInteger

sealed class DashboardItem {
    data class EthBalance(val data: BigDecimal) : DashboardItem()
    data class UsoBalance(val data: BigDecimal) : DashboardItem()
    data class Height(val data: BigInteger) : DashboardItem()
    data class Supply(val data: BigDecimal) : DashboardItem()
}