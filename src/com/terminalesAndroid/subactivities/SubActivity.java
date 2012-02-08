package com.terminalesAndroid.subactivities;

import com.terminalesAndroid.subactivities.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends Activity {
	
	private EditText editText;
	
	public void onCreate( Bundle savedInstance ){
		super.onCreate(savedInstance);
		this.setContentView(R.layout.text);
		editText = (EditText) this.findViewById(R.id.edit);
		editText.setText(this.getIntent().getExtras().getString("text"));
	
		// Manejo boton ok
		Button ok = (Button) this.findViewById(R.id.bt_OK);
		ok.setOnClickListener(new OnClickListener(){

			
			public void onClick(View v) {
				Intent i = new Intent( SubActivity.this, SubActivity.class );
				i.putExtra("text", editText.getText());
				setResult( Activity.RESULT_OK, i );
				SubActivity.this.finish();
				
			}
			
		});
		// Manejo boton Cancelar
		Button cancel = (Button) this.findViewById(R.id.Bt_Cancel);
		cancel.setOnClickListener(new OnClickListener(){

		
			public void onClick(View v) {
				Intent i = new Intent( SubActivity.this, SubActivity.class );
				i.putExtra("text", editText.getText());
				setResult( Activity.RESULT_CANCELED, i );
				SubActivity.this.finish();
			}
			
		});
	}

}
