package com.v2ray.android.protobuf.dsl.proxy.vmess

import com.v2ray.android.protobuf.dsl.common.protocol.serverEndpoint
import com.v2ray.core.common.protocol.ServerEndpoint
import com.v2ray.core.proxy.vmess.outbound.Config

fun vmessClientConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun Config.Builder.addReceiver(init: ServerEndpoint.Builder.() -> Unit) {
    addReceiver(serverEndpoint(init))
}