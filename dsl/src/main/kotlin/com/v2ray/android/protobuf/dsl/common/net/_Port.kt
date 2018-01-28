package com.v2ray.android.protobuf.dsl.common.net

import com.v2ray.core.common.net.PortRange

fun portRange(init: PortRange.Builder.() -> Unit): PortRange = PortRange.newBuilder().apply(init).build()

fun portRange(from: Int, to: Int = from): PortRange = portRange {
    setFrom(from)
    setTo(to)
}