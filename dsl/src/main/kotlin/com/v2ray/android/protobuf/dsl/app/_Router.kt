package com.v2ray.android.protobuf.dsl.app

import com.google.protobuf.ByteString
import com.v2ray.core.app.router.CIDR
import com.v2ray.core.app.router.Config
import com.v2ray.core.app.router.Domain
import com.v2ray.core.app.router.RoutingRule
import com.v2ray.core.common.net.Network
import com.v2ray.core.common.net.NetworkList

fun routerConfig(init: Config.Builder.() -> Unit): Config = Config.newBuilder().apply(init).build()

fun routingRule(init: RoutingRule.Builder.() -> Unit): RoutingRule = RoutingRule.newBuilder().apply(init).build()

fun Config.Builder.addRule(init: RoutingRule.Builder.() -> Unit) {
    addRule(routingRule(init))
}


fun domain(init: Domain.Builder.() -> Unit): Domain = Domain.newBuilder().apply(init).build()

fun domain(domain: String, type: Domain.Type) = domain {
    setType(type)
    value = domain
}

fun RoutingRule.Builder.addDomain(init: Domain.Builder.() -> Unit) {
    addDomain(domain(init))
}

fun RoutingRule.Builder.addDomain(domain: String, type: Domain.Type = Domain.Type.Plain) {
    addDomain(domain(domain, type))
}


fun cidr(init: CIDR.Builder.() -> Unit): CIDR = CIDR.newBuilder().apply(init).build()

fun cidr(ip: ByteArray, prefix: Int) = cidr {
    setIp(ByteString.copyFrom(ip))
    setPrefix(prefix)
}

fun RoutingRule.Builder.addCidr(init: CIDR.Builder.() -> Unit) {
    addCidr(cidr(init))
}

fun RoutingRule.Builder.addCidr(ip: ByteArray, prefix: Int) {
    addCidr(cidr(ip, prefix))
}

fun RoutingRule.Builder.addSourceCidr(init: CIDR.Builder.() -> Unit) {
    addSourceCidr(cidr(init))
}

fun RoutingRule.Builder.addSourceCidr(ip: ByteArray, prefix: Int) {
    addSourceCidr(cidr(ip, prefix))
}

fun RoutingRule.Builder.networkList(init: NetworkList.Builder.() -> Unit) {
    networkList = com.v2ray.android.protobuf.dsl.common.net.networkList(init)
}

fun RoutingRule.Builder.networkList(vararg network: Network) {
    networkList = com.v2ray.android.protobuf.dsl.common.net.networkList(*network)
}

fun RoutingRule.Builder.portRange(from: Int, to: Int = from) {
    portRange = com.v2ray.android.protobuf.dsl.common.net.portRange(from, to)
}
