package com.v2ray.android.protobuf.dsl.common.net

import com.v2ray.core.common.net.Network
import com.v2ray.core.common.net.NetworkList

fun networkList(init: NetworkList.Builder.() -> Unit): NetworkList = NetworkList.newBuilder().apply(init).build()

fun networkList(vararg network: Network): NetworkList = networkList { network.forEach { addNetwork(it) } }
