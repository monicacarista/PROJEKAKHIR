package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Model.DaftarKRS;
import com.example.projectakhir.Model.DaftarKelas;
import com.example.projectakhir.R;

import java.util.ArrayList;

public class LihatKelasAdapter extends RecyclerView.Adapter<LihatKelasAdapter.ViewHolder>{
    Context context;
    ArrayList<DaftarKelas> daftarKelasArrayList;
    //Array tambahan untuk picture
    // public static List<String> ic = new ArrayList<String>();


    public LihatKelasAdapter(ArrayList<DaftarKelas>daftarKelasArrayList){
        this.daftarKelasArrayList = daftarKelasArrayList;
    }

    @NonNull
    @Override
    public LihatKelasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_lihatkelas,
                parent, false);
        return new LihatKelasAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LihatKelasAdapter.ViewHolder holder, final int position) {
        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100*i, 100*i);//menghubungkan data, data dari konstruktor .
        holder.txtHari1.setText(daftarKelasArrayList.get(position).getHari1());
        holder.txtSesi1.setText(daftarKelasArrayList.get(position).getSesi1());
        holder.txtDosenPengampu1.setText(daftarKelasArrayList.get(position).getDosen_pengampu1());
        holder.txtJumlahMhs1.setText(daftarKelasArrayList.get(position).getJumlah_mhs1());


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
        return (daftarKelasArrayList !=null)? daftarKelasArrayList.size() :0;   //jika array mhs 0 maka akan kmbli ke ukuran array list awal
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtHari1, txtSesi1,  txtDosenPengampu1, txtJumlahMhs1;


        public ViewHolder(View view) {
            super(view);
            txtHari1 = view.findViewById(R.id.txtHari1);
            txtSesi1 = view.findViewById(R.id.txtSesi1);
            txtDosenPengampu1 = view.findViewById(R.id.txtDosenPengampu1);
            txtJumlahMhs1= view.findViewById(R.id.txtJlhMhs1);

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
