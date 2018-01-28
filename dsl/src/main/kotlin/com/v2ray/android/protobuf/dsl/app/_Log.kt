package com.v2ray.android.protobuf.dsl.app

import com.v2ray.core.app.log.Config

fun logConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()
