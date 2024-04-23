package org.example.NettySSL;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class ClientSSLContextProvider {

    private static final String PROTOCOL = "TLS";
    private static final String ALGORITHM = "SunX509";
    private static final String KEYSTORE_PATH = "ssl_certs/TestTruststore.jks";
    private static final String KEYSTORE_PASSWORD = "123456";

    public static SslContext getClientSslContext() throws Exception {
        TrustManagerFactory trustManagerFactory = getTrustManagerFactory();
        return SslContextBuilder.forClient().trustManager(trustManagerFactory).build();
    }

    private static TrustManagerFactory getTrustManagerFactory() throws Exception {
        try (InputStream inputStream = new FileInputStream(KEYSTORE_PATH)) {
            KeyStore truststore = KeyStore.getInstance("JKS");
            truststore.load(inputStream, "changeit".toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(truststore);
            return trustManagerFactory;

        } catch (IOException | CertificateException e) {
            System.err.println(e);
            throw new RuntimeException("Failed to load truststore", e);
        }
    }
}
