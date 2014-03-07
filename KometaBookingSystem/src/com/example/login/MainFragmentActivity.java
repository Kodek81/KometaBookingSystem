/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 * */
package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;


import com.example.kometabookingsystem.DashBoardFragment;
import com.example.kometabookingsystem.LoginFragment;
import com.example.kometabookingsystem.R;
import com.example.kometabookingsystem.RegisterFragment;
import com.example.kometabookingsystem.LoginFragment.UiListener;
import com.example.kometabookingsystem.RegisterFragment.UiRegisterListener;
import com.example.library.UserFunctions;

public class MainFragmentActivity extends FragmentActivity implements UiListener,UiRegisterListener{
	UserFunctions userFunctions;
	Button btnLogout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /**
         * Dashboard Screen for the application
         * */        
        // Check login status in database
        userFunctions = new UserFunctions();
        if(userFunctions.isUserLoggedIn(getApplicationContext())){
        	        	
        }else{
        	Fragment fragment = new LoginFragment();
    		FragmentManager fragmentManager = getSupportFragmentManager();
    		fragmentManager.beginTransaction()
    		.replace(R.id.mainfragment, fragment)
    		.commit();
        }
           
        
    }
    public void  onLoginClicked(){
        // handle button clicked  
    	/*
		String email = inputEmail.getText().toString();
		String password = inputPassword.getText().toString();
		UserFunctions userFunction = new UserFunctions();
		Log.d("Button", "Login");
		JSONObject json = userFunction.loginUser(email, password);

		// check for login response
		try {
			if (json.getString(KEY_SUCCESS) != null) {
				loginErrorMsg.setText("");
				String res = json.getString(KEY_SUCCESS); 
				if(Integer.parseInt(res) == 1){
					// user successfully logged in
					// Store user details in SQLite Database
					DatabaseHandler db = new DatabaseHandler(getActivity().getApplicationContext());
					JSONObject json_user = json.getJSONObject("user");
					
					// Clear all previous data in database
					userFunction.logoutUser(getActivity().getApplicationContext());
					db.addUser(json_user.getString(KEY_NAME), json_user.getString(KEY_EMAIL), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT));						
					
					// Launch Dashboard Screen
					Intent dashboard = new Intent(getActivity().getApplicationContext(), DashboardActivity.class);
					
					// Close all views before launching Dashboard
					dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(dashboard);
				        						
				}else{
					// Error in login
					loginErrorMsg.setText("Incorrect username/password");
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		*/
    }
    public void  onRegisterClicked()
    {
    		Fragment fragment = new RegisterFragment();
    		FragmentManager fragmentManager = getSupportFragmentManager();
    		fragmentManager.beginTransaction()
    		.replace(R.id.mainfragment, fragment)
    		.commit();
    	
    }
    public void onSendRegister()
    {
    		
    	Fragment fragment = new RegisterFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
		.replace(R.id.mainfragment, fragment)
		.commit();
    	
    	
    	
    	/*String name = inputFullName.getText().toString();
    		String email = inputEmail.getText().toString();
    		String password = inputPassword.getText().toString();
    		UserFunctions userFunction = new UserFunctions();
    		JSONObject json = userFunction.registerUser(name, email, password);
		
		// check for login response
    		try {
    			if (json.getString(KEY_SUCCESS) != null) {
				registerErrorMsg.setText("");
				String res = json.getString(KEY_SUCCESS); 
				if(Integer.parseInt(res) == 1){
					// user successfully registred
					// Store user details in SQLite Database
					DatabaseHandler db = new DatabaseHandler(getActivity().getApplicationContext());
					JSONObject json_user = json.getJSONObject("user");
					
					// Clear all previous data in database
					userFunction.logoutUser(getActivity().getApplicationContext());
					db.addUser(json_user.getString(KEY_NAME), json_user.getString(KEY_EMAIL), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT));						
					// Launch Dashboard Screen
					Intent dashboard = new Intent(getActivity().getApplicationContext(), DashboardActivity.class);
					// Close all views before launching Dashboard
					dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(dashboard);
					// Close Registration Screen
					
				}else{
					// Error in registration
					registerErrorMsg.setText("Error occured in registration");
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		*/
    }
}