package com.belevitnev.test;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class create_acc extends BaseTestClass {

    private String emailString = "dfhdghsdsdsas@yopmail.com";

    @Test
    public  void TestOne(){
        System.out.println("Test one runned");

        RestAssured.baseURI="https://www.qa.texture.com";

        String sql = "SELECT * FROM user_detail WHERE user_detail.email=" + "'"+emailString+"'";

//        Squad Squad = new Squad();
//        String dad = Squad.squad(12,5);
//        System.out.println(dad);

        given().header("X-Nimsaleschannel","SAMSTORE").
                param("email", emailString).
                param("firstName","Test").
                param("password","24232558").
                param("keepMeUpToDate", "true").when().post("/accounts/api/accounts/texture").
                then().assertThat().statusCode(200);

        SqlTest SqlTest = new SqlTest();
        String emaildb =SqlTest.sqlTest(sql);

        given().
                param("j_password", "24232558").
                param("j_username",emailString).
               when().post("/accounts/api/login/texture").
                then().assertThat().statusCode(200).and().body("result.user.email",equalTo(emaildb));
    }
}
