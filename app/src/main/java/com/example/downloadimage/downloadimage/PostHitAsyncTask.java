package com.example.downloadimage.downloadimage;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Ranjeet Singh on 9/17/2015.
 */
public class PostHitAsyncTask extends AsyncTask<String, String, Bitmap> {

    private ILeadCaptureCallback callback;
    private String url;

    public PostHitAsyncTask(String url,ILeadCaptureCallback callback) {
        this.callback = callback;
        this.url = url;
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        URL url;
        String response = "";
        Bitmap bitmap = null;
        try {
            url = new URL(this.url);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            int responseCode=conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        callback.receivedLeadResponse(result);
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(String... text) {
    }
}
