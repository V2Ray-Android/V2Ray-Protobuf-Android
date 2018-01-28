package com.v2ray.android.protobuf.dsl.common.net

import com.google.protobuf.ByteString
import com.v2ray.core.common.net.IPOrDomain
import java.net.InetAddress

fun iPOrDomain(init: IPOrDomain.Builder.() -> Unit): IPOrDomain = IPOrDomain.newBuilder().apply(init).build()

fun ip(ip: ByteArray): IPOrDomain = iPOrDomain { setIp(ByteString.copyFrom(ip)) }

fun ip(ip: String): IPOrDomain = ip(InetAddress.getByName(ip).address)

fun domain(domain: String): IPOrDomain = iPOrDomain { setDomain(domain) }