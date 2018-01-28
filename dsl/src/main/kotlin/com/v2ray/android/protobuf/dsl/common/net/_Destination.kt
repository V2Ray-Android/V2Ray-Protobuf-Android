package com.v2ray.android.protobuf.dsl.common.net

import com.v2ray.core.common.net.Endpoint
import com.v2ray.core.common.net.IPOrDomain
import com.v2ray.core.common.net.Network

fun endpoint(init: Endpoint.Builder.() -> Unit): Endpoint = Endpoint.newBuilder().apply(init).build()

fun endpoint(network: Network, address: IPOrDomain, port: Int): Endpoint = endpoint {
    setNetwork(network)
    setAddress(address)
    setPort(port)
}
