package Q0;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Telephony;
import com.android.mmt.util.O;

/* loaded from: classes.dex */
final class k implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f1112i;

    k(Context context) {
        this.f1112i = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Settings.System.putInt(this.f1112i.getContentResolver(), "mms_upload_old_msg_state", 0);
        Settings.System.putString(this.f1112i.getContentResolver(), "mms_upload_old_msg_accounts", null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("account", (String) null);
        contentValues.put("bind_id", (Integer) 0);
        Context context = this.f1112i;
        O.g(context, context.getContentResolver(), Telephony.Sms.CONTENT_URI, contentValues, "account is not null and account != ?", new String[]{null});
        Context context2 = this.f1112i;
        O.g(context2, context2.getContentResolver(), Telephony.Mms.CONTENT_URI, contentValues, "account is not null and account != ?", new String[]{null});
        int i4 = P0.r.f937c;
        new Bundle().putBoolean("force", true);
    }
}
