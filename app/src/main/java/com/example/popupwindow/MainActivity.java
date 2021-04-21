package com.example.popupwindow;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button open_popup, back;
    ImageButton close;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        open_popup = findViewById(R.id.btn_pop);

        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

        View viewPopupWindow = layoutInflater.inflate(R.layout.custom_pop_up, null);

        open_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupWindow = new PopupWindow(viewPopupWindow, 900, 900, true);

                close = viewPopupWindow.findViewById(R.id.exit);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Exit button CLICKED", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });

                back = viewPopupWindow.findViewById(R.id.btn_back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Back Button CLICKED", Toast.LENGTH_SHORT).show();
                    }
                });


                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
//


//                viewPopupWindow.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        popupWindow.dismiss();
//                        return false;
//                    }
//                });
            }
        });

    }


}