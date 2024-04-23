

# 生成ssl证书

keytool  -genkey -noprompt -trustcacerts -keyalg RSA -alias cert -dname  maanadev.org -keypass 123456 -keystore mysslstore.jks -storepass 123456 -dname CN=maanadev.org
keytool -export -keystore mysslstore.jks -alias cert -file maanadev.org.cert
keytool -importcert -file maanadev.org.cert -keystore TestTruststore.jks -storepass changeit -storetype JKS