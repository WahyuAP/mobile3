package com.resep.alif.utilitas;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.resep.alif.activity.PembukaResepActivity;
import com.resep.alif.R;

public class ListResepAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private int posisi;

    public ListResepAdapter(Context context, int posisi) {
        this.context = context;
        this.posisi = posisi;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<>(new ListResepAdapter.RecycleWrapperTiapItem(context));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holders, final int position) {
        final RecycleWrapperTiapItem holder = (RecycleWrapperTiapItem) holders.itemView;
        holder.gambarKategori.setImageResource(KumpulanData.kumpulanKategori[posisi].getModelResep()[position].getGambarResep());
        holder.namaKategori.setText(KumpulanData.kumpulanKategori[posisi].getModelResep()[position].getNamaResep());
        holder.penampungList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PembukaResepActivity.class);
                intent.putExtra("posisi_resep", position);
                intent.putExtra("posisi_kategori", posisi);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return KumpulanData.kumpulanKategori[posisi].getModelResep().length;
    }

    class RecycleWrapperTiapItem extends FrameLayout {
        private ImageView gambarKategori;
        private TextView namaKategori;
        private CardView penampungList;
        public RecycleWrapperTiapItem(Context context) {
            super(context);
            inflate(context, R.layout.design_kategori, this);
            gambarKategori = (ImageView) findViewById(R.id.gambarKategori);
            namaKategori = (TextView) findViewById(R.id.namaKategori);
            penampungList = (CardView) findViewById(R.id.penampunglist);
        }
    }
}
