package com.feng.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJwtTest {
    public static void main(String[] args) {

        try{

            Claims claims = Jwts.parser().setSigningKey("feng")
                    .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjMiLCJzdWIiOiLlhq_kv4rmnbAiLCJpYXQiOjE1NzMzNzc1MTIsImV4cCI6MTU3MzM3NzU3Miwicm9sZSI6ImFkbWluIn0.QgyfLvsbfxL_zw90CExL79Yq-IdZAhJNflCRWXH6qWE")
                    .getBody();
            System.out.println("用户名："+claims.getId());
            System.out.println("用户名："+claims.getSubject());
            System.out.println("角色："+claims.get("role"));
        }catch (Exception e){
            System.out.println("已过期！");
        }


    }
}
