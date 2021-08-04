package cc.shinichi.bigimageviewpager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.Random;

import cc.shinichi.library.ImagePreview;
import cc.shinichi.library.view.helper.ImageSource;
import cc.shinichi.library.view.photoview.PhotoView;

public class GifActivity extends AppCompatActivity {


    PhotoView imageGif;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif2);
        imageGif = findViewById(R.id.gif_view);
        String url =  "https://i.pinimg.com/originals/99/a0/11/99a01123f4f5ec82d359289b5dee2e8a.gif";

        String bigjpg = "http://img6.16fan.com/attachments/wenzhang/201805/18/152660818127263ge.jpeg";

        imageGif.setZoomTransitionDuration(ImagePreview.getInstance().getZoomTransitionDuration());
        imageGif.setMinimumScale(0.5f);
        imageGif.setMaximumScale(8.0f);
        imageGif.setScaleType(ImageView.ScaleType.FIT_CENTER);


        if(new Random().nextBoolean()){
            Glide.with(this)
                    .load(bigjpg)
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(ImagePreview.getInstance().getErrorPlaceHolder()))
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            if(e != null){
                                e.printStackTrace();
                            }
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(imageGif);
            return;
        }


        Glide.with(this)
                .asGif()
                .load(url)
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(ImagePreview.getInstance().getErrorPlaceHolder()))
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target,
                                                boolean isFirstResource) {
                        if(e != null){
                            e.printStackTrace();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageGif);
    }
}
