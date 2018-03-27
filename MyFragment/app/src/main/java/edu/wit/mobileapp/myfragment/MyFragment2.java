package edu.wit.mobileapp.myfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment2_main, container, false);

        Button myBtn = (Button) rootView.findViewById(R.id.myBtn2);
        myBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();

                Fragment fragment2 = new MyFragment1();
                transaction.replace(R.id.container, fragment2);
                transaction.commit();
            }
        });

        return rootView;
    }
}
