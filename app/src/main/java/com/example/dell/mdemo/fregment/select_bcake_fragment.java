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
 * {@link select_bcake_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link select_bcake_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class select_bcake_fragment extends Fragment {
    ImageView bcake1,bcake2,bcake3,bcake4,bcake5,bcake6,bcake7,bcake8,bcake9,bcake10,bcake11,bcake12;
    String m_bboy_name,myour_name,mwish;
    int m_bback_no,m_text_no,m_cake_no;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public select_bcake_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment select_bcake_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static select_bcake_fragment newInstance(String param1, String param2) {
        select_bcake_fragment fragment = new select_bcake_fragment();
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

        Bundle bundle = getArguments();
//        Log.d("rbundle",bundle.toString());
        if (bundle != null) {
            m_bboy_name = bundle.getString("bboy name");
            myour_name = bundle.getString("your name");
            mwish = bundle.getString("wish");
            m_bback_no = bundle.getInt("bback_no");
            m_text_no = bundle.getInt("btext_no");



            Log.d("name on cake",m_bboy_name+"\n"+myour_name+"\n"+mwish+"\n"+m_bback_no+"\n"+m_text_no);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout fl=(FrameLayout) inflater.inflate(R.layout.fragment_select_bcake_fragment, container, false);

        bcake1=(ImageView)fl.findViewById(R.id.iv_cake1);
        bcake2=(ImageView)fl.findViewById(R.id.iv_cake2);
        bcake3=(ImageView)fl.findViewById(R.id.iv_cake3);
        bcake4=(ImageView)fl.findViewById(R.id.iv_cake4);
        bcake5=(ImageView)fl.findViewById(R.id.iv_cake5);
        bcake6=(ImageView)fl.findViewById(R.id.iv_cake6);
        bcake7=(ImageView)fl.findViewById(R.id.iv_cake7);
        bcake8=(ImageView)fl.findViewById(R.id.iv_cake8);
        bcake9=(ImageView)fl.findViewById(R.id.iv_cake9);
        bcake10=(ImageView)fl.findViewById(R.id.iv_cake10);
        bcake11=(ImageView)fl.findViewById(R.id.iv_cake11);
        bcake12=(ImageView)fl.findViewById(R.id.iv_cake12);





        bcake1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            m_cake_no=1;
                get_d_send_data();




            }
        });

        bcake2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=2;
                get_d_send_data();




            }
        });

        bcake3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=3;
                get_d_send_data();




            }
        });

        bcake4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=4;
                get_d_send_data();




            }
        });

        bcake5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=5;
                get_d_send_data();




            }
        });

        bcake6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=6;
                get_d_send_data();




            }
        });

        bcake7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=7;
                get_d_send_data();




            }
        });

        bcake8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=8;
                get_d_send_data();




            }
        });

        bcake9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=9;
                get_d_send_data();




            }
        });
        bcake10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=10;
                get_d_send_data();




            }
        });

        bcake11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=11;
                get_d_send_data();




            }
        });

        bcake12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_cake_no=12;
                get_d_send_data();




            }
        });


        return fl;



    }




    public void get_d_send_data()
    {

        BirthdayCardFragment fragment = new BirthdayCardFragment();
        Bundle bundle = new Bundle();
        bundle.putString("bboy name",m_bboy_name);
        bundle.putString("your name",myour_name);
        bundle.putString("wish",mwish);
        bundle.putInt("bback_no",m_bback_no);
        bundle.putInt("btext_no",m_text_no);
        bundle.putInt("bcake_no",m_cake_no);



        fragment.setArguments(bundle);

        android.support.v4.app.FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack("f15");
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
