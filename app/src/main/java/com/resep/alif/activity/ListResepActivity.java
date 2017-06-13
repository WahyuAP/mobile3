package com.resep.alif.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.resep.alif.R;
import com.resep.alif.utilitas.DekorasiRecycleItem;
import com.resep.alif.utilitas.KumpulanData;
import com.resep.alif.utilitas.ListResepAdapter;

public class ListResepActivity extends AppCompatActivity {

    //inisialisasi
    private ImageView tombolKembali;
    private RecyclerView listResep;
    private ListResepAdapter listAdapter;
    private TextView judulResep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resep);

        Intent intent = getIntent();
        int posisi = intent.getIntExtra("posisi_kategori", 0);
        judulResep = (TextView) findViewById(R.id.judulResep);
        judulResep.setText(KumpulanData.kumpulanKategori[posisi].getNamaKategori());

        tombolKembali = (ImageView) findViewById(R.id.tombolKembali);
        tombolKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        listResep = (RecyclerView) findViewById(R.id.listResep);
        listAdapter = new ListResepAdapter(this, posisi);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listResep.setLayoutManager(layoutManager);
        listResep.setItemAnimator(new DefaultItemAnimator());
        listResep.addItemDecoration(new DekorasiRecycleItem(2, this));
        listResep.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
