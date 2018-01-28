package com.v2ray.android.protobuf.dsl.transport

import com.v2ray.android.protobuf.dsl.transport.internet.kcpConfig
import com.v2ray.android.protobuf.dsl.transport.internet.tcpConfig
import com.v2ray.android.protobuf.dsl.transport.internet.tlsConfig
import com.v2ray.android.protobuf.dsl.transport.internet.websocketConfig
import com.v2ray.android.protobuf.extention.toTypedMessage
import com.v2ray.core.transport.internet.ProxyConfig
import com.v2ray.core.transport.internet.StreamConfig
import com.v2ray.core.transport.internet.TransportConfig

fun streamConfig(init: StreamConfig.Builder.() -> Unit): StreamConfig = StreamConfig.newBuilder().apply(init).build()

fun transportConfig(init: TransportConfig.Builder.() -> Unit): TransportConfig = TransportConfig.newBuilder().apply(init).build()

fun StreamConfig.Builder.addTransportSettings(init: TransportConfig.Builder.() -> Unit) {
    addTransportSettings(transportConfig(init))
}

fun StreamConfig.Builder.addTlsSettings(init: com.v2ray.core.transport.internet.tls.Config.Builder.() -> Unit) {
    addSecuritySettings(tlsConfig(init).toTypedMessage())
}

fun TransportConfig.Builder.tcpSettings(init: com.v2ray.core.transport.internet.tcp.Config.Builder.() -> Unit) {
    settings = tcpConfig(init).toTypedMessage()
}

fun TransportConfig.Builder.kcpSettings(init: com.v2ray.core.transport.internet.kcp.Config.Builder.() -> Unit) {
    settings = kcpConfig(init).toTypedMessage()
}

fun TransportConfig.Builder.websocketSettings(init: com.v2ray.core.transport.internet.websocket.Config.Builder.() -> Unit) {
    settings = websocketConfig(init).toTypedMessage()
}

fun proxyConfig(init: ProxyConfig.Builder.() -> Unit): ProxyConfig = ProxyConfig.newBuilder().apply(init).build()
