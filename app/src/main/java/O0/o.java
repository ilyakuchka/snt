package O0;

import a.C0178a;
import android.content.Context;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import f0.C0303b;
import g0.C0309e;
import g0.C0314j;
import g0.C0319o;
import g0.C0321q;
import java.io.IOException;

/* loaded from: classes.dex */
public final class o extends com.android.mmt.transaction.l implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    private final Uri f812s;

    public o(Context context, v vVar, String str) {
        super(context, vVar);
        Uri uri = Uri.parse(str);
        this.f812s = uri;
        this.f4642m.c(uri);
        this.f4641l = str;
    }

    @Override // com.android.mmt.transaction.l
    public final int g() {
        return 3;
    }

    @Override // com.android.mmt.transaction.l
    public final void j() {
        Q2.c.a(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0319o c0319oE = C0319o.e(this.f4640k.getApplicationContext());
        try {
            C0321q c0321q = (C0321q) c0319oE.h(this.f812s);
            String strF = C0178a.f(this.f4640k, (int) this.p);
            if (TextUtils.isEmpty(strF)) {
                Log.e("ReadRecTransaction", "lineNumber is empty");
                strF = "";
            }
            c0321q.b(new C0309e(strF));
            k(new C0314j(this.f4640k, c0321q).l(), null);
            Uri uriM = c0319oE.m(this.f812s, Telephony.Mms.Sent.CONTENT_URI);
            this.f4642m.d(1);
            this.f4642m.c(uriM);
        } catch (C0303b unused) {
            if (this.f4642m.b() != 1) {
            }
        } catch (IOException unused2) {
            if (this.f4642m.b() != 1) {
            }
        } catch (RuntimeException unused3) {
            if (this.f4642m.b() != 1) {
            }
        } catch (Throwable th) {
            if (this.f4642m.b() != 1) {
                this.f4642m.d(2);
                this.f4642m.c(this.f812s);
            }
            c();
            throw th;
        }
        if (this.f4642m.b() != 1) {
            this.f4642m.d(2);
            this.f4642m.c(this.f812s);
        }
        c();
    }
}
