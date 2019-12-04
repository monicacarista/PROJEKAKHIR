package com.example.projectakhir.CRUDMatkul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectakhir.Adapter.TampilMatkulAdapter;
import com.example.projectakhir.Model.TampilMatkul;
import com.example.projectakhir.R;

import java.util.ArrayList;

public class TampilMatkulActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TampilMatkulAdapter TampilMatkulAdapter;
    private ArrayList<TampilMatkul> tampilMatkulArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilmatkul);

        addData();

        recyclerView = findViewById(R.id.rvMatkul);
        TampilMatkulAdapter = new TampilMatkulAdapter(tampilMatkulArrayList);

        //mahasiswaAdapter = new MahasiswaAdapter(List);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TampilMatkulActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(TampilMatkulAdapter);
    }

    private void addData(){
        tampilMatkulArrayList = new ArrayList<>();


        tampilMatkulArrayList.add(new TampilMatkul("SI9999","IMK","Kamis","3", "3"));
        //     crudArrayList.add(new CRUDDosen("S.Ko","m@gmail.com","JOGJA",R.drawable.xx));
        //     crudArrayList.add(new CRUDDosen("S.Km","m@gmail.com","JOGJA",R.drawable.xx));
        //     crudArrayList.add(new CRUDDosen("S.Kll","mo@gmail.com","JOGJA",R.drawable.xx));
        //  crudArrayList.add(new CRUDDosen("S.Km","monica@gmail.com","JOGJA",R.drawable.xx));
//
    }
}
