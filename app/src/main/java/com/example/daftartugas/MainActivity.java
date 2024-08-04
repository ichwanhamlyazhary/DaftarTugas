package com.example.daftartugas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

// pewarisan
// kelas MainActivity mewarisi kelas abstrak Tugas
public class MainActivity extends Tugas {

    // inisialisasi variabel
    EditText editJudul, editDeskripsi;
    Button btnTambah;
    ListView listTugas;
    ArrayList<String> dataTugas;
    ArrayAdapter<String> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // inisialisasi sumber nilai variabel
        editJudul = (EditText) findViewById(R.id.editJudul);
        editDeskripsi = (EditText) findViewById(R.id.editDeskripsi);
        btnTambah = (Button) findViewById(R.id.btnTambahTugas);
        listTugas = (ListView) findViewById(R.id.listTugas);

        // instansiasi objek TugasKuliah
        Tugas TugasKuliah = new MainActivity();

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String judul = editJudul.getText().toString();
                String deskripsi = editDeskripsi.getText().toString();

                // mengisi atribut menggunakan setter
                TugasKuliah.setJudul(judul);
                TugasKuliah.setDeskripsi(deskripsi);

                String detail = TugasKuliah.getDetails();

                dataAdapter.add(detail);
                editJudul.setText("");
                editDeskripsi.setText("");
            }
        });

        dataTugas = new ArrayList<>();
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataTugas);
        listTugas.setAdapter(dataAdapter);
    }

    // mengakses constructor tanpa argumen
    public MainActivity(){
    }

    @Override
    // polimorfisme
    public String getDetails() {
        // mengakses atribut menggunakan getter
        return getJudul() + "\n" + getDeskripsi();
    }
}