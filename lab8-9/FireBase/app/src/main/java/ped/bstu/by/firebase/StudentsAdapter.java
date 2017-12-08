package ped.bstu.by.firebase;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ped.bstu.by.firebase.Activities.EditProfileActivity;

/**
 * Created by Egor on 30.11.2017.
 */

public class StudentsAdapter {

    /*

    private List<Student> studentList;

    Context context;

    int resource;

    public StudentsAdapter(Context context, int resource, List<Student> studentList) {
        super(context, resource, studentList);
        this.context = context;
        this.resource = resource;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        return view;
    }

    private void showStudent(final int postition) {
        Intent intent = new Intent(getContext(), EditProfileActivity.class);
    }

    private void removeStudent(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                studentList.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView mName, mMark;
        ImageView mPhoto;
        CardView mCardView;

        public StudentViewHolder(View view) {
            super(view);

            mCardView = view.findViewById(R.id.cardView);
            mPhoto = view.findViewById(R.id.photo_imageView);
            mMark = view.findViewById(R.id.mark_textView);
            mName = view.findViewById(R.id.name_textView);

        }

    }

    */

}
