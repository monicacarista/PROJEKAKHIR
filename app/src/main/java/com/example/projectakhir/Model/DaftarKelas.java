package com.example.projectakhir.Model;

public class DaftarKelas {
    private String hari1;
    private String sesi1;
    private String dosen_pengampu1;
    private String jumlah_mhs1;

    public DaftarKelas(String hari1, String sesi1,  String dosen_pengampu1, String jumlah_mhs1){

        this.hari1= hari1;
        this.sesi1 = sesi1;
        this.dosen_pengampu1 = dosen_pengampu1;
        this.jumlah_mhs1 =jumlah_mhs1;

    }
    public String getHari1() {
        return hari1;
    }
    public void setHari1(String hari1) {
        this.hari1 = hari1;
    }


    public String getSesi1() {
        return sesi1;
    }
    public void setSesi1(String sesi1) {
        this.sesi1 = sesi1;
    }


    public String getDosen_pengampu1() {
        return dosen_pengampu1;
    }
    public void setDosen_pengampu1(String dosen_pengampu1) {
        this.dosen_pengampu1 = dosen_pengampu1;
    }

    public String getJumlah_mhs1() {
        return jumlah_mhs1;
    }
    public void setJumlah_mhs1(String jumlah_mhs1) {
        this.jumlah_mhs1 = jumlah_mhs1;
    }

}
