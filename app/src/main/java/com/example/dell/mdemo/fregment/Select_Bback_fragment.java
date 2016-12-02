package com.example.dell.mdemo.fregment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.dell.mdemo.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Select_Bback_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Select_Bback_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Select_Bback_fragment extends Fragment {
String m_bboy_name,myour_name,mwish;
    int bback_no;


    ImageView bback1,bback2,bback3,bback4,bback5,bback6,bback7,bback8,bback9,bback10,bback11,bback12;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Select_Bback_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Select_Bback_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Select_Bback_fragment newInstance(String param1, String param2) {
        Select_Bback_fragment fragment = new Select_Bback_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        Bundle bundle = getArguments();
//        Log.d("rbundle",bundle.toString());
        if (bundle != null) {
            m_bboy_name = bundle.getString("bboy name");
            myour_name = bundle.getString("your name");
            mwish = bundle.getString("wish");



             Log.d("name",m_bboy_name+"\n"+myour_name+"\n"+mwish);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout fl=(FrameLayout) inflater.inflate(R.layout.fragment_select__bback_fragment, container, false);

        bback1=(ImageView)fl.findViewById(R.id.iv_bback1);
        bback2=(ImageView)fl.findViewById(R.id.iv_bback2);
        bback3=(ImageView)fl.findViewById(R.id.iv_bback3);
        bback4=(ImageView)fl.findViewById(R.id.iv_bback4);
        bback5=(ImageView)fl.findViewById(R.id.iv_bback5);
        bback6=(ImageView)fl.findViewById(R.id.iv_bback6);
        bback7=(ImageView)fl.findViewById(R.id.iv_bback7);
        bback8=(ImageView)fl.findViewById(R.id.iv_bback8);
        bback9=(ImageView)fl.findViewById(R.id.iv_bback9);
        bback10=(ImageView)fl.findViewById(R.id.iv_bback10);
        bback11=(ImageView)fl.findViewById(R.id.iv_bback11);
        bback12=(ImageView)fl.findViewById(R.id.iv_bback12);



        bback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=1;

                get_d_send_data();


            }
        });

        bback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=2;

                get_d_send_data();


            }
        });

        bback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=3;

                get_d_send_data();


            }
        });

        bback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=4;

                get_d_send_data();


            }
        });

        bback5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=5;

                get_d_send_data();


            }
        });

        bback6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=6;

                get_d_send_data();


            }
        });

        bback7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=7;

                get_d_send_data();


            }
        });

        bback8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=8;

                get_d_send_data();


            }
        });

        bback9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=9;

                get_d_send_data();


            }
        });

        bback10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=10;

                get_d_send_data();


            }
        });

        bback11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=11;

                get_d_send_data();


            }
        });

        bback12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bback_no=12;

                get_d_send_data();


            }
        });

        return fl;
    }// end onCreateView






    public void get_d_send_data()
    {
        Select_btext_fragment fragment = new Select_btext_fragment();
        Bundle bundle = new Bundle();
        bundle.putString("bboy name",m_bboy_name);
        bundle.putString("your name",myour_name);
        bundle.putString("wish",mwish);
        bundle.putInt("bback_no",bback_no);



        fragment.setArguments(bundle);

        android.support.v4.app.FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack("f13");
        fragmentTransaction.commit();
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
