package com.example.rayca.my_application_lab_5.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rayca.my_application_lab_5.R;
import com.example.rayca.my_application_lab_5.model.Doctor;

import java.util.ArrayList;

public class DoctorAdapter  extends ArrayAdapter<Doctor> {


    public DoctorAdapter(Activity context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.doctor_item_layout,parent,false);
        }
        Doctor currentDoctor = getItem(position);

        ImageView doctorImage = listItemView.findViewById(R.id.doctorImage);
        byte[] decodedString = Base64.decode(currentDoctor.getPhoto(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        doctorImage.setImageBitmap(decodedByte);

        TextView nameTextView = listItemView.findViewById(R.id.doctorName);
        nameTextView.setText(currentDoctor.getName());

        TextView specialityTextView = listItemView.findViewById(R.id.doctorSpeciality);
        specialityTextView.setText(currentDoctor.getSpeciality());

        TextView addressTextView = listItemView.findViewById(R.id.doctorAddress);
        addressTextView.setText(currentDoctor.getAddress());

        TextView ratingDoctor = listItemView.findViewById(R.id.doctorRating);
        ratingDoctor.setText(String.valueOf((currentDoctor.getRating())));

//        TextView doctorRatingTextView = findViewById(R.id.doctorRating);
//        doctorRatingTextView.setText(String.valueOf(doctor.getRating()));

        return listItemView;
    }

    public void setDoctorslist(ArrayList<Doctor> doctorslist) {
        addAll(doctorslist);
        notifyDataSetChanged();
    }
}
