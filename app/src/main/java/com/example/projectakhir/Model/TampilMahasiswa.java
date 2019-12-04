package com.example.projectakhir.Model;

public class TampilMahasiswa {
    private String nim;
    private String namaMhs;
    private String emailmhs;
    private String alamatmhs;
    private int imgMhs;

    public TampilMahasiswa(String nim, String namaMhs,  String emailmhs,String alamatmhs, int imgMhs){

        this.nim = nim;
        this.namaMhs = namaMhs;
        this.emailmhs =emailmhs;
        this.alamatmhs = alamatmhs;
        this.imgMhs = imgMhs;


    }

    public int getImgMhs(){
        return imgMhs;
    }
    public void setImgMhs(int imageResource) {
        this.imgMhs = imgMhs;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }


    public String getNamaMhs() {
        return namaMhs;
    }
    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getEmailmhs() {
        return emailmhs;
    }
    public void setEmailmhs(String emailmhs) {
        this.emailmhs = emailmhs;
    }

    public String getAlamatmhs() {
        return alamatmhs;
    }
    public void setAlamatmhs(String alamatmhs) {
        this.alamatmhs = alamatmhs;
    }



}
