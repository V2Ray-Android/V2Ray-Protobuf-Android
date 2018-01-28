package com.v2ray.android.protobuf.dsl.transport.internet

import com.v2ray.core.transport.internet.websocket.Config
import com.v2ray.core.transport.internet.websocket.Header

fun websocketConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun header(init: Header.Builder.() -> Unit): Header = Header.newBuilder().apply(init).build()

fun header(key: String, value: String) = header {
    setKey(key)
    setValue(value)
}

fun Config.Builder.addheader(key: String, value: String) {
    addHeader(header(key, value))
}
