package X0;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
final class d {

    /* renamed from: f, reason: collision with root package name */
    private static final a f1829f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final a f1830a = f1829f;

    /* renamed from: b, reason: collision with root package name */
    private final c f1831b;

    /* renamed from: c, reason: collision with root package name */
    private final Z0.b f1832c;
    private final ContentResolver d;

    /* renamed from: e, reason: collision with root package name */
    private final List<ImageHeaderParser> f1833e;

    d(List<ImageHeaderParser> list, c cVar, Z0.b bVar, ContentResolver contentResolver) {
        this.f1831b = cVar;
        this.f1832c = bVar;
        this.d = contentResolver;
        this.f1833e = list;
    }

    final int a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.d.openInputStream(uri);
                int iB = com.bumptech.glide.load.a.b(this.f1833e, inputStreamOpenInputStream, this.f1832c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iB;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x001b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:10:0x001b */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022 A[PHI: r3
      0x0022: PHI (r3v8 android.database.Cursor) = (r3v3 android.database.Cursor), (r3v10 android.database.Cursor) binds: [B:24:0x0048, B:13:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputStream b(Uri uri) throws Throwable {
        SecurityException e2;
        Cursor cursorA;
        Cursor cursor;
        String string;
        boolean z4 = false;
        Cursor cursor2 = null;
        try {
            try {
                cursorA = this.f1831b.a(uri);
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SecurityException e4) {
            e2 = e4;
            cursorA = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursorA != null) {
            try {
            } catch (SecurityException e5) {
                e2 = e5;
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e2);
                }
                if (cursorA != null) {
                }
                string = null;
                if (TextUtils.isEmpty(string)) {
                }
            }
            if (cursorA.moveToFirst()) {
                string = cursorA.getString(0);
                cursorA.close();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                Objects.requireNonNull(this.f1830a);
                File file = new File(string);
                Objects.requireNonNull(this.f1830a);
                if (file.exists()) {
                    Objects.requireNonNull(this.f1830a);
                    if (0 < file.length()) {
                        z4 = true;
                    }
                }
                if (!z4) {
                    return null;
                }
                Uri uriFromFile = Uri.fromFile(file);
                try {
                    return this.d.openInputStream(uriFromFile);
                } catch (NullPointerException e6) {
                    throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e6));
                }
            }
        }
        if (cursorA != null) {
            cursorA.close();
        }
        string = null;
        if (TextUtils.isEmpty(string)) {
        }
    }
}
