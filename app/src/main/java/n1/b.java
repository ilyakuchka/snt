package n1;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f7479a = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<com.bumptech.glide.load.ImageHeaderParser>] */
    public final synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f7479a.add(imageHeaderParser);
    }

    public final synchronized List<ImageHeaderParser> b() {
        return this.f7479a;
    }
}
