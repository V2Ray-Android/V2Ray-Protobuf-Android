package com.v2ray.android.protobuf.extention

import com.google.protobuf.MessageLite
import com.v2ray.core.common.serial.TypedMessage

fun MessageLite.toTypedMessage(): TypedMessage {
    return TypedMessage.newBuilder().apply {
        type = this@toTypedMessage.messageName
        value = this@toTypedMessage.toByteString()
    }.build()
}

val MessageLite.messageName: String
    get() {
        val javaName = this::class.java.name
        return if (javaName.startsWith("com.v2ray.core"))
            javaName.removePrefix("com.")
        else
            javaName
    }
