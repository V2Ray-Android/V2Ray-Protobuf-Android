package com.v2ray.android.protobuf.dsl.proxy

import com.v2ray.android.protobuf.dsl.common.protocol.serverEndpoint
import com.v2ray.core.common.protocol.ServerEndpoint
import com.v2ray.core.common.protocol.User
import com.v2ray.core.proxy.shadowsocks.Account
import com.v2ray.core.proxy.shadowsocks.ClientConfig
import com.v2ray.core.proxy.shadowsocks.ServerConfig

fun shadowsocksServerConfig(init: ServerConfig.Builder.() -> Unit): ServerConfig = ServerConfig.newBuilder().apply(init).build()

fun shadowsocksClientConfig(init: ClientConfig.Builder.() -> Unit): ClientConfig = ClientConfig.newBuilder().apply(init).build()

fun shadowsocksAccount(init: Account.Builder.() -> Unit): Account = Account.newBuilder().apply(init).build()

fun ServerConfig.Builder.user(init: User.Builder.() -> Unit) {
    user = com.v2ray.android.protobuf.dsl.common.protocol.user(init)
}

fun ClientConfig.Builder.addServer(init: ServerEndpoint.Builder.() -> Unit) {
    addServer(serverEndpoint(init))
}
