package W0;

import W0.d;
import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class k<T> implements d<T> {

    /* renamed from: i, reason: collision with root package name */
    private final Uri f1812i;

    /* renamed from: j, reason: collision with root package name */
    private final ContentResolver f1813j;

    /* renamed from: k, reason: collision with root package name */
    private T f1814k;

    public k(ContentResolver contentResolver, Uri uri) {
        this.f1813j = contentResolver;
        this.f1812i = uri;
    }

    @Override // W0.d
    public final void b() {
        T t2 = this.f1814k;
        if (t2 != null) {
            try {
                e(t2);
            } catch (IOException unused) {
            }
        }
    }

    @Override // W0.d
    public final void c(com.bumptech.glide.f fVar, d.a<? super T> aVar) {
        try {
            T tF = f(this.f1812i, this.f1813j);
            this.f1814k = tF;
            aVar.f(tF);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.e(e2);
        }
    }

    @Override // W0.d
    public final void cancel() {
    }

    @Override // W0.d
    public final V0.a d() {
        return V0.a.f1747i;
    }

    protected abstract void e(T t2) throws IOException;

    protected abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
