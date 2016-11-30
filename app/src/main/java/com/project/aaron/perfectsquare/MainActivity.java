package com.project.aaron.perfectsquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private View perfectSquare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perfectSquare = ((View) findViewById(R.id.perfectSquare));

        Log.d(TAG, "onCreate: " + perfectSquare.getWidth() + " " + perfectSquare.getHeight());

        perfectSquare.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                perfectSquare.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                Log.d(TAG, "onGlobalLayout: " + perfectSquare.getWidth() + " " + perfectSquare.getHeight());

                ViewGroup.LayoutParams newLayout = perfectSquare.getLayoutParams();
                newLayout.width =  perfectSquare.getWidth();
                newLayout.height =  perfectSquare.getWidth();
                perfectSquare.setLayoutParams(newLayout);
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "onPostResume: " + perfectSquare.getWidth() + " " + perfectSquare.getHeight());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + perfectSquare.getWidth() + " " + perfectSquare.getHeight());
    }
}
