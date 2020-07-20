package com.industrialmaster.funapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp);
    }
    public void read(View v){
        List<String> names = new ArrayList<String>();
        ContentResolver cr = getContentResolver();

        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        if(cursor!=null){
            int i = 0;
            while(cursor.moveToNext()){
                int index1 = cursor.getColumnIndex(ContactsContract.Contacts._ID);
                String id = cursor.getString(index1);
                int index2 = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                String name = cursor.getString(index2);
                names.add(name);
                Toast.makeText(this, "ID"+id+"NAME"+name, Toast.LENGTH_SHORT).show();
                i++;
                if(i>10) {
                    break;
                }
            }
        }
        cursor.close();
        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter adapter = new ArrayAdapter(this,layout,names);
        ListView lv = findViewById(R.id.contact_list);
        lv.setAdapter(adapter);
    }
}
