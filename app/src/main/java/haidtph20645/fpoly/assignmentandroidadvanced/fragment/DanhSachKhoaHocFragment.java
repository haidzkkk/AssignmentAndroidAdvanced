package haidtph20645.fpoly.assignmentandroidadvanced.fragment;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import haidtph20645.fpoly.assignmentandroidadvanced.R;
import haidtph20645.fpoly.assignmentandroidadvanced.activity.DanhSachKhoaHocActivity;
import haidtph20645.fpoly.assignmentandroidadvanced.service.DangKyMonHocService;

public class DanhSachKhoaHocFragment extends Fragment {

    public DanhSachKhoaHocFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_danh_sach_khoa_hoc, null);


        return view;
    }
}
