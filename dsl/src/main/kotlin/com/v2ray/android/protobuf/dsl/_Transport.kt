package com.v2ray.android.protobuf.dsl

import com.v2ray.core.transport.Config
import com.v2ray.core.transport.internet.TransportConfig

fun transportConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun Config.Builder.addTransportSettings(init: TransportConfig.Builder.() -> Unit) {
    addTransportSettings(com.v2ray.android.protobuf.dsl.transport.transportConfig(init))
}
