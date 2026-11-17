package h0;

import android.content.ContentUris;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.Telephony;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import q.g;

/* loaded from: classes.dex */
public final class c extends AbstractC0330a<Uri, d> {

    /* renamed from: e, reason: collision with root package name */
    private static final UriMatcher f6314e;

    /* renamed from: f, reason: collision with root package name */
    private static final SparseArray<Integer> f6315f;
    private static c g;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<HashSet<Uri>> f6316b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private final g<Long, HashSet<Uri>> f6317c = new g<>();
    private final HashSet<Uri> d = new HashSet<>();

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f6314e = uriMatcher;
        uriMatcher.addURI("mms", null, 0);
        uriMatcher.addURI("mms", "#", 1);
        uriMatcher.addURI("mms", "inbox", 2);
        uriMatcher.addURI("mms", "inbox/#", 3);
        uriMatcher.addURI("mms", "sent", 4);
        uriMatcher.addURI("mms", "sent/#", 5);
        uriMatcher.addURI("mms", "drafts", 6);
        uriMatcher.addURI("mms", "drafts/#", 7);
        uriMatcher.addURI("mms", "outbox", 8);
        uriMatcher.addURI("mms", "outbox/#", 9);
        uriMatcher.addURI("mms-sms", "conversations", 10);
        uriMatcher.addURI("mms-sms", "conversations/#", 11);
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f6315f = sparseArray;
        sparseArray.put(2, 1);
        sparseArray.put(4, 2);
        sparseArray.put(6, 3);
        sparseArray.put(8, 4);
    }

    private c() {
    }

    public static final synchronized c e() {
        if (g == null) {
            g = new c();
        }
        return g;
    }

    private void h(Integer num) {
        if (num != null) {
            HashSet<Uri> hashSet = this.f6316b.get(num.intValue());
            this.f6316b.remove(num.intValue());
            if (hashSet != null) {
                Iterator<Uri> it = hashSet.iterator();
                while (it.hasNext()) {
                    Uri next = it.next();
                    this.d.remove(next);
                    d dVarB = b(next);
                    if (dVarB != null) {
                        l(next, dVarB);
                    }
                }
            }
        }
    }

    private d i(Uri uri) {
        this.d.remove(uri);
        d dVarB = b(uri);
        if (dVarB == null) {
            return null;
        }
        l(uri, dVarB);
        k(uri, dVarB);
        return dVarB;
    }

    private void k(Uri uri, d dVar) {
        HashSet<Uri> orDefault = this.f6317c.getOrDefault(Long.valueOf(dVar.a()), null);
        if (orDefault != null) {
            orDefault.remove(uri);
        }
    }

    private void l(Uri uri, d dVar) {
        HashSet<Uri> orDefault = this.f6317c.getOrDefault(Long.valueOf(dVar.c()), null);
        if (orDefault != null) {
            orDefault.remove(uri);
        }
    }

    public final synchronized boolean f(Uri uri) {
        return this.d.contains(uri);
    }

    public final synchronized d g(Uri uri) {
        int iMatch = f6314e.match(uri);
        switch (iMatch) {
            case 0:
            case 10:
                synchronized (this) {
                    super.c();
                    this.f6316b.clear();
                    this.f6317c.clear();
                    this.d.clear();
                }
                return null;
            case 1:
                return i(uri);
            case 2:
            case 4:
            case 6:
            case 8:
                h(f6315f.get(iMatch));
                return null;
            case 3:
            case 5:
            case 7:
            case 9:
                return i(Uri.withAppendedPath(Telephony.Mms.CONTENT_URI, uri.getLastPathSegment()));
            case 11:
                HashSet<Uri> hashSetRemove = this.f6317c.remove(Long.valueOf(ContentUris.parseId(uri)));
                if (hashSetRemove != null) {
                    Iterator<Uri> it = hashSetRemove.iterator();
                    while (it.hasNext()) {
                        Uri next = it.next();
                        this.d.remove(next);
                        d dVarB = b(next);
                        if (dVarB != null) {
                            k(next, dVarB);
                        }
                    }
                }
                return null;
            default:
                return null;
        }
    }

    public final synchronized boolean j(Uri uri, d dVar) {
        boolean zD;
        int iA = dVar.a();
        HashSet<Uri> hashSet = this.f6316b.get(iA);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f6316b.put(iA, hashSet);
        }
        long jC = dVar.c();
        Uri uriWithAppendedPath = null;
        HashSet<Uri> orDefault = this.f6317c.getOrDefault(Long.valueOf(jC), null);
        if (orDefault == null) {
            orDefault = new HashSet<>();
            this.f6317c.put(Long.valueOf(jC), orDefault);
        }
        int iMatch = f6314e.match(uri);
        if (iMatch == 1) {
            uriWithAppendedPath = uri;
        } else if (iMatch == 3 || iMatch == 5 || iMatch == 7 || iMatch == 9) {
            uriWithAppendedPath = Uri.withAppendedPath(Telephony.Mms.CONTENT_URI, uri.getLastPathSegment());
        }
        zD = d(uriWithAppendedPath, dVar);
        if (zD) {
            hashSet.add(uriWithAppendedPath);
            orDefault.add(uriWithAppendedPath);
        }
        m(uri, false);
        return zD;
    }

    public final synchronized void m(Uri uri, boolean z4) {
        if (z4) {
            this.d.add(uri);
        } else {
            this.d.remove(uri);
        }
    }
}
