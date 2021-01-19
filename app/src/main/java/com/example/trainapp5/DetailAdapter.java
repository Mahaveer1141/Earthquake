package com.example.trainapp5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailAdapter extends ArrayAdapter<Detail> {

    public DetailAdapter(@NonNull Context context, List<Detail> arrayList) {
        super(context, 0, arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_view, parent, false);
        }

        Detail current = getItem(position);


        Date dateObject = new Date(current.getTime());
        TextView dateView = listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        String primary_location, location_offset;
        if(current.getLocation().contains("of")) {
            String[] parts = current.getLocation().split("of");
            primary_location = parts[1];
            location_offset = parts[0] + "of";
        }
        else {
            primary_location = current.getLocation();
            location_offset = "";
        }


        TextView location_offsetText = listItemView.findViewById(R.id.location_offset);
        location_offsetText.setText(location_offset);


        TextView primary_locationText = listItemView.findViewById(R.id.primary_location);
        primary_locationText.setText(primary_location);


        TextView magnitudeText = listItemView.findViewById(R.id.magnitude);
        String magnitude = current.getMagnitude();
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(magnitude));
        magnitudeText.setText(magnitude);


        TextView timeView = listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);


        return listItemView;
    }

    private int getMagnitudeColor(String magnitude) {
        int color = R.color.magnitude1;

        switch (magnitude.charAt(0)) {
            case '1' :
                color = R.color.magnitude1;
                break;
            case '2' :
                color = R.color.magnitude2;
                break;
            case '3' :
                color = R.color.magnitude3;
                break;
            case '4' :
                color = R.color.magnitude4;
                break;
            case '5' :
                color = R.color.magnitude5;
                break;
            case '6' :
                color = R.color.magnitude6;
                break;
            case '7' :
                color = R.color.magnitude7;
                break;
            case '8' :
                color = R.color.magnitude8;
                break;
            case '9' :
                color = R.color.magnitude9;
                break;
            default:
                color = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), color);
    }

    private String formatDate(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */

    private String formatTime(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
      return timeFormat.format(dateObject);
    }
}

// <TextView
//         android:id="@+id/task"
//         android:layout_width="290dp"
//         android:layout_height="32dp"
//         android:layout_marginStart="16dp"
//         android:layout_marginTop="16dp"
//         android:text="@string/demo"
//         android:textColor="@color/black"
//         android:textSize="18sp"
//         app:layout_constraintBottom_toBottomOf="parent"
//         app:layout_constraintStart_toStartOf="parent"
//         app:layout_constraintTop_toTopOf="parent"
//         app:layout_constraintVertical_bias="0.013" />

// <CheckBox
//         android:id="@+id/checkBox"
//         android:layout_width="68dp"
//         android:layout_height="33dp"
//         android:layout_marginEnd="16dp"
//         android:gravity="center"
//         android:text="Done"
//         app:layout_constraintBottom_toBottomOf="parent"
//         app:layout_constraintEnd_toEndOf="parent"
//         app:layout_constraintHorizontal_bias="1.0"
//         app:layout_constraintStart_toEndOf="@+id/task"
//         app:layout_constraintTop_toTopOf="@+id/task"
//         app:layout_constraintVertical_bias="0.0" />
