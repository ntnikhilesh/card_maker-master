package com.example.dell.mdemo.fregment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.mdemo.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SelectDesignFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SelectDesignFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectDesignFragment extends Fragment {

    FrameLayout fl;

    String nyour_name, nparter_name,ndate_time,nwedding_msg,nlocation;
    TextView wc_detail,pyour_name,ppartner_name,pwedding_message,pdate_time,plocation;

    TextView tv1,tv2,tv4,tv7;
    int nimage_no;
    LinearLayout ll;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SelectDesignFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectDesignFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectDesignFragment newInstance(String param1, String param2) {
        SelectDesignFragment fragment = new SelectDesignFragment();
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
           // nyourname = bundle.getString("your name");
            nyour_name= bundle.getString("your name");
            nparter_name= bundle.getString("partner name");
            ndate_time= bundle.getString("dt");
            nwedding_msg= bundle.getString("msg");
            nlocation= bundle.getString("location");
            nimage_no=bundle.getInt("image no");

            Toast.makeText(getActivity(),"image no-"+nimage_no,Toast.LENGTH_LONG).show();


           // Log.d("name",nyourname);
        }





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fl = (FrameLayout) inflater.inflate(R.layout.fragment_select_design, container, false);

      //Send data to main activity

        goto_Main_activity();



      /*  // Recive data from detail fragment

        // receive details from previous activity
       ll=(LinearLayout)fl.findViewById(R.id.ll_select_design_fragment);

        select_image();

        pyour_name=(TextView)fl.findViewById(R.id.tv_w3_your_name);
        ppartner_name=(TextView)fl.findViewById(R.id.tv_w5_partner_name);
        pwedding_message=(TextView)fl.findViewById(R.id.tv_w6_wedding_message);
        pdate_time=(TextView)fl.findViewById(R.id.tv_w7_time);
        plocation=(TextView)fl.findViewById(R.id.tv_w8_location);

        Log.d("wc detail",nyour_name+""+nparter_name+""+ndate_time+""+nwedding_msg+""+nlocation);


        pyour_name.setText(nyour_name);
        ppartner_name.setText(nparter_name);
        pwedding_message.setText(nwedding_msg);
        pdate_time.setText(ndate_time);
        plocation.setText(nlocation); */


       // TextView t=(TextView)fl.findViewById(R.id.tv_select_design);
        //t.setText(nyourname);


        return fl;





    } //end oncreateview



    // send data from fragment to Activity

    public void goto_Main_activity()
    {
        someEventListener1.someEvent(nyour_name,nparter_name,ndate_time,nwedding_msg,nlocation,nimage_no);
    }

    public interface onSomeEventListener1 {
        public void someEvent(String w_your_name,String w_parter_name, String w_date_time,String w_wedding_msg,String w_location,int w_image_no);
    }

    onSomeEventListener1 someEventListener1;


    public void select_image()
    {
        switch (nimage_no)
        {
            case 1:


                ll.setBackgroundResource(R.drawable.wc_img1);
                break;

            case 2:

                set_text_color();
                //pyour_name.setTextColor(Color.MAGENTA);
                ll.setBackgroundResource(R.drawable.wc_img2);
                break;

            case 3:
                set_text_color();
                ll.setBackgroundResource(R.drawable.wc_img3);
                break;
            case 4:
                set_text_color();
                ll.setBackgroundResource(R.drawable.wc_img4);
                break;
            case 5:
                set_text_color();
                ll.setBackgroundResource(R.drawable.wc_img5);
                break;
            case 6:

                ll.setBackgroundResource(R.drawable.wc_img6);
                break;
            case 7:

                ll.setBackgroundResource(R.drawable.wc_img7);
                break;

            case 8:
                set_text_color();
                ll.setBackgroundResource(R.drawable.wc_img8);
                break;

            case 9:
                set_text_color();
                ll.setBackgroundResource(R.drawable.wc_img9);
                break;
            case 10:
                set_text_color();
                ll.setBackgroundResource(R.drawable.wc_img10);
                break;
            case 11:

                ll.setBackgroundResource(R.drawable.wc_img11);
                break;
            case 12:
                set_text_color();
                ll.setBackgroundResource(R.drawable.wc_img12);
                break;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    public void set_text_color()
    {

        tv1=(TextView)fl.findViewById(R.id.tv_w1);
        tv2=(TextView)fl.findViewById(R.id.tv_w2);
        tv4=(TextView)fl.findViewById(R.id.tv_w4);
        tv7=(TextView)fl.findViewById(R.id.tv_w7);
        pyour_name=(TextView)fl.findViewById(R.id.tv_w3_your_name);
        ppartner_name=(TextView)fl.findViewById(R.id.tv_w5_partner_name);
        pwedding_message=(TextView)fl.findViewById(R.id.tv_w6_wedding_message);
        pdate_time=(TextView)fl.findViewById(R.id.tv_w7_time);
        plocation=(TextView)fl.findViewById(R.id.tv_w8_location);


        tv1.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
        tv2.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
        tv4.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
        tv7.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
        pyour_name.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
        ppartner_name.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
        pwedding_message.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
        pdate_time.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
        plocation.setTextColor(ContextCompat.getColor(getActivity(), R.color.wc_text_color));
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

        try {
            someEventListener1 = (onSomeEventListener1) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener1");
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
