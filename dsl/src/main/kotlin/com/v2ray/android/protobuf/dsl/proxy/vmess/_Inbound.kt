package com.v2ray.android.protobuf.dsl.proxy.vmess

import com.v2ray.android.protobuf.dsl.common.protocol.user
import com.v2ray.core.common.protocol.User
import com.v2ray.core.proxy.vmess.inbound.Config
import com.v2ray.core.proxy.vmess.inbound.DefaultConfig
import com.v2ray.core.proxy.vmess.inbound.DetourConfig

fun vmessServerConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun Config.Builder.addUser(init: User.Builder.() -> Unit) {
    addUser(user(init))
}

fun detour(init: DetourConfig.Builder.() -> Unit) = DetourConfig.newBuilder().apply(init).build()

fun Config.Builder.detour(init: DetourConfig.Builder.() -> Unit) {
    detour = com.v2ray.android.protobuf.dsl.proxy.vmess.detour(init)
}

fun default(init: DefaultConfig.Builder.() -> Unit) = DefaultConfig.newBuilder().apply(init).build()

fun Config.Builder.default(init: DefaultConfig.Builder.() -> Unit) {
    default = com.v2ray.android.protobuf.dsl.proxy.vmess.default(init)
}
