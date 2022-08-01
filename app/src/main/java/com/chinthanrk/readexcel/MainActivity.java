package com.chinthanrk.readexcel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public static String [] name=new String[189];
    public static String [] mano=new String[190];
    public static String [] qollanish=new String[190];
    public static String [] manba=new String[190];
    public static String aka;
    public static String uka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list);
        InputStream inputStream;
        AssetManager assetManager = getAssets();

        try {
            inputStream = assetManager.open("FileHandler.xls");

            POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);

            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);

            HSSFSheet mySheet = workbook.getSheetAt(0);

            for(int i=1;i<=153;i++){
                name[i-1]=mySheet.getRow(i).getCell(0).getStringCellValue();
            }
         /*   for(int i=1;i<=189;i++){
                mano[i-1]=mySheet.getRow(i).getCell(1).getStringCellValue();
            }
            for(int i=1;i<=189;i++){
                qollanish[i-1]=mySheet.getRow(i).getCell(2).getStringCellValue();
            }
            for(int i=1;i<=189;i++){
                manba[i-1]=mySheet.getRow(i).getCell(3).getStringCellValue();
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                       /* aka=mano[i];*/
                }
            }
        });
    }
}