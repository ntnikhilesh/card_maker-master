package com.example.dell.mdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static android.R.attr.bitmap;

public class WCActivity extends AppCompatActivity {

    String nyour_name, nparter_name,ndate_time,nwedding_msg,nlocation;
    TextView wc_detail,pyour_name,ppartner_name,pwedding_message,pdate_time,plocation;

    TextView tv1,tv2,tv4,tv7;
    int nimage_no;
    LinearLayout ll;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wc);


        Intent intent = getIntent();
        //String myText = intent.getExtras().getString(Intent.EXTRA_TEXT);
        nyour_name = intent.getExtras().getString("your_name");
        nparter_name = intent.getExtras().getString("partner_name");
        ndate_time = intent.getExtras().getString("time");
        nwedding_msg =intent.getExtras().getString("msg");
        nlocation = intent.getExtras().getString("location");
        nimage_no= (Integer.parseInt( intent.getExtras().getString("image_no")));


        Log.d("name on wedding card",nyour_name+"\n"+nparter_name+"\n"+ndate_time+"\n"+nwedding_msg+"\n"+nlocation+"\n"+nimage_no);






        // Recive data from Main Activity and set them

        // receive details from previous activity
        ll=(LinearLayout)findViewById(R.id.ll_select_design_fragment);

        select_image();

        pyour_name=(TextView)findViewById(R.id.tv_w3_your_name);
        ppartner_name=(TextView)findViewById(R.id.tv_w5_partner_name);
        pwedding_message=(TextView)findViewById(R.id.tv_w6_wedding_message);
        pdate_time=(TextView)findViewById(R.id.tv_w7_time);
        plocation=(TextView)findViewById(R.id.tv_w8_location);

        Log.d("wc detail",nyour_name+""+nparter_name+""+ndate_time+""+nwedding_msg+""+nlocation);


        pyour_name.setText(nyour_name);
        ppartner_name.setText(nparter_name);
        pwedding_message.setText(nwedding_msg);
        pdate_time.setText(ndate_time);
        plocation.setText(nlocation);


//Save WC in SD card

        Button save_image=(Button)findViewById(R.id.button_save_bimage_on_wc);
        save_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewToBitmap1();
                saveImageFile(bitmap);
                Intent i=new Intent(WCActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.save_wcard);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setVisibility(View.INVISIBLE);
                viewToBitmap1();
                saveImageFile(bitmap);
                Intent i=new Intent(WCActivity.this,MainActivity.class);
                startActivity(i);

            }
        });

    } // end on create


    public void viewToBitmap1()
    {
        File imageFile;
// image naming and path  to include sd card  appending name you choose for file
        String mPath = Environment.getExternalStorageDirectory().toString() + "/a.png";

// create bitmap screen capture
        View view1 = getWindow().getDecorView().getRootView();
        DisplayMetrics metrics = WCActivity.this.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        // int height = metrics.heightPixels;
        view1.measure(80, View.MeasureSpec.UNSPECIFIED);
        bitmap = Bitmap.createBitmap(view1.getMeasuredWidth(), view1.getMeasuredHeight(), Bitmap.Config.ARGB_8888);


        Canvas c = new Canvas(bitmap);


        view1.layout(0, 0, view1.getMeasuredWidth(), view1.getMeasuredHeight());
        view1.draw(c);

    }//end viewtoBitmap


    public String saveImageFile(Bitmap bitmap) {
        FileOutputStream out = null;
        String filename = getFilename();
        try {
            out = new FileOutputStream(filename);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);

            Toast.makeText(WCActivity.this,"Image saved in Wedding Card folder",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return filename;
    }

    private String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory()
                .getPath(), "Wedding Card");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/"
                + System.currentTimeMillis() + ".jpg");
        return uriSting;
    }



    //Select image

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
    }// end select image


    public void set_text_color()
    {

        tv1=(TextView)findViewById(R.id.tv_w1);
        tv2=(TextView)findViewById(R.id.tv_w2);
        tv4=(TextView)findViewById(R.id.tv_w4);
        tv7=(TextView)findViewById(R.id.tv_w7);
        pyour_name=(TextView)findViewById(R.id.tv_w3_your_name);
        ppartner_name=(TextView)findViewById(R.id.tv_w5_partner_name);
        pwedding_message=(TextView)findViewById(R.id.tv_w6_wedding_message);
        pdate_time=(TextView)findViewById(R.id.tv_w7_time);
        plocation=(TextView)findViewById(R.id.tv_w8_location);


        tv1.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
        tv2.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
        tv4.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
        tv7.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
        pyour_name.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
        ppartner_name.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
        pwedding_message.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
        pdate_time.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
        plocation.setTextColor(ContextCompat.getColor(this, R.color.wc_text_color));
    }

    @Override
    public void onBackPressed() {

        Intent i=new Intent(WCActivity.this,MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}
