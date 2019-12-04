package com.example.projectakhir.CRUDDosen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectakhir.Adapter.CRUDDOSENAdapter;
import com.example.projectakhir.Model.CRUDDosen;
import com.example.projectakhir.Model.DefaultResult;
import com.example.projectakhir.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.projectakhir.Network.GetDataService;
import com.example.projectakhir.Network.RetrofitClientInstance;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class CRUDDosenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CRUDDOSENAdapter CRUDDOSENAdapter;
    private ArrayList<CRUDDosen> crudArrayList;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruddosen);


        recyclerView = findViewById(R.id.rvCruddos);

        Button btnCreate = (Button) findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CRUDDosenActivity.this, EditDosenActivity.class);
                startActivity(i);
            }
        });

        //addData();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Load..");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<CRUDDosen>> call = service.getDosenAll("72170133");
        call.enqueue(new Callback<ArrayList<CRUDDosen>>() {
            @Override
            public void onResponse(Call<ArrayList<CRUDDosen>> call, Response<ArrayList<CRUDDosen>> response) {
                progressDialog.dismiss();
                crudArrayList = response.body();
                CRUDDOSENAdapter = new CRUDDOSENAdapter(response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CRUDDosenActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(CRUDDOSENAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<CRUDDosen>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CRUDDosenActivity.this, "Login Gagal", Toast.LENGTH_SHORT);
            }
        });
        registerForContextMenu(recyclerView);


//        CRUDDOSENAdapter = new CRUDDOSENAdapter(crudArrayList);
//        List<CRUDDosen> crudDosenList;
        //mahasiswaAdapter = new MahasiswaAdapter(List);

    }




    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        CRUDDosen dosen = crudArrayList.get(item.getGroupId());
        if (item.getTitle() == "Ubah Data Dosen") {
            Intent intent = new Intent(CRUDDosenActivity.this, EditDosenActivity.class);
            intent.putExtra("id_dosen", dosen.getId());
            intent.putExtra("nama_dosen", dosen.getNama());
            intent.putExtra("nidn", dosen.getNidn());
            intent.putExtra("alamat_dosen", dosen.getAlamat());
            intent.putExtra("email_dosen", dosen.getEmail());
            intent.putExtra("gelar", dosen.getGelar());
            intent.putExtra("foto", dosen.getFoto());
            intent.putExtra("is_update", true);
            startActivity(intent);

        } else if (item.getTitle() == "Hapus Data Dosen") {
            progressDialog = new ProgressDialog(CRUDDosenActivity.this);
            progressDialog.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_dosen(
                    dosen.getId(), "72170133"
            );
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(CRUDDosenActivity.this, "Data terhapus", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CRUDDosenActivity.this, CRUDDosenActivity.class);
                    startActivity(intent);
                    finish();
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(CRUDDosenActivity.this, "Data gagal  terhapus", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return super.onContextItemSelected(item);
    }
}


