package com.example.projectakhir.Model;

public class DaftarKRS {
    private String hari;
    private String sesi;
    private String jumlah_sks;
    private String dosen_pengampu;
    private String jumlah_mhs;

    public DaftarKRS(String hari, String sesi,  String jumlah_sks,String dosen_pengampu, String jumlah_mhs){

        this.hari = hari;
        this.sesi = sesi;
        this.jumlah_sks =jumlah_sks;
        this.dosen_pengampu = dosen_pengampu;
        this.jumlah_mhs =jumlah_mhs;

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

    public String getJumlah_sks() {
        return jumlah_sks;
    }
    public void setJumlah_sks(String jumlah_sks) {
        this.jumlah_sks = jumlah_sks;
    }

    public String getDosen_pengampu() {
        return dosen_pengampu;
    }
    public void setDosen_pengampu(String dosen_pengampu) {
        this.dosen_pengampu = dosen_pengampu;
    }

    public String getJumlah_mhs() {
        return jumlah_mhs;
    }
    public void setJumlah_mhs(String jumlah_mhs) {
        this.jumlah_mhs = jumlah_mhs;
    }


}
