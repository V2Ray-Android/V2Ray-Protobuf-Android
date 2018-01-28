package com.v2ray.android.protobuf.dsl

import com.v2ray.android.protobuf.dsl.app.senderConfig
import com.v2ray.android.protobuf.dsl.proxy.blackholeConfig
import com.v2ray.android.protobuf.dsl.proxy.freedomConfig
import com.v2ray.android.protobuf.dsl.proxy.shadowsocksClientConfig
import com.v2ray.android.protobuf.dsl.proxy.socksClientConfig
import com.v2ray.android.protobuf.dsl.proxy.vmess.vmessClientConfig
import com.v2ray.android.protobuf.extention.toTypedMessage
import com.v2ray.core.OutboundHandlerConfig
import com.v2ray.core.app.proxyman.SenderConfig

fun OutboundHandlerConfig.Builder.sender(init: SenderConfig.Builder.() -> Unit) {
    senderSettings = senderConfig(init).toTypedMessage()
}

fun OutboundHandlerConfig.Builder.blackhole(init: com.v2ray.core.proxy.blackhole.Config.Builder.() -> Unit) {
    proxySettings = blackholeConfig(init).toTypedMessage()
}

fun OutboundHandlerConfig.Builder.freedom(init: com.v2ray.core.proxy.freedom.Config.Builder.() -> Unit) {
    proxySettings = freedomConfig(init).toTypedMessage()
}

fun OutboundHandlerConfig.Builder.shadowsocks(init: com.v2ray.core.proxy.shadowsocks.ClientConfig.Builder.() -> Unit) {
    proxySettings = shadowsocksClientConfig(init).toTypedMessage()
}

fun OutboundHandlerConfig.Builder.socks(init: com.v2ray.core.proxy.socks.ClientConfig.Builder.() -> Unit) {
    proxySettings = socksClientConfig(init).toTypedMessage()
}

fun OutboundHandlerConfig.Builder.vmess(init: com.v2ray.core.proxy.vmess.outbound.Config.Builder.() -> Unit) {
    proxySettings = vmessClientConfig(init).toTypedMessage()
}
