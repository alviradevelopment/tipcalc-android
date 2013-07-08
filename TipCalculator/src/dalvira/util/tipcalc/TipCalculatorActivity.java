//AlviraDevelopment

package dalvira.util.tipcalc;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity implements
		OnRatingBarChangeListener {
	/** Called when the activity is first created. */

	private static double perctVal = 0;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final EditText partyNum = (EditText) findViewById(R.id.editPartyNumID);
		
		final EditText totalBill = (EditText) findViewById(R.id.editBillTotalID);
		
		final TextView totalDisp = (TextView) findViewById(R.id.totalPrintID);
		
		final TextView tipDisp = (TextView) findViewById(R.id.tipPrintID);

		Button calculate = (Button) findViewById(R.id.calcTipBtnID);
		calculate.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				String partyVal = partyNum.getText().toString();

				String billVal = totalBill.getText().toString();
				
				if (partyVal.equals("") || billVal.equals("")) {

				}else {

					double partyValD = Double.parseDouble(partyVal);
					double billValD = Double.parseDouble(billVal);

					DecimalFormat df = new DecimalFormat("#.##");

					double tipVal = (billValD * perctVal) / partyValD;

					double tipTotal = (billValD * perctVal);
					
					totalDisp.setText("$" + df.format(tipTotal));
					
					tipDisp.setText("$" + df.format(tipVal));

				}
			}
		});

		Button resetBtn = (Button) findViewById(R.id.resetBtnID);
		resetBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				partyNum.setText("");

				totalBill.setText("");
				
				TextView totalDisp = (TextView) findViewById(R.id.totalPrintID);
				totalDisp.setText("$");

				TextView tipDisp = (TextView) findViewById(R.id.tipPrintID);
				tipDisp.setText("$");

			}
		});
		
		Button settings = (Button) findViewById(R.id.settingBtn);
		settings.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				Intent settingIntent = new Intent();
				settingIntent.setClassName("dalvira.util.tipcalc","dalvira.util.tipcalc.SettingsActivity");
				startActivity(settingIntent);
				
			}
			
		});


		final RatingBar servRating = (RatingBar) findViewById(R.id.serviceRatingBarID);
		servRating.setOnRatingBarChangeListener(this);

	}

	public void onRatingChanged(RatingBar servRating, float rating,
			boolean fromUser) {

		TextView servRatingPrint = (TextView) findViewById(R.id.servRateID);

		if (rating == 1) {
			servRatingPrint.setText(SettingsActivity.s1Val + "%");
			perctVal = .01 * SettingsActivity.s1Val;
		} else if (rating == 2) {
			servRatingPrint.setText(SettingsActivity.s2Val + "%");
			perctVal = .01 * SettingsActivity.s2Val;
		} else if (rating == 3) {
			servRatingPrint.setText(SettingsActivity.s3Val + "%");
			perctVal = .01 * SettingsActivity.s3Val;
		} else if (rating == 4) {
			servRatingPrint.setText(SettingsActivity.s4Val + "%");
			perctVal = .01 * SettingsActivity.s4Val;
		} else if (rating == 5) {
			servRatingPrint.setText(SettingsActivity.s5Val + "%");
			perctVal = .01 * SettingsActivity.s5Val;
		} else {
			servRatingPrint.setText("%");
			perctVal = 0;
		}

	}
	

}