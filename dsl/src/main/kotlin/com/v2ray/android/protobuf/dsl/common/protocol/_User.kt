package com.v2ray.android.protobuf.dsl.common.protocol

import com.v2ray.android.protobuf.dsl.proxy.shadowsocksAccount
import com.v2ray.android.protobuf.dsl.proxy.socksAccount
import com.v2ray.android.protobuf.dsl.proxy.vmess.vmesssAccount
import com.v2ray.android.protobuf.extention.toTypedMessage
import com.v2ray.core.common.protocol.User

fun user(init: User.Builder.() -> Unit): User = User.newBuilder().apply(init).build()

fun User.Builder.accountVmess(init: com.v2ray.core.proxy.vmess.Account.Builder.() -> Unit) {
    account = vmesssAccount(init).toTypedMessage()
}

fun User.Builder.accountShadowsocks(init: com.v2ray.core.proxy.shadowsocks.Account.Builder.() -> Unit) {
    account = shadowsocksAccount(init).toTypedMessage()
}

fun User.Builder.accountSocks(init: com.v2ray.core.proxy.socks.Account.Builder.() -> Unit) {
    account = socksAccount(init).toTypedMessage()
}

fun User.Builder.accountSocks(user: String, pass: String) {
    account = socksAccount(user, pass).toTypedMessage()
}