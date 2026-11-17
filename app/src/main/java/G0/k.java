package G0;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.Log;
import f0.C0303b;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class k extends l implements Z3.a {

    /* renamed from: j, reason: collision with root package name */
    protected Context f166j;

    /* renamed from: k, reason: collision with root package name */
    protected int f167k;

    /* renamed from: l, reason: collision with root package name */
    protected int f168l;

    /* renamed from: m, reason: collision with root package name */
    protected String f169m;

    /* renamed from: n, reason: collision with root package name */
    protected String f170n;

    /* renamed from: o, reason: collision with root package name */
    protected String f171o;
    private Uri p;

    /* renamed from: q, reason: collision with root package name */
    private byte[] f172q;

    /* renamed from: r, reason: collision with root package name */
    protected int f173r;

    public k(Context context, String str, String str2, String str3, Uri uri) throws C0303b, IOException {
        this.f166j = context;
        this.f169m = str;
        this.f171o = str2;
        this.p = uri;
        C(str3);
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f166j.getContentResolver().openInputStream(this.p);
                if (inputStreamOpenInputStream instanceof FileInputStream) {
                    this.f173r = (int) ((FileInputStream) inputStreamOpenInputStream).getChannel().size();
                    if (z() && this.f173r > k0.d.j()) {
                        Log.w("Mms/media", "initMediaSize: Video size: f.getChannel().size(): " + this.f173r + " larger than max message size: " + k0.d.j());
                    }
                } else {
                    while (inputStreamOpenInputStream != null && -1 != inputStreamOpenInputStream.read()) {
                        this.f173r++;
                    }
                }
            } catch (IOException e2) {
                Log.e("Mms/media", "IOException caught while opening or reading stream", e2);
                if (e2 instanceof FileNotFoundException) {
                    throw new C0303b(e2.getMessage());
                }
                if (0 != 0) {
                }
            }
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e4) {
                    Log.e("Mms/media", "IOException caught while closing stream", e4);
                }
            }
            new ArrayList();
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e5) {
                    Log.e("Mms/media", "IOException caught while closing stream", e5);
                }
            }
            throw th;
        }
    }

    public static boolean w(Uri uri) {
        return uri.getAuthority().startsWith("mms");
    }

    protected void A(int i2, long j2) throws C0303b {
    }

    public final void B(int i2) {
        if (!x() || i2 >= 0) {
            this.f168l = i2;
        } else {
            try {
                v();
            } catch (C0303b e2) {
                Log.e("Mms/media", e2.getMessage(), e2);
                return;
            } catch (IOException e4) {
                Log.e("Mms/media", "setDuration: ", e4);
                return;
            }
        }
        g();
    }

    final void C(String str) {
        if (str != null) {
            this.f170n = str.replace(" ", "_");
        }
    }

    final void D(Uri uri) {
        this.p = uri;
    }

    public final String p() {
        return this.f171o;
    }

    public final byte[] q() {
        byte[] bArr = this.f172q;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final int r() {
        return this.f168l;
    }

    public final int s() {
        return this.f173r;
    }

    public final String t() {
        return this.f170n;
    }

    public final Uri u() {
        return this.p;
    }

    protected final void v() throws C0303b, IOException {
        if (this.p == null) {
            throw new IllegalArgumentException("Uri may not be null.");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(this.f166j, this.p);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                this.f168l = strExtractMetadata != null ? Integer.parseInt(strExtractMetadata) : 0;
            } catch (Exception e2) {
                Log.e("Mms/media", "MediaMetadataRetriever failed to get duration for " + this.p.getPath(), e2);
                throw new C0303b(e2);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    protected boolean x() {
        return this instanceof a;
    }

    public final boolean y() {
        return this.f169m.equals("text");
    }

    public final boolean z() {
        return this.f169m.equals("video");
    }

    public k(Context context, String str, String str2, byte[] bArr) {
        this.f166j = context;
        this.f169m = "text";
        this.f171o = str;
        this.f172q = bArr;
        this.f173r = bArr.length;
        new ArrayList();
        C(str2);
    }
}
