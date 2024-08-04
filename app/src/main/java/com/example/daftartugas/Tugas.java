package com.example.daftartugas;

import androidx.appcompat.app.AppCompatActivity;

// abstraksi
// membuat kelas abstrak Tugas
// kelas abstrak Tugas mewarisi kelas AppCompatActivity
public abstract class Tugas extends AppCompatActivity {
    private String judul;
    private String deskripsi;

    // constructor tanpa argumen sebagai constructor default
    public Tugas() {
    }

    // enkapsulasi
    // subclass yang mewarisi kelas abstrak Tugas harus menggunakan setter dan getter untuk mengakses atribut
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // metode abstrak untuk polimorfisme
    // metode ini tidak memiliki return tapi harus diwariskan oleh subclass
    public abstract String getDetails();
}
