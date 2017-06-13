package com.resep.alif.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.resep.alif.R;
import com.resep.alif.utilitas.KumpulanData;

public class PembukaResepActivity extends AppCompatActivity {

    private ImageView tombolKembali;
    private WebView webView;
    private TextView namaResep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembuka_resep);


        Intent intent = getIntent();
        int posisiResep = intent.getIntExtra("posisi_resep", 0);
        int posisiKategori = intent.getIntExtra("posisi_kategori", 0);

        namaResep = (TextView) findViewById(R.id.namaResep);
        namaResep.setText(KumpulanData.kumpulanKategori[posisiKategori].getModelResep()[posisiResep].getNamaResep());

        tombolKembali = (ImageView) findViewById(R.id.tombolKembali);
        tombolKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        webView = (WebView) findViewById(R.id.webviw);
        webView.loadUrl("file:///android_asset/" + KumpulanData.kumpulanKategori[posisiKategori].getModelResep()[posisiResep].getAlamatResep());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
