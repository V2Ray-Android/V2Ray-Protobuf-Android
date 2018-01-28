package com.v2ray.android.protobuf.dsl.transport.internet.headers

import com.v2ray.core.transport.internet.headers.utp.Config

fun utpConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()
