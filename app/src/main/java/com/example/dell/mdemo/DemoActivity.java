package com.example.dell.mdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.nguyenhoanglam.imagepicker.activity.ImagePicker;
import com.nguyenhoanglam.imagepicker.activity.ImagePickerActivity;
import com.nguyenhoanglam.imagepicker.model.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import static android.R.attr.bitmap;

public class DemoActivity extends AppCompatActivity {
    String mbirthday_boy_name,myour_name,mwish;
    int m_bback_no,m_text_no,m_cake_no;

    TextView tv_bboy_name,tv_wish,tv_from;

    ImageView iv_hapy_text,iv_bboy,iv_cake;
    LinearLayout ll;

    Bitmap bitmap;

    Image images;
    String filename;

    int REQUEST_CODE_PICKER=1;

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

        //set birthday boy image

        iv_bboy=(ImageView)findViewById(R.id.iv_bboy_image);
        iv_bboy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DemoActivity.this, ImagePickerActivity.class);

                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_FOLDER_MODE, true);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_MODE, ImagePickerActivity.MODE_MULTIPLE);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_LIMIT, 10);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_SHOW_CAMERA, true);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_SELECTED_IMAGES, images);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_FOLDER_TITLE, "Album");
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_IMAGE_TITLE, "Tap to select images");
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_IMAGE_DIRECTORY, "Camera");

                startActivityForResult(intent, REQUEST_CODE_PICKER);
            }
        });



        //save image

       Button save_image=(Button)findViewById(R.id.button_save_bimage_on_demo);
        save_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewToBitmap1();
                saveImageFile(bitmap);

                Intent i=new Intent(DemoActivity.this,MainActivity.class);
                startActivity(i);
            }
        });



        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.save_bcard);
        final FloatingActionButton fab_share = (FloatingActionButton) findViewById(R.id.share_bcard);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setVisibility(View.INVISIBLE);
                fab_share.setVisibility(View.INVISIBLE);
                viewToBitmap1();
                saveImageFile(bitmap);

                Intent i=new Intent(DemoActivity.this,MainActivity.class);
                startActivity(i);

            }
        });


        //share Image


        fab_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_share.setVisibility(View.INVISIBLE);
                fab.setVisibility(View.INVISIBLE);
                //save image and get url of image
                // Capture actionbar menu item click


                       // Bitmap bitmap;
                        OutputStream output;

                        // Take screen shot of image and convert into bitmap
                viewToBitmap1();
                        //bitmap = BitmapFactory.decodeResource(getResources(),
                                //R.drawable.wallpaper);

                        // Find the SD Card path
                        File filepath = Environment.getExternalStorageDirectory();

                        // Create a new folder AndroidBegin in SD Card
                        File dir = new File(filepath.getAbsolutePath() + "/Birthday Card/");
                        dir.mkdirs();

                        // Create a name for the saved image
                        File file = new File(dir, "sample_wallpaper.png");

                        try {

                            // Share Intent
                            Intent share = new Intent(Intent.ACTION_SEND);

                            // Type of file to share
                            share.setType("image/jpeg");

                            output = new FileOutputStream(file);

                            // Compress into png format image from 0% - 100%
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                            output.flush();
                            output.close();

                            // Locate the image to Share
                            Uri uri = Uri.fromFile(file);

                            // Pass the image into an Intnet
                            share.putExtra(Intent.EXTRA_STREAM, uri);

                            // Show the social share chooser list
                            fab_share.setVisibility(View.VISIBLE);
                            fab.setVisibility(View.VISIBLE);
                            startActivity(Intent.createChooser(share, "NT App...Share Card Via"));

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }



            }
        });
    }// end onCreate


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICKER && resultCode == RESULT_OK && data != null) {
            ArrayList<Image> images = data.getParcelableArrayListExtra(ImagePickerActivity.INTENT_EXTRA_SELECTED_IMAGES);


            Log.d("bimage = ",images.get(0).getPath());
            Uri imgUri=Uri.parse(images.get(0).getPath());



           iv_bboy=(ImageView)findViewById(R.id.iv_bboy_image);
            iv_bboy.setImageURI(imgUri);
            // do your logic ....
        }
    }

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
        filename = getFilename();
        try {
            out = new FileOutputStream(filename);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);

            Toast.makeText(DemoActivity.this,"Image saved in Birthday Card folder",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Log.d("image storage address-","="+filename);
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

    @Override
    public void onBackPressed() {
        Intent i=new Intent(DemoActivity.this,MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}
