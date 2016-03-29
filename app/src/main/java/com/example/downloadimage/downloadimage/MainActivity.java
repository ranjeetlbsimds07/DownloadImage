package com.example.downloadimage.downloadimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends Activity {

    private String reqStringURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reqStringURL = "http://www.allindiaflorist.com/imgs/arrangemen4.jpg";



        PostHitAsyncTask asyncTask = new PostHitAsyncTask(reqStringURL, new ILeadCaptureCallback() {
            @Override
            public void receivedLeadResponse(Bitmap response) {
                ImageView ivImage = (ImageView)findViewById(R.id.ivImage);
                ivImage.setImageBitmap(response);
            }
        });
        asyncTask.execute();



    }
    }
