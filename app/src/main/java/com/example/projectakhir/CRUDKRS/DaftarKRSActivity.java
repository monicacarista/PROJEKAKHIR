package com.example.projectakhir.CRUDKRS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectakhir.Adapter.DaftarKRSAdapter;
import com.example.projectakhir.Model.DaftarKRS;
import com.example.projectakhir.R;

import java.util.ArrayList;
import java.util.List;

public class DaftarKRSActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DaftarKRSAdapter DaftarKRSAdapter;
    private ArrayList<DaftarKRS> daftarArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_krs);

        addData();

        recyclerView = findViewById(R.id.rvDaftarKRS);
        DaftarKRSAdapter = new DaftarKRSAdapter(daftarArrayList);
        List<DaftarKRS> daftarKRSList;
        //mahasiswaAdapter = new MahasiswaAdapter(List);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DaftarKRSActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(DaftarKRSAdapter);
        }
        private void addData(){
            daftarArrayList = new ArrayList<>();


            daftarArrayList.add(new DaftarKRS("Senin","2","3","Willy", "60"));
            //     crudArrayList.add(new CRUDDosen("S.Ko","m@gmail.com","JOGJA",R.drawable.xx));
            //     crudArrayList.add(new CRUDDosen("S.Km","m@gmail.com","JOGJA",R.drawable.xx));
            //     crudArrayList.add(new CRUDDosen("S.Kll","mo@gmail.com","JOGJA",R.drawable.xx));
            //  crudArrayList.add(new CRUDDosen("S.Km","monica@gmail.com","JOGJA",R.drawable.xx));
//
        }
    }


