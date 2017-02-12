package com.example.dell.mdemo.fregment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.mdemo.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static android.R.attr.bitmap;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BirthdayCardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BirthdayCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirthdayCardFragment extends Fragment {
    String mbirthday_boy_name,myour_name,mwish;
    int m_bback_no,m_text_no,m_cake_no;

    Bitmap bitmap;
    FrameLayout fl;

Button save_image,share_image;

    TextView tv_bboy_name,tv_wish,tv_from;

    ImageView iv_hapy_text,iv_bboy,iv_cake;
    LinearLayout ll;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BirthdayCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BirthdayCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BirthdayCardFragment newInstance(String param1, String param2) {
        BirthdayCardFragment fragment = new BirthdayCardFragment();
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


            Bundle bundle = getArguments();
//        Log.d("rbundle",bundle.toString());
            if (bundle != null) {
                // nyourname = bundle.getString("your name");
                mbirthday_boy_name = bundle.getString("bboy name");
                myour_name = bundle.getString("your name");
                mwish = bundle.getString("wish");
                m_bback_no = bundle.getInt("bback_no");
                m_text_no = bundle.getInt("btext_no");
                m_cake_no = bundle.getInt("bcake_no");


                Log.d("name on card",mbirthday_boy_name+"\n"+myour_name+"\n"+mwish+"\n"+m_bback_no+"\n"+m_text_no+"\n"+m_cake_no);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        fl=(FrameLayout)inflater.inflate(R.layout.fragment_birthday_card, container, false);
        //l1=(LinearLayout) fl.findViewById(R.id.ll_birthday_card_fragment);

        set_data_on_bcard();

        save_image=(Button)fl.findViewById(R.id.button_save_bimage);
        save_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewToBitmap1();
                saveImageFile(bitmap);
            }
        });

        share_image=(Button)fl.findViewById(R.id.button_share_bimage);
        share_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
                i.putExtra(android.content.Intent.EXTRA_TEXT, "extra text that you want to put");
                startActivity(Intent.createChooser(i,"Share via"));
            }
        });



        return fl;
    }

    public void viewToBitmap1()
    {
        File imageFile;
// image naming and path  to include sd card  appending name you choose for file
        String mPath = Environment.getExternalStorageDirectory().toString() + "/a.png";

// create bitmap screen capture
        View view1 = getActivity().getWindow().getDecorView().getRootView();
        view1.measure(getView().getWidth(), View.MeasureSpec.EXACTLY);
        bitmap = Bitmap.createBitmap(view1.getMeasuredWidth(), view1.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas c = new Canvas(bitmap);


        view1.layout(0, 0, view1.getMeasuredWidth(), view1.getMeasuredHeight());
        view1.draw(c);

    }


    public void set_data_on_bcard()
    {
        tv_bboy_name=(TextView)fl.findViewById(R.id.tv_to_on_birthday_card);
        tv_wish=(TextView)fl.findViewById(R.id.tv_wish);
        tv_from=(TextView)fl.findViewById(R.id.tv_from);




        tv_bboy_name.setText(mbirthday_boy_name);
        tv_from.setText("From : "+myour_name);
        tv_wish.setText(mwish);

        set_background();
        set_happy_text();
        set_cake();

    }//end set data on bcard




    public void set_background()
    {
        ll=(LinearLayout)fl.findViewById(R.id.ll_birthday_card_fragment);

        switch (m_bback_no)
        {
            case 1:


                ll.setBackgroundResource(R.drawable.bdesign1);
                break;

            case 2:


                ll.setBackgroundResource(R.drawable.bdesign2);
                break;

            case 3:


                ll.setBackgroundResource(R.drawable.bdesign3);
                break;

            case 4:


                ll.setBackgroundResource(R.drawable.bdesign4);
                break;

            case 5:


                ll.setBackgroundResource(R.drawable.bdesign5);
                break;

            case 6:


                ll.setBackgroundResource(R.drawable.bdesign6);
                break;

            case 7:


                ll.setBackgroundResource(R.drawable.bdesign7);
                break;

            case 8:


                ll.setBackgroundResource(R.drawable.bdesign8);
                break;

            case 9:


                ll.setBackgroundResource(R.drawable.bdesign9);
                break;

            case 10:


                ll.setBackgroundResource(R.drawable.bdesign10);
                break;

            case 11:


                ll.setBackgroundResource(R.drawable.bdesign11);
                break;

            case 12:


                ll.setBackgroundResource(R.drawable.bdesign12);
                break;

        }


    }//end set background


    public void set_happy_text()
    {

        iv_hapy_text=(ImageView)fl.findViewById(R.id.iv_happy_text);

        switch (m_text_no)
        {
            case 1:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image1);
                break;

            case 2:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image2);
                break;

            case 3:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image3);
                break;

            case 4:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image4);
                break;

            case 5:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image5);
                break;

            case 6:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image6);
                break;

            case 7:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image7);
                break;

            case 8:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image8);
                break;

            case 9:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image9);
                break;

            case 10:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image10);
                break;

            case 11:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image11);
                break;

            case 12:


                iv_hapy_text.setImageResource(R.drawable.happybirthday_image12);
                break;

        }
    }//end set hapy text

    public void set_cake()
    {

        iv_cake=(ImageView)fl.findViewById(R.id.iv_cake_on_bcard);

        switch (m_cake_no)
        {
            case 1:


                iv_cake.setImageResource(R.drawable.cake_image1);
                break;

            case 2:


                iv_cake.setImageResource(R.drawable.cake_image2);
                break;

            case 3:


                iv_cake.setImageResource(R.drawable.cake_image3);
                break;

            case 4:


                iv_cake.setImageResource(R.drawable.cake_image4);
                break;
            case 5:


                iv_cake.setImageResource(R.drawable.cake_image5);
                break;
            case 6:


                iv_cake.setImageResource(R.drawable.cake_image6);
                break;
            case 7:


                iv_cake.setImageResource(R.drawable.cake_image7);
                break;

            case 8:


                iv_cake.setImageResource(R.drawable.cake_image8);
                break;

            case 9:


                iv_cake.setImageResource(R.drawable.cake_image9);
                break;
            case 10:


                iv_cake.setImageResource(R.drawable.cake_image10);
                break;
            case 11:


                iv_cake.setImageResource(R.drawable.cake_image11);
                break;

            case 12:


                iv_cake.setImageResource(R.drawable.cake_image12);
                break;






        }

    }//end set cake



    public Bitmap viewToBitmap(View view) {

   bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);



        return bitmap;
    }


    @Override
    public void onResume() {

        // convert a view (framelayout) into a bitmap:
        //then save your bitmap into a file:



        super.onResume();
    }


    public String saveImageFile(Bitmap bitmap) {
        FileOutputStream out = null;
        String filename = getFilename();
        try {
            out = new FileOutputStream(filename);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return filename;
    }

    private String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory()
                .getPath(), "TestFolder");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/"
                + System.currentTimeMillis() + ".jpg");
        return uriSting;
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
