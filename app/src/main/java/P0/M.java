package P0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.android.mmt.util.C0283o;
import com.android.mmt.util.O;
import f0.C0303b;
import g0.C0318n;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.util.ByteArrayBuffer;

/* loaded from: classes.dex */
public final class M {

    /* renamed from: a, reason: collision with root package name */
    private final Context f905a;

    /* renamed from: b, reason: collision with root package name */
    private final Uri f906b;

    /* renamed from: c, reason: collision with root package name */
    private String f907c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private String f908e;

    /* renamed from: f, reason: collision with root package name */
    private int f909f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f910h;

    public M(Context context, Uri uri) throws Throwable {
        int iLastIndexOf;
        InputStream inputStreamOpenInputStream;
        Cursor cursorE;
        String string;
        int columnIndex;
        if (context == null || uri == null) {
            throw new C0303b("context or uri is null");
        }
        InputStream inputStream = null;
        if (uri.getScheme().equals("content")) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                cursorE = O.e(context, contentResolver, uri, null, null, null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
                cursorE = null;
            }
            if (cursorE == null) {
                throw new C0303b("Query on " + uri + " returns null result.");
            }
            try {
                if (cursorE.getCount() != 1 || !cursorE.moveToFirst()) {
                    throw new C0303b("Query on " + uri + " returns 0 or multiple rows.");
                }
                if (G0.k.w(uri)) {
                    string = cursorE.getString(cursorE.getColumnIndexOrThrow("fn"));
                    string = TextUtils.isEmpty(string) ? cursorE.getString(cursorE.getColumnIndexOrThrow("_data")) : string;
                    this.f907c = cursorE.getString(cursorE.getColumnIndexOrThrow("ct"));
                    this.f910h = C0283o.c(context, uri);
                } else {
                    String path = uri.getPath();
                    try {
                        try {
                            this.f907c = cursorE.getString(cursorE.getColumnIndexOrThrow("mime_type"));
                        } catch (IllegalArgumentException unused) {
                            this.f907c = cursorE.getString(cursorE.getColumnIndexOrThrow("mimetype"));
                        }
                    } catch (IllegalArgumentException unused2) {
                        this.f907c = contentResolver.getType(uri);
                    }
                    int iC = C0283o.c(context, uri);
                    this.f910h = iC;
                    if (iC == 0 && (columnIndex = cursorE.getColumnIndex("orientation")) != -1) {
                        this.f910h = cursorE.getInt(columnIndex) % 360;
                    }
                    string = path;
                }
                this.d = string;
            } finally {
                cursorE.close();
            }
        } else if (uri.getScheme().equals("file")) {
            this.d = uri.getPath();
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(this.d);
            if (TextUtils.isEmpty(fileExtensionFromUrl) && (iLastIndexOf = this.d.lastIndexOf(46)) >= 0) {
                fileExtensionFromUrl = this.d.substring(iLastIndexOf + 1);
            }
            this.f907c = fileExtensionFromUrl == null ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
            this.f910h = C0283o.b(uri.getPath());
        }
        if (TextUtils.isEmpty(this.d)) {
            throw new C0303b("mPath is empty");
        }
        String str = this.d;
        String strSubstring = str.substring(str.lastIndexOf(47) + 1);
        this.f908e = strSubstring;
        if (strSubstring.startsWith(".") && this.f908e.length() > 1) {
            this.f908e = this.f908e.substring(1);
        }
        this.f908e = this.f908e.replace(' ', '_');
        this.f905a = context;
        this.f906b = uri;
        try {
            try {
                try {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                } catch (FileNotFoundException e4) {
                    e = e4;
                }
            } catch (Throwable th) {
                th = th;
                inputStreamOpenInputStream = inputStream;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (this.f910h % 180 == 0) {
                    this.f909f = options.outWidth;
                    this.g = options.outHeight;
                } else {
                    this.g = options.outWidth;
                    this.f909f = options.outHeight;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                inputStream = inputStreamOpenInputStream;
                Log.e("Mms/image", "IOException caught while opening stream", e);
                if (inputStream != null) {
                    inputStream.close();
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e6) {
                        Log.e("Mms/image", "IOException caught while closing stream", e6);
                    }
                }
                throw th;
            }
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
        } catch (IOException e7) {
            Log.e("Mms/image", "IOException caught while closing stream", e7);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final Bitmap a(int i2) throws IOException {
        Bitmap bitmapDecodeStream;
        InputStream inputStreamOpenInputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i4 = 1;
        while (true) {
            bitmapDecodeStream = null;
            try {
                inputStreamOpenInputStream = this.f905a.getContentResolver().openInputStream(this.f906b);
            } catch (FileNotFoundException unused) {
                Y1.a.d("Cannot open bitmap %s", this.f906b.toString());
                inputStreamOpenInputStream = null;
            }
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            options.inSampleSize = i2;
            try {
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    S2.d.c(inputStreamOpenInputStream);
                    break;
                } catch (OutOfMemoryError unused2) {
                    Log.w("Mms/image", "getResizedImageData: img too large to decode (OutOfMemoryError), may try with larger sampleSize. Curr sampleSize=" + i2);
                    i2 *= 2;
                    i4++;
                    S2.d.c(inputStreamOpenInputStream);
                    if (i4 >= 8) {
                        break;
                    }
                }
            } catch (Throwable th) {
                S2.d.c(inputStreamOpenInputStream);
                throw th;
            }
        }
        return bitmapDecodeStream;
    }

