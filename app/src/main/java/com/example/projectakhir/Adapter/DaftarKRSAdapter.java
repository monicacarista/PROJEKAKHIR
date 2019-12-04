package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Model.CRUDDosen;
import com.example.projectakhir.Model.DaftarKRS;
import com.example.projectakhir.R;

import java.util.ArrayList;

public class DaftarKRSAdapter  extends RecyclerView.Adapter<DaftarKRSAdapter.ViewHolder> {
    Context context;
    ArrayList<DaftarKRS> krsArrayList;
    //Array tambahan untuk picture
    // public static List<String> ic = new ArrayList<String>();


    public DaftarKRSAdapter(ArrayList<DaftarKRS>krsArrayList){
        this.krsArrayList = krsArrayList;
    }

    @NonNull
    @Override
    public DaftarKRSAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_dftrkrs,
                parent, false);
        return new DaftarKRSAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarKRSAdapter.ViewHolder holder, final int position) {
        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100*i, 100*i);//menghubungkan data, data dari konstruktor .
        holder.txtHari.setText(krsArrayList.get(position).getHari());
        holder.txtSesi.setText(krsArrayList.get(position).getSesi());
        holder.txtJumlahSKS.setText(krsArrayList.get(position).getJumlah_sks());
        holder.txtDosenPengampu.setText(krsArrayList.get(position).getDosen_pengampu());
        holder.txtJumlahMhs.setText(krsArrayList.get(position).getJumlah_mhs());


//
//        holder.imgdos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Nama = dosenArrayList.get(position).getAlamat().toString();
//                Toast.makeText(context, Nama + " is selected", Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return (krsArrayList !=null)? krsArrayList.size() :0;   //jika array mhs 0 maka akan kmbli ke ukuran array list awal
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtHari, txtSesi, txtJumlahSKS, txtDosenPengampu, txtJumlahMhs;


        public ViewHolder(View view) {
            super(view);
            txtHari = view.findViewById(R.id.txtHari);
            txtSesi = view.findViewById(R.id.txtSesi);
            txtJumlahSKS = view.findViewById(R.id.txtJumlahSKS);
            txtDosenPengampu = view.findViewById(R.id.txtDosenPengampu);
            txtJumlahMhs = view.findViewById(R.id.txtJlhMhs);

//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    view.getContext().startActivity(new Intent(view.getContext(), EditDosenActivity.class));
//                }
//            });
            //Tambahan untuk id Picture
        }

    }
    }
