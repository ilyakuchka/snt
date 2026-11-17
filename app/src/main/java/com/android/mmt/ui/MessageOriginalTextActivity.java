package com.android.mmt.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
public class MessageOriginalTextActivity extends miuix.appcompat.app.h {

    /* renamed from: N, reason: collision with root package name */
    public static final /* synthetic */ int f5012N = 0;

    /* renamed from: A, reason: collision with root package name */
    private FrameLayout f5013A;

    /* renamed from: B, reason: collision with root package name */
    private FrameLayout f5014B;

    /* renamed from: C, reason: collision with root package name */
    private TextView f5015C;

    /* renamed from: D, reason: collision with root package name */
    private TextView f5016D;

    /* renamed from: E, reason: collision with root package name */
    private int f5017E;

    /* renamed from: F, reason: collision with root package name */
    private int f5018F;

    /* renamed from: G, reason: collision with root package name */
    private int f5019G;

    /* renamed from: H, reason: collision with root package name */
    private String f5020H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f5021I;

    /* renamed from: J, reason: collision with root package name */
    private String f5022J;

    /* renamed from: K, reason: collision with root package name */
    private long f5023K;
    private int L;
    private int M;

    /* renamed from: v, reason: collision with root package name */
    private RelativeLayout f5024v;

    /* renamed from: w, reason: collision with root package name */
    private RelativeLayout f5025w;

    /* renamed from: x, reason: collision with root package name */
    private LinearLayout f5026x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f5027y;

    /* renamed from: z, reason: collision with root package name */
    private RelativeLayout f5028z;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int paddingTop = (MessageOriginalTextActivity.this.f5025w.getPaddingTop() * 2) + MessageOriginalTextActivity.this.f5026x.getHeight();
            MessageOriginalTextActivity messageOriginalTextActivity = MessageOriginalTextActivity.this;
            MessageOriginalTextActivity.U(messageOriginalTextActivity, MessageOriginalTextActivity.S(messageOriginalTextActivity, paddingTop), MessageOriginalTextActivity.this.f5028z.getHeight(), MessageOriginalTextActivity.this.f5025w.getPaddingTop() * 2);
        }
    }

    final class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                return true;
            }
            MessageOriginalTextActivity messageOriginalTextActivity = MessageOriginalTextActivity.this;
            int i2 = MessageOriginalTextActivity.f5012N;
            Objects.requireNonNull(messageOriginalTextActivity);
            MessageOriginalTextActivity.V(MessageOriginalTextActivity.this);
            return true;
        }
    }

    static int S(MessageOriginalTextActivity messageOriginalTextActivity, int i2) {
        int i4 = messageOriginalTextActivity.f5017E;
        if (i2 >= i4) {
            i2 = i4;
        }
        return i2 == messageOriginalTextActivity.f5018F ? i2 + 1 : i2;
    }

    static void U(MessageOriginalTextActivity messageOriginalTextActivity, int i2, int i4, int i5) {
        if (i2 < messageOriginalTextActivity.f5017E) {
            return;
        }
        if (i4 <= 0) {
            i4 = messageOriginalTextActivity.getResources().getDimensionPixelSize(R.dimen.sms_card_understand_button_height) + messageOriginalTextActivity.getResources().getDimensionPixelSize(R.dimen.card_button_margin_top);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) messageOriginalTextActivity.f5027y.getLayoutParams();
        layoutParams.height = (i2 - i4) - i5;
        messageOriginalTextActivity.f5027y.setLayoutParams(layoutParams);
    }

    static void V(MessageOriginalTextActivity messageOriginalTextActivity) {
        messageOriginalTextActivity.finish();
        messageOriginalTextActivity.overridePendingTransition(0, R.anim.disappear);
    }

    @Override // miuix.appcompat.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        finish();
        overridePendingTransition(0, R.anim.disappear);
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        Resources resources;
        int i2;
        super.onCreate(bundle);
        setContentView(R.layout.message_anim_view);
        this.f5024v = (RelativeLayout) findViewById(R.id.message_anim_fullscreen);
        this.f5025w = (RelativeLayout) findViewById(R.id.original_text_container);
        this.f5026x = (LinearLayout) findViewById(R.id.message_container);
        this.f5027y = (TextView) findViewById(R.id.original_text);
        this.f5028z = (RelativeLayout) findViewById(R.id.text_footer);
        this.f5013A = (FrameLayout) findViewById(R.id.btn_favor);
        this.f5014B = (FrameLayout) findViewById(R.id.btn_copy);
        this.f5015C = (TextView) findViewById(R.id.text_favor);
        this.f5016D = (TextView) findViewById(R.id.text_copy);
        this.f5018F = getIntent().getIntExtra("height", 0);
        this.f5019G = getIntent().getIntExtra("width", 0);
        getIntent().getIntExtra("location_y", 0);
        this.f5020H = getIntent().getStringExtra("body");
        this.L = getIntent().getIntExtra("topMargin", 0);
        this.M = getIntent().getIntExtra("bottomMargin", 0);
        this.f5021I = getIntent().getBooleanExtra("locked", false);
        this.f5022J = getIntent().getStringExtra("msg_type");
        this.f5023K = getIntent().getLongExtra("msg_id", -1L);
        this.f5017E = (getResources().getDisplayMetrics().heightPixels - this.L) - this.M;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5025w.getLayoutParams();
        layoutParams.width = this.f5019G;
        this.f5025w.setLayoutParams(layoutParams);
        this.f5027y.setTextIsSelectable(true);
        this.f5027y.setText(this.f5020H);
        this.f5027y.setLinkTextColor(getResources().getColor(R.color.message_highlight_text_in_color));
        this.f5015C.setTextSize(0, getResources().getDimension(R.dimen.card_original_text_button_text_size));
        this.f5016D.setTextSize(0, getResources().getDimension(R.dimen.card_original_text_button_text_size));
        this.f5015C.setTextColor(getResources().getColor(R.color.card_original_text_primary));
        this.f5016D.setTextColor(getResources().getColor(R.color.card_original_text_primary));
        TextView textView = this.f5015C;
        if (this.f5021I) {
            resources = getResources();
            i2 = R.string.menu_unlock;
        } else {
            resources = getResources();
            i2 = R.string.menu_lock;
        }
        textView.setText(resources.getString(i2));
        this.f5016D.setText(getResources().getString(R.string.copy_message_text));
        this.f5027y.setOnClickListener(new p0(this));
        this.f5013A.setOnClickListener(new q0(this));
        this.f5014B.setOnClickListener(new r0(this));
        this.f5026x.post(new a());
        this.f5024v.setOnTouchListener(new b());
    }
}
