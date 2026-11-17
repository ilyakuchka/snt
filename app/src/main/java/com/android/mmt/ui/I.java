package com.android.mmt.ui;

import android.widget.Toast;
import com.android.mmt.R;
import com.android.mmt.ui.DeleteMessageDialogActivity;
import com.android.mmt.ui.P;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class I implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4850i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4851j;

    public /* synthetic */ I(Object obj, int i2) {
        this.f4850i = i2;
        this.f4851j = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4850i) {
            case 0:
                DeleteMessageDialogActivity.a aVar = (DeleteMessageDialogActivity.a) this.f4851j;
                DeleteMessageDialogActivity.this.getContentResolver().delete(DeleteMessageDialogActivity.this.f4755w, null, null);
                break;
            case 1:
                P.t tVar = (P.t) this.f4851j;
                if (!tVar.f5301i.isFinishing() && !tVar.f5301i.isDestroyed()) {
                    tVar.f5301i.C0();
                    tVar.f5301i.V0();
                    break;
                }
                break;
            case 2:
                Toast.makeText(((C0230a) this.f4851j).f5506a, R.string.fail_to_add_attachment, 0).show();
                break;
            default:
                MmsTabActivity mmsTabActivity = (MmsTabActivity) this.f4851j;
                int i2 = MmsTabActivity.f5055F;
                Objects.requireNonNull(mmsTabActivity);
                break;
        }
    }
}
