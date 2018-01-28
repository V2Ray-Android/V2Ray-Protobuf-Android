package com.v2ray.android.protobuf.dsl.proxy

import com.v2ray.android.protobuf.extention.messageName
import com.v2ray.android.protobuf.extention.toTypedMessage
import com.v2ray.core.proxy.blackhole.Config
import com.v2ray.core.proxy.blackhole.HTTPResponse
import com.v2ray.core.proxy.blackhole.NoneResponse

fun blackholeConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

enum class ResponseType {
    NONE,
    HTTP
}

var Config.Builder.responseType: ResponseType
    get() = if (response.messageName == HTTPResponse.getDefaultInstance().messageName) ResponseType.HTTP
    else ResponseType.NONE
    set(value) = when (value) {
        ResponseType.HTTP -> response = HTTPResponse.getDefaultInstance().toTypedMessage()
        ResponseType.NONE -> response = NoneResponse.getDefaultInstance().toTypedMessage()
    }
