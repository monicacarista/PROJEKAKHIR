package com.example.projectakhir.CRUDDosen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectakhir.Model.DefaultResult;
import com.example.projectakhir.AdminActivity;
import com.example.projectakhir.Model.DefaultResult;
import com.example.projectakhir.Network.GetDataService;
import com.example.projectakhir.Network.RetrofitClientInstance;
import com.example.projectakhir.R;
import com.squareup.picasso.Picasso;


import java.io.ByteArrayOutputStream;
import java.sql.BatchUpdateException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class EditDosenActivity extends AppCompatActivity {
ProgressDialog pd;
EditText nidn, nama, gelar, alamat, email , foto;
String idDosen = "";
String stringImg;
private ImageView imgDosen;
private static final int GALLERY_REQUEST_CODE=58;
private static final int FILE_ACCESS_REQUEST_CODE=58;
String sfoto = "";
    GetDataService service;
    Boolean isUpdate = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dosen);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE}, FILE_ACCESS_REQUEST_CODE);
        }
        nama = (EditText)findViewById(R.id.etxtNamaDosen);
        nidn = (EditText)findViewById(R.id.etxtNidnDosen);
        alamat = (EditText)findViewById(R.id.etxtAlamatDosen);
        email = (EditText)findViewById(R.id.etxtEmailDosen);
        gelar = (EditText)findViewById(R.id.etxtGelarDosen);
        foto = (EditText)findViewById(R.id.etxtFoto);
       // EditText txtNidn = (EditText) findViewById(R.id.txtNIDN);
        this.setTitle("SI KRS - Hai Dosen");

        pd = new ProgressDialog(this);

        checkUpdate();
        Button btnBrowse = findViewById(R.id.btnBrowse);
        Button btnSimpanDosen = findViewById(R.id.btnSimpanDosen);

        if(isUpdate){
            btnSimpanDosen.setText("Update");
        }

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                String[]mimeTypes = {"image/jpeg"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
                startActivityForResult(intent,GALLERY_REQUEST_CODE);
            }
        });
      //  Button btnUpload = findViewById(R.id.btnUpload);

        btnSimpanDosen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                AlertDialog.Builder builder = new AlertDialog.Builder(EditDosenActivity.this);
                builder.setMessage("Apakah anda ingin menyimpan?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(EditDosenActivity.this, AdminActivity.class);
                                startActivity(i);
                                Toast.makeText(EditDosenActivity.this, "Tidak jadi Save",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(!isUpdate){
                                    if(isUpdate){
                                        pd = new ProgressDialog(EditDosenActivity.this);
                                        pd.show();


                                        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                        Call<DefaultResult> call = service.insert_dosen(nama.getText().toString(),
                                                nidn.getText().toString(), alamat.getText().toString(),
                                                email.getText().toString(), gelar.getText().toString(), stringImg, "72170133");
                                        call.enqueue(new Callback<com.example.projectakhir.Model.DefaultResult>() {
                                            @Override
                                            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                                                pd.dismiss();
                                                Toast.makeText(EditDosenActivity.this, "Data tersimpan",
                                                        Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(EditDosenActivity.this,CRUDDosenActivity.class);
                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onFailure(Call<DefaultResult> call, Throwable t) {
                                                Toast.makeText(EditDosenActivity.this, "GAGALLLLL",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }else{
                                        pd = new ProgressDialog(EditDosenActivity.this);
                                        pd.show();

                                        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                        Call<DefaultResult> call = service.update_dosen(idDosen, nama.getText().toString(),
                                                nidn.getText().toString(),
                                                alamat.getText().toString(),
                                                email.getText().toString(),
                                                gelar.getText().toString(),
                                                foto.getText().toString(),"72170133");
                                        call.enqueue(new Callback<DefaultResult>() {
                                            @Override
                                            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                                                pd.dismiss();
                                                Toast.makeText(EditDosenActivity.this, "Data tersimpan", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(EditDosenActivity.this, CRUDDosenActivity.class);
                                                startActivity(intent);
//                                                finish();
//                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onFailure(Call<DefaultResult> call, Throwable t) {
                                                pd.dismiss();
                                                Toast.makeText(EditDosenActivity.this, "Data gagal  teredit", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                }

//                                Intent i = new Intent(EditDosenActivity.this, CRUDDosenActivity.class);
//                                startActivity(i);
//
//                                Toast.makeText(EditDosenActivity.this, "Save Berhasil !!",
//                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case FILE_ACCESS_REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0]==PERMISSION_GRANTED){

                }
                break;
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case GALLERY_REQUEST_CODE:
                    Uri selectedImage = data.getData();
                    imgDosen.setImageURI(selectedImage);

                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String imgDecodableString = cursor.getString(columnIndex);
                    foto.setText(imgDecodableString);
                    cursor.close();

                    Bitmap bm = BitmapFactory.decodeFile(imgDecodableString);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] b = baos.toByteArray();
                    stringImg = Base64.encodeToString(b, Base64.DEFAULT);
                    break;
            }
    }

    void checkUpdate(){
        Bundle extras = getIntent().getExtras();
        if(extras == null){
            return;
        }

        //get data via the key
        isUpdate = extras.getBoolean("is_update");
        idDosen = extras.getString("id_dosen");
        nama.setText(extras.getString("nama_dosen"));
        nidn.setText(extras.getString("nidn"));
        alamat.setText(extras.getString("alamat_dosen"));
        email.setText(extras.getString("email"));
        gelar.setText(extras.getString("gelar"));
        foto.setText(extras.getString("foto"));

//        sfoto= extras.getString("foto");
//        Picasso.with(EditDosenActivity.this).load("https://kpsi.fti.ukdw.ac.id/progmob/"+ extras.getString("foto")).into(imgDosen);
    }
}
