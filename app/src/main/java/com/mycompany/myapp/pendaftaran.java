package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import com.mycompany.myapp.mylibs.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;

public class pendaftaran extends Activity
{

	
	public static String KEYS_USER = "USER";
	public static String KEYS_PASSWORD = "PASSWORD";
	public static myDBS DataUser;
	EditText username, password;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pendaftaran);
		DataUser = new myDBS(this);
		check_user_();
	
		submit = findViewById(R.id.pendaftaranButton1);
		username = findViewById(R.id.pendaftaranEditText1);
		password = findViewById(R.id.pendaftaranEditText2);
		
		
		submit.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View p1)
				{
		
					String form_user = username.getText().toString();
					String form_pass = password.getText().toString();
					if(form_user.length() < 1 && form_pass.length() != 1){
						pesan_Toast("Isi kedua Formulir");
					}
					else{
						masuk(form_user, form_pass);
					}
				}
			});
					
	}
	public void masuk(String user, String pass){
		DataUser.tambah_data(KEYS_USER, user);
		DataUser.tambah_data(KEYS_PASSWORD, pass);
		startActivity(new Intent(getApplicationContext(), beranda.class));
		finish();
	}
	public void pesan_Toast(String s){
		Toast.makeText(getApplicationContext(), s,1).show();
	}
	void check_user_(){
		/*Disini gw hanya mengambil patokan dari USERNAME dan PASSWORD yg terdaftar saja, kalau mau multi user? yaah pelajarin
		//Structure Data, lagian juga gw capek harus nyusun se komplex jidat tanpa bayaran juga
		ini yg buat gw fakum di Java, Syntaxnya panjang2 Babi
		*/
		if(myDBS.mengambil_data(KEYS_USER) != null && myDBS.mengambil_data(KEYS_PASSWORD) != null){
			startActivity(new Intent(this, beranda.class));
			finish();
		}
		else{
			pesan_Toast("Kamu belum daftar Niih, Naftar dulu");
		}
	}
}
