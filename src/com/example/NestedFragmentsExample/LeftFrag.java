package com.example.NestedFragmentsExample;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LeftFrag extends Fragment {
    TextView changeableText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.left_frag, container, false);
        Button doNestingButton = (Button) root.findViewById(R.id.left_frag_button);
        changeableText = (TextView) root.findViewById(R.id.left_frag_text);
        doNestingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment videoFragment = new NestedFrag();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.add(getId(), videoFragment).commit();
            }
        });
        return root;
    }

    public void setChangeableText(String newText) {
        if (changeableText != null)
            changeableText.setText(newText);
    }
}