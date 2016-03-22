package com.lonelyship.portfolio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;

import at.technikum.mti.fancycoverflow.FancyCoverFlow;


public class MainActivity extends Activity {

    private FancyCoverFlow fancyCoverFlow;

    Intent it = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.fancyCoverFlow = (FancyCoverFlow) this
                .findViewById(R.id.fancyCoverFlow);
        this.fancyCoverFlow.setAdapter(new FancyCoverFlowSampleAdapter(this));
        this.fancyCoverFlow.setUnselectedAlpha(1.0f);
        this.fancyCoverFlow.setUnselectedSaturation(0.0f);
        this.fancyCoverFlow.setUnselectedScale(0.5f);
        this.fancyCoverFlow.setSpacing(50);
        this.fancyCoverFlow.setMaxRotation(100);


        this.fancyCoverFlow.setScaleDownGravity(0.2f);
        this.fancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);

        this.fancyCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                try {
                    switch (position) {
                        case 0:
                            it = getPackageManager().getLaunchIntentForPackage("com.iiistudent.paintmaster");       //繪畫大師
                            startActivity(it);
                            break;
                        case 1:
                            it = getPackageManager().getLaunchIntentForPackage("com.iiistudent.bingo");             //賓果
                            startActivity(it);
                            break;
                        case 2:
                            it = getPackageManager().getLaunchIntentForPackage("com.systex.hkspractice");           //好康多
                            startActivity(it);
                            break;
                        case 3:
                            it = getPackageManager().getLaunchIntentForPackage("com.lonelyship.holdem");            //德州撲克
                            startActivity(it);
                            break;
                        case 4:
                            it = getPackageManager().getLaunchIntentForPackage("com.lonelyship.line_toy");          //搖頭娃娃
                            startActivity(it);
                            break;
                        case 5:
                            it = getPackageManager().getLaunchIntentForPackage("com.lonelyship.randomkeyboard");    //動鍵鍵盤
                            startActivity(it);
                            break;
                        case 6:
                            it = getPackageManager().getLaunchIntentForPackage("com.example.giftest");              //全息投影
                            startActivity(it);
                            break;
                        case 7:
                            it = getPackageManager().getLaunchIntentForPackage("com.example.kp");                   //kp太鼓達人
                            startActivity(it);
                            break;
//                    case 5:
//
//                        it = new Intent(IndexActivity.this,
//                                GalleryFileActivity.class);
//                        startActivity(it);
//
//                        break;

                        default:
                            break;
                    }
                    // Toast.makeText(getApplicationContext(),
                    // ((Integer)(position)).toString(), Toast.LENGTH_SHORT).show();
                    // AlphaDialog();

                }catch (Exception e)
                {

                }
            }

        });
    }

}
