package com.test.just.myapplication;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView img1, img2, img3;
    private ImageButton ib1, ib2, ib3;
    private final int CODE_IMG_GALLERY1 = 1;
    private final int CODE_IMG_GALLERY2 = 2;
    private final int CODE_IMG_GALLERY3 = 3;
    private final int CODE_MULTIPLE_IMG_GALLERY = 3;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //1 IMG
               startActivityForResult(Intent.createChooser(new Intent().
                       setAction(Intent.ACTION_GET_CONTENT).
                       setType("image/*"), "Select an image"),
                       CODE_IMG_GALLERY1);

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1 IMG
                startActivityForResult(Intent.createChooser(new Intent().
                                setAction(Intent.ACTION_GET_CONTENT).
                                setType("image/*"), "Select an image"),
                        CODE_IMG_GALLERY2);
            }
        });
//        img2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //MULTIPLE IMGS
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "select multiple images"),
//                        CODE_MULTIPLE_IMG_GALLERY);
//            }
//        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1 IMG
                startActivityForResult(Intent.createChooser(new Intent().
                                setAction(Intent.ACTION_GET_CONTENT).
                                setType("image/*"), "Select an image"),
                        CODE_IMG_GALLERY3);
            }
        });

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.picture);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setImageResource(R.drawable.picture);

            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img3.setImageResource(R.drawable.picture);

            }
        });
    }

    private void init(){
      this.img1=findViewById(R.id.img1);
      this.img2=findViewById(R.id.img2);
      this.img3=findViewById(R.id.img3);
      this.ib1 =findViewById(R.id.ib1);
      this.ib2 =findViewById(R.id.ib2);
      this.ib3 =findViewById(R.id.ib3);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODE_IMG_GALLERY1 && resultCode == RESULT_OK){

            Uri imageUri1 =data.getData();
            if(imageUri1!=null){
                img1.setImageURI(imageUri1);
            }
        }
        else if(requestCode == CODE_IMG_GALLERY2 && resultCode == RESULT_OK){

            Uri imageUri2 =data.getData();
            if(imageUri2!=null){
                img2.setImageURI(imageUri2);
            }
        }
        else if(requestCode == CODE_IMG_GALLERY3 && resultCode == RESULT_OK){

            Uri imageUri3 =data.getData();
            if(imageUri3!=null){
                img3.setImageURI(imageUri3);
            }
        }
//        else if (requestCode == CODE_MULTIPLE_IMG_GALLERY && resultCode == RESULT_OK){
//
//            ClipData clipData = data.getClipData();
//
//            if(clipData!=null){
//
//                img1.setImageURI(clipData.getItemAt(0).getUri());
//                img2.setImageURI(clipData.getItemAt(1).getUri());
//                img3.setImageURI(clipData.getItemAt(2).getUri());
//
//                //PARP MAS
//                for(int i=0;i < clipData.getItemCount();i++){
//                    ClipData.Item item = clipData.getItemAt(i);
//                    Uri uri = item.getUri();
//                    Log.e("MAS IMGS: ", uri.toString());
//                }
//
//            }
//        }
    }
}
