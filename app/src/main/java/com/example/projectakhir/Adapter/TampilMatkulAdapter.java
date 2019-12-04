package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Model.DaftarKRS;
import com.example.projectakhir.Model.TampilMatkul;
import com.example.projectakhir.R;

import java.util.ArrayList;

public class TampilMatkulAdapter  extends RecyclerView.Adapter<TampilMatkulAdapter.ViewHolder>{
    Context context;
    ArrayList<TampilMatkul> tampilMatkulArrayList;


    public TampilMatkulAdapter(ArrayList<TampilMatkul>tampilMatkulArrayList){
        this.tampilMatkulArrayList = tampilMatkulArrayList;
    }

    @NonNull
    @Override
    public TampilMatkulAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_tampilmatkul,
                parent, false);
        return new TampilMatkulAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TampilMatkulAdapter.ViewHolder holder, final int position) {
        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100*i, 100*i);//menghubungkan data, data dari konstruktor .
        holder.txtKode.setText(tampilMatkulArrayList.get(position).getKode());
        holder.txtMatkul.setText(tampilMatkulArrayList.get(position).getMatkul());
        holder.txtHari.setText(tampilMatkulArrayList.get(position).getHari());
        holder.txtSesi.setText(tampilMatkulArrayList.get(position).getSesi());
        holder.txtJumlahSks.setText(tampilMatkulArrayList.get(position).getJumlahsks());

    }

    @Override
    public int getItemCount() {
        return (tampilMatkulArrayList !=null)? tampilMatkulArrayList.size() :0;   //jika array mhs 0 maka akan kmbli ke ukuran array list awal
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtKode, txtMatkul, txtHari, txtSesi, txtJumlahSks;


        public ViewHolder(View view) {
            super(view);
            txtKode = view.findViewById(R.id.txtKodeMatkul);
            txtMatkul = view.findViewById(R.id.txtMatkul);
            txtHari = view.findViewById(R.id.txtHariMatkul);
            txtSesi = view.findViewById(R.id.txtSesiMatkul);
            txtJumlahSks = view.findViewById(R.id.txtJumlahSks);

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
