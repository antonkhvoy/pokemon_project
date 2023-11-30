package com.example.pokemon_project.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.function.Consumer;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    Consumer<Bitmap> callBack;

    public DownloadImageTask(ImageView bmImage, Consumer<Bitmap> callBack) {
        this.bmImage = bmImage;
        this.callBack = callBack;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
        callBack.accept(result);
    }
}
