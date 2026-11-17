package com.bumptech.glide.load;

import W0.l;
import com.bumptech.glide.load.ImageHeaderParser;
import f1.r;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    final class C0108a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f6129a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Z0.b f6130b;

        C0108a(l lVar, Z0.b bVar) {
            this.f6129a = lVar;
            this.f6130b = bVar;
        }

        public final ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            r rVar = null;
            try {
                r rVar2 = new r(new FileInputStream(this.f6129a.a().getFileDescriptor()), this.f6130b);
                try {
                    ImageHeaderParser.ImageType imageTypeC = imageHeaderParser.c(rVar2);
                    try {
                        rVar2.close();
                    } catch (IOException unused) {
                    }
                    this.f6129a.a();
                    return imageTypeC;
                } catch (Throwable th) {
                    th = th;
                    rVar = rVar2;
                    if (rVar != null) {
                        try {
                            rVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.f6129a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f6131a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Z0.b f6132b;

        b(l lVar, Z0.b bVar) {
            this.f6131a = lVar;
            this.f6132b = bVar;
        }

        public final int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            r rVar = null;
            try {
                r rVar2 = new r(new FileInputStream(this.f6131a.a().getFileDescriptor()), this.f6132b);
                try {
                    int iB = imageHeaderParser.b(rVar2, this.f6132b);
                    try {
                        rVar2.close();
                    } catch (IOException unused) {
                    }
                    this.f6131a.a();
                    return iB;
                } catch (Throwable th) {
                    th = th;
                    rVar = rVar2;
                    if (rVar != null) {
                        try {
                            rVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.f6131a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private interface c {
    }

    private interface d {
    }

    public static int a(List<ImageHeaderParser> list, l lVar, Z0.b bVar) throws IOException {
        return c(list, new b(lVar, bVar));
    }

    public static int b(List<ImageHeaderParser> list, InputStream inputStream, Z0.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new r(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                int iB = list.get(i2).b(inputStream, bVar);
                if (iB != -1) {
                    return iB;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    private static int c(List<ImageHeaderParser> list, c cVar) throws Throwable {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iA = ((b) cVar).a(list.get(i2));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType d(List<ImageHeaderParser> list, l lVar, Z0.b bVar) throws IOException {
        return f(list, new C0108a(lVar, bVar));
    }

    public static ImageHeaderParser.ImageType e(List<ImageHeaderParser> list, InputStream inputStream, Z0.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new r(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ImageHeaderParser.ImageType imageTypeC = list.get(i2).c(inputStream);
                inputStream.reset();
                if (imageTypeC != ImageHeaderParser.ImageType.UNKNOWN) {
                    return imageTypeC;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    private static ImageHeaderParser.ImageType f(List<ImageHeaderParser> list, d dVar) throws Throwable {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = ((C0108a) dVar).a(list.get(i2));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
