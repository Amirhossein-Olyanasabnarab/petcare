package com.petcare.domain.location;

public class Address {
    private String street;
    private String city;
    private String postalCode;
    private String country;

    public Address
            (
                    String street,
                    String city,
                    String postalCode,
                    String country
            ){

        if (street == null || street.isBlank())
            throw new IllegalArgumentException("The street is required.");

        if (city == null || city.isBlank())
            throw new IllegalArgumentException("The city is required.");

        if (postalCode == null || postalCode.isBlank())
            throw new IllegalArgumentException("The postal code is required.");

        if (country == null || country.isBlank())
            throw new IllegalArgumentException("The country is required.");

        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }
}
