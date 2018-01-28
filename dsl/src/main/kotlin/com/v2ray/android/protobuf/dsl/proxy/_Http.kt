package com.v2ray.android.protobuf.dsl.proxy

import com.v2ray.core.proxy.http.ServerConfig

fun httpServerConfig(init: ServerConfig.Builder.() -> Unit): ServerConfig = ServerConfig.newBuilder().apply(init).build()
