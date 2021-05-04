package com.leyou.auth.test;

import com.leyou.common.pojo.UserInfo;
import com.leyou.common.utils.JwtUtils;
import com.leyou.common.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "E:\\IdeaProjects\\tmp\\rsa\\rsa.pub";

    private static final String priKeyPath = "E:\\IdeaProjects\\tmp\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTYyMDExMTc1MH0.I_KXRdfv8jYMCoGUFeAvfxyhQJgFJoeniZ4uomPeqbLpZwd9EfAK7xeZv7zUVfQn2eaDbdeCDcc_g8jiyiB45ZW8qfOMn3nczOy-pFUljC92FrGw8y-e5NxmejguiLZ8lR09LBuGP7LDnxGIMgDjIRZMxwcHzoxVfD6mBm5S7Uzm8NKSa_MIapVr8cAEPJuMmME-JbbUI5kWMaHDuaaseY0Hqc1KQgf4CD3vqvT5PPCzMhwTIuaDixP3kEDEFtHBxFgNKINmSE63x9wsu_Nz9MmNW30fstibZUK1Tumy0yh7mSzqNOmuQtOt3R9KfsWIScT_btawan1nhK55uUKxHg";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}