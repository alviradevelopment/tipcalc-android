package dalvira.util.tipcalc;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;


public class SettingsActivity extends Activity {
	
	
	public static double s1Val = 13;
	public static double s2Val = 15;
	public static double s3Val = 18;
	public static double s4Val = 20;
	public static double s5Val = 22;
	
	public static String saveFile = "Shared1";

	SharedPreferences savedVals;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        savedVals = getSharedPreferences(saveFile, 0);
  
        final EditText star1 = (EditText) findViewById(R.id.s1edit);
        
		final EditText star2 = (EditText) findViewById(R.id.s2edit);
	
		final EditText star3 = (EditText) findViewById(R.id.s3edit);

		final EditText star4 = (EditText) findViewById(R.id.s4edit);

		final EditText star5 = (EditText) findViewById(R.id.s5edit);
		
		Button save = (Button) findViewById(R.id.saveBtn);
		save.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {              
		        savedVals = getSharedPreferences(saveFile, 0);

				SharedPreferences.Editor editor = savedVals.edit();
				
				String s1 = star1.getText().toString();
				editor.putString("sharedString1", s1);
				//editor.commit();

				
				String s2 = star2.getText().toString();
				editor.putString("sharedString2", s2);
				//editor.commit();

				
				String s3 = star3.getText().toString();
				editor.putString("sharedString3", s3);
				//editor.commit();

				
				String s4 = star4.getText().toString();
				editor.putString("sharedString4", s4);
				//editor.commit();

				
				String s5 = star5.getText().toString();
				editor.putString("sharedString5", s5);
				
				
				editor.commit();
				
				
				String retVal1 = savedVals.getString("sharedString1", "Couldn't Load Value");
		        s1Val = Double.parseDouble(retVal1);
				String retVal2 = savedVals.getString("sharedString2", "Couldn't Load Value");
		        s1Val = Double.parseDouble(retVal2);
				String retVal3 = savedVals.getString("sharedString3", "Couldn't Load Value");
		        s1Val = Double.parseDouble(retVal3);
				String retVal4 = savedVals.getString("sharedString4", "Couldn't Load Value");
		        s1Val = Double.parseDouble(retVal4);
				String retVal5 = savedVals.getString("sharedString5", "Couldn't Load Value");
		        s1Val = Double.parseDouble(retVal5);
				
				Intent homeIntent = new Intent();
				homeIntent.setClassName("dalvira.util.tipcalc","dalvira.util.tipcalc.TipCalculatorActivity");
				startActivity(homeIntent);

			}
			
		});
		
		Button defaults = (Button) findViewById(R.id.defaultBtn);
		defaults.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				s1Val = 13;
				s2Val = 15;
				s3Val = 18;
				s4Val = 20;
				s5Val = 22;
				
				Intent homeIntent = new Intent();
				homeIntent.setClassName("dalvira.util.tipcalc","dalvira.util.tipcalc.TipCalculatorActivity");
				startActivity(homeIntent);
			}
			
		});        
        
    }
    


}
