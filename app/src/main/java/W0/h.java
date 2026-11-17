package W0;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class h extends b {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f1802l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(AssetManager assetManager, String str, int i2) {
        super(assetManager, str);
        this.f1802l = i2;
    }

    @Override // W0.d
    public final Class a() {
        switch (this.f1802l) {
            case 0:
                return ParcelFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }
}
