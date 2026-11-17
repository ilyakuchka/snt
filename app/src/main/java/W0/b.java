package W0;

import W0.d;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: i, reason: collision with root package name */
    private final String f1788i;

    /* renamed from: j, reason: collision with root package name */
    private final AssetManager f1789j;

    /* renamed from: k, reason: collision with root package name */
    /* JADX INFO: Incorrect field signature: TT; */
    private Closeable f1790k;

    public b(AssetManager assetManager, String str) {
        this.f1789j = assetManager;
        this.f1788i = str;
    }

    @Override // W0.d
    public final void b() throws IOException {
        Closeable closeable = this.f1790k;
        if (closeable == null) {
            return;
        }
        try {
            switch (((h) this).f1802l) {
                case 0:
                    ((ParcelFileDescriptor) closeable).close();
                    break;
                default:
                    ((InputStream) closeable).close();
                    break;
            }
        } catch (IOException unused) {
        }
    }

    @Override // W0.d
    public final void c(com.bumptech.glide.f fVar, d.a<? super T> aVar) throws IOException {
        Closeable parcelFileDescriptor;
        try {
            AssetManager assetManager = this.f1789j;
            String str = this.f1788i;
            switch (((h) this).f1802l) {
                case 0:
                    parcelFileDescriptor = assetManager.openFd(str).getParcelFileDescriptor();
                    break;
                default:
                    parcelFileDescriptor = assetManager.open(str);
                    break;
            }
            this.f1790k = parcelFileDescriptor;
            aVar.f(parcelFileDescriptor);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
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
}
