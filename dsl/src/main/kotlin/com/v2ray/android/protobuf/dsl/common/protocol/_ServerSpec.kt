package com.v2ray.android.protobuf.dsl.common.protocol

import com.v2ray.android.protobuf.dsl.common.net.iPOrDomain
import com.v2ray.core.common.net.IPOrDomain
import com.v2ray.core.common.protocol.ServerEndpoint
import com.v2ray.core.common.protocol.User

fun serverEndpoint(init: ServerEndpoint.Builder.() -> Unit): ServerEndpoint = ServerEndpoint.newBuilder().apply(init).build()

fun serverEndpoint(address: IPOrDomain, port: Int, init: (User.Builder.() -> Unit)? = null): ServerEndpoint = serverEndpoint {
    setAddress(address)
    setPort(port)
    if (init != null) addUser(init)
}

fun ServerEndpoint.Builder.address(init: IPOrDomain.Builder.() -> Unit) {
    address = iPOrDomain(init)
}

fun ServerEndpoint.Builder.addUser(init: User.Builder.() -> Unit) {
    addUser(user(init))
}
