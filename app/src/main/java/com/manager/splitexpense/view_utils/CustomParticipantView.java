package com.manager.splitexpense.view_utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.manager.splitexpense.R;
import com.manager.splitexpense.listeners.BaseView;
import com.manager.splitexpense.listeners.IValueObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomParticipantView extends LinearLayout implements BaseView {
    private IValueObserver iValueObserver;

    public CustomParticipantView(Context context) {
        super(context);
//        this.iValueObserver = iValueObserver;

        initView(context);
    }

    private void initView(Context context) {
        setOrientation(LinearLayout.HORIZONTAL);
        View v = inflate(context, R.layout.itemview_participant,null);

        addView(v);

    }

    public CustomParticipantView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CustomParticipantView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    @NotNull
    @Override
    public String getValue() {
        return null;
    }
}
