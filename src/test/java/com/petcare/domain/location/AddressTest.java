package com.petcare.domain.location;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    @Test
    void shouldCreateAddressWithValidData(){
        Address address = new Address
                (
                         "Damrak 1",
                         "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        assertEquals("Damrak 1", address.getStreet());
        assertEquals("Amsterdam", address.getCity());
        assertEquals("1012LH", address.getPostalCode());
        assertEquals("Netherlands", address.getCountry());

    }

    @Test
    void shouldRejectNullStreet(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Address
                                (
                                        null,
                                        "Amsterdam",
                                        "1012LH",
                                        "Netherlands"
                                )
                );
    }

    @Test
    void shouldRejectBlankStreet(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Address
                                (
                                        " ",
                                        "Amsterdam",
                                        "1012LH",
                                        "Netherlands"
                                )
                );
    }

    @Test
    void shouldRejectNullCity(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Address
                                (
                                        "Damrak 1",
                                        null,
                                        "1012LH",
                                        "Netherlands"
                                )
                );
    }

    @Test
    void shouldRejectBlankCity(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Address
                                (
                                        "Damrak 1",
                                        " ",
                                        "1012LH",
                                        "Netherlands"
                                )
                );
    }

    @Test
    void shouldRejectNullPostalCode(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Address
                                (
                                        "Damrak 1",
                                        "Amsterdam",
                                        null,
                                        "Netherlands"
                                )
                );
    }

    @Test
    void shouldRejectBlankPostalCode(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Address
                                (
                                        "Damrak 1",
                                        "Amsterdam",
                                        " ",
                                        "Netherlands"
                                )
                );
    }

    @Test
    void shouldRejectNullCountry(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Address
                                (
                                        "Damrak 1",
                                        "Amsterdam",
                                        "1012LH",
                                        null
                                )
                );
    }

    @Test
    void shouldRejectBlankCountry(){
        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new Address
                                (
                                        "Damrak 1",
                                        "Amsterdam",
                                        "1012LH",
                                        " "
                                )
                );
    }
}
