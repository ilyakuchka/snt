package v;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public Context f7939a;

    /* renamed from: e, reason: collision with root package name */
    CharSequence f7942e;

    /* renamed from: f, reason: collision with root package name */
    CharSequence f7943f;
    PendingIntent g;

    /* renamed from: h, reason: collision with root package name */
    Bitmap f7944h;

    /* renamed from: i, reason: collision with root package name */
    int f7945i;

    /* renamed from: k, reason: collision with root package name */
    h f7947k;

    /* renamed from: l, reason: collision with root package name */
    String f7948l;

    /* renamed from: m, reason: collision with root package name */
    Bundle f7949m;

    /* renamed from: n, reason: collision with root package name */
    String f7950n;

    /* renamed from: o, reason: collision with root package name */
    boolean f7951o;
    Notification p;

    /* renamed from: q, reason: collision with root package name */
    @Deprecated
    public ArrayList<String> f7952q;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<C0398e> f7940b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<k> f7941c = new ArrayList<>();
    ArrayList<C0398e> d = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    boolean f7946j = true;

    public g(Context context, String str) {
        Notification notification = new Notification();
        this.p = notification;
        this.f7939a = context;
        this.f7950n = str;
        notification.when = System.currentTimeMillis();
        this.p.audioStreamType = -1;
        this.f7945i = 0;
        this.f7952q = new ArrayList<>();
        this.f7951o = true;
    }

    protected static CharSequence c(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final g a(C0398e c0398e) {
        this.f7940b.add(c0398e);
        return this;
    }

    public final Notification b() {
        return new i(this).a();
    }

    public final g d() {
        this.f7948l = "msg";
        return this;
    }

    public final g e(PendingIntent pendingIntent) {
        this.g = pendingIntent;
        return this;
    }

    public final g f(CharSequence charSequence) {
        this.f7943f = c(charSequence);
        return this;
    }

    public final g g(CharSequence charSequence) {
        this.f7942e = c(charSequence);
        return this;
    }

    public final g h() {
        Notification notification = this.p;
        notification.defaults = -1;
        notification.flags |= 1;
        return this;
    }

    public final g i(Bundle bundle) {
        this.f7949m = bundle;
        return this;
    }

    public final g j() {
        this.f7945i = 1;
        return this;
    }

    public final g k() {
        this.f7946j = true;
        return this;
    }

    public final g l(int i2) {
        this.p.icon = i2;
        return this;
    }

    public final g m(Uri uri) {
        Notification notification = this.p;
        notification.sound = uri;
        notification.audioStreamType = -1;
        notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
        return this;
    }

    public final g n(h hVar) {
        if (this.f7947k != hVar) {
            this.f7947k = hVar;
            if (hVar.f7953a != this) {
                hVar.f7953a = this;
                n(hVar);
            }
        }
        return this;
    }

    public final g o(CharSequence charSequence) {
        this.p.tickerText = c(charSequence);
        return this;
    }

    public final g p(long j2) {
        this.p.when = j2;
        return this;
    }
}
