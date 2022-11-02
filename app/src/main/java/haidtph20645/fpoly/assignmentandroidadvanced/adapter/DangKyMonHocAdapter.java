package haidtph20645.fpoly.assignmentandroidadvanced.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import haidtph20645.fpoly.assignmentandroidadvanced.R;
import haidtph20645.fpoly.assignmentandroidadvanced.dao.DangKyMonHocDAO;
import haidtph20645.fpoly.assignmentandroidadvanced.model.MonHoc;
import haidtph20645.fpoly.assignmentandroidadvanced.model.ThongTin;
import haidtph20645.fpoly.assignmentandroidadvanced.service.DKMonHocService;

public class DangKyMonHocAdapter extends RecyclerView.Adapter<DangKyMonHocAdapter.ViewHolder>{

    Context context;
    List<MonHoc> list;
    DangKyMonHocDAO dangKyMonHocDAO;
    int id;
    boolean isAll;

    public DangKyMonHocAdapter(Context context, List<MonHoc> list, int id, boolean isAll) {
        this.context = context;
        this.list = list;
        dangKyMonHocDAO = new DangKyMonHocDAO(context);
        this.id = id;
        this.isAll = isAll;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dangkymonhoc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvname.setText(list.get(position).name);
        holder.tvcodeteach.setText(list.get(position).code + " | " + list.get(position).teacher);

        if (list.get(position).idRegister == id){
            holder.btn.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.btn_dangky_out));
            holder.btn.setText("Hủy đăng ký khóa học");
        }else {
            holder.btn.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.btn_dangky_in));
            holder.btn.setText("Đăng ký khóa học");
        }

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DKMonHocService.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                bundle.putString("code", list.get(holder.getAdapterPosition()).code);
                bundle.putInt("isRegister", list.get(holder.getAdapterPosition()).idRegister);
                bundle.putBoolean("isAll", isAll);
                intent.putExtras(bundle);
                context.startService(intent);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ThongTin> listTT = list.get(holder.getAdapterPosition()).list;
                String name = list.get(holder.getAdapterPosition()).name;
                showDialogDetail(name, listTT);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvname, tvcodeteach;
        Button btn;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.item_dangky_tv_name);
            tvcodeteach = itemView.findViewById(R.id.item_dangky_tv_code_teacher);
            btn = itemView.findViewById(R.id.item_dangky_btn);
            cardView = itemView.findViewById(R.id.item_dangky_cardview);
        }
    }

    public void showDialogDetail(String name,ArrayList<ThongTin> listTT){
        Dialog dialogDetail = new Dialog(context);
        dialogDetail.setContentView(R.layout.dialog_danh_sach_khoa_hoc_detail);
        dialogDetail.show();

        RecyclerView recyclerView = dialogDetail.findViewById(R.id.dialog_rcv_dangkymonhoc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        Dialog_DangKyMonHocAdapter adapter = new Dialog_DangKyMonHocAdapter(context, name, listTT);
        recyclerView.setAdapter(adapter);


    }

}
