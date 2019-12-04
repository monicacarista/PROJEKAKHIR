package com.example.projectakhir.CRUDMatkul;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectakhir.R;

public class EditMatkulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_matkul);
        Button btnSimpanMatkul =(Button)findViewById(R.id.btnSimpanMatkul);
        btnSimpanMatkul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                AlertDialog.Builder builder = new AlertDialog.Builder(EditMatkulActivity.this);
                builder.setMessage("Apakah anda ingin menyimpan?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(EditMatkulActivity.this, EditMatkulActivity.class);
                                startActivity(i);
                                Toast.makeText(EditMatkulActivity.this, "Tidak jadi Save",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(EditMatkulActivity.this, TampilMatkulActivity.class);
                                startActivity(i);

                                Toast.makeText(EditMatkulActivity.this, "Save Berhasil !!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
