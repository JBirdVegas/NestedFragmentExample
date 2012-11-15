package com.example.NestedFragmentsExample;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {
    FragmentManager mChildFragmentManager;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // just load the fragments from xml
        setContentView(R.layout.main);
    }
}
