package haidtph20645.fpoly.assignmentandroidadvanced.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haidtph20645.fpoly.assignmentandroidadvanced.R;
import haidtph20645.fpoly.assignmentandroidadvanced.dao.DangKyMonHocDAO;
import haidtph20645.fpoly.assignmentandroidadvanced.model.MonHoc;
import haidtph20645.fpoly.assignmentandroidadvanced.model.ThongTin;

public class Dialog_DangKyMonHocAdapter extends RecyclerView.Adapter<Dialog_DangKyMonHocAdapter.ViewHolder>{

    Context context;
    List<ThongTin> list;
    String name;

    public Dialog_DangKyMonHocAdapter(Context context,String name, List<ThongTin> list) {
        this.context = context;
        this.name = name;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_item_dangkymonhoc, parent, false);
        return new Dialog_DangKyMonHocAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvaddress.setText(list.get(position).address);
        holder.tvname.setText( name);
        holder.tvdate.setText(list.get(position).date);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvaddress, tvname, tvdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvaddress = itemView.findViewById(R.id.dialog_item_tv_adress);
            tvname = itemView.findViewById(R.id.dialog_item_tv_name);
            tvdate = itemView.findViewById(R.id.dialog_item_tv_date);
        }
    }
}
