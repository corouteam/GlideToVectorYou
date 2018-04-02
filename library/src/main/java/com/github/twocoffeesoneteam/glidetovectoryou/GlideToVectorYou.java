package com.github.twocoffeesoneteam.glidetovectoryou;

import android.app.Activity;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class GlideToVectorYou {

    private static GlideToVectorYou instance;

    private Activity activity;
    private RequestBuilder<PictureDrawable> requestBuilder;
    private int placeHolderLoading = -1;
    private int placeHolderError = -1;

    public static GlideToVectorYou init(){
        if (instance == null) {
            instance = new GlideToVectorYou();
        }

        return instance;
    }

    public GlideToVectorYou with(Activity activity){
        this.activity = activity;
        createRequestBuilder();

        return instance;
    }

    public GlideToVectorYou withListener(GlideToVectorYouListener listener) {
        requestBuilder.listener(new SvgSoftwareLayerSetter(listener));

        return instance;
    }

    public GlideToVectorYou setPlaceHolder(int placeHolderLoading, int placeHolderError) {
        this.placeHolderError = placeHolderError;
        this.placeHolderLoading = placeHolderLoading;

        return instance;
    }

    public void load(Uri uri, ImageView imageView) {
        if (placeHolderLoading != -1 && placeHolderError != -1) {
            requestBuilder.apply(
                    new RequestOptions()
                            .placeholder(placeHolderLoading)
                            .error(placeHolderError));
        }

        requestBuilder.load(uri).into(imageView);

    }

    public static void justLoadImage(Activity activity, Uri uri, ImageView imageView){
        GlideApp.with(activity)
                .as(PictureDrawable.class)
                .listener(new SvgSoftwareLayerSetter()).load(uri).into(imageView);
    }

    public RequestBuilder<PictureDrawable> getRequestBuilder() {
        return requestBuilder;
    }

    private void createRequestBuilder(){
        requestBuilder = GlideApp.with(activity)
                .as(PictureDrawable.class)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .listener(new SvgSoftwareLayerSetter());
    }

}
