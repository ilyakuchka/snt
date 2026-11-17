package P0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.mmt.R;
import x0.C0414a;
import x0.C0415b;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    private Context f892a;

    /* renamed from: b, reason: collision with root package name */
    private C0414a f893b;

    /* renamed from: c, reason: collision with root package name */
    private miuix.appcompat.app.b f894c;

    public F(Context context, miuix.appcompat.app.b bVar, C0415b c0415b) {
        this.f892a = context;
        this.f894c = bVar;
        if (c0415b == null || c0415b.size() == 0 || c0415b.get(0) == null) {
            Y1.a.k("updateTitle mContact is null", new Object[0]);
        } else {
            b(c0415b);
        }
    }

    public final void a() {
        C0414a c0414a = this.f893b;
        if (c0414a != null) {
            synchronized (c0414a) {
            }
            if (this.f893b.Z() > 0) {
                Uri uriF0 = this.f893b.f0();
                if (uriF0 == null) {
                    Y1.a.k("onMenuItemIdContactLook uri is null", new Object[0]);
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW", uriF0);
                intent.putExtra("ignoreDefaultUpBehavior", true);
                int i2 = r.f937c;
                intent.setPackage("com.android.contacts");
                this.f892a.startActivity(intent);
                return;
            }
            if (this.f893b.i0()) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.putExtra("data1", this.f893b.W());
                int i4 = r.f937c;
                intent2.setPackage("com.android.contacts");
                this.f892a.startActivity(intent2);
                return;
            }
            Intent intent3 = new Intent("android.intent.action.VIEW");
            intent3.putExtra("number", this.f893b.W());
            int i5 = r.f937c;
            intent3.setPackage("com.android.contacts");
            this.f892a.startActivity(intent3);
        }
    }

    public final void b(C0415b c0415b) {
        if (c0415b == null || c0415b.size() == 0 || c0415b.get(0) == null || c0415b.get(0).equals(this.f893b)) {
            Y1.a.k("updateTitle mContact is null", new Object[0]);
            return;
        }
        C0414a c0414a = c0415b.get(0);
        this.f893b = c0414a;
        String strU = c0414a.U();
        String strW = this.f893b.W();
        String strX = this.f893b.X();
        synchronized (this.f893b) {
        }
        synchronized (this.f893b) {
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (strU.equals(strW)) {
            sb.append(strW);
        } else {
            sb.append(strU);
        }
        synchronized (this.f893b) {
        }
        if (!TextUtils.isEmpty(null)) {
            sb2.append(this.f892a.getResources().getString(R.string.mark_number_by_own_dialog_subtitle, null));
        } else if (!strU.equals(strW)) {
            synchronized (this.f893b) {
            }
            if (TextUtils.isEmpty(strX)) {
                sb2.append(strW);
            } else {
                sb2.append(strW + " " + strX);
            }
        } else if (!TextUtils.isEmpty(strX)) {
            sb2.append(strX);
        }
        this.f894c.i();
        if (PhoneNumberUtils.isGlobalPhoneNumber(sb.toString())) {
            this.f894c.n(PhoneNumberUtils.createTtsSpannable(sb));
        } else {
            this.f894c.n(sb);
        }
        if (PhoneNumberUtils.isGlobalPhoneNumber(sb2.toString())) {
            this.f894c.l(PhoneNumberUtils.createTtsSpannable(sb2));
        } else {
            this.f894c.l(sb2);
        }
        this.f894c.u(0);
        this.f894c.w(false);
    }
}
