package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    int status;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                switch (status) {
                    case 0:
                        imageView.animate()
                                .scaleX(1)
                                .scaleY(1)
                                .rotation(360)
                                .alpha(1.0F)
                                .translationX(500)
                                .setInterpolator(new DecelerateInterpolator())
                                .setDuration(1000);
                        break;
                    case 1:
                        imageView.animate()
                                .scaleX(0)
                                .scaleY(0)
                                .rotation(0)
                                .alpha(0F)
                                .translationX(0)
                                .setInterpolator(new DecelerateInterpolator())
                                .setDuration(1000);
                        break;

                }
                status++;
                if (status == 2) {
                    status = 0;
                }

            }
        });
    }
}
