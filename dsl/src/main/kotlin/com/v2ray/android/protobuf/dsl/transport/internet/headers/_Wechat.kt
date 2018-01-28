package com.v2ray.android.protobuf.dsl.transport.internet.headers

import com.v2ray.core.transport.internet.headers.wechat.VideoConfig

fun wechatVideoConfig(init: VideoConfig.Builder.() -> Unit): VideoConfig = VideoConfig.newBuilder().apply(init).build()
