package com.resep.alif.model;


public class ModelKategori{
    private int gambarKategori;
    private String namaKategori;
    private ModelResep[] modelResep;

    public ModelKategori(int gambarKategori, String namaKategori, ModelResep[] modelResep) {
        this.gambarKategori = gambarKategori;
        this.namaKategori = namaKategori;
        this.modelResep = modelResep;
    }

    public int getGambarKategori() {
        return gambarKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public ModelResep[] getModelResep() {
        return modelResep;
    }
}

