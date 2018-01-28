package com.v2ray.android.protobuf.dsl.transport.internet.headers

import com.v2ray.core.transport.internet.headers.http.*

fun httpConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun requestConfig(init: RequestConfig.Builder.() -> Unit): RequestConfig = RequestConfig.newBuilder().apply(init).build()

fun Config.Builder.request(init: RequestConfig.Builder.() -> Unit) {
    request = requestConfig(init)
}

fun responseConfig(init: ResponseConfig.Builder.() -> Unit): ResponseConfig = ResponseConfig.newBuilder().apply(init).build()

fun Config.Builder.response(init: ResponseConfig.Builder.() -> Unit) {
    response = responseConfig(init)
}

fun version(init: Version.Builder.() -> Unit): Version = Version.newBuilder().apply(init).build()

fun RequestConfig.Builder.version(init: Version.Builder.() -> Unit) {
    version = com.v2ray.android.protobuf.dsl.transport.internet.headers.version(init)
}

fun ResponseConfig.Builder.version(init: Version.Builder.() -> Unit) {
    version = com.v2ray.android.protobuf.dsl.transport.internet.headers.version(init)
}

var RequestConfig.Builder.versionValue: String
    get() = version.value
    set(value) = version { setValue(value) }

var ResponseConfig.Builder.versionValue: String
    get() = version.value
    set(value) = version { setValue(value) }

fun method(init: Method.Builder.() -> Unit): Method = Method.newBuilder().apply(init).build()

fun RequestConfig.Builder.method(init: Method.Builder.() -> Unit) {
    method = com.v2ray.android.protobuf.dsl.transport.internet.headers.method(init)
}

var RequestConfig.Builder.methodValue: String
    get() = method.value
    set(value) = method { setValue(value) }

fun header(init: Header.Builder.() -> Unit): Header = Header.newBuilder().apply(init).build()

fun RequestConfig.Builder.addHeader(init: Header.Builder.() -> Unit) {
    addHeader(header(init))
}

fun ResponseConfig.Builder.addHeader(init: Header.Builder.() -> Unit) {
    addHeader(header(init))
}

fun header(name: String, vararg value: String): Header = header {
    this.name = name
    value.forEach { addValue(it) }
}

fun RequestConfig.Builder.addHeader(name: String, vararg value: String) {
    addHeader(header(name, *value))
}

fun ResponseConfig.Builder.addHeader(name: String, vararg value: String) {
    addHeader(header(name, *value))
}

fun status(init: Status.Builder.() -> Unit): Status = Status.newBuilder().apply(init).build()

fun ResponseConfig.Builder.status(init: Status.Builder.() -> Unit) {
    status = com.v2ray.android.protobuf.dsl.transport.internet.headers.status(init)
}

fun status(code: String, reason: String): Status = status {
    this.code = code
    this.reason = reason
}

fun ResponseConfig.Builder.status(code: String, reason: String) {
    status = com.v2ray.android.protobuf.dsl.transport.internet.headers.status(code, reason)
}
