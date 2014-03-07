package com.example.kometabookingsystem;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import android.widget.Button;


import com.example.kometabookingsystem.DashBoardFragment;
import com.example.kometabookingsystem.LoginFragment;
import com.example.kometabookingsystem.LoginFragment.UiLoginListener;
import com.example.kometabookingsystem.R;
import com.example.kometabookingsystem.RegisterFragment;

import com.example.kometabookingsystem.RegisterFragment.UiRegisterListener;
import com.example.library.DatabaseHandler;
import com.example.library.UserFunctions;


public class MainFragmentActivity extends FragmentActivity implements UiLoginListener,UiRegisterListener{
	UserFunctions userFunctions;
	Button btnLogout;
	// JSON Response node names
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_UID = "uid";
	private static String KEY_NAME = "name";
	private static String KEY_EMAIL = "email";
	private static String KEY_CREATED_AT = "created_at";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.mainfragmentactivity);
     
        /**
         * Dashboard Screen for the application
         * */        
        // Check login status in database
        userFunctions = new UserFunctions();
        Log.e("Mainfragment","1");
        if(userFunctions.isUserLoggedIn(getApplicationContext())){
     
        	Fragment fragment = new DashBoardFragment();
    		FragmentManager fragmentManager = getSupportFragmentManager();
    		fragmentManager.beginTransaction()
    		.replace(R.id.mainfragment, fragment)
    		.commit();
        	        	
        }
        else{
     
        	LoginFragment fragment = new LoginFragment();
     
        	FragmentManager fragmentManager = getSupportFragmentManager();
    		fragmentManager.beginTransaction()
    		.replace(R.id.mainfragment, fragment)
    		.commit();
    		Log.e("Mainfragmentactivity", "6");
    		
        }
           
        
    }
    public void  onLoginClicked(String name, String password){
    	new LoginUserAsyncTask(this).execute(name,password);
        
    }
    public void  onRegisterClicked()
    {
    		Fragment fragment = new RegisterFragment();
    		FragmentManager fragmentManager = getSupportFragmentManager();
    		fragmentManager.beginTransaction()
    		.replace(R.id.mainfragment, fragment)
    		.commit();
    	
    }
    public void onSendRegister(String name, String password,String email)
    {
    		
    	Fragment fragment = new DashBoardFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
		.replace(R.id.mainfragment, fragment)
		.commit();
    	
		new RegisterUserAsyncTask(this).execute(name,email,password);
    	
    	
	
    }
    private class LoginUserAsyncTask extends AsyncTask <String, Void, JSONObject>
    {
    	
    	public Activity activity;

    	public LoginUserAsyncTask(Activity a)
    	{
    		this.activity = a;
    	}
    	    
    	protected JSONObject doInBackground(String... params) {
    		UserFunctions userFunction = new UserFunctions();
    		if (params.length != 2)
    			return null;
    		JSONObject json = userFunction.loginUser(params[0], params[1]);
    		return json;
    	}

    	protected void onPostExecute(JSONObject json) {
    	try {
    			if (json != null && json.getString(KEY_SUCCESS) != null) {
    		
    			String res = json.getString(KEY_SUCCESS);
    			if(Integer.parseInt(res) == 1){
    				// 	user successfully logged in
    				// Store user details in SQLite Database
    				//DatabaseHandler db = new DatabaseHandler(getActivity().getApplicationContext());
    				//DatabaseHandler db = new DatabaseHandler(context);
    				JSONObject json_user = json.getJSONObject("user");

    				// 	Clear all previous data in database
    				UserFunctions userFunction = new UserFunctions();
    				userFunction.logoutUser(activity.getApplicationContext());
    				DatabaseHandler db = new DatabaseHandler(activity.getApplicationContext());
    				db.addUser(json_user.getString(KEY_NAME),json_user.getString(KEY_EMAIL), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT));

    				//showProgress(false);

    				// I launch my fragment here, if you are using activities start your new intent instead.
    				DashBoardFragment fragment = new DashBoardFragment();
    				FragmentManager fragmentManager = getSupportFragmentManager();
    				fragmentManager.beginTransaction()
    				.replace(R.id.mainfragment, fragment)
    				.commit();

    			}else{

    				//showProgress(false);
    				// Error in login
    				Log.e("error","Incorrect username/password");
    			}
    		}
    	} catch 
    		(JSONException e) {
    			e.printStackTrace();
    		}
    	}//on postExecute
    }//loginUserAsyntask

    
    private class RegisterUserAsyncTask extends AsyncTask <String, Void, JSONObject>
    {
    	
    	public Activity activity;

    	public RegisterUserAsyncTask(Activity a)
    	{
    		this.activity = a;
    	}
    	    
    	protected JSONObject doInBackground(String... params) {
    		UserFunctions userFunction = new UserFunctions();
    		if (params.length != 3)
    			return null;
		
    		JSONObject json = userFunction.registerUser(params[0],params[1], params[2]);
    		return json;
    	}


    	protected void onPostExecute(JSONObject json) {
    	try {

    			if (json != null && json.getString(KEY_SUCCESS) != null)  {
				
    				String res = json.getString(KEY_SUCCESS); 
    				if(Integer.parseInt(res) == 1){
    					// user successfully registred
    					// Store user details in SQLite Database
    					DatabaseHandler db = new DatabaseHandler(activity.getApplicationContext());
    					JSONObject json_user = json.getJSONObject("user");
    					// Clear all previous data in database
    					UserFunctions userFunction = new UserFunctions();
    					userFunction.logoutUser(activity.getApplicationContext());
    					db.addUser(json_user.getString(KEY_NAME), json_user.getString(KEY_EMAIL), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT));						
    								
    					// Close Registration Screen
    					// I launch my fragment here, if you are using activities start your new intent instead.
    					DashBoardFragment fragment = new DashBoardFragment();
    					FragmentManager fragmentManager = getSupportFragmentManager();
    					fragmentManager.beginTransaction()
    					.replace(R.id.mainfragment, fragment)
    					.commit();
					
    				}else{
					// Error in registration
    					Log.e("error","Error in the registration");
    				}
    			}
    		}
    	 catch 
    		(JSONException e) {
    			e.printStackTrace();
    		}
    	}//on postExecute
    }//RegisterUserAsyntask
}