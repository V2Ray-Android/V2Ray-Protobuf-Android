package com.v2ray.android.protobuf.dsl.proxy.vmess

import com.v2ray.core.common.protocol.SecurityConfig
import com.v2ray.core.common.protocol.SecurityType
import com.v2ray.core.proxy.vmess.Account

fun vmesssAccount(init: Account.Builder.() -> Unit) = Account.newBuilder().apply(init).build()

fun security(init: SecurityConfig.Builder.() -> Unit): SecurityConfig = SecurityConfig.newBuilder().apply(init).build()

fun Account.Builder.security(init: SecurityConfig.Builder.() -> Unit) {
    securitySettings = com.v2ray.android.protobuf.dsl.proxy.vmess.security(init)
}

fun security(type: SecurityType): SecurityConfig = security { setType(type) }

var Account.Builder.securityType: SecurityType
    get() = securitySettings.type
    set(value) = security { type = value }