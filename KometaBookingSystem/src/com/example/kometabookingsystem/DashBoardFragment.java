package com.example.kometabookingsystem;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DashBoardFragment extends Fragment {
	
	Button btnLogout;
	
    public interface UiListener{
            public void onButtonClicked();
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
        Log.e("DashboarFramgent","onCreateView");
        
    	return inflater.inflate(R.layout.dashboardfragment, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            Log.e("DashboarFramgent","onViewCreated");               
           	btnLogout = (Button) getView().findViewById(R.id.btnLogout);
        	
        	btnLogout.setOnClickListener(new View.OnClickListener() {
    			
    			public void onClick(View arg0) {
    				// TODO Auto-generated method stub
    				/*userFunctions.logoutUser(getApplicationContext());
    				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
    	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	        	startActivity(login);
    	        	// Closing dashboard screen
    	        	finish();
    	        	*/
    			}
    		});

}
}
