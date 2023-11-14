package com.example.myapplication;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    private static final String FAKE_STRING = "Login was successful";

    private static final String FAKE_USERNAME_STRING="Valid Username";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {

        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // ...when the string is returned from the object under test...
        String result = myObjectUnderTest.validate("admin","admin");

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));
    }

    @Test
    public void testValidUsername() {
        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // Checking for valid username.
        String result = myObjectUnderTest.validate_email("admin123@uottawa.ca");

        // Both should match!
        assertThat(result, is(FAKE_USERNAME_STRING));
    }

    @Test
    public void testInvalidUsername() {
        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // Checking for invalid username.
        String result = myObjectUnderTest.validate_email("!!!!@g@1$.com");

        // Both should not be equal, hence error when testing.
        assertThat(result, is(FAKE_USERNAME_STRING));
    }
}
