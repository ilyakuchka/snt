package com.android.mmt.transaction;

import android.app.NotificationManager;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.mmt.R;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.transaction.NotificationAssistService;
import com.android.mmt.ui.TimePickActivity;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class NotificationAssistService extends Service {

    /* renamed from: i, reason: collision with root package name */
    private static final Uri f4510i = Uri.parse("content://mms-sms");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f4511j = 0;

    public static void a(NotificationAssistService notificationAssistService, Uri uri) {
        notificationAssistService.d(uri);
        notificationAssistService.getApplicationContext().getContentResolver().call(f4510i, "updateThreadsForVerificationCodes", (String) null, (Bundle) null);
    }

    public static /* synthetic */ void b(NotificationAssistService notificationAssistService, Uri uri, Intent intent) {
        notificationAssistService.d(uri);
        long longExtra = intent.getLongExtra("extra_threadid", -1L);
        if (longExtra > 0) {
            BugleDatabase.y().x().s(new ArrayList(Arrays.asList(Long.valueOf(longExtra))));
        }
    }

    private void c(int i2, long j2) {
        if (j2 != -1) {
            C0.a.b(j2);
        } else {
            ((NotificationManager) getSystemService("notification")).cancel(i2);
        }
        C0.a.a();
    }

    private void d(Uri uri) {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("read", (Integer) 1);
        contentValues.put("seen", (Integer) 1);
        getContentResolver().update(uri, contentValues, null, null);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i2, int i4) {
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("function_type"))) {
            final int i5 = 0;
            intent.getBooleanExtra("is_verification_code", false);
            int intExtra = intent.getIntExtra("extra_notification_id", -1);
            final Uri data = intent.getData();
            intent.getStringExtra("extra_address");
            if ("function_copy".equalsIgnoreCase(intent.getStringExtra("function_type"))) {
                String stringExtra = intent.getStringExtra("extra_text");
                if (!TextUtils.isEmpty(stringExtra)) {
                    ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, stringExtra));
                    Toast.makeText(this, getString(R.string.copy_verification_code_tip), 0).show();
                    Q2.c.a(new O0.i(this, data, 0));
                    c(intExtra, intent.getLongExtra("extra_threadid", -1L));
                }
            } else if ("function_delete".equalsIgnoreCase(intent.getStringExtra("function_type"))) {
                Q2.c.a(new Runnable(this) { // from class: O0.h

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ NotificationAssistService f796j;

                    {
                        this.f796j = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i5) {
                            case 0:
                                NotificationAssistService notificationAssistService = this.f796j;
                                Uri uri = data;
                                Intent intent2 = intent;
                                int i6 = NotificationAssistService.f4511j;
                                notificationAssistService.getContentResolver().delete(uri, null, null);
                                long longExtra = intent2.getLongExtra("extra_threadid", -1L);
                                if (longExtra > 0) {
                                    L0.b.a(longExtra, true);
                                    break;
                                }
                                break;
                            default:
                                NotificationAssistService.b(this.f796j, data, intent);
                                break;
                        }
                    }
                });
                c(intExtra, intent.getLongExtra("extra_threadid", -1L));
            } else if ("function_seen".equalsIgnoreCase(intent.getStringExtra("function_type"))) {
                final int i6 = 1;
                Q2.c.a(new Runnable(this) { // from class: O0.h

                    /* renamed from: j, reason: collision with root package name */
                    public final /* synthetic */ NotificationAssistService f796j;

                    {
                        this.f796j = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i6) {
                            case 0:
                                NotificationAssistService notificationAssistService = this.f796j;
                                Uri uri = data;
                                Intent intent2 = intent;
                                int i62 = NotificationAssistService.f4511j;
                                notificationAssistService.getContentResolver().delete(uri, null, null);
                                long longExtra = intent2.getLongExtra("extra_threadid", -1L);
                                if (longExtra > 0) {
                                    L0.b.a(longExtra, true);
                                    break;
                                }
                                break;
                            default:
                                NotificationAssistService.b(this.f796j, data, intent);
                                break;
                        }
                    }
                });
                c(intExtra, intent.getLongExtra("extra_threadid", -1L));
            } else if ("function_add_todo".equalsIgnoreCase(intent.getStringExtra("function_type"))) {
                c(intExtra, intent.getLongExtra("extra_threadid", -1L));
                Intent intent2 = new Intent(this, (Class<?>) TimePickActivity.class);
                intent2.putExtra("extra_text", intent.getStringExtra("extra_text"));
                intent2.setFlags(268435456);
                startActivity(intent2);
            }
        }
        return super.onStartCommand(intent, i2, i4);
    }
}
