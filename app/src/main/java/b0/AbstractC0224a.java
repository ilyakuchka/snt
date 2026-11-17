package b0;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: b0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0224a {

    /* renamed from: a, reason: collision with root package name */
    private final DataSetObservable f4310a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    private DataSetObserver f4311b;

    public abstract void a(Object obj);

    public abstract void b();

    public abstract int c();

    public abstract int d(Object obj);

    public abstract Object e(ViewGroup viewGroup, int i2);

    public abstract boolean f(View view, Object obj);

    public final void g() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.f4311b;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.f4310a.notifyChanged();
    }

    public abstract void h(Object obj);

    final void i(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f4311b = dataSetObserver;
        }
    }
}
