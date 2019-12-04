package com.example.projectakhir.Adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectakhir.Model.CRUDDosen;
import com.example.projectakhir.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CRUDDOSENAdapter extends RecyclerView.Adapter<CRUDDOSENAdapter.ViewHolder>{
    Context context;
    ArrayList<CRUDDosen> dosenArrayList;
    //Array tambahan untuk picture
    // public static List<String> ic = new ArrayList<String>();


    public CRUDDOSENAdapter(ArrayList<CRUDDosen>dosenArrayList){
        this.dosenArrayList = dosenArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_d,
                parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100*i, 100*i);//menghubungkan data, data dari konstruktor .


        //holder.imgdos.setImageResource(dosenArrayList.get(position).getFoto());
        holder.imgdos.getLayoutParams().width=100;
        holder.imgdos.getLayoutParams().height=100;
        if(dosenArrayList.get(position).getFoto()!=null){
            Picasso.with(this.context).load("https://kpsi.fti.ukdw.ac.id/progmob/"+ dosenArrayList.get(position).getFoto()).into(holder.imgdos);
        }
        holder.txtNIDN.setText(dosenArrayList.get(position).getNama());
        holder.txtNama.setText(dosenArrayList.get(position).getNama());
        holder.txtGelar.setText(dosenArrayList.get(position).getGelar());
        holder.txtEmail.setText(dosenArrayList.get(position).getEmail());
        holder.txtAlamat.setText(dosenArrayList.get(position).getAlamat());


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
        return (dosenArrayList !=null)? dosenArrayList.size() :0;   //jika array mhs 0 maka akan kmbli ke ukuran array list awal
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    implements View.OnCreateContextMenuListener
    {
        private TextView txtGelar, txtEmail, txtAlamat, txtNama, txtNIDN;
        ImageView imgdos;

        public ViewHolder(View view){
            super(view);
            txtNama = view.findViewById(R.id.txtNama);
            txtNIDN=view.findViewById(R.id.txtNIDN);
            imgdos=view.findViewById(R.id.imgdos);
            txtGelar = view.findViewById(R.id.txtGelar);
            txtEmail = view.findViewById(R.id.txtEmail);
            txtAlamat = view.findViewById(R.id.txtAlamat);
            view.setOnCreateContextMenuListener(this);

//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    view.getContext().startActivity(new Intent(view.getContext(), EditDosenActivity.class));
//                }
//            });
            //Tambahan untuk id Picture
        }


        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo menuInfo) {
            contextMenu.setHeaderTitle("Pilih Aksi");
            contextMenu.add(this.getAdapterPosition(), view.getId(), 0, "Ubah Data Dosen");
            contextMenu.add(this.getAdapterPosition(), view.getId(), 0, "Hapus Data Dosen");
        }
    }
}
