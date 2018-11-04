package com.example.fez_1.roombd;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {
    private static final String DATABASE_NAME = "items_test_db";
    private static MyAppDataBase myAppDataBase;
    TextView txtDB;
    EditText txtID, txtFirst, txtLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppDataBase = Room.databaseBuilder(getApplicationContext(),MyAppDataBase.class , DATABASE_NAME).allowMainThreadQueries().build();
        txtDB = findViewById(R.id.txtDB);
        txtID = findViewById(R.id.txtID);
        txtFirst = findViewById(R.id.txtFirst);
        txtLast = findViewById(R.id.txtLast);

    }






    public void testSaveDB (View view){
    String first = txtFirst.getText().toString();
    String last = txtLast.getText().toString();
    Items book = new Items();
    book.setFirst(first);
    book.setLast(last);
    myAppDataBase.daoAccess().addItem(book);
    }
     public  void TestReadDB (View view){

         List<Items> items = myAppDataBase.daoAccess().getItems();
         String Temp = "";
         for (Items item : items){
                int id = item.getId();
             String first = item.getFirst();
             String last = item.getLast();
             Temp = Temp + "\n\n"+"ID :"+id+"\n First Name :"+first+"\n Last Name :" + last;



         }




         txtDB.setText(Temp);

     }

     public void DeleteDbItems(View view){
        int id = Integer.parseInt(txtID.getText().toString());
        Items item = new Items();
        item.setId(id);
        myAppDataBase.daoAccess().deleteitem(item);
        TestReadDB(null);
     }





}



