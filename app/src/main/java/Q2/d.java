package Q2;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class d<Params, Progress, Result, T> extends AsyncTask<Params, Progress, Result> {

    /* renamed from: a, reason: collision with root package name */
    protected WeakReference<T> f1201a;

    public d(T t2) {
        this.f1201a = new WeakReference<>(t2);
    }

    protected abstract Object a(Object obj);

    protected abstract void b(T t2, Result result);

    @Override // android.os.AsyncTask
    protected final Result doInBackground(Params[] paramsArr) {
        T t2 = this.f1201a.get();
        if (t2 != null) {
            return (Result) a(t2);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Result result) {
        T t2 = this.f1201a.get();
        if (t2 != null) {
            b(t2, result);
        }
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        this.f1201a.get();
    }

    @Override // android.os.AsyncTask
    protected final void onProgressUpdate(Progress[] progressArr) {
        this.f1201a.get();
    }
}
