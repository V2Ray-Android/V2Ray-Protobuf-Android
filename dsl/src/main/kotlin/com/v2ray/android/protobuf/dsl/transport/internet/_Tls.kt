package com.v2ray.android.protobuf.dsl.transport.internet

import com.v2ray.core.transport.internet.tls.Certificate
import com.v2ray.core.transport.internet.tls.Config

fun tlsConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()


fun certificateConfig(init: Certificate.Builder.() -> Unit): Certificate = Certificate.newBuilder().apply(init).build()

fun Config.Builder.addCertificate(init: Certificate.Builder.() -> Unit) {
    addCertificate(certificateConfig(init))
}
