package com.cihangll.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;

@Path("/")
@Produces("text/html; charset=UTF-8")
public class CustomerResource {

    /*
     *  Regex kullanmak için {} içerisinde {pathName : REGEX} şeklinde tanımlama yapabiliriz.
     *
     *  Örneğin;
     *  @Path("/order/{id : \\d+}")  \\d+ --regexine uygun şeklinde id girilmeli.
     *  @Path("/car/{search : criteria}") --/car/criteria ile başlayan search gelmeli.
     *
     * */


    @GET
    @Produces("application/json")
    public List<String> greeting() {
        return Arrays.asList("teçöö.işi.üüst1", "test2", "test3");
    }

    @GET
    @Path("/customer/{id}")
    public String getCustomerById(@PathParam("id") String customerId) {
        String message = "getCustomerById is called. Customer Id : " + customerId;
        return message;
    }

    @GET
    @Path("customer/{firstname}-{lastname}")
    public String getCustomerByName(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname) {
        String message = "getCustomerByName is called. Welcome , " + firstname + " " + lastname;
        return message;
    }

    @GET
    @Path("/order/{day}/{month}/{year}")
    public String getOrdersByHistory(@PathParam("day") int day, @PathParam("month") int month,
                                     @PathParam("year") int year) {

        String message = "getOrdersByHistory is called. ";
        String date = day + "." + month + "." + year;
        return message + " " + date;
    }
}
