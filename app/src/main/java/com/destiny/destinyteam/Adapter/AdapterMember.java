package com.destiny.destinyteam.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destiny.destinyteam.Activity.PDFViewerActivity;
import com.destiny.destinyteam.Model.MemberModel;
import com.destiny.destinyteam.R;

import java.util.ArrayList;

public class AdapterMember extends RecyclerView.Adapter<AdapterMember.CardViewViewHolder>{
    private Context context;
    private ArrayList<MemberModel> listMember;
    private ArrayList<MemberModel> getListMember() {
        return listMember;
    }
    public void setListMember(ArrayList<MemberModel> listMember) {
        this.listMember = listMember;
    }
    public AdapterMember(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_member, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder cardViewViewHolder, int i) {
        final MemberModel p = getListMember().get(i);

        cardViewViewHolder.imgPhoto.setImageResource(Integer.parseInt(p.getGambar()));
        cardViewViewHolder.nama.setText(p.getNama());
        cardViewViewHolder.pendidikanterakhir.setText(p.getPendidikanTerakhir());
        cardViewViewHolder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goInput = new Intent(context, PDFViewerActivity.class);
                goInput.putExtra("PDF",p.getCv());
                context.startActivities(new Intent[]{goInput});
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMember().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        Button detail;
        TextView nama,alamat,pendidikanterakhir,email;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.ivFotoProfil);
            nama = itemView.findViewById(R.id.tvNama);
            pendidikanterakhir = itemView.findViewById(R.id.tvPendidikanTerakhir);
            detail = itemView.findViewById(R.id.btnDetail);
        }
    }
}


