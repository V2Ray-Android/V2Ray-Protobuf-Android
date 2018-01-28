# V2Ray-Protobuf-Android
V2Ray Protobuf-lite models and DSL builder for them

## Import
Models only
```Groovy
implementation 'com.v2ray.android.protobuf:model:x.y.z'
```
Models and DSL builder
```Groovy
implementation 'com.v2ray.android.protobuf:dsl:x.y.z'
```

## Example
```Kotlin
fun main(args: Array<String>) {
    val config = config {
        addInbound {
            receiver {
                portRange(10800)
                listen = ip("127.0.0.1")
            }
            http {}
        }
        addInbound {
            receiver {
                portRange(10808)
                listen = ip("127.0.0.1")
            }
            socks {
                udpEnabled = true
                address = ip("127.0.0.1")
            }
        }
        addOutbound {
            vmess {
                addReceiver {
                    address = domain("example.com")
                    port = 443
                    addUser {
                        level = 1
                        accountVmess {
                            id = "490f75d7-0063-485a-a1bd-4f264f04a3e5"
                            alterId = 32
                            securityType = SecurityType.NONE
                        }
                    }
                }
            }
            sender {
                streamSettings {
                    protocol = TransportProtocol.WebSocket
                    addTransportSettings {
                        protocol = TransportProtocol.WebSocket
                        websocketSettings {
                            path = "v2ray"
                        }
                    }
                    securityType = com.v2ray.core.transport.internet.tls.Config.getDefaultInstance().messageName
                    addTlsSettings { }
                }
                multiplexSettings {
                    enabled = true
                    concurrency = 8
                }
            }
        }
        addOutbound {
            tag = "direct"
            freedom {}
        }
        dns {
            addNameServers(ip("8.8.8.8"))
        }
        router {
            domainStrategy = Config.DomainStrategy.IpIfNonMatch
            addRule {
                addDomain("www.ipip.net")
                tag = "direct"
            }
        }
        log {
            errorLogLevel = Severity.Debug
        }
        addApp(InboundConfig.getDefaultInstance().toTypedMessage())
        addApp(OutboundConfig.getDefaultInstance().toTypedMessage())
        addApp(com.v2ray.core.app.dispatcher.Config.getDefaultInstance().toTypedMessage())
    }
    
    config.writeTo(File("config.pb").outputStream())
}
```