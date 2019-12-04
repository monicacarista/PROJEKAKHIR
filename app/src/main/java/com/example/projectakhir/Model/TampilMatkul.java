package com.example.projectakhir.Model;

public class TampilMatkul {
    private String kode;
    private String matkul;
    private String hari;
    private String sesi;
    private String jumlahsks;

    public TampilMatkul(String kode, String matkul,  String hari,String sesi, String jumlahsks){

        this.kode = kode;
        this.matkul = matkul;
        this.hari =hari;
        this.sesi = sesi;
        this.jumlahsks =jumlahsks;

    }
    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }


    public String getMatkul() {
        return matkul;
    }
    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getHari() {
        return hari;
    }
    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getSesi() {
        return sesi;
    }
    public void setSesi(String sesi) {
        this.sesi = sesi;
    }

    public String getJumlahsks() {
        return jumlahsks;
    }
    public void setJumlahsks(String jumlahsks) {
        this.jumlahsks = jumlahsks;
    }

}
