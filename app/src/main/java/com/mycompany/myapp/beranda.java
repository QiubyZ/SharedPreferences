package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.mycompany.myapp.mylibs.*;
import android.content.*;

public class beranda extends Activity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.beranda);
		TextView welcome = findViewById(R.id.berandaTextView1);
		welcome.setText("Selamat Datang: " + String.valueOf(myDBS.mengambil_data(pendaftaran.KEYS_USER)));
		Button hapus = findViewById(R.id.berandaButton1);
		hapus.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					myDBS.hapus_data(pendaftaran.KEYS_USER);
					myDBS.hapus_data(pendaftaran.KEYS_PASSWORD);
					startActivity(new Intent(getApplicationContext(), pendaftaran.class));
					finish();
				}
			});
	}
}
