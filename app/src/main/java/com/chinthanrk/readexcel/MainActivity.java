package com.chinthanrk.readexcel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String > adapter;
    public static String [] name=new String[152];
    public static String [] mano=new String[152];
    public static String [] qollanish=new String[152];
    public static String aka;
    public static String uka;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog=new Dialog(this);
        listView=findViewById(R.id.list);
        InputStream inputStream;
        AssetManager assetManager = getAssets();

        try {
            inputStream = assetManager.open("FileHandler.xls");

            POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);

            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);

            HSSFSheet mySheet = workbook.getSheetAt(0);

            for(int i=1;i<=152;i++){
                name[i-1]=mySheet.getRow(i).getCell(0).getStringCellValue();
            }
            for(int i=1;i<=152;i++){
                mano[i-1]=mySheet.getRow(i).getCell(1).getStringCellValue();
            }
            for(int i=1;i<=152;i++){
                qollanish[i-1]=mySheet.getRow(i).getCell(2).getStringCellValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            aka=mano[i];
            uka=qollanish[i];
            dialog.setContentView(R.layout.play);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
    }
    public void clickmano(View view){
        startActivity(new Intent(MainActivity.this,Manosi.class));
    }
    public void clickqollanish(View view){
        startActivity(new Intent(MainActivity.this,qollanishi.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView;
        searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}