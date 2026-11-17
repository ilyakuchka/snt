package com.android.mmt.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.mmt.R;
import x0.C0415b;
import x0.C0416c;

/* loaded from: classes.dex */
public class ComposeMessageRouterActivity extends Activity {
    public static Intent a(Context context, long j2) {
        Intent intent = new Intent();
        c(intent, j2);
        d(context, intent);
        return intent;
    }

    public static Uri b(long j2, long j4, String str, String str2) {
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("sms").appendPath("conversation").appendPath(String.valueOf(j2)).appendQueryParameter("select_id", String.valueOf(j4));
        if (!TextUtils.isEmpty(str)) {
            builderAppendQueryParameter.appendQueryParameter("highlight_text", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builderAppendQueryParameter.appendQueryParameter("body_substitution", P0.r.u(str2, str, 30, 10)).build();
        }
        return builderAppendQueryParameter.build();
    }

    public static void c(Intent intent, long j2) {
        if (j2 > 0) {
            intent.putExtra("thread_id", j2);
        }
    }

    public static void d(Context context, Intent intent) {
        C0416c c0416cX;
        long longExtra = intent.getLongExtra("thread_id", -1L);
        if (longExtra != -1) {
            c0416cX = C0416c.v(longExtra);
        } else {
            Uri data = intent.getData();
            if (data != null) {
                c0416cX = C0416c.w(data);
            } else {
                String stringExtra = intent.getStringExtra("address");
                c0416cX = !TextUtils.isEmpty(stringExtra) ? C0416c.x(C0415b.l(stringExtra, true)) : null;
            }
        }
        if (c0416cX != null) {
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(c0416cX.I());
            objArr[1] = Integer.valueOf(c0416cX.C());
            objArr[2] = Integer.valueOf(c0416cX.G() == null ? 0 : c0416cX.G().size());
            Y1.a.c(String.format("routing: threadId=%d, messageCount=%d, recipientCount=%d", objArr), new Object[0]);
        } else {
            Y1.a.c("routing: conv=null", new Object[0]);
        }
        long longExtra2 = intent.getLongExtra("conversation_message_count", c0416cX != null ? c0416cX.C() : 0L);
        if (c0416cX == null || longExtra2 == 0 || c0416cX.G() == null || c0416cX.G().size() == 0 || c0416cX.I() == 0) {
            intent.putExtra("in_animation_extra", R.anim.push_up_in);
            intent.setClass(context, NewMessageActivity.class);
            return;
        }
        c(intent, c0416cX.I());
        if (c0416cX.G().size() > 1) {
            intent.setClass(context, MultipleRecipientsConversationActivity.class);
        } else {
            intent.setClass(context, SingleRecipientConversationActivity.class);
        }
    }

    public static void e(Context context, Intent intent) {
        d(context, intent);
        try {
            context.startActivity(intent, null);
        } catch (SecurityException e2) {
            Toast.makeText(context, R.string.fail_to_add_attachment, 0).show();
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NewMessagePopupActivity.z();
        if (com.android.mmt.util.c0.a(this)) {
            Y1.a.d("sms function disabled, abort routing", new Object[0]);
            finish();
            return;
        }
        Intent intent = getIntent();
        intent.putExtra("from_activity", "ComposeMessageRouterActivity");
        e(this, intent);
        int intExtra = getIntent().getIntExtra("in_animation_extra", -1);
        finish();
        if (intExtra == -1) {
            intExtra = 0;
        }
        overridePendingTransition(intExtra, 0);
    }
}
