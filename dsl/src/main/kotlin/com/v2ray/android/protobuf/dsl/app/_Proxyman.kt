package com.v2ray.android.protobuf.dsl.app

import com.v2ray.android.protobuf.dsl.common.net.iPOrDomain
import com.v2ray.android.protobuf.dsl.transport.proxyConfig
import com.v2ray.android.protobuf.dsl.transport.streamConfig
import com.v2ray.core.app.proxyman.AllocationStrategy
import com.v2ray.core.app.proxyman.MultiplexingConfig
import com.v2ray.core.app.proxyman.ReceiverConfig
import com.v2ray.core.app.proxyman.SenderConfig
import com.v2ray.core.common.net.IPOrDomain
import com.v2ray.core.common.net.PortRange
import com.v2ray.core.transport.internet.ProxyConfig
import com.v2ray.core.transport.internet.StreamConfig

fun receiverConfig(init: ReceiverConfig.Builder.() -> Unit): ReceiverConfig = ReceiverConfig.newBuilder().apply(init).build()

fun ReceiverConfig.Builder.portRange(init: PortRange.Builder.() -> Unit) {
    portRange = com.v2ray.android.protobuf.dsl.common.net.portRange(init)
}

fun ReceiverConfig.Builder.portRange(from: Int, to: Int = from) {
    portRange = com.v2ray.android.protobuf.dsl.common.net.portRange(from, to)
}

fun ReceiverConfig.Builder.listen(init: IPOrDomain.Builder.() -> Unit) {
    listen = iPOrDomain(init)
}

fun allocationStrategy(init: AllocationStrategy.Builder.() -> Unit): AllocationStrategy = AllocationStrategy.newBuilder().apply(init).build()

fun ReceiverConfig.Builder.allocationStrategy(init: AllocationStrategy.Builder.() -> Unit) {
    allocationStrategy = com.v2ray.android.protobuf.dsl.app.allocationStrategy(init)
}

fun ReceiverConfig.Builder.streamSettings(init: StreamConfig.Builder.() -> Unit) {
    streamSettings = streamConfig(init)
}

fun senderConfig(init: SenderConfig.Builder.() -> Unit): SenderConfig = SenderConfig.newBuilder().apply(init).build()

fun SenderConfig.Builder.via(init: IPOrDomain.Builder.() -> Unit) {
    via = iPOrDomain(init)
}

fun SenderConfig.Builder.streamSettings(init: StreamConfig.Builder.() -> Unit) {
    streamSettings = streamConfig(init)
}

fun SenderConfig.Builder.proxySettings(init: ProxyConfig.Builder.() -> Unit) {
    proxySettings = proxyConfig(init)
}

fun multiplexingConfig(init: MultiplexingConfig.Builder.() -> Unit): MultiplexingConfig = MultiplexingConfig.newBuilder().apply(init).build()

fun SenderConfig.Builder.multiplexSettings(init: MultiplexingConfig.Builder.() -> Unit) {
    multiplexSettings = multiplexingConfig(init)
}
