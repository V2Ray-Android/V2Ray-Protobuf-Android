package com.v2ray.android.protobuf.dsl

import com.v2ray.android.protobuf.dsl.app.receiverConfig
import com.v2ray.android.protobuf.dsl.proxy.dokodemoConfig
import com.v2ray.android.protobuf.dsl.proxy.httpServerConfig
import com.v2ray.android.protobuf.dsl.proxy.shadowsocksServerConfig
import com.v2ray.android.protobuf.dsl.proxy.socksServerConfig
import com.v2ray.android.protobuf.dsl.proxy.vmess.vmessServerConfig
import com.v2ray.android.protobuf.extention.toTypedMessage
import com.v2ray.core.InboundHandlerConfig
import com.v2ray.core.app.proxyman.ReceiverConfig

fun InboundHandlerConfig.Builder.receiver(init: ReceiverConfig.Builder.() -> Unit) {
    receiverSettings = receiverConfig(init).toTypedMessage()
}

fun InboundHandlerConfig.Builder.http(init: com.v2ray.core.proxy.http.ServerConfig.Builder.() -> Unit) {
    proxySettings = httpServerConfig(init).toTypedMessage()
}

fun InboundHandlerConfig.Builder.socks(init: com.v2ray.core.proxy.socks.ServerConfig.Builder.() -> Unit) {
    proxySettings = socksServerConfig(init).toTypedMessage()
}

fun InboundHandlerConfig.Builder.vmess(init: com.v2ray.core.proxy.vmess.inbound.Config.Builder.() -> Unit) {
    proxySettings = vmessServerConfig(init).toTypedMessage()
}

fun InboundHandlerConfig.Builder.shadowsocks(init: com.v2ray.core.proxy.shadowsocks.ServerConfig.Builder.() -> Unit) {
    proxySettings = shadowsocksServerConfig(init).toTypedMessage()
}

fun InboundHandlerConfig.Builder.dokodemo(init: com.v2ray.core.proxy.dokodemo.Config.Builder.() -> Unit) {
    proxySettings = dokodemoConfig(init).toTypedMessage()
}