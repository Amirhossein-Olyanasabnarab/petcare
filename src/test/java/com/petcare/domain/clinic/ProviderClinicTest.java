package com.petcare.domain.clinic;

import com.petcare.domain.location.Address;
import com.petcare.domain.location.Location;
import com.petcare.domain.user.Role;
import com.petcare.domain.user.User;
import com.petcare.domain.user.provider.ProviderProfile;
import com.petcare.domain.user.provider.ProviderType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ProviderClinicTest {

    @Test
    void shouldCreateProviderClinicWithValidData() {
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user, ProviderType.VETERINARIAN, 15
                );
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        ProviderClinic providerClinic = new ProviderClinic
                (
                        provider,
                        clinic,
                        LocalDate.of(2026, 1, 1),
                        EmploymentType.FULL_TIME,
                        ProviderClinicStatus.ACTIVE
                );


        assertNotNull(providerClinic.getId());
        assertEquals(provider, providerClinic.getProvider());
        assertEquals(clinic, providerClinic.getClinic());
        assertEquals(
                LocalDate.of(2026, 1, 1),
                providerClinic.getStartDate()
        );
        assertEquals(EmploymentType.FULL_TIME, providerClinic.getEmploymentType());
        assertEquals(ProviderClinicStatus.ACTIVE, providerClinic.getStatus());
    }


    @Test
    void shouldRejectNullProvider() {

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new ProviderClinic
                                (
                                        null,
                                        clinic,
                                        LocalDate.of(2026, 1, 1),
                                        EmploymentType.FULL_TIME,
                                        ProviderClinicStatus.ACTIVE
                                )
                );
    }

    @Test
    void shouldRejectNullClinic() {

        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user, ProviderType.VETERINARIAN, 15
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new ProviderClinic
                                (
                                        provider,
                                        null,
                                        LocalDate.of(2026, 1, 1),
                                        EmploymentType.FULL_TIME,
                                        ProviderClinicStatus.ACTIVE
                                )
                );
    }


    @Test
    void shouldRejectNullStartDate() {
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user, ProviderType.VETERINARIAN, 15
                );
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> new ProviderClinic
                                (
                                        provider,
                                        clinic,
                                        null,
                                        EmploymentType.FULL_TIME,
                                        ProviderClinicStatus.ACTIVE
                                )
                );
    }

    @Test
    void shouldRejectNullEmploymentType(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user, ProviderType.VETERINARIAN, 15
                );
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new ProviderClinic
                                (
                                        provider,
                                        clinic,
                                        LocalDate.of(2026, 1, 1),
                                        null,
                                        ProviderClinicStatus.ACTIVE
                                )
                );
    }

    @Test
    void shouldRejectNullStatus(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user, ProviderType.VETERINARIAN, 15
                );
        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        assertThrows
                (
                        IllegalArgumentException.class,
                        ()->new ProviderClinic
                                (
                                        provider,
                                        clinic,
                                        LocalDate.of(2026, 1, 1),
                                        EmploymentType.FULL_TIME,
                                        null
                                )
                );
    }

    @Test
    void shouldSetEndDate() {
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        ProviderClinic providerClinic = new ProviderClinic
                (
                        provider,
                        clinic,
                        LocalDate.of(2026, 1, 1),
                        EmploymentType.FULL_TIME,
                        ProviderClinicStatus.ACTIVE
                );

        LocalDate endDate = LocalDate.of(2026, 6, 30);

        providerClinic.endEmployment(endDate);

        assertEquals(endDate, providerClinic.getEndDate());
    }


    @Test
    void shouldRejectEndDateBeforeStartDate(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        ProviderClinic providerClinic = new ProviderClinic
                (
                        provider,
                        clinic,
                        LocalDate.of(2026, 1, 1),
                        EmploymentType.FULL_TIME,
                        ProviderClinicStatus.ACTIVE
                );

        LocalDate endDate = LocalDate.of(2025, 6, 30);

        assertThrows
                (
                        IllegalArgumentException.class,
                        () -> providerClinic.endEmployment(endDate)
                );
    }

    @Test
    void shouldRejectNullEndDate(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        ProviderClinic providerClinic = new ProviderClinic
                (
                        provider,
                        clinic,
                        LocalDate.of(2026, 1, 1),
                        EmploymentType.FULL_TIME,
                        ProviderClinicStatus.ACTIVE
                );
        assertThrows(
                IllegalArgumentException.class,
                ()->providerClinic.endEmployment(null)

        );
    }


    @Test
    void shouldChangeStatusToEndedWhenEmploymentEnds(){
        User user = new User
                (
                        "amir",
                        "amir@gmail.com",
                        "password_hash",
                        Set.of(Role.PROVIDER)
                );

        ProviderProfile provider = new ProviderProfile
                (
                        user,
                        ProviderType.VETERINARIAN,
                        15
                );

        Address address = new Address
                (
                        "Damrak 1",
                        "Amsterdam",
                        "1012LH",
                        "Netherlands"
                );

        Location location = new Location
                (
                        address,
                        BigDecimal.valueOf(52.3676),
                        BigDecimal.valueOf(4.9041)
                );

        Clinic clinic = new Clinic
                (
                        "Amsterdam Pet Clinic",
                        location
                );

        ProviderClinic providerClinic = new ProviderClinic
                (
                        provider,
                        clinic,
                        LocalDate.of(2026, 1, 1),
                        EmploymentType.FULL_TIME,
                        ProviderClinicStatus.ACTIVE
                );

        LocalDate endDate = LocalDate.of(2026, 6, 30);

        providerClinic.endEmployment(endDate);

        assertEquals(
                ProviderClinicStatus.ENDED,
                providerClinic.getStatus()
        );
    }
}
