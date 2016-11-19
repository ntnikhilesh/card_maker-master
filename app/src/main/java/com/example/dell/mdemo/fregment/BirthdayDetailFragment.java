package com.example.dell.mdemo.fregment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.dell.mdemo.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BirthdayDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BirthdayDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirthdayDetailFragment extends Fragment {

    EditText birthday_boy_name,your_name,wish;
    Button next_on_birthday_detail;

    String mbirthday_boy_name,myour_name,mwish;

    FrameLayout fl;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BirthdayDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BirthdayDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BirthdayDetailFragment newInstance(String param1, String param2) {
        BirthdayDetailFragment fragment = new BirthdayDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fl=(FrameLayout) inflater.inflate(R.layout.fragment_birthday_detail, container, false);


        next_on_birthday_detail=(Button)fl.findViewById(R.id.button_next_on_birthday_detail_fragment);

        next_on_birthday_detail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                birthday_boy_name=(EditText)fl.findViewById(R.id.et_bithday_boy);
                your_name=(EditText)fl.findViewById(R.id.et_your_name_on_birthday_detail);
                wish=(EditText)fl.findViewById(R.id.et_birthday_wish);

                mbirthday_boy_name=birthday_boy_name.getText().toString();
                myour_name=your_name.getText().toString();
                mwish=wish.getText().toString();

                Log.d("wc detail",myour_name+""+mbirthday_boy_name+""+myour_name+""+mwish);

                // SelectDesignFragment fragment = new SelectDesignFragment();

                BirthdayCardFragment fragment = new BirthdayCardFragment();
                Bundle bundle = new Bundle();
                bundle.putString("bboy name",mbirthday_boy_name);
                bundle.putString("your name",myour_name);
                bundle.putString("wish",mwish);



                fragment.setArguments(bundle);

                android.support.v4.app.FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack("f12");
                fragmentTransaction.commit();

            }
        });


        return fl;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
