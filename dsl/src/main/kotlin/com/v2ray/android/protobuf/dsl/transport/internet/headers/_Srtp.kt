package com.v2ray.android.protobuf.dsl.transport.internet.headers

import com.v2ray.core.transport.internet.headers.srtp.Config

fun srtpConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()
