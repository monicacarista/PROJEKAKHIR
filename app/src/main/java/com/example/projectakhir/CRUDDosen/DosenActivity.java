package com.example.projectakhir.CRUDDosen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.projectakhir.AdminActivity;
import com.example.projectakhir.CRUDKRS.EditKRSActivity;
import com.example.projectakhir.CRUDKRS.TampilKRSActivity;
import com.example.projectakhir.CRUDMahasiswa.TampilMahasiswaActivity;
import com.example.projectakhir.LihatDataKelasActivity;
import com.example.projectakhir.MainActivity;
import com.example.projectakhir.R;


public class DosenActivity extends AppCompatActivity {
ImageButton imageButton;
    ImageButton imbDaftarKRS;
    ImageButton imbDataDiri;
    ImageButton imbLihatKelas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);

        ImageButton imbDaftarKRS = (ImageButton) findViewById(R.id.imbDaftarKRS);
        ImageButton imbDataDiri = (ImageButton) findViewById(R.id.imbDataDiri);
        ImageButton imbLihatKelas = (ImageButton) findViewById(R.id.imbLihatKelas);
        Button btnlogout = (Button) findViewById(R.id.btnLogout3);

        Button logOutButton = (Button)findViewById(R.id.btnLogout3);
        //resetButton.setOnClickListener(resetButtonListener);

        logOutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                AlertDialog.Builder builder = new AlertDialog.Builder(DosenActivity.this);
                builder.setMessage("Apakah anda yakin untuk Logout?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DosenActivity.this, "Tidak jadi Logout",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences prefs = DosenActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
                                String statusLogin = prefs.getString("isLogin",null);
                                SharedPreferences.Editor edit = prefs.edit();
                                edit.putString("isLogin", null);
                                edit.commit();
                                Intent i = new Intent(DosenActivity.this, MainActivity.class);
                                startActivity(i);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        imbDaftarKRS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(DosenActivity.this, TampilKRSActivity.class);
                startActivity(i);
            }
        });

        imbDataDiri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(DosenActivity.this, TampilMahasiswaActivity.class);
                startActivity(i);
            }
        });

        imbLihatKelas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(DosenActivity.this, LihatDataKelasActivity.class);
                startActivity(i);
            }
        });



    }
    
}
