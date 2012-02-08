package com.terminalesAndroid.subactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private static final int REQUEST_TEXT = 0;
	private TextView t;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		t = (TextView) this.findViewById(R.id.textView );
		
		// Manejo boton
        Button b = (Button) this.findViewById(R.id.launch );
        b.setOnClickListener(new OnClickListener( ){

			public void onClick(View v) {
				Intent i = new Intent( MainActivity.this, SubActivity.class );
				i.putExtra("text", t.getText());
				MainActivity.this.startActivityForResult(i, REQUEST_TEXT);
			}
        	
        });
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if ( requestCode == REQUEST_TEXT ){
			if ( resultCode == Activity.RESULT_OK ){	
				t.setText(data.getExtras().get("text").toString());
			}
		}
		
	}
}
