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

import com.resep.alif.activity.ListResepActivity;
import com.resep.alif.R;

public class ListKategoriAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;

    public ListKategoriAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<>(new RecycleWrapperTiapItem(context));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holders, final int position) {
        final RecycleWrapperTiapItem holder = (RecycleWrapperTiapItem) holders.itemView;
        holder.gambarKategori.setImageResource(KumpulanData.kumpulanKategori[position].getGambarKategori());
        holder.namaKategori.setText(KumpulanData.kumpulanKategori[position].getNamaKategori());
        holder.penampungList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListResepActivity.class);
                intent.putExtra("posisi_kategori", position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return KumpulanData.kumpulanKategori.length;
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
