package com.example.projectakhir.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CRUDDosen {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nidn")
    @Expose
    private String nidn;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("gelar")
    @Expose
    private String gelar;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("foto")
    @Expose
    private String foto;

    public CRUDDosen(String gelar, String email,  String alamat, String foto){

        this.gelar = gelar;
        this.email = email;
        this.alamat =alamat;
        this.foto = foto;

    }

    public CRUDDosen(String gelar, String email,  String nama, String nidn, String alamat, String foto,String id){
        this.id = id;
        this.nama= nama;
        this.nidn = nidn;
        this.gelar = gelar;
        this.email = email;
        this.alamat =alamat;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGelar() {
        return gelar;
    }
    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }



}
