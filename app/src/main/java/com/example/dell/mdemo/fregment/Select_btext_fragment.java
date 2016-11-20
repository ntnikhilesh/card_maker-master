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
 * {@link Select_btext_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Select_btext_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Select_btext_fragment extends Fragment {
    ImageView btext1,btext2,btext3,btext4,btext5,btext6,btext7,btext8,btext9,btext10,btext11,btext12;
    String m_bboy_name,myour_name,mwish;
    int m_bback_no,m_text_no;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Select_btext_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Select_btext_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Select_btext_fragment newInstance(String param1, String param2) {
        Select_btext_fragment fragment = new Select_btext_fragment();
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



            Log.d("name on text",m_bboy_name+"\n"+myour_name+"\n"+mwish+"\n"+m_bback_no);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout fl=(FrameLayout) inflater.inflate(R.layout.fragment_select_btext_fragment, container, false);

        btext1 =(ImageView)fl.findViewById(R.id.iv_btext1);
        btext2 =(ImageView)fl.findViewById(R.id.iv_btext2);
        btext3 =(ImageView)fl.findViewById(R.id.iv_btext3);
        btext4 =(ImageView)fl.findViewById(R.id.iv_btext4);
        btext5 =(ImageView)fl.findViewById(R.id.iv_btext5);
        btext6 =(ImageView)fl.findViewById(R.id.iv_btext6);
        btext7 =(ImageView)fl.findViewById(R.id.iv_btext7);
        btext8 =(ImageView)fl.findViewById(R.id.iv_btext8);
        btext9 =(ImageView)fl.findViewById(R.id.iv_btext9);
        btext10 =(ImageView)fl.findViewById(R.id.iv_btext10);
        btext11 =(ImageView)fl.findViewById(R.id.iv_btext11);
        btext12 =(ImageView)fl.findViewById(R.id.iv_btext12);





        btext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=1;

                get_d_send_data();



            }
        });

        btext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=2;

                get_d_send_data();



            }
        });

        btext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=3;

                get_d_send_data();



            }
        });

        btext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=4;

                get_d_send_data();



            }
        });

        btext5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=5;

                get_d_send_data();



            }
        });

        btext6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=6;

                get_d_send_data();



            }
        });

        btext7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=7;

                get_d_send_data();



            }
        });


        btext8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=8;

                get_d_send_data();



            }
        });

        btext9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=9;

                get_d_send_data();



            }
        });

        btext10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=10;

                get_d_send_data();



            }
        });

        btext11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=11;

                get_d_send_data();



            }
        });

        btext12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                m_text_no=12;

                get_d_send_data();



            }
        });

        return fl;
    }




    public void get_d_send_data()
    {
        select_bcake_fragment fragment = new select_bcake_fragment();
        Bundle bundle = new Bundle();
        bundle.putString("bboy name",m_bboy_name);
        bundle.putString("your name",myour_name);
        bundle.putString("wish",mwish);
        bundle.putInt("bback_no",m_bback_no);
        bundle.putInt("btext_no",m_text_no);



        fragment.setArguments(bundle);

        android.support.v4.app.FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack("f14");
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
