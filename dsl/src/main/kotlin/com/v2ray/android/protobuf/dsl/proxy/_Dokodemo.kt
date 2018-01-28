package com.v2ray.android.protobuf.dsl.proxy

import com.v2ray.android.protobuf.dsl.common.net.iPOrDomain
import com.v2ray.core.common.net.IPOrDomain
import com.v2ray.core.common.net.Network
import com.v2ray.core.proxy.dokodemo.Config

fun dokodemoConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun Config.Builder.address(init: IPOrDomain.Builder.() -> Unit) {
    address = iPOrDomain(init)
}

fun Config.Builder.networkList(vararg network: Network) {
    networkList = com.v2ray.android.protobuf.dsl.common.net.networkList(*network)
}
