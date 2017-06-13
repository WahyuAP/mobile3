package com.resep.alif.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.resep.alif.R;
import com.resep.alif.utilitas.DekorasiRecycleItem;
import com.resep.alif.utilitas.ListKategoriAdapter;

public class ListKategoriActivity extends AppCompatActivity {

    //deklarasi list
    private RecyclerView listKategori;
    private ListKategoriAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi
        listKategori = (RecyclerView) findViewById(R.id.listKategori);

        listAdapter = new ListKategoriAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listKategori.setLayoutManager(layoutManager);
        listKategori.setItemAnimator(new DefaultItemAnimator());
        listKategori.addItemDecoration(new DekorasiRecycleItem(2, this));
        listKategori.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
