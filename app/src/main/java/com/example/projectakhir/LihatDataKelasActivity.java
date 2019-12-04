package com.example.projectakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectakhir.Adapter.DaftarKRSAdapter;
import com.example.projectakhir.Adapter.LihatKelasAdapter;
import com.example.projectakhir.Model.DaftarKRS;
import com.example.projectakhir.Model.DaftarKelas;

import java.util.ArrayList;
import java.util.List;

public class LihatDataKelasActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LihatKelasAdapter LihatKelasAdapter;
    private ArrayList<DaftarKelas> daftarKelasArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_kelas);

        addData();

        recyclerView = findViewById(R.id.rvLihatKelas);
        LihatKelasAdapter = new LihatKelasAdapter(daftarKelasArrayList);
        List<DaftarKelas> daftarArrayList;


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatDataKelasActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(LihatKelasAdapter);

    }

    private void addData() {
        daftarKelasArrayList = new ArrayList<>();
        daftarKelasArrayList.add(new DaftarKelas("Senin", "2", "Willy", "60"));
    }
}
