package com.example.hajeri.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hajeri.R;
import com.example.hajeri.models.StudentModel;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    private Context context;
    private List<StudentModel> sList;

    public StudentAdapter(Context context, List<StudentModel> sList) {
        this.context = context;
        this.sList = sList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_student_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.tv_studentname.setText(sList.get(i).getNAME());
        viewHolder.tv_category.setText(sList.get(i).getCATEGORY());
        viewHolder.tv_gender.setText(sList.get(i).getGENDER());
        viewHolder.tv_gr_no.setText(sList.get(i).getREGISTER_NUMBER());

    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_studentname,tv_gr_no,tv_gender,tv_category;
        private Button bt_profile;
        private ImageButton ib_call,ib_options;
        private ImageView iv_profile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_studentname = itemView.findViewById(R.id.tv_student_name_single_student_item);
            tv_gr_no = itemView.findViewById(R.id.tv_gr_no_single_student_item);
            tv_gender = itemView.findViewById(R.id.tv_gender_single_student_item);
            tv_category = itemView.findViewById(R.id.tv_category_single_student_item);
            bt_profile = itemView.findViewById(R.id.bt_profile_single_student_item);
            ib_call = itemView.findViewById(R.id.ibt_call_single_student_item);
            ib_options = itemView.findViewById(R.id.ibt_options_single_student_item);
            iv_profile = itemView.findViewById(R.id.iv_profile_single_student_item);
        }
    }
}
