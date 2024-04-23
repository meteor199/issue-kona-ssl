package org.example;

import com.tencent.kona.crypto.KonaCryptoProvider;
import com.tencent.kona.pkix.KonaPKIXProvider;
import com.tencent.kona.ssl.KonaSSLProvider;

import java.security.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        Security.addProvider(new KonaCryptoProvider());
        Security.addProvider(new KonaPKIXProvider());
        Security.addProvider(new KonaSSLProvider());

        new TLCPWithNettyDemo().tlcpDemo();

    }

}