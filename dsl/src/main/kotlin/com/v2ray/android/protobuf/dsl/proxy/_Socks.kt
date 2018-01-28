package com.v2ray.android.protobuf.dsl.proxy

import com.v2ray.android.protobuf.dsl.common.net.iPOrDomain
import com.v2ray.android.protobuf.dsl.common.protocol.serverEndpoint
import com.v2ray.core.common.net.IPOrDomain
import com.v2ray.core.common.protocol.ServerEndpoint
import com.v2ray.core.proxy.socks.Account
import com.v2ray.core.proxy.socks.ClientConfig
import com.v2ray.core.proxy.socks.ServerConfig

fun socksServerConfig(init: ServerConfig.Builder.() -> Unit): ServerConfig = ServerConfig.newBuilder().apply(init).build()

fun socksClientConfig(init: ClientConfig.Builder.() -> Unit): ClientConfig = ClientConfig.newBuilder().apply(init).build()

fun ServerConfig.Builder.address(init: IPOrDomain.Builder.() -> Unit) {
    address = iPOrDomain(init)
}

fun ClientConfig.Builder.addServer(init: ServerEndpoint.Builder.() -> Unit) {
    addServer(serverEndpoint(init))
}

fun socksAccount(init: Account.Builder.() -> Unit): Account = Account.newBuilder().apply(init).build()

fun socksAccount(user: String, pass: String): Account = socksAccount {
    username = user
    password = pass
}
