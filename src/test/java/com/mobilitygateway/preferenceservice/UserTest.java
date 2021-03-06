package com.mobilitygateway.preferenceservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;
    private String username = "maria.ziegler@online.de";
    private String fullname = "Maria Ziegler";
    private String password = "1234";

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setPassword(password);
    }

    @Test
    public void testToReceiveTokenBodyFormat() {
        String serialized = user.toReceiveTokenBodyFormat();
        String goal = "grant_type=" + "password" + "&username=" + username + "&password=" + password;
        assertEquals(goal, serialized);
    }

    @Test
    public void testToSignupBodyFormat() {
        String serialized = user.toSignupBodyFormat();
        String goal = "username=" + username + "&fullname=" + fullname + "&password=" + password;
        assertEquals(goal, serialized);
    }

    @Test
    public void testLogin() {
        user.login();
    }

    @Test
    public void testSignup() {
        user.signup();
    }

    @Test
    public void testUpdateFullname() {
        user.login();
        String newName = "Maria Ziegler";
        user.updateFullname(newName);
        assertEquals(newName, user.getFullname());
    }

    @Test
    public void testUpdatePassword() {
        user.login();
        String newPassword = "1234";
        user.updatePassword(newPassword);
        assertEquals(newPassword, user.getPassword());
    }
}
