package y;

import C.j;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.util.Objects;
import miuix.appcompat.internal.app.widget.SearchActionModeView;
import q.f;
import x.C0412a;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final d f8144a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final f<String, Typeface> f8145b = new f<>(16);

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f8146c = 0;

    public static class a extends j.c {

        /* renamed from: a, reason: collision with root package name */
        private x.d f8147a;

        public a(x.d dVar) {
            this.f8147a = dVar;
        }

        @Override // C.j.c
        public final void a(int i2) {
        }

        @Override // C.j.c
        public final void b(Typeface typeface) {
            x.d dVar = this.f8147a;
            if (dVar != null) {
                dVar.d(typeface);
            }
        }
    }

    public static Typeface a(Context context, j.b[] bVarArr, int i2) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        Objects.requireNonNull(f8144a);
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : SearchActionModeView.ANIMATION_DURATION, (i2 & 2) != 0 ? 1 : 0)).build();
                }
                j.b bVar = bVarArr[i4];
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.c(), "r", null);
                } catch (IOException unused) {
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                    i4++;
                } else {
                    try {
                        Font.Builder weight = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.d());
                        if (!bVar.e()) {
                            i5 = 0;
                        }
                        Font fontBuild = weight.setSlant(i5).setTtcIndex(bVar.b()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                parcelFileDescriptorOpenFileDescriptor.close();
                i4++;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Typeface b(Context context, C0412a.InterfaceC0143a interfaceC0143a, Resources resources, int i2, int i4, x.d dVar) throws IOException {
        Typeface typefaceA;
        if (interfaceC0143a instanceof C0412a.d) {
            C0412a.d dVar2 = (C0412a.d) interfaceC0143a;
            String strC = dVar2.c();
            Typeface typeface = null;
            if (strC != null && !strC.isEmpty()) {
                Typeface typefaceCreate = Typeface.create(strC, 0);
                Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
                if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                    typeface = typefaceCreate;
                }
            }
            if (typeface != null) {
                dVar.b(typeface);
                return typeface;
            }
            typefaceA = j.a(context, dVar2.b(), i4, dVar2.a() == 0, dVar2.d(), x.d.c(), new a(dVar));
        } else {
            typefaceA = f8144a.a(context, (C0412a.b) interfaceC0143a, resources, i4);
            if (typefaceA != null) {
                dVar.b(typefaceA);
            } else {
                dVar.a();
            }
        }
        if (typefaceA != null) {
            f8145b.c(d(resources, i2, i4), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface c(Resources resources, int i2, int i4) throws IOException {
        Typeface typefaceBuild;
        Objects.requireNonNull(f8144a);
        try {
            Font fontBuild = new Font.Builder(resources, i2).build();
            typefaceBuild = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            typefaceBuild = null;
        }
        if (typefaceBuild != null) {
            f8145b.c(d(resources, i2, i4), typefaceBuild);
        }
        return typefaceBuild;
    }

    private static String d(Resources resources, int i2, int i4) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i4;
    }

    public static Typeface e(Resources resources, int i2, int i4) {
        return f8145b.b(d(resources, i2, i4));
    }
}