    public final String b() {
        return this.f907c;
    }

    public final int c() {
        return this.g;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:(3:379|6|7)|(3:381|8|(2:16|(2:17|(2:19|(2:387|21)(1:22))(1:386)))(0))|326|41|48) */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0227, code lost:
    
        if (r16 == null) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0229, code lost:
    
        r16.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x022d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x022e, code lost:
    
        android.util.Log.e("Mms/image", r0.getMessage(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        r0 = r12.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        r10.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0083: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:44:0x0083 */
    /* JADX WARN: Removed duplicated region for block: B:100:0x014a A[Catch: all -> 0x0161, OutOfMemoryError -> 0x0163, FileNotFoundException -> 0x0165, TRY_ENTER, TRY_LEAVE, TryCatch #2 {FileNotFoundException -> 0x0165, blocks: (B:100:0x014a, B:125:0x019f), top: B:318:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e5 A[Catch: all -> 0x02ad, FileNotFoundException -> 0x02b0, OutOfMemoryError -> 0x02b3, TryCatch #5 {all -> 0x02ad, blocks: (B:137:0x01d1, B:139:0x01d5, B:142:0x01db, B:166:0x0243, B:171:0x0250, B:187:0x0297, B:202:0x02c8, B:204:0x02cf, B:208:0x02e9, B:207:0x02e5, B:209:0x0317, B:211:0x031e, B:221:0x0336, B:224:0x033d, B:201:0x02b4, B:170:0x0249, B:146:0x01e5, B:148:0x01fa, B:150:0x0217, B:152:0x021d, B:154:0x0222), top: B:321:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01fa A[Catch: all -> 0x02ad, FileNotFoundException -> 0x02b0, OutOfMemoryError -> 0x02b3, TRY_LEAVE, TryCatch #5 {all -> 0x02ad, blocks: (B:137:0x01d1, B:139:0x01d5, B:142:0x01db, B:166:0x0243, B:171:0x0250, B:187:0x0297, B:202:0x02c8, B:204:0x02cf, B:208:0x02e9, B:207:0x02e5, B:209:0x0317, B:211:0x031e, B:221:0x0336, B:224:0x033d, B:201:0x02b4, B:170:0x0249, B:146:0x01e5, B:148:0x01fa, B:150:0x0217, B:152:0x021d, B:154:0x0222), top: B:321:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x021d A[Catch: OutOfMemoryError -> 0x02ab, all -> 0x02ad, FileNotFoundException -> 0x02b0, TRY_ENTER, TryCatch #5 {all -> 0x02ad, blocks: (B:137:0x01d1, B:139:0x01d5, B:142:0x01db, B:166:0x0243, B:171:0x0250, B:187:0x0297, B:202:0x02c8, B:204:0x02cf, B:208:0x02e9, B:207:0x02e5, B:209:0x0317, B:211:0x031e, B:221:0x0336, B:224:0x033d, B:201:0x02b4, B:170:0x0249, B:146:0x01e5, B:148:0x01fa, B:150:0x0217, B:152:0x021d, B:154:0x0222), top: B:321:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0222 A[Catch: OutOfMemoryError -> 0x02ab, all -> 0x02ad, FileNotFoundException -> 0x02b0, TRY_LEAVE, TryCatch #5 {all -> 0x02ad, blocks: (B:137:0x01d1, B:139:0x01d5, B:142:0x01db, B:166:0x0243, B:171:0x0250, B:187:0x0297, B:202:0x02c8, B:204:0x02cf, B:208:0x02e9, B:207:0x02e5, B:209:0x0317, B:211:0x031e, B:221:0x0336, B:224:0x033d, B:201:0x02b4, B:170:0x0249, B:146:0x01e5, B:148:0x01fa, B:150:0x0217, B:152:0x021d, B:154:0x0222), top: B:321:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0260 A[Catch: all -> 0x02a0, FileNotFoundException -> 0x02a4, OutOfMemoryError -> 0x02a8, TryCatch #21 {FileNotFoundException -> 0x02a4, blocks: (B:172:0x0255, B:174:0x0260, B:178:0x026a, B:180:0x0271, B:186:0x0292, B:185:0x028b), top: B:342:0x0255 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x031e A[Catch: all -> 0x02ad, FileNotFoundException -> 0x02b0, OutOfMemoryError -> 0x0363, TryCatch #5 {all -> 0x02ad, blocks: (B:137:0x01d1, B:139:0x01d5, B:142:0x01db, B:166:0x0243, B:171:0x0250, B:187:0x0297, B:202:0x02c8, B:204:0x02cf, B:208:0x02e9, B:207:0x02e5, B:209:0x0317, B:211:0x031e, B:221:0x0336, B:224:0x033d, B:201:0x02b4, B:170:0x0249, B:146:0x01e5, B:148:0x01fa, B:150:0x0217, B:152:0x021d, B:154:0x0222), top: B:321:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x033d A[Catch: all -> 0x02ad, FileNotFoundException -> 0x02b0, OutOfMemoryError -> 0x0363, TRY_LEAVE, TryCatch #5 {all -> 0x02ad, blocks: (B:137:0x01d1, B:139:0x01d5, B:142:0x01db, B:166:0x0243, B:171:0x0250, B:187:0x0297, B:202:0x02c8, B:204:0x02cf, B:208:0x02e9, B:207:0x02e5, B:209:0x0317, B:211:0x031e, B:221:0x0336, B:224:0x033d, B:201:0x02b4, B:170:0x0249, B:146:0x01e5, B:148:0x01fa, B:150:0x0217, B:152:0x021d, B:154:0x0222), top: B:321:0x01d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0409 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0418 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x02cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x03af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0243 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0344 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x03be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0353 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x03d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x03e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:396:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013d A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r12v0, types: [int] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [int] */
    /* JADX WARN: Type inference failed for: r12v15, types: [int] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v27, types: [float] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.graphics.Rect] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0318n d(int i2, int i4, int i5) throws Throwable {
        byte[] byteArray;
        ?? width;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        IOException iOException;
        byte[] byteArray2;
        IOException iOException2;
        int i6;
        Bitmap bitmap;
        float f4;
        float f5;
        char c2;
        float f6;
        int i7;
        int i8;
        int i9;
        int i10;
        Bitmap bitmapCreateScaledBitmap;
        ByteArrayOutputStream byteArrayOutputStream3;
        int size;
        InputStream inputStream3;
        InputStream inputStreamOpenInputStream;
        int i11 = i2;
        int i12 = i4;
        C0318n c0318n = new C0318n();
        Bitmap bitmapOpenInputStream = 2;
        int i13 = 1;
        ?? r9 = 0;
        InputStream inputStream4 = null;
        if (this.f909f <= i11) {
            try {
                if (this.g <= i12) {
                    try {
                        inputStreamOpenInputStream = this.f905a.getContentResolver().openInputStream(this.f906b);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        inputStreamOpenInputStream = null;
                    } catch (IOException e4) {
                        e = e4;
                        inputStreamOpenInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream4 != null) {
                            try {
                                inputStream4.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[3];
                        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(4099);
                        int i14 = inputStreamOpenInputStream.read(bArr);
                        if (i14 == 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
                            byteArrayBuffer.append(bArr, 0, i14);
                            byte[] bArr2 = new byte[4096];
                            while (true) {
                                int i15 = inputStreamOpenInputStream.read(bArr2);
                                if (i15 == -1) {
                                    break;
                                }
                                if (byteArrayBuffer.length() + i15 > i5) {
                                    break;
                                }
                                byteArrayBuffer.append(bArr2, 0, i15);
                            }
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        e.printStackTrace();
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        byteArray = null;
                        if (byteArray != null) {
                        }
                        return c0318n;
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        byteArray = null;
                        if (byteArray != null) {
                        }
                        return c0318n;
                    }
                    inputStreamOpenInputStream.close();
                    byteArray = null;
                } else {
                    byteArray = null;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream4 = inputStream3;
            }
        }
        if (byteArray != null) {
            c0318n.r(byteArray);
            c0318n.q("image/gif".getBytes());
        } else {
            width = this.f909f;
            int height = this.g;
            try {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    int iC = C0283o.c(this.f905a, this.f906b);
                    int i16 = 1;
                    int i17 = 1;
                    inputStream2 = null;
                    Bitmap bitmapDecodeStream = null;
                    while (true) {
                        try {
                            bitmapOpenInputStream = this.f905a.getContentResolver().openInputStream(this.f906b);
                            try {
                                try {
                                    options.inSampleSize = i16;
                                    try {
                                        try {
                                            bitmapDecodeStream = BitmapFactory.decodeStream(bitmapOpenInputStream, r9, options);
                                        } catch (OutOfMemoryError unused2) {
                                            Log.w("Mms/image", "getResizedBitmap: img too large to decode (OutOfMemoryError), may try with larger sampleSize. Curr sampleSize=" + i16);
                                            i16 *= 2;
                                            i17++;
                                            if (bitmapOpenInputStream != 0) {
                                                try {
                                                    bitmapOpenInputStream.close();
                                                } catch (IOException e7) {
                                                    iOException2 = e7;
                                                    Log.e("Mms/image", iOException2.getMessage(), iOException2);
                                                    i6 = i17;
                                                    bitmapOpenInputStream = bitmapDecodeStream;
                                                    inputStream2 = null;
                                                    char c4 = '\b';
                                                    if (bitmapOpenInputStream == 0) {
                                                    }
                                                    try {
                                                        try {
                                                            break;
                                                            if (bitmapOpenInputStream != 0) {
                                                            }
                                                        } catch (FileNotFoundException e8) {
                                                            e = e8;
                                                            bitmapOpenInputStream = inputStream2;
                                                            width = 0;
                                                            bitmapOpenInputStream = bitmapOpenInputStream;
                                                            Log.e("Mms/image", e.getMessage(), e);
                                                            if (bitmapOpenInputStream != 0) {
                                                                try {
                                                                    bitmapOpenInputStream.close();
                                                                } catch (IOException e9) {
                                                                    Log.e("Mms/image", e9.getMessage(), e9);
                                                                }
                                                            }
                                                            if (width != 0) {
                                                                try {
                                                                    width.close();
                                                                } catch (IOException e10) {
                                                                    iOException = e10;
                                                                    bitmapOpenInputStream = bitmapOpenInputStream;
                                                                    width = width;
                                                                    Log.e("Mms/image", iOException.getMessage(), iOException);
                                                                    byteArray2 = null;
                                                                    if (byteArray2 == null) {
                                                                    }
                                                                }
                                                            }
                                                            byteArray2 = null;
                                                            if (byteArray2 == null) {
                                                            }
                                                        }
                                                    } catch (OutOfMemoryError e11) {
                                                        e = e11;
                                                        bitmapOpenInputStream = inputStream2;
                                                        width = 0;
                                                        bitmapOpenInputStream = bitmapOpenInputStream;
                                                        Log.e("Mms/image", e.getMessage(), e);
                                                        if (bitmapOpenInputStream != 0) {
                                                        }
                                                        if (width != 0) {
                                                        }
                                                        byteArray2 = null;
                                                        if (byteArray2 == null) {
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        inputStream = inputStream2;
                                                        byteArrayOutputStream2 = null;
                                                        th = th;
                                                        byteArrayOutputStream = byteArrayOutputStream2;
                                                        if (inputStream != null) {
                                                        }
                                                        if (byteArrayOutputStream == null) {
                                                        }
                                                    }
                                                    byteArray2 = null;
                                                    if (byteArray2 == null) {
                                                    }
                                                }
                                            }
                                        }
                                        if (bitmapDecodeStream != null) {
                                            if (bitmapOpenInputStream != 0) {
                                                try {
                                                    bitmapOpenInputStream.close();
                                                } catch (IOException e12) {
                                                    iOException2 = e12;
                                                    Log.e("Mms/image", iOException2.getMessage(), iOException2);
                                                    i6 = i17;
                                                    bitmapOpenInputStream = bitmapDecodeStream;
                                                    inputStream2 = null;
                                                    char c42 = '\b';
                                                    if (bitmapOpenInputStream == 0) {
                                                    }
                                                    break;
                                                    if (bitmapOpenInputStream != 0) {
                                                        Log.v("Mms/image", "getResizedImageData: gave up after too many attempts to resize");
                                                        if (inputStream2 != null) {
                                                            try {
                                                                inputStream2.close();
                                                            } catch (IOException e13) {
                                                                Log.e("Mms/image", e13.getMessage(), e13);
                                                            }
                                                        }
                                                    } else {
                                                        if (iC != 0) {
                                                            try {
                                                                Matrix matrix = new Matrix();
                                                                matrix.postRotate(iC);
                                                                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapOpenInputStream, 0, 0, bitmapOpenInputStream.getWidth(), bitmapOpenInputStream.getHeight(), matrix, false);
                                                                bitmapOpenInputStream = bitmapOpenInputStream;
                                                                if (bitmapOpenInputStream == bitmapCreateBitmap) {
                                                                    bitmapOpenInputStream = bitmapCreateBitmap;
                                                                    width = bitmapOpenInputStream.getWidth();
                                                                    height = bitmapOpenInputStream.getHeight();
                                                                } else {
                                                                    if (bitmapCreateBitmap != null) {
                                                                        try {
                                                                            bitmapOpenInputStream.recycle();
                                                                            bitmapOpenInputStream = bitmapCreateBitmap;
                                                                        } catch (Exception e14) {
                                                                            e = e14;
                                                                            bitmapOpenInputStream = bitmapCreateBitmap;
                                                                            Log.e("Mms/image", "createBitmap for rotate err", e);
                                                                            bitmap = bitmapOpenInputStream;
                                                                            f4 = 1.0f;
                                                                            while (true) {
                                                                                f5 = (float) width;
                                                                                if (f5 * f4 > i11) {
                                                                                }
                                                                                f4 *= f6;
                                                                                i11 = i2;
                                                                                i12 = i4;
                                                                                c42 = c2;
                                                                                i13 = 1;
                                                                            }
                                                                            i7 = 95;
                                                                            i8 = i13;
                                                                            width = 0;
                                                                            while (true) {
                                                                                try {
                                                                                    try {
                                                                                        try {
                                                                                        } catch (Throwable th5) {
                                                                                            th = th5;
                                                                                        }
                                                                                    } catch (FileNotFoundException e15) {
                                                                                        e = e15;
                                                                                    }
                                                                                } catch (OutOfMemoryError unused3) {
                                                                                    i9 = 0;
                                                                                }
                                                                                if (options.outWidth <= i11) {
                                                                                    int iMax = Math.max(i13, (int) (f5 * f4));
                                                                                    int iMax2 = Math.max(i13, (int) (bitmapOpenInputStream * f4));
                                                                                    if (Log.isLoggable("Mms:app", 2)) {
                                                                                    }
                                                                                    i9 = 0;
                                                                                    try {
                                                                                        bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iMax, iMax2, false);
                                                                                        if (bitmap != bitmapCreateScaledBitmap) {
                                                                                        }
                                                                                    } catch (OutOfMemoryError unused4) {
                                                                                        Log.w("Mms/image", "getResizedImageData - image too big (OutOfMemoryError), will try  with smaller scale factor, cur scale factor: " + f4);
                                                                                        width = width;
                                                                                        if (Log.isLoggable("Mms:app", 2)) {
                                                                                        }
                                                                                        f4 *= 0.75f;
                                                                                        i8++;
                                                                                        if (width == 0) {
                                                                                        }
                                                                                        return c0318n;
                                                                                    }
                                                                                    if (bitmapCreateScaledBitmap != null) {
                                                                                        if (width != 0) {
                                                                                        }
                                                                                        byteArrayOutputStream3 = new ByteArrayOutputStream();
                                                                                        try {
                                                                                            try {
                                                                                                bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i7, byteArrayOutputStream3);
                                                                                                size = byteArrayOutputStream3.size();
                                                                                                if (size > i5) {
                                                                                                }
                                                                                                bitmap = bitmapCreateScaledBitmap;
                                                                                                width = byteArrayOutputStream3;
                                                                                            } catch (FileNotFoundException e16) {
                                                                                                e = e16;
                                                                                                width = byteArrayOutputStream3;
                                                                                                bitmapOpenInputStream = inputStream2;
                                                                                                width = width;
                                                                                                Log.e("Mms/image", e.getMessage(), e);
                                                                                                if (bitmapOpenInputStream != 0) {
                                                                                                }
                                                                                                if (width != 0) {
                                                                                                }
                                                                                                byteArray2 = null;
                                                                                                if (byteArray2 == null) {
                                                                                                }
                                                                                            }
                                                                                        } catch (OutOfMemoryError unused5) {
                                                                                            bitmap = bitmapCreateScaledBitmap;
                                                                                            width = byteArrayOutputStream3;
                                                                                            Log.w("Mms/image", "getResizedImageData - image too big (OutOfMemoryError), will try  with smaller scale factor, cur scale factor: " + f4);
                                                                                            width = width;
                                                                                            if (Log.isLoggable("Mms:app", 2)) {
                                                                                            }
                                                                                            f4 *= 0.75f;
                                                                                            i8++;
                                                                                            if (width == 0) {
                                                                                            }
                                                                                            return c0318n;
                                                                                        } catch (Throwable th6) {
                                                                                            th = th6;
                                                                                            width = byteArrayOutputStream3;
                                                                                            inputStream = inputStream2;
                                                                                            byteArrayOutputStream2 = width;
                                                                                            th = th;
                                                                                            byteArrayOutputStream = byteArrayOutputStream2;
                                                                                            if (inputStream != null) {
                                                                                                try {
                                                                                                    inputStream.close();
                                                                                                } catch (IOException e17) {
                                                                                                    Log.e("Mms/image", e17.getMessage(), e17);
                                                                                                }
                                                                                            }
                                                                                            if (byteArrayOutputStream == null) {
                                                                                                throw th;
                                                                                            }
                                                                                            try {
                                                                                                byteArrayOutputStream.close();
                                                                                                throw th;
                                                                                            } catch (IOException e18) {
                                                                                                Log.e("Mms/image", e18.getMessage(), e18);
                                                                                                throw th;
                                                                                            }
                                                                                        }
                                                                                        if (Log.isLoggable("Mms:app", 2)) {
                                                                                        }
                                                                                        f4 *= 0.75f;
                                                                                        i8++;
                                                                                        if (width == 0) {
                                                                                        }
                                                                                    }
                                                                                    bitmap = bitmapCreateScaledBitmap;
                                                                                    Log.w("Mms/image", "getResizedImageData - image too big (OutOfMemoryError), will try  with smaller scale factor, cur scale factor: " + f4);
                                                                                    width = width;
                                                                                    if (Log.isLoggable("Mms:app", 2)) {
                                                                                    }
                                                                                    f4 *= 0.75f;
                                                                                    i8++;
                                                                                    if (width == 0) {
                                                                                    }
                                                                                }
                                                                                return c0318n;
                                                                                i11 = i2;
                                                                                i12 = i4;
                                                                                i13 = 1;
                                                                                width = width;
                                                                            }
                                                                            bitmap.recycle();
                                                                            if (i10 == 0) {
                                                                            }
                                                                            if (inputStream2 != null) {
                                                                            }
                                                                            if (width != 0) {
                                                                            }
                                                                            if (byteArray2 == null) {
                                                                            }
                                                                        }
                                                                    }
                                                                    width = bitmapOpenInputStream.getWidth();
                                                                    height = bitmapOpenInputStream.getHeight();
                                                                }
                                                            } catch (Exception e19) {
                                                                e = e19;
                                                            }
                                                            return c0318n;
                                                        }
                                                        bitmap = bitmapOpenInputStream;
                                                        f4 = 1.0f;
                                                        while (true) {
                                                            f5 = (float) width;
                                                            if (f5 * f4 > i11) {
                                                                bitmapOpenInputStream = height;
                                                                if (bitmapOpenInputStream * f4 <= i12) {
                                                                    break;
                                                                }
                                                                f6 = 0.75f;
                                                                c2 = '\b';
                                                            } else {
                                                                c2 = c42;
                                                                f6 = 0.75f;
                                                            }
                                                            f4 *= f6;
                                                            i11 = i2;
                                                            i12 = i4;
                                                            c42 = c2;
                                                            i13 = 1;
                                                        }
                                                        i7 = 95;
                                                        i8 = i13;
                                                        width = 0;
                                                        while (true) {
                                                            if (options.outWidth <= i11 || options.outHeight > i12 || (width != 0 && width.size() > i5)) {
                                                                int iMax3 = Math.max(i13, (int) (f5 * f4));
                                                                int iMax22 = Math.max(i13, (int) (bitmapOpenInputStream * f4));
                                                                if (Log.isLoggable("Mms:app", 2)) {
                                                                    Log.v("Mms/image", "getResizedImageData: retry scaling using Bitmap.createScaledBitmap: w=" + iMax3 + ", h=" + iMax22);
                                                                }
                                                                i9 = 0;
                                                                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iMax3, iMax22, false);
                                                                if (bitmap != bitmapCreateScaledBitmap) {
                                                                    bitmap.recycle();
                                                                }
                                                                if (bitmapCreateScaledBitmap != null) {
                                                                    Log.v("Mms/image", "Bitmap.createScaledBitmap returned NULL!");
                                                                    break;
                                                                }
                                                                bitmap = bitmapCreateScaledBitmap;
                                                                Log.w("Mms/image", "getResizedImageData - image too big (OutOfMemoryError), will try  with smaller scale factor, cur scale factor: " + f4);
                                                                width = width;
                                                                if (Log.isLoggable("Mms:app", 2)) {
                                                                    try {
                                                                        StringBuilder sb = new StringBuilder();
                                                                        sb.append("attempt=");
                                                                        sb.append(i8);
                                                                        sb.append(" size=");
                                                                        sb.append(width == 0 ? i9 : width.size());
                                                                        sb.append(" width=");
                                                                        sb.append(f5 * f4);
                                                                        sb.append(" height=");
                                                                        sb.append(bitmapOpenInputStream * f4);
                                                                        sb.append(" scaleFactor=");
                                                                        sb.append(f4);
                                                                        sb.append(" quality=");
                                                                        sb.append(i7);
                                                                        Log.v("Mms/image", sb.toString());
                                                                    } catch (OutOfMemoryError e20) {
                                                                        e = e20;
                                                                        bitmapOpenInputStream = inputStream2;
                                                                        width = width;
                                                                        Log.e("Mms/image", e.getMessage(), e);
                                                                        if (bitmapOpenInputStream != 0) {
                                                                            try {
                                                                                bitmapOpenInputStream.close();
                                                                            } catch (IOException e21) {
                                                                                Log.e("Mms/image", e21.getMessage(), e21);
                                                                            }
                                                                        }
                                                                        if (width != 0) {
                                                                            try {
                                                                                width.close();
                                                                            } catch (IOException e22) {
                                                                                iOException = e22;
                                                                                bitmapOpenInputStream = bitmapOpenInputStream;
                                                                                width = width;
                                                                                Log.e("Mms/image", iOException.getMessage(), iOException);
                                                                                byteArray2 = null;
                                                                                if (byteArray2 == null) {
                                                                                }
                                                                            }
                                                                        }
                                                                        byteArray2 = null;
                                                                        if (byteArray2 == null) {
                                                                        }
                                                                    }
                                                                }
                                                                f4 *= 0.75f;
                                                                i8++;
                                                                i10 = (width == 0 || width.size() > i5) ? 1 : i9;
                                                                if (i10 != 0 || i8 >= 8) {
                                                                    break;
                                                                }
                                                                i11 = i2;
                                                                i12 = i4;
                                                                i13 = 1;
                                                                width = width;
                                                            } else {
                                                                bitmapCreateScaledBitmap = bitmap;
                                                                i9 = 0;
                                                            }
                                                            if (width != 0) {
                                                                try {
                                                                    try {
                                                                        width.close();
                                                                    } catch (IOException e23) {
                                                                        Log.e("Mms/image", e23.getMessage(), e23);
                                                                    }
                                                                } catch (OutOfMemoryError unused6) {
                                                                    bitmap = bitmapCreateScaledBitmap;
                                                                    Log.w("Mms/image", "getResizedImageData - image too big (OutOfMemoryError), will try  with smaller scale factor, cur scale factor: " + f4);
                                                                    width = width;
                                                                    if (Log.isLoggable("Mms:app", 2)) {
                                                                    }
                                                                    f4 *= 0.75f;
                                                                    i8++;
                                                                    if (width == 0) {
                                                                    }
                                                                    return c0318n;
                                                                }
                                                            }
                                                            byteArrayOutputStream3 = new ByteArrayOutputStream();
                                                            bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i7, byteArrayOutputStream3);
                                                            size = byteArrayOutputStream3.size();
                                                            if (size > i5) {
                                                                int i18 = (i7 * i5) / size;
                                                                i7 = i18 < 50 ? 50 : i18;
                                                                if (Log.isLoggable("Mms:app", 2)) {
                                                                    Log.v("Mms/image", "getResizedImageData: compress(2) w/ quality=" + i7);
                                                                }
                                                                try {
                                                                    byteArrayOutputStream3.close();
                                                                } catch (IOException e24) {
                                                                    Log.e("Mms/image", e24.getMessage(), e24);
                                                                }
                                                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                                                bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i7, byteArrayOutputStream4);
                                                                byteArrayOutputStream3 = byteArrayOutputStream4;
                                                            }
                                                            bitmap = bitmapCreateScaledBitmap;
                                                            width = byteArrayOutputStream3;
                                                            if (Log.isLoggable("Mms:app", 2)) {
                                                            }
                                                            f4 *= 0.75f;
                                                            i8++;
                                                            if (width == 0) {
                                                                if (i10 != 0) {
                                                                    break;
                                                                    break;
                                                                }
                                                                i11 = i2;
                                                                i12 = i4;
                                                                i13 = 1;
                                                                width = width;
                                                            }
                                                            return c0318n;
                                                        }
                                                        bitmap.recycle();
                                                        byteArray2 = i10 == 0 ? null : width.toByteArray();
                                                        if (inputStream2 != null) {
                                                            try {
                                                                inputStream2.close();
                                                            } catch (IOException e25) {
                                                                Log.e("Mms/image", e25.getMessage(), e25);
                                                            }
                                                        }
                                                        if (width != 0) {
                                                            try {
                                                                width.close();
                                                            } catch (IOException e26) {
                                                                Log.e("Mms/image", e26.getMessage(), e26);
                                                            }
                                                        }
                                                        if (byteArray2 == null) {
                                                        }
                                                    }
                                                    byteArray2 = null;
                                                    if (byteArray2 == null) {
                                                    }
                                                }
                                                i6 = i17;
                                                bitmapOpenInputStream = bitmapDecodeStream;
                                                inputStream2 = null;
                                                char c422 = '\b';
                                                if (bitmapOpenInputStream == 0 || i6 >= 8) {
                                                    break;
                                                }
                                                i17 = i6;
                                                bitmapDecodeStream = bitmapOpenInputStream;
                                                r9 = 0;
                                            }
                                            inputStream2 = bitmapOpenInputStream;
                                            i6 = i17;
                                            bitmapOpenInputStream = bitmapDecodeStream;
                                            char c4222 = '\b';
                                            if (bitmapOpenInputStream == 0) {
                                            }
                                            break;
                                            break;
                                        }
                                        if (bitmapOpenInputStream != 0) {
                                            try {
                                                bitmapOpenInputStream.close();
                                            } catch (IOException e27) {
                                                Log.e("Mms/image", e27.getMessage(), e27);
                                            }
                                            bitmapOpenInputStream = r9;
                                        }
                                        if (bitmapOpenInputStream != 0) {
                                            try {
                                                bitmapOpenInputStream.close();
                                            } catch (IOException e28) {
                                                Log.e("Mms/image", e28.getMessage(), e28);
                                            }
                                        }
                                        byteArray2 = r9;
                                    } catch (Throwable th7) {
                                        if (bitmapOpenInputStream == 0) {
                                            inputStream2 = bitmapOpenInputStream;
                                            throw th7;
                                        }
                                        try {
                                            bitmapOpenInputStream.close();
                                        } catch (IOException e29) {
                                            Log.e("Mms/image", e29.getMessage(), e29);
                                        }
                                        throw th7;
                                    }
                                } catch (FileNotFoundException e30) {
                                    e = e30;
                                    width = 0;
                                    bitmapOpenInputStream = bitmapOpenInputStream;
                                    Log.e("Mms/image", e.getMessage(), e);
                                    if (bitmapOpenInputStream != 0) {
                                    }
                                    if (width != 0) {
                                    }
                                    byteArray2 = null;
                                    if (byteArray2 == null) {
                                    }
                                }
                            } catch (OutOfMemoryError e31) {
                                e = e31;
                                width = 0;
                                bitmapOpenInputStream = bitmapOpenInputStream;
                                Log.e("Mms/image", e.getMessage(), e);
                                if (bitmapOpenInputStream != 0) {
                                }
                                if (width != 0) {
                                }
                                byteArray2 = null;
                                if (byteArray2 == null) {
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                th = th;
                                inputStream = bitmapOpenInputStream;
                                byteArrayOutputStream = null;
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream == null) {
                                }
                            }
                        } catch (FileNotFoundException e32) {
                            e = e32;
                        } catch (OutOfMemoryError e33) {
                            e = e33;
                        } catch (Throwable th9) {
                            th = th9;
                            bitmapOpenInputStream = inputStream2;
                        }
                    }
                } catch (Throwable th10) {
                    th = th10;
                    inputStream2 = bitmapOpenInputStream;
                }
            } catch (FileNotFoundException e34) {
                e = e34;
                bitmapOpenInputStream = 0;
            } catch (OutOfMemoryError e35) {
                e = e35;
                bitmapOpenInputStream = 0;
            } catch (Throwable th11) {
                th = th11;
                inputStream = null;
            }
            if (byteArray2 == null) {
                return null;
            }
            c0318n.r(byteArray2);
            c0318n.q("image/jpeg".getBytes());
        }
        return c0318n;
        if (width != 0) {
            try {
                width.close();
            } catch (IOException e36) {
                iOException = e36;
                bitmapOpenInputStream = bitmapOpenInputStream;
                width = width;
                Log.e("Mms/image", iOException.getMessage(), iOException);
                byteArray2 = null;
                if (byteArray2 == null) {
                }
            }
        }
        byteArray2 = null;
        if (byteArray2 == null) {
        }
    }

    public final int e() {
        return this.f910h;
    }

    public final String f() {
        return this.f908e;
    }

    public final int g() {
        return this.f909f;
    }
}
