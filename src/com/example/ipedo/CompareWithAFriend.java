package com.example.ipedo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CompareWithAFriend extends Activity implements OnClickListener {

	TextView clickToCompare;
	Button f1;
	Button f2;
	Button f3;
	Button f4;
	Button f5;
	Button f6;
	Button f7;
	Button f8;
	Button f9;
	Button f10;
	
	SQLiteDatabase ipedoDB;
	
	String name = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compare_with_afriend);
		
		clickToCompare = (TextView) findViewById(R.id.clickToCompare);
		f1 = (Button) findViewById(R.id.f1);
		f2 = (Button) findViewById(R.id.f2);
		f3 = (Button) findViewById(R.id.f3);
		f4 = (Button) findViewById(R.id.f4);
		f5 = (Button) findViewById(R.id.f5);
		f6 = (Button) findViewById(R.id.f6);
		f7 = (Button) findViewById(R.id.f7);
		f8 = (Button) findViewById(R.id.f8);
		f9 = (Button) findViewById(R.id.f9);
		f10 = (Button) findViewById(R.id.f10);
		
		f1.setOnClickListener(this);
		f2.setOnClickListener(this);
		f3.setOnClickListener(this);
		f4.setOnClickListener(this);
		f5.setOnClickListener(this);
		f6.setOnClickListener(this);
		f7.setOnClickListener(this);
		f8.setOnClickListener(this);
		f9.setOnClickListener(this);
		f10.setOnClickListener(this);
		
		clickToCompare.setText("Select to Compare");
		
		ipedoDB = openOrCreateDatabase("IPedoDB", Context.MODE_PRIVATE, null);
		ipedoDB.execSQL("CREATE TABLE IF NOT EXISTS FriendName (Name VARCHAR PRIMARY KEY);");
		Cursor resultSet = ipedoDB.rawQuery("Select Name from FriendName", null);
		if(resultSet.getCount() > 0) {
			Button temp = f1;
			resultSet.moveToFirst();
			int i = 1;
			while(!resultSet.isLast()) {
				String str = resultSet.getString(0);
				resultSet.moveToNext();
			    temp.setVisibility(View.VISIBLE);
			    temp.setText(str);
			    i++;
			    switch(i) {
			    case 2:
			    	temp = f2;
			    	break;
			    case 3:
			    	temp = f3;
			    	break;
			    case 4:
			    	temp = f4;
			    	break;
			    case 5:
			    	temp = f5;
			    	break;
			    case 6: 
			    	temp = f6;
			    	break;
			    case 7: 
			    	temp = f7;
			    	break;
			    case 8: 
			    	temp = f8;
			    	break;
			    case 9: 
			    	temp = f9;
			    	break;
			    case 10: 
			    	temp = f10;
			    	break;
			    } 
			}
			String str = resultSet.getString(0);
		    temp.setVisibility(View.VISIBLE);
		    temp.setText(str);
		    
		}
		resultSet.close();
		
		ipedoDB.execSQL("CREATE TABLE IF NOT EXISTS UserName (Name VARCHAR PRIMARY KEY);");
		resultSet = ipedoDB.rawQuery("Select Name from UserName", null);
		if(resultSet.getCount() > 0) {
			resultSet.moveToFirst();
			name = resultSet.getString(0);
		}
		resultSet.close();
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str = "";
		if(v.getId() == R.id.f1) {
			str = f1.getText().toString();
		}
		else if(v.getId() == R.id.f2) {
			str = f2.getText().toString();
		}
		else if(v.getId() == R.id.f3) {
			str = f3.getText().toString();
		}
		else if(v.getId() == R.id.f4) {
			str = f4.getText().toString();
		}
		else if(v.getId() == R.id.f5) {
			str = f5.getText().toString();
		}
		else if(v.getId() == R.id.f6) {
			str = f6.getText().toString();
		}
		else if(v.getId() == R.id.f7) {
			str = f7.getText().toString();
		}
		else if(v.getId() == R.id.f8) {
			str = f8.getText().toString();
		}
		else if(v.getId() == R.id.f9) {
			str = f9.getText().toString();
		}
		else if(v.getId() == R.id.f10) {
			str = f10.getText().toString();
		}
		Intent intent = new Intent(this, ShowComparison.class);
		intent.putExtra("YourName", name);
		intent.putExtra("FriendName", str);
		startActivity(intent);
	}
	
}
