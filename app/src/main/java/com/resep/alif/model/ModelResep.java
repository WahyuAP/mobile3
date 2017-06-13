package com.resep.alif.model;



public class ModelResep{
    private int gambarResep;
    private String namaResep;
    private String alamatResep;

    public ModelResep(int gambarResep, String namaResep, String alamatResep) {
        this.gambarResep = gambarResep;
        this.namaResep = namaResep;
        this.alamatResep = alamatResep;
    }
    public int getGambarResep() {
        return gambarResep;
    }

    public String getNamaResep() {
        return namaResep;
    }

    public String getAlamatResep(){
        return alamatResep;
    }
}