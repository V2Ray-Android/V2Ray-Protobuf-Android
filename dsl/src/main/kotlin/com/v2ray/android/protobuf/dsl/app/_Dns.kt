package com.v2ray.android.protobuf.dsl.app

import com.v2ray.android.protobuf.dsl.common.net.endpoint
import com.v2ray.core.app.dns.Config
import com.v2ray.core.common.net.IPOrDomain
import com.v2ray.core.common.net.Network

fun dnsConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun Config.Builder.addNameServers(address: IPOrDomain, port: Int = 53, network: Network = Network.UDP) {
    addNameServers(endpoint(network, address, port))
}
