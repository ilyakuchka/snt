package f1;

import Y0.x;
import android.graphics.Bitmap;
import java.io.IOException;

/* loaded from: classes.dex */
public final class u implements V0.j<Bitmap, Bitmap> {

    private static final class a implements x<Bitmap> {

        /* renamed from: i, reason: collision with root package name */
        private final Bitmap f6231i;

        a(Bitmap bitmap) {
            this.f6231i = bitmap;
        }

        @Override // Y0.x
        public final int b() {
            return s1.j.d(this.f6231i);
        }

        @Override // Y0.x
        public final Class<Bitmap> c() {
            return Bitmap.class;
        }

        @Override // Y0.x
        public final void d() {
        }

        @Override // Y0.x
        public final Bitmap get() {
            return this.f6231i;
        }
    }

    @Override // V0.j
    public final /* bridge */ /* synthetic */ boolean a(Bitmap bitmap, V0.h hVar) throws IOException {
        return true;
    }

    @Override // V0.j
    public final x<Bitmap> b(Bitmap bitmap, int i2, int i4, V0.h hVar) throws IOException {
        return new a(bitmap);
    }
}
