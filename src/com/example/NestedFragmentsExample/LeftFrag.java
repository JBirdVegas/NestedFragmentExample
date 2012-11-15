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
        // set the view
        View root = inflater.inflate(R.layout.left_frag, container, false);
        Button doNestingButton = (Button) root.findViewById(R.id.left_frag_button);
        changeableText = (TextView) root.findViewById(R.id.left_frag_text);
        // make our buttons nest the second Fragment
        doNestingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment videoFragment = new NestedFrag();
                // we get the 'childFragmentManager' for our transaction
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                // make the back button return to the main screen
                // and supply the tag 'left' to the backstack
                transaction.addToBackStack("left");
                // add our new nested fragment
                transaction.add(getId(), videoFragment, "left");
                // commit the transaction
                transaction.commit();
            }
        });
        return root;
    }

    public void setChangeableText(String newText) {
        if (changeableText != null)
            changeableText.setText(newText);
    }
}