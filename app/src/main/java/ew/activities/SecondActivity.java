package ew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 28.03.2018.
 */

public class SecondActivity extends AppCompatActivity {

    final String TAG = "Activity Two";
    final String IMPORTANT_STRING = "important";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editText = new EditText(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setWeightSum(4);
        params.weight = 1;
//        Button next = findViewById(R.id.nextTwo);
        Button next = new Button(this);
        next.setText("NEXT");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        Button prev = findViewById(R.id.prevTwo);
        Button prev = new Button(this);
        prev.setText("PREV");
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
                finish();
            }

        });
        prev.setLayoutParams(params);
        next.setLayoutParams(params);
        editText.setLayoutParams(params);
        TextView textView = new TextView(this);
        textView.setText(R.string.second_activity);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        linearLayout.addView(prev);
        linearLayout.addView(next);
        setContentView(linearLayout);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (editText != null){
            outState.putString(IMPORTANT_STRING, editText.getText().toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            if (editText != null){
                editText.setText(savedInstanceState.getString(IMPORTANT_STRING));
            }
        }
    }
}
