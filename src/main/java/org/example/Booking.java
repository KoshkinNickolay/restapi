package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Booking
{
    private static int  id;
    public static void main( String[] args ) {
    }
        public static void autorizacia(){
        String restauth = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        String result = RestAssured.given()
                .body(restauth)
                .contentType(ContentType.JSON)
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .extract()
                .response()
                .jsonPath()
                .get("token");
        System.out.println(result);
    }

        public static void createBooking() {
            String restbooking = "{\n" +
                    "    \"firstname\" : \"Jhon\",\n" +
                    "    \"lastname\" : \"Kerry\",\n" +
                    "    \"totalprice\" : 101010,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2021-01-01\",\n" +
                    "        \"checkout\" : \"2021-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}";
           id = RestAssured.given()
                    .body(restbooking)
                    .contentType(ContentType.JSON)
                    .post("https://restful-booker.herokuapp.com/booking")
                    .then()
                    .extract()
                    .response()
                    .jsonPath()
                    .getInt("bookingid");
            System.out.println(id);

        }

        public static void chek() {
            RestAssured.given()
                    .baseUri("https://restful-booker.herokuapp.com/booking/")
                    .when()
                    .get(String.format("%d", id))
                    .then()
                    .extract()
                    .response()
                    .body()
                    .prettyPrint();
        }

}
