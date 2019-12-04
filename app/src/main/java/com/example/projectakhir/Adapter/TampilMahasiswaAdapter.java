package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Model.DaftarKRS;
import com.example.projectakhir.Model.TampilMahasiswa;
import com.example.projectakhir.R;

import java.util.ArrayList;

public class TampilMahasiswaAdapter  extends RecyclerView.Adapter<TampilMahasiswaAdapter.ViewHolder> {
    Context context;
    ArrayList<TampilMahasiswa> tampilMahasiswaArrayList;
    //Array tambahan untuk picture
    // public static List<String> ic = new ArrayList<String>();


    public TampilMahasiswaAdapter(ArrayList<TampilMahasiswa>tampilMahasiswaArrayList){
        this.tampilMahasiswaArrayList = tampilMahasiswaArrayList;
    }

    @NonNull
    @Override
    public TampilMahasiswaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_mhs,
                parent, false);
        return new TampilMahasiswaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TampilMahasiswaAdapter.ViewHolder holder, final int position) {
        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100*i, 100*i);//menghubungkan data, data dari konstruktor .
        holder.txtNim.setText(tampilMahasiswaArrayList.get(position).getNim());
        holder.txtNamaMhs.setText(tampilMahasiswaArrayList.get(position).getNamaMhs());
        holder.txtEmailMhs.setText(tampilMahasiswaArrayList.get(position).getEmailmhs());
        holder.txtAlamatMhs.setText(tampilMahasiswaArrayList.get(position).getAlamatmhs());
        holder.imgMhs.setImageResource(tampilMahasiswaArrayList.get(position).getImgMhs());



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
        return (tampilMahasiswaArrayList !=null)? tampilMahasiswaArrayList.size() :0;   //jika array mhs 0 maka akan kmbli ke ukuran array list awal
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNim, txtNamaMhs, txtEmailMhs, txtAlamatMhs;
        ImageView imgMhs;

        public ViewHolder(View view) {
            super(view);
            txtNim = view.findViewById(R.id.txtNIMmhs);
            txtNamaMhs = view.findViewById(R.id.txtNamaMhs);
            txtEmailMhs = view.findViewById(R.id.txtEmailMhs);
            txtAlamatMhs = view.findViewById(R.id.txtAlamatMhs);
            imgMhs = view.findViewById(R.id.imgMhs);

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
