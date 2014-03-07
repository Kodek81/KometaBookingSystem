package com.example.kometabookingsystem;




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



public class RegisterFragment extends Fragment {
	
	Button btnRegister;
	Button btnLinkToLogin;
	EditText inputFullName;
	EditText inputEmail;
	EditText inputPassword;
	TextView registerErrorMsg;
	
	// JSON Response node names
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_UID = "uid";
	private static String KEY_NAME = "name";
	private static String KEY_EMAIL = "email";
	private static String KEY_CREATED_AT = "created_at";

	
	public interface UiRegisterListener{
            public void onSendRegister(String name, String password,String email);
            
           
    }
    
    private UiRegisterListener uiCallback;
    
    @Override
    public void onAttach(Activity activity) {               
            super.onAttach(activity);               
            try{
                    uiCallback = (UiRegisterListener) activity; // check if the interface is implemented
            }catch(ClassCastException e){
                    e.printStackTrace();
            }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                    Bundle savedInstanceState) {
            
            return inflater.inflate(R.layout.registerfragment, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
                       
         // Importing all assets like buttons, text fields
    		inputFullName = (EditText) getView().findViewById(R.id.registerName);
    		inputEmail = (EditText) getView().findViewById(R.id.registerEmail);
    		inputPassword = (EditText) getView().findViewById(R.id.registerPassword);
    		btnRegister = (Button) getView().findViewById(R.id.btnRegister);
    		btnLinkToLogin = (Button) getView().findViewById(R.id.btnLinkToLoginScreen);
    		registerErrorMsg = (TextView) getView().findViewById(R.id.register_error);
    		
    		// Register Button Click event
    		btnRegister.setOnClickListener(new View.OnClickListener() {			
    			public void onClick(View view) {
    				uiCallback.onSendRegister(inputFullName.getText().toString(), inputPassword.getText().toString(),inputEmail.getText().toString());
    			}
    		});
    }
}
