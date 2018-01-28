package com.v2ray.android.protobuf.dsl.proxy

import com.v2ray.core.common.protocol.ServerEndpoint
import com.v2ray.core.proxy.freedom.Config
import com.v2ray.core.proxy.freedom.DestinationOverride

fun freedomConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun destinationOverride(init: DestinationOverride.Builder.() -> Unit): DestinationOverride = DestinationOverride.newBuilder().apply(init).build()

fun Config.Builder.destinationOverride(init: DestinationOverride.Builder.() -> Unit) {
    destinationOverride = com.v2ray.android.protobuf.dsl.proxy.destinationOverride(init)
}

var Config.Builder.destinationOverrideServer: ServerEndpoint
    get() = destinationOverride.server
    set(value) = destinationOverride { server = value }
