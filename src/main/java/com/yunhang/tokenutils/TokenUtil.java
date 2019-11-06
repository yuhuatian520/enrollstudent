package com.yunhang.tokenutils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yunhang.entity.AdministratorInfo;
import lombok.var;

/** token的生成
 * @author Administrator
 */
public class TokenUtil {

    public static String getToken(AdministratorInfo administratorInfo) {
        var token="";
        token= JWT.create().withAudience(administratorInfo.getAdministratorId())
                .sign(Algorithm.HMAC256(administratorInfo.getAdministratorPassword()));
        return token;
    }


}
