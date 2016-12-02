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
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.dell.mdemo.R;

import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WeddingDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WeddingDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeddingDetailFragment extends Fragment {


    EditText your_name,partner_name,wedding_msg,location;
    String myour_name,mpartner_name,mwedding_msg,mdate_time,mlocation;
    Button nextb,datetimeb;
    TextView tv_date_time;

    private static final String TAG = "Sample";

    private static final String TAG_DATETIME_FRAGMENT = "TAG_DATETIME_FRAGMENT";

    private static final String STATE_TEXTVIEW = "STATE_TEXTVIEW";

    private SwitchDateTimeDialogFragment dateTimeFragment;

    FrameLayout fl;

    //date and time picker

    private SimpleDateFormat mFormatter = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");
    private Button mButton;









    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WeddingDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeddingDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeddingDetailFragment newInstance(String param1, String param2) {
        WeddingDetailFragment fragment = new WeddingDetailFragment();
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

               fl = (FrameLayout) inflater.inflate(R.layout.fragment_wedding_detail, container, false);


        your_name=(EditText)fl.findViewById(R.id.et_your_name);
        partner_name=(EditText)fl.findViewById(R.id.et_partner_name);
        tv_date_time=(TextView)fl.findViewById(R.id.tv_date_time);
        wedding_msg=(EditText)fl.findViewById(R.id.et_wedding_msg);
        location=(EditText)fl.findViewById(R.id.et_location);
        datetimeb=(Button)fl.findViewById(R.id.button_set_datetime);

        //date d time

        if (savedInstanceState != null) {
            // Restore value from saved state
            tv_date_time.setText(savedInstanceState.getCharSequence(STATE_TEXTVIEW));
        }

        initialize_date_time_data();




        datetimeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dateTimeFragment.show(getActivity().getSupportFragmentManager(), TAG_DATETIME_FRAGMENT);

               /* new SlideDateTimePicker.Builder(getFragmentManager())
                        .setListener(listener)
                        .setInitialDate(new Date())
                        //.setMinDate(minDate)
                        //.setMaxDate(maxDate)
                        //.setIs24HourTime(true)
                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
                        //.setIndicatorColor(Color.parseColor("#990000"))
                        .build()
                        .show();  */
            }
        });
        nextb=(Button)fl.findViewById(R.id.button_next_on_wedding_detail_fragment);
        nextb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myour_name=your_name.getText().toString();
                mpartner_name=partner_name.getText().toString();
                mwedding_msg=wedding_msg.getText().toString();
                mlocation=location.getText().toString();
                Log.d("wc detail",myour_name+""+mpartner_name+""+mwedding_msg+""+mlocation);

               // SelectDesignFragment fragment = new SelectDesignFragment();

                SelectBackground fragment = new SelectBackground();
                Bundle bundle = new Bundle();
                bundle.putString("your name",myour_name);
                bundle.putString("partner name",mpartner_name);
                bundle.putString("dt",mdate_time);
                bundle.putString("msg",mwedding_msg);
                bundle.putString("location",mlocation);


                fragment.setArguments(bundle);

                android.support.v4.app.FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack("f2");
                fragmentTransaction.commit();


              /*  Intent myintent=new Intent(WeddingDetailFragment.this, SelectDesignActivity.class);
                myintent .putExtra("your name",myour_name);
                myintent .putExtra("partner name",mpartner_name);
                myintent .putExtra("dt",mdate_time);
                myintent .putExtra("msg",mwedding_msg);
                myintent .putExtra("location",mlocation);

                startActivity(myintent); */

            }
        });


        return fl;
    }//end OncreateView

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the current textView
        tv_date_time=(TextView)fl.findViewById(R.id.tv_date_time);
        savedInstanceState.putCharSequence(STATE_TEXTVIEW, tv_date_time.getText());
        super.onSaveInstanceState(savedInstanceState);
    }



    public void initialize_date_time_data()
    {



        // Construct SwitchDateTimePicker
        dateTimeFragment = (SwitchDateTimeDialogFragment)getActivity().getSupportFragmentManager().findFragmentByTag(TAG_DATETIME_FRAGMENT);
        if(dateTimeFragment == null) {
            dateTimeFragment = SwitchDateTimeDialogFragment.newInstance(
                    getString(R.string.label_datetime_dialog),
                    getString(R.string.positive_button_datetime_picker),
                    getString(R.string.negative_button_datetime_picker)
            );
        }

        // Assign values we want
        final SimpleDateFormat myDateFormat = new SimpleDateFormat("d MMM yyyy HH:mm", java.util.Locale.getDefault());
        dateTimeFragment.startAtCalendarView();
        dateTimeFragment.set24HoursMode(false);
        dateTimeFragment.setDefaultHourOfDay(15);
        dateTimeFragment.setDefaultMinute(20);
        dateTimeFragment.setDefaultDay(8);
        dateTimeFragment.setDefaultMonth(Calendar.AUGUST);
        dateTimeFragment.setDefaultYear(2018);

        // Define new day and month format
        try {
            dateTimeFragment.setSimpleDateMonthAndDayFormat(new SimpleDateFormat("MMMM dd", Locale.getDefault()));
        } catch (SwitchDateTimeDialogFragment.SimpleDateMonthAndDayFormatException e) {
            Log.e(TAG, e.getMessage());
        }

        // Set listener for date
        dateTimeFragment.setOnButtonClickListener(new SwitchDateTimeDialogFragment.OnButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Date date) {
                tv_date_time.setText(myDateFormat.format(date));
                mdate_time=tv_date_time.getText().toString();
            }

            @Override
            public void onNegativeButtonClick(Date date) {
                tv_date_time.setText("");
            }
        });


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
