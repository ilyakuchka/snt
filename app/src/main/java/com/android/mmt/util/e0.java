package com.android.mmt.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public final class e0 {
    public static miuix.appcompat.app.g a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, boolean z4, boolean z5) {
        String string;
        String string2 = context.getString(z4 ? R.string.confirm_dialog_locked_title : R.string.confirm_dialog_title);
        if (z5) {
            string2 = context.getString(R.string.confirm_dialog_title);
            string = context.getString(R.string.confirm_delete_group_message);
        } else {
            string = context.getString(z4 ? R.string.confirm_delete_locked_message : R.string.confirm_delete_message);
        }
        g.a aVar = new g.a(context);
        aVar.y(string2);
        aVar.h();
        aVar.c(true);
        aVar.k(string);
        aVar.t(R.string.delete, onClickListener);
        aVar.m(R.string.no, onClickListener2);
        return aVar.A();
    }

    public static CharSequence b(TextView textView, String str, String str2, int i2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String[] strArrSplit = str2.split(" ");
        if (strArrSplit.length < 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(Pattern.quote(strArrSplit[0]));
        for (int i4 = 1; i4 < strArrSplit.length; i4++) {
            sb.append("|");
            sb.append(Pattern.quote(strArrSplit[i4]));
        }
        Pattern patternCompile = Pattern.compile(sb.toString(), 2);
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = patternCompile.matcher(str);
        while (matcher.find()) {
            spannableString.setSpan(new P0.L(textView.getContext(), i2), matcher.start(), matcher.end(), 18);
        }
        return spannableString;
    }

    public static miuix.appcompat.app.g c(Context context, int i2) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_loading_dialog, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.progress_text)).setText(i2);
        g.a aVar = new g.a(context);
        aVar.c(false);
        aVar.z(viewInflate);
        return aVar.a();
    }

    public static int d(Context context) {
        switch (Settings.System.getInt(context.getContentResolver(), "ui_mode_scale", 0)) {
            case 11:
                return 5;
            case 12:
                return 0;
            case 13:
                return 1;
            case 14:
                return 3;
            case 15:
                return 4;
            default:
                return 2;
        }
    }

    public static boolean e(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean f() {
        Configuration configuration = MmsApp.c().getResources().getConfiguration();
        return configuration != null && configuration.fontScale > 1.0f;
    }

    public static boolean g(Context context) {
        return d(context) > 3;
    }

    public static boolean h() {
        return (MmsApp.c().getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static void i(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        attributes.flags |= 65536;
    }

    public static void j(TextView textView, String str, String str2, int i2) {
        textView.setText(b(textView, str, str2, i2));
    }
}
