package com.github.twocoffeesoneteam.glidetovectoryou;

import android.graphics.drawable.PictureDrawable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.Target;

/**
 * Listener which updates the {@link ImageView} to be software rendered, because
 * {@link com.caverock.androidsvg.SVG SVG}/{@link android.graphics.Picture Picture} can't render on
 * a hardware backed {@link android.graphics.Canvas Canvas}.
 */
public class SvgSoftwareLayerSetter implements RequestListener<PictureDrawable> {

    GlideToVectorYouListener customListener;

    SvgSoftwareLayerSetter(GlideToVectorYouListener listener) {
        this.customListener = listener;
    }


    SvgSoftwareLayerSetter() {
    }

    @Override
    public boolean onLoadFailed(GlideException e, Object model, Target<PictureDrawable> target,
                                boolean isFirstResource) {
        ImageView view = ((ImageViewTarget<?>) target).getView();
        view.setLayerType(ImageView.LAYER_TYPE_NONE, null);

        if (customListener != null) {
            customListener.onLoadFailed();
        }
        return false;
    }

    @Override
    public boolean onResourceReady(PictureDrawable resource, Object model,
                                   Target<PictureDrawable> target, DataSource dataSource, boolean isFirstResource) {
        ImageView view = ((ImageViewTarget<?>) target).getView();
        view.setLayerType(ImageView.LAYER_TYPE_SOFTWARE, null);

        if (customListener != null) {
            customListener.onResourceReady();
        }

        return false;
    }
}
