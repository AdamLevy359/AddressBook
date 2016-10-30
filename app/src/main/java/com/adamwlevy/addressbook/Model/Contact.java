package com.adamwlevy.addressbook.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * The Contacts class encapsulates all the data contained in a single contact within
 * the address book.
 *
 */
//TODO add data validation for all setter methods.
public class Contact implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String street;
    private String city;
    private String state;
    private String postalCode;

    /**
     * Constructor for Contact object
     * @param jsonString a sting in JSON format returned by https://randomuser.me/api
     *                   as of Oct 29, 2016.
     *
     */
    public Contact(String jsonString){
        try {
            //Convert the string to a JSON object
            JSONObject jsonObj = new JSONObject(jsonString);

            //Get the results array
            JSONArray jsonResults = jsonObj.getJSONArray("results");

            //Get the first result in the array
            JSONObject jsonContact = jsonResults.getJSONObject(0);

            //Get the email and phone strings from the result
            email = jsonContact.getString("email");
            phoneNumber = jsonContact.getString("phone");

            //Get the name object from the result
            JSONObject jsonName = jsonContact.getJSONObject("name");
            firstName = jsonName.getString("first");
            lastName = jsonName.getString("last");

            //Get the location object from the result
            JSONObject jsonLocation = jsonContact.getJSONObject("location");
            city = jsonLocation.getString("city");
            postalCode = jsonLocation.getString("postcode");
            state = jsonLocation.getString("state");
            street = jsonLocation.getString("street");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setStreet(String street){
        this.street = street;
    }
    public String getStreet(){
        return street;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return city;
    }

    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    public String getPostalCode(){
        return postalCode;
    }

}
