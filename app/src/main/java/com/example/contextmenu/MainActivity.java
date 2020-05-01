package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] turkey;
    ArrayAdapter<String>adapter;
    ArrayList<String> arrayList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        registerForContextMenu(listView);
        turkey=getResources().getStringArray(R.array.turkey);
        adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.turkey_layout,R.id.row_item,arrayList);
        listView.setAdapter(adapter);
        for (String item:turkey){
            arrayList.add(item);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu,menu);


    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch(item.getItemId()){

            case R.id.delete:
                arrayList.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;
                default:
                    return super.onContextItemSelected(item);

        }




    }
}
