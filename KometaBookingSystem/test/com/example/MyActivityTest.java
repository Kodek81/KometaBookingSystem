package com.example;

import org.robolectric.RobolectricTestRunner;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.library.*;

import com.example.kometabookingsystem.R;
import com.example.login.*;
import com.example.library.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;
@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {
	private static String KEY_SUCCESS = "success";
	

    @Test
    public void shouldHaveHappySmiles() throws Exception {
        /*
         * String appName = new RegisterActivity().getResources().getString(R.string.app_name);
        	assertThat(appName, equalTo("Kometa Booking System"));
        	UserFunctions userFunction = new UserFunctions();
        	JSONObject json = userFunction.registerUser("kepaPrueba", "kepa@gmail.com", "7rosamu5");
        	assertNotNull(json.getString(KEY_SUCCESS));
       */
    }
}
