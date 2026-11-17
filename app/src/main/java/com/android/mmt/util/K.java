package com.android.mmt.util;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    private static miuix.appcompat.app.g f5905a;

    public interface a {
        void a();

        void b();
    }

    public static void a(int i2, int i4, Context context, a aVar, DialogInterface dialogInterface) {
        if (e(i2)) {
            C0286s.a(context, i4);
        }
        if (aVar != null) {
            aVar.a();
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            f5905a = null;
        }
        C.f(MmsApp.c(), "key_user_last_reject_time", System.currentTimeMillis());
    }

    public static void b(int i2, Context context, int i4, a aVar, DialogInterface dialogInterface) {
        if (e(i2)) {
            C0286s.a(context, i4);
        }
        if (514 == i4) {
            androidx.preference.g.c(MmsApp.c()).edit().putBoolean("key_recommend_mx_banner_show", true).apply();
        }
        if (513 == i4) {
            androidx.preference.g.c(MmsApp.c()).edit().putBoolean("key_recommend_smart_sms_banner_show", true).apply();
        }
        C.f(MmsApp.c(), "key_user_last_reject_time", System.currentTimeMillis());
        if (aVar != null) {
            aVar.b();
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            f5905a = null;
        }
    }

    public static void c(Context context, Handler handler, Handler handler2) {
        if (context == null || handler == null || handler2 == null) {
            return;
        }
        f();
        handler2.sendMessage(handler.obtainMessage(1008));
    }

    public static void d(Handler handler) {
        handler.removeMessages(520);
        handler.removeMessages(514);
        handler.removeMessages(513);
        handler.removeMessages(515);
    }

    private static boolean e(int i2) {
        return (i2 == 3 || i2 == 4) ? false : true;
    }

    private static void f() {
        Log.d("RecommendHelper", "getRecommendType: 512");
    }

    public static boolean g(Context context, int i2, a aVar, int i4) {
        Button button;
        StringBuilder sbC = C2.c.c("Recommend.handleMessage: ", i2, " | ");
        sbC.append(D2.e.j(i4));
        Log.d("RecommendHelper", sbC.toString());
        if (context == null) {
            return false;
        }
        if (i2 == 520) {
            aVar.b();
            return true;
        }
        switch (i2) {
            case 513:
            case 514:
                int i5 = i2 == 514 ? R.string.recommend_free_internet_message : R.string.recommend_free_smart_server;
                int i6 = i2 == 514 ? R.drawable.recommend_mx_enable_dialog_banner : R.drawable.recommend_smart_sms_enable_dialog_banner;
                I i7 = new I(i4, i2, context, aVar);
                I i8 = new I(i4, context, i2, aVar);
                if (f5905a == null) {
                    J j2 = new DialogInterface.OnShowListener() { // from class: com.android.mmt.util.J
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                        }
                    };
                    View viewInflate = LayoutInflater.from(context).inflate(R.layout.recommend_dialog, (ViewGroup) null, false);
                    g.a aVar2 = new g.a(context);
                    aVar2.z(viewInflate);
                    aVar2.x(i5);
                    aVar2.c(false);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.recommend_message);
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.mx_title);
                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.mx_summary0);
                    TextView textView4 = (TextView) viewInflate.findViewById(R.id.mx_summary1);
                    TextView textView5 = (TextView) viewInflate.findViewById(R.id.smart_title);
                    TextView textView6 = (TextView) viewInflate.findViewById(R.id.smart_summary0);
                    TextView textView7 = (TextView) viewInflate.findViewById(R.id.smart_summary1);
                    Button button2 = (Button) viewInflate.findViewById(R.id.turnOn);
                    TextView textView8 = (TextView) viewInflate.findViewById(R.id.ignore);
                    Y1.a.e((TextView) viewInflate.findViewById(R.id.recommend_mg), textView);
                    if (i2 == 514) {
                        textView2.setVisibility(0);
                        textView3.setVisibility(0);
                        textView4.setVisibility(8);
                        button = button2;
                    } else {
                        button = button2;
                        if (i2 == 513) {
                            textView5.setVisibility(0);
                            textView6.setVisibility(0);
                            textView7.setVisibility(0);
                        } else {
                            textView2.setVisibility(0);
                            textView3.setVisibility(0);
                            textView4.setVisibility(8);
                            textView5.setVisibility(0);
                            textView6.setVisibility(0);
                            textView7.setVisibility(0);
                        }
                    }
                    TextView textView9 = (TextView) viewInflate.findViewById(R.id.message);
                    ((ImageView) viewInflate.findViewById(R.id.img_view)).setImageResource(i6);
                    textView9.setVisibility(8);
                    textView9.setMovementMethod(LinkMovementMethod.getInstance());
                    textView9.setTextDirection(5);
                    CharSequence text = textView.getText();
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    if (text instanceof Spanned) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
                        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, text.length(), URLSpan.class);
                        if (uRLSpanArr.length != 0) {
                            for (URLSpan uRLSpan : uRLSpanArr) {
                                int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
                                int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
                                spannableStringBuilder.removeSpan(uRLSpan);
                                String url = uRLSpan.getURL();
                                if (spanStart >= 0 && spanEnd >= 0) {
                                    spannableStringBuilder.setSpan(new F(context, url), spanStart, spanEnd, 17);
                                }
                            }
                            text = spannableStringBuilder;
                        }
                        textView.setText(text);
                    }
                    miuix.appcompat.app.g gVarA = aVar2.A();
                    gVarA.setOnShowListener(j2);
                    button.setOnClickListener(new D(i7, gVarA));
                    textView8.setOnClickListener(new E(i8, gVarA));
                    f5905a = gVarA;
                    androidx.preference.g.c(MmsApp.c()).edit().putInt("key_dialog_show_counts", androidx.preference.g.c(MmsApp.c()).getInt("key_dialog_show_counts", 0) + 1).apply();
                    Log.i("RecommendHelper", "show single recommend dialog ,is from main:" + e(i4) + " from:" + D2.e.j(i4));
                    break;
                }
                break;
        }
        return false;
    }

    public static boolean h(Context context) {
        f();
        return false;
    }
}
