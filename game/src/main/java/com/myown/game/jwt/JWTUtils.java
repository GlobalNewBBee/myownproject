package com.myown.game.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JWTUtils {

    public final String secret = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    /*
    * jwtToken是由header.payload.signature三部分组成的
    * */
    public String createToken(String phone,String password){

        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE,10);
        Date expireTime = date.getTime();

        String headerAndPayloadJson = JWT.create().withClaim("name", StringUtils.isBlank(phone) ? null : phone)
                .withClaim("password", StringUtils.isBlank(password) ? null : password)
                .withClaim("exp", expireTime)
                .sign(Algorithm.HMAC256(secret));

        return null;
    }
}
