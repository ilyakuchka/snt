package W0;

import W0.e;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* loaded from: classes.dex */
public final class l implements e<ParcelFileDescriptor> {

    /* renamed from: a, reason: collision with root package name */
    private final b f1815a;

    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // W0.e.a
        public final Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        @Override // W0.e.a
        public final e<ParcelFileDescriptor> b(ParcelFileDescriptor parcelFileDescriptor) {
            return new l(parcelFileDescriptor);
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ParcelFileDescriptor f1816a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f1816a = parcelFileDescriptor;
        }

        final ParcelFileDescriptor a() throws IOException, ErrnoException {
            try {
                Os.lseek(this.f1816a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.f1816a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    public l(ParcelFileDescriptor parcelFileDescriptor) {
        this.f1815a = new b(parcelFileDescriptor);
    }

    @Override // W0.e
    public final void b() {
    }

    @Override // W0.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ParcelFileDescriptor a() throws IOException {
        return this.f1815a.a();
    }
}
