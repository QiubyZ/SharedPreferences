package com.mycompany.myapp.mylibs;
import android.content.*;
import android.content.SharedPreferences.*;
import java.util.*;
import android.app.*;
import android.preference.*;

public class myDBS{
	public static SharedPreferences data_user;
	public static SharedPreferences.Editor edit;
	
	public myDBS(Context c){
		data_user = PreferenceManager.getDefaultSharedPreferences(c);
		edit = data_user.edit();
	}
	public static void tambah_data(String KEYS, String VALUE){
		edit.putString(KEYS, VALUE).apply();
	}
	public static String mengambil_data(String KEYS){
		return data_user.getString(KEYS, null);
		
	}
	public static void hapus_data(String KEYS){
		edit.remove(KEYS).apply();
	}
}
