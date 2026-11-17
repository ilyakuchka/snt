package Q0;

import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;

/* loaded from: classes.dex */
final class l implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f1113i;

    l(Context context) {
        this.f1113i = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Settings.System.putInt(this.f1113i.getContentResolver(), "mms_upload_old_msg_state", 0);
        Settings.System.putString(this.f1113i.getContentResolver(), "mms_upload_old_msg_accounts", null);
    }
}
