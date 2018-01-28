package com.v2ray.android.protobuf.dsl

import com.v2ray.android.protobuf.dsl.app.dnsConfig
import com.v2ray.android.protobuf.dsl.app.logConfig
import com.v2ray.android.protobuf.dsl.app.routerConfig
import com.v2ray.android.protobuf.extention.toTypedMessage
import com.v2ray.core.Config
import com.v2ray.core.InboundHandlerConfig
import com.v2ray.core.OutboundHandlerConfig

fun config(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun inboundHandlerConfig(init: InboundHandlerConfig.Builder.() -> Unit): InboundHandlerConfig = InboundHandlerConfig.newBuilder().apply(init).build()

fun Config.Builder.addInbound(init: InboundHandlerConfig.Builder.() -> Unit) {
    addInbound(inboundHandlerConfig(init))
}

fun outboundHandlerConfig(init: OutboundHandlerConfig.Builder.() -> Unit): OutboundHandlerConfig = OutboundHandlerConfig.newBuilder().apply(init).build()

fun Config.Builder.addOutbound(init: OutboundHandlerConfig.Builder.() -> Unit) {
    addOutbound(outboundHandlerConfig(init))
}

fun Config.Builder.log(init: com.v2ray.core.app.log.Config.Builder.() -> Unit) {
    addApp(logConfig(init).toTypedMessage())
}

fun Config.Builder.dns(init: com.v2ray.core.app.dns.Config.Builder.() -> Unit) {
    addApp(dnsConfig(init).toTypedMessage())
}

fun Config.Builder.router(init: com.v2ray.core.app.router.Config.Builder.() -> Unit) {
    addApp(routerConfig(init).toTypedMessage())
}

fun Config.Builder.transport(init: com.v2ray.core.transport.Config.Builder.() -> Unit) {
    transport = transportConfig(init)
}
