//AlviraDevelopment

package dalvira.util.tipcalc;

import java.text.DecimalFormat;

import android.app.Activity;
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
	private static int s1Val = 13;
	private static int s2Val = 15;
	private static int s3Val = 18;
	private static int s4Val = 20;
	private static int s5Val = 22;
	

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

		final RatingBar servRating = (RatingBar) findViewById(R.id.serviceRatingBarID);
		servRating.setOnRatingBarChangeListener(this);

	}

	public void onRatingChanged(RatingBar servRating, float rating,
			boolean fromUser) {

		TextView servRatingPrint = (TextView) findViewById(R.id.servRateID);

		if (rating == 1) {
			servRatingPrint.setText(s1Val + "%");
			perctVal = .01 * s1Val;
		} else if (rating == 2) {
			servRatingPrint.setText(s2Val + "%");
			perctVal = .01 * s2Val;
		} else if (rating == 3) {
			servRatingPrint.setText(s3Val + "%");
			perctVal = .01 * s3Val;
		} else if (rating == 4) {
			servRatingPrint.setText(s4Val + "%");
			perctVal = .01 * s4Val;
		} else if (rating == 5) {
			servRatingPrint.setText(s5Val + "%");
			perctVal = .01 * s5Val;
		} else {
			servRatingPrint.setText("%");
			perctVal = 0;
		}

	}
	

}