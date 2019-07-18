package com.nada.psikologiku.model;

public class History {
    private int id;
    private String nama;
    private String hasilKlasifikasi;
    private String metode;

    public History() {

    }
    public History(int id, String nama, String hasilKlasifikasi, String metode) {
        this.id = id;
        this.nama = nama;
        this.hasilKlasifikasi = hasilKlasifikasi;
        this.metode = metode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHasilKlasifikasi() {
        return hasilKlasifikasi;
    }

    public void setHasilKlasifikasi(String hasilKlasifikasi) {
        this.hasilKlasifikasi = hasilKlasifikasi;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
