package com.example.dell.mdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.mdemo.fregment.select_bcake_fragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static android.R.attr.bitmap;

public class DemoActivity extends AppCompatActivity {
    String mbirthday_boy_name,myour_name,mwish;
    int m_bback_no,m_text_no,m_cake_no;

    TextView tv_bboy_name,tv_wish,tv_from;

    ImageView iv_hapy_text,iv_bboy,iv_cake;
    LinearLayout ll;

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Intent intent = getIntent();
        //String myText = intent.getExtras().getString(Intent.EXTRA_TEXT);
        mbirthday_boy_name = intent.getExtras().getString("bboy_name");
        myour_name = intent.getExtras().getString("your_name");
        mwish = intent.getExtras().getString("wish");
        m_bback_no =(Integer.parseInt( intent.getExtras().getString("back")));
        m_text_no = (Integer.parseInt( intent.getExtras().getString("text")));
        m_cake_no = (Integer.parseInt( intent.getExtras().getString("cake")));


        Log.d("name on card",mbirthday_boy_name+"\n"+myour_name+"\n"+mwish+"\n"+m_bback_no+"\n"+m_text_no+"\n"+m_cake_no);


        set_data_on_bcard();

       Button save_image=(Button)findViewById(R.id.button_save_bimage_on_demo);
        save_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewToBitmap1();
                saveImageFile(bitmap);
            }
        });
    }// end onCreate


    public void set_data_on_bcard()
    {
        tv_bboy_name=(TextView)findViewById(R.id.tv_to_on_birthday_card);
        tv_wish=(TextView)findViewById(R.id.tv_wish);
        tv_from=(TextView)findViewById(R.id.tv_from);




        tv_bboy_name.setText(mbirthday_boy_name);
        tv_from.setText("From : "+myour_name);
        tv_wish.setText(mwish);

        set_background();
        set_happy_text();
        set_cake();

    }//end set data on bcard



    public void set_background()
    {
        ll=(LinearLayout)findViewById(R.id.ll_birthday_card_fragment);

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

        iv_hapy_text=(ImageView)findViewById(R.id.iv_happy_text);

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

        iv_cake=(ImageView)findViewById(R.id.iv_cake_on_bcard);

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



    public void viewToBitmap1()
    {
        File imageFile;
// image naming and path  to include sd card  appending name you choose for file
        String mPath = Environment.getExternalStorageDirectory().toString() + "/a.png";

// create bitmap screen capture
        View view1 = getWindow().getDecorView().getRootView();
        DisplayMetrics metrics = DemoActivity.this.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
       // int height = metrics.heightPixels;
        view1.measure(80, View.MeasureSpec.UNSPECIFIED);
       bitmap = Bitmap.createBitmap(view1.getMeasuredWidth(), view1.getMeasuredHeight(), Bitmap.Config.ARGB_8888);


        Canvas c = new Canvas(bitmap);


        view1.layout(0, 0, view1.getMeasuredWidth(), view1.getMeasuredHeight());
        view1.draw(c);

    }


    public String saveImageFile(Bitmap bitmap) {
        FileOutputStream out = null;
        String filename = getFilename();
        try {
            out = new FileOutputStream(filename);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);

            Toast.makeText(DemoActivity.this,"Image saved in Birthday Card folder",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return filename;
    }

    private String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory()
                .getPath(), "Birthday Card");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/"
                + System.currentTimeMillis() + ".jpg");
        return uriSting;
    }


}
