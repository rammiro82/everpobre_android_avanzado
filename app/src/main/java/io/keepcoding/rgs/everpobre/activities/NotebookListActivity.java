package io.keepcoding.rgs.everpobre.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.keepcoding.rgs.everpobre.R;

public class NotebookListActivity extends AppCompatActivity {

    public static final String TAG = NotebookListActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook_list);

        Log.d(TAG, "Hello from Activitie");
    }
}
