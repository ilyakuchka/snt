package com.android.mmt.provider;

import C2.c;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.android.mmt.R;
import com.android.mmt.util.C0275g;
import com.android.mmt.util.M;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MmsSettingsSearchProvider extends ContentProvider {

    class a {

        /* renamed from: a, reason: collision with root package name */
        String f4495a;

        /* renamed from: b, reason: collision with root package name */
        String f4496b = "";

        /* renamed from: c, reason: collision with root package name */
        String f4497c;
        String d;

        /* renamed from: e, reason: collision with root package name */
        String f4498e;

        public a(String str, String str2, String str3, String str4, String str5) {
            this.f4495a = str;
            this.f4497c = str2;
            this.d = str3;
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                this.f4498e = "";
            } else {
                this.f4498e = c.a(str4, ":", str5);
            }
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        MatrixCursor matrixCursor = new MatrixCursor(M.f5910a);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(getContext().getString(R.string.title_show_list_avatar), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_show_list_avatar"));
        arrayList.add(new a(getContext().getString(R.string.title_show_photo_word), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_show_photo_word"));
        arrayList.add(new a(getContext().getString(R.string.title_show_blocked_messages), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_show_blocked_messages"));
        arrayList.add(new a(getContext().getString(R.string.pref_title_delivery_reports), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_delivery_reports"));
        arrayList.add(new a(getContext().getString(R.string.pref_delivery_ringtone), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_delivery_ringtone"));
        if (C0275g.d() || C0275g.b()) {
            arrayList.add(new a(getContext().getString(R.string.pref_title_auto_delete), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_auto_delete"));
            arrayList.add(new a(getContext().getString(R.string.pref_title_sms_delete), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_sms_delete_limit"));
            arrayList.add(new a(getContext().getString(R.string.pref_title_mms_delete), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_mms_delete_limit"));
        }
        if (C0275g.a()) {
            arrayList.add(new a(getContext().getString(R.string.title_use_gsm_alphabet), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_use_gsm_alphabet"));
        }
        arrayList.add(new a(getContext().getString(R.string.pref_title_notification_body_enabled), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_enable_notification_body"));
        arrayList.add(new a(getContext().getString(R.string.found_wild_messages_title), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_key_download_wild_msg"));
        int i2 = C0275g.f5975b;
        arrayList.add(new a(getContext().getString(R.string.pref_cell_broadcast), getContext().getPackageName(), "com.android.mmt.ui.MessagingPreferenceActivity", "extra_preference_key", "pref_cell_broadcast"));
        arrayList.add(new a(getContext().getString(R.string.pref_advanced_settings_title), getContext().getPackageName(), "com.android.mmt.ui.MessagingAdvancedPreferenceActivity", "", ""));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            matrixCursor.newRow().add("title", aVar.f4495a).add("intentAction", aVar.f4496b).add("intentTargetPackage", aVar.f4497c).add("intentTargetClass", aVar.d).add("extras", aVar.f4498e);
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
