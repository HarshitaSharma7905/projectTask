package com.example.projecttask;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
TextView id;
EditText name,type,language,status,runtime,average,premiered,dataend,official;
ImageView image;
Button update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        id=findViewById(R.id.id);
        image= findViewById(R.id.image);
        name= findViewById(R.id.name);
        type=findViewById(R.id.type);
        language=findViewById(R.id.type);
        status=findViewById(R.id.status);
        runtime=findViewById(R.id.runtime);
        average=findViewById(R.id.average);
        premiered=findViewById(R.id.premiered);
        dataend=findViewById(R.id.dataend);
        official=findViewById(R.id.official);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
//        DELETE:-----
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db=new DatabaseHelper(MainActivity2.this);
                db.deleteData(Integer.parseInt(id.getText().toString()));
                startActivity(getIntent());
            }
        });

        DatabaseHelper dataHelper=new DatabaseHelper(MainActivity2.this);
        DataModel list =dataHelper.fetchData();
        id.setText(list.getId());
        Picasso.get()
                .load(list.getUrl())
                .into(image);
        name.setText(list.getName());
        type.setText(list.getType());
        language.setText(list.getLanguage());
        status.setText(list.getStatus());
        runtime.setText(list.getRuntime());
        average.setText(list.getAverageRuntime());
        premiered.setText(list.getPremiered());
        dataend.setText(list.getEnded());
        official.setText(list.getOfficialSite());
//        update--------
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid=id.getText().toString();
             String uname=name.getText().toString();
             String uType=type.getText().toString();
             String uLanguage=language.getText().toString();
             String uStatus=status.getText().toString();
             String uRuntime=runtime.getText().toString();
             String uAverage=average.getText().toString();
             String uPremiered=premiered.getText().toString();
             String uDataEnd=dataend.getText().toString();
             String uOfficial=official.getText().toString();

               DatabaseHelper dbHelper =new DatabaseHelper(MainActivity2.this);
               dbHelper.updateData(uid,uname,uType,uLanguage,uStatus,uRuntime,uAverage,uPremiered,
                                    uDataEnd,uOfficial);
            }
        });

    }

}