package com.android.mmt.ui;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class MessageFullscreenActivity extends miuix.appcompat.app.h {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f4919w = 0;

    /* renamed from: v, reason: collision with root package name */
    private TextView f4920v;

    final class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                return true;
            }
            MessageFullscreenActivity messageFullscreenActivity = MessageFullscreenActivity.this;
            int i2 = MessageFullscreenActivity.f4919w;
            messageFullscreenActivity.finish();
            messageFullscreenActivity.overridePendingTransition(0, R.anim.disappear);
            return true;
        }
    }

    final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MessageFullscreenActivity messageFullscreenActivity = MessageFullscreenActivity.this;
            int i2 = MessageFullscreenActivity.f4919w;
            messageFullscreenActivity.finish();
            messageFullscreenActivity.overridePendingTransition(0, R.anim.disappear);
        }
    }

    @Override // miuix.appcompat.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.disappear);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.message_fullscreen_view);
        String stringExtra = getIntent().getStringExtra("body");
        TextView textView = (TextView) findViewById(R.id.message_body);
        this.f4920v = textView;
        textView.setTextIsSelectable(true);
        this.f4920v.setText(stringExtra);
        ((RelativeLayout) findViewById(R.id.message_fullscreen)).setOnTouchListener(new a());
        ((LinearLayout) findViewById(R.id.text_container)).setOnClickListener(new b());
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onResume() {
        super.onResume();
        if (this.f4920v == null || com.android.mmt.util.e0.d(this) != 5) {
            return;
        }
        this.f4920v.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.message_fullscreen_textsize_godzillaui));
        this.f4920v.setMaxWidth((int) getResources().getDimension(R.dimen.message_fullscreen_width_godzillaui));
    }
}
