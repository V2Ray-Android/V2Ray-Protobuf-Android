package com.v2ray.android.protobuf.dsl.transport.internet

import com.v2ray.android.protobuf.dsl.transport.internet.headers.httpConfig
import com.v2ray.android.protobuf.extention.toTypedMessage
import com.v2ray.core.transport.internet.tcp.Config

fun tcpConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun Config.Builder.httpHeader(init: com.v2ray.core.transport.internet.headers.http.Config.Builder.() -> Unit) {
    headerSettings = httpConfig(init).toTypedMessage()
}
