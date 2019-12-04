package com.example.projectakhir.CRUDKRS;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectakhir.R;

public class EditKRSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_krs);

        Button btnSimpanKRS =(Button)findViewById(R.id.btnSimpanKRS);

//        btnSimpanKRS.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Intent i = new Intent(EditKRSActivity.this, DaftarKRSActivity.class);
//                startActivity(i);
//            }
//        });

        btnSimpanKRS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                AlertDialog.Builder builder = new AlertDialog.Builder(EditKRSActivity.this);
                builder.setMessage("Apakah anda ingin menyimpan?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(EditKRSActivity.this,EditKRSActivity.class);
                                startActivity(i);
                                Toast.makeText(EditKRSActivity.this, "Tidak jadi Save",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(EditKRSActivity.this, DaftarKRSActivity.class);
                                startActivity(i);

                                Toast.makeText(EditKRSActivity.this, "Save Berhasil !!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
