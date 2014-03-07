package com.example.kometabookingsystem;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.library.DatabaseHandler;
import com.example.library.UserFunctions;
import com.example.login.MainFragmentActivity;
import com.example.login.RegisterActivity;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class LoginFragment extends Fragment {

	Button btnLogin;
	Button btnLinkToRegister;
	EditText inputEmail;
	EditText inputPassword;
	TextView loginErrorMsg;

	// JSON Response node names
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_UID = "uid";
	private static String KEY_NAME = "name";
	private static String KEY_EMAIL = "email";
	private static String KEY_CREATED_AT = "created_at";
	
	public interface UiListener{
            public void onRegisterClicked();
            public void onLoginClicked();
           
    }
    
    private UiListener uiCallback;
    
    @Override
    public void onAttach(Activity activity) {               
            super.onAttach(activity);               
            try{
                    uiCallback = (UiListener) activity; // check if the interface is implemented
            }catch(ClassCastException e){
                    e.printStackTrace();
            }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                    Bundle savedInstanceState) {
            
          	return inflater.inflate(R.layout.loginfragment, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
                       
        		// Importing all assets like buttons, text fields
        		inputEmail = (EditText) getView().findViewById(R.id.loginEmail);
        		inputPassword = (EditText) getView().findViewById(R.id.loginPassword);
        		btnLogin = (Button) getView().findViewById(R.id.btnLogin);
        		btnLinkToRegister = (Button) getView().findViewById(R.id.btnLinkToRegisterScreen);
        		loginErrorMsg = (TextView) getView().findViewById(R.id.login_error);
        		
        		// Login button Click Event
        		btnLogin.setOnClickListener(new View.OnClickListener() {

        			public void onClick(View view) {
        				
        				uiCallback.onLoginClicked();
        			
        			}
        		});

        		// Link to Register Screen
        		btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

        			public void onClick(View view) {
        			
        				uiCallback.onRegisterClicked();
        			}
        		});    
    }
}
