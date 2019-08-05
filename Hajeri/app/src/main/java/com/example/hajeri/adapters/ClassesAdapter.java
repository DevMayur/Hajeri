package com.example.hajeri.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hajeri.CalenderActivity;
import com.example.hajeri.R;
import com.example.hajeri.models.ClassesModel;
import com.example.hajeri.StudentsList;

import java.util.List;

public class ClassesAdapter extends RecyclerView.Adapter<ClassesAdapter.ViewHolder> {

    private Context context;
    private List<ClassesModel> cList;

    public ClassesAdapter(Context context, List<ClassesModel> cList) {
        this.context = context;
        this.cList = cList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_class_division,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.className.setText(cList.get(i).getCLASS_NAME());
        viewHolder.teacherName.setText(cList.get(i).getTEACHER_NAME());
        viewHolder.dates.setText(cList.get(i).getSTART_DATE() + " " + cList.get(i).getEND_DATE());
        viewHolder.numberOfStudents.setText(cList.get(i).getNUMBER_OF_STUDENTS());
        final int position = i;
        viewHolder.students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentsList.class);
                intent.putExtra("class_name",cList.get(position).getCLASS_NAME());
                SharedPreferences sharedPreferences = context.getSharedPreferences("class_name",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("class_name",cList.get(position).getCLASS_NAME());
                editor.commit();

                context.startActivity(intent);
            }
        });


        viewHolder.attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CalenderActivity.class);
                intent.putExtra("class_name",cList.get(position).getCLASS_NAME());
                SharedPreferences sharedPreferences = context.getSharedPreferences("class_name",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("class_name",cList.get(position).getCLASS_NAME());
                editor.commit();

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView className,teacherName,dates,numberOfStudents;
        public Button students,attendance;
        public ImageButton options;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            className = itemView.findViewById(R.id.tv_classname_single_class);
            teacherName = itemView.findViewById(R.id.tv_teachername_single_class);
            dates = itemView.findViewById(R.id.tv_date_single_class);
            numberOfStudents = itemView.findViewById(R.id.tv_number_of_students_single_class);
            students = itemView.findViewById(R.id.bt_students_single_class);
            attendance = itemView.findViewById(R.id.bt_attendance_single_class);
            options = itemView.findViewById(R.id.ibt_options_single_class);

        }
    }
}
