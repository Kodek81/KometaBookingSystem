package com.example.kometabookingsystem;




import android.R.string;
import android.app.Activity;

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


	
	public interface UiLoginListener{
            public void onRegisterClicked();
            public void onLoginClicked(String name,String password);
           
    }
    
    private UiLoginListener uiCallback;
    
    @Override
    public void onAttach(Activity activity) {               
            super.onAttach(activity);               
            try{
                    uiCallback = (UiLoginListener) activity; // check if the interface is implemented
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
        				
        				uiCallback.onLoginClicked(inputEmail.getText().toString(),inputPassword.getText().toString());
        			
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
