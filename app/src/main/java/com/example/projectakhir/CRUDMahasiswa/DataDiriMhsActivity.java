package com.example.projectakhir.CRUDMahasiswa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectakhir.AdminActivity;
import com.example.projectakhir.R;

public class DataDiriMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_diri_mhs);

        Button btnSimpanMhs =(Button)findViewById(R.id.btnSimpanMhs);

//        btnSimpanMhs.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Intent i = new Intent(DataDiriMhsActivity.this, TampilMahasiswaActivity.class);
//                startActivity(i);
//            }
//        });
        btnSimpanMhs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                AlertDialog.Builder builder = new AlertDialog.Builder(DataDiriMhsActivity.this);
                builder.setMessage("Apakah anda ingin menyimpan?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(DataDiriMhsActivity.this, AdminActivity.class);
                                startActivity(i);
                                Toast.makeText(DataDiriMhsActivity.this, "Tidak jadi Save",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(DataDiriMhsActivity.this, TampilMahasiswaActivity.class);
                                startActivity(i);

                                Toast.makeText(DataDiriMhsActivity.this, "Save Berhasil !!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
