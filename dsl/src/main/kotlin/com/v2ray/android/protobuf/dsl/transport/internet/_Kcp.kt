package com.v2ray.android.protobuf.dsl.transport.internet

import com.v2ray.android.protobuf.dsl.transport.internet.headers.srtpConfig
import com.v2ray.android.protobuf.dsl.transport.internet.headers.utpConfig
import com.v2ray.android.protobuf.dsl.transport.internet.headers.wechatVideoConfig
import com.v2ray.android.protobuf.extention.toTypedMessage
import com.v2ray.core.transport.internet.kcp.*

fun kcpConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()


fun mtu(init: MTU.Builder.() -> Unit): MTU = MTU.newBuilder().apply(init).build()

fun Config.Builder.mtu(init: MTU.Builder.() -> Unit) {
    mtu = com.v2ray.android.protobuf.dsl.transport.internet.mtu(init)
}

var Config.Builder.mtuValue: Int
    get() = mtu.value
    set(value) = mtu { setValue(value) }


fun tti(init: TTI.Builder.() -> Unit): TTI = TTI.newBuilder().apply(init).build()

fun Config.Builder.tti(init: TTI.Builder.() -> Unit) {
    tti = com.v2ray.android.protobuf.dsl.transport.internet.tti(init)
}

var Config.Builder.ttiValue: Int
    get() = tti.value
    set(value) = tti { setValue(value) }


fun uplinkCapacity(init: UplinkCapacity.Builder.() -> Unit): UplinkCapacity = UplinkCapacity.newBuilder().apply(init).build()

fun Config.Builder.uplinkCapacity(init: UplinkCapacity.Builder.() -> Unit) {
    uplinkCapacity = com.v2ray.android.protobuf.dsl.transport.internet.uplinkCapacity(init)
}

var Config.Builder.uplinkCapacityValue: Int
    get() = uplinkCapacity.value
    set(value) = uplinkCapacity { setValue(value) }


fun downlinkCapacity(init: DownlinkCapacity.Builder.() -> Unit): DownlinkCapacity = DownlinkCapacity.newBuilder().apply(init).build()

fun Config.Builder.downlinkCapacity(init: DownlinkCapacity.Builder.() -> Unit) {
    downlinkCapacity = com.v2ray.android.protobuf.dsl.transport.internet.downlinkCapacity(init)
}

var Config.Builder.downlinkCapacityValue: Int
    get() = downlinkCapacity.value
    set(value) = downlinkCapacity { setValue(value) }


fun writeBuffer(init: WriteBuffer.Builder.() -> Unit): WriteBuffer = WriteBuffer.newBuilder().apply(init).build()

fun Config.Builder.writeBuffer(init: WriteBuffer.Builder.() -> Unit) {
    writeBuffer = com.v2ray.android.protobuf.dsl.transport.internet.writeBuffer(init)
}


fun readBuffer(init: ReadBuffer.Builder.() -> Unit): ReadBuffer = ReadBuffer.newBuilder().apply(init).build()

fun Config.Builder.readBuffer(init: ReadBuffer.Builder.() -> Unit) {
    readBuffer = com.v2ray.android.protobuf.dsl.transport.internet.readBuffer(init)
}


fun Config.Builder.utpHeader(init: com.v2ray.core.transport.internet.headers.utp.Config.Builder.() -> Unit) {
    headerConfig = utpConfig(init).toTypedMessage()
}


fun Config.Builder.wechatVideoHeader(init: com.v2ray.core.transport.internet.headers.wechat.VideoConfig.Builder.() -> Unit) {
    headerConfig = wechatVideoConfig(init).toTypedMessage()
}


fun Config.Builder.srtpHeader(init: com.v2ray.core.transport.internet.headers.srtp.Config.Builder.() -> Unit) {
    headerConfig = srtpConfig(init).toTypedMessage()
}
