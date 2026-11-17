package G0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.android.mmt.util.O;
import f0.C0303b;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class g extends l {

    /* renamed from: j, reason: collision with root package name */
    protected Context f152j;

    /* renamed from: k, reason: collision with root package name */
    protected String f153k;

    /* renamed from: l, reason: collision with root package name */
    protected String f154l;

    /* renamed from: m, reason: collision with root package name */
    protected Uri f155m;

    /* renamed from: n, reason: collision with root package name */
    protected int f156n;

    public g() {
    }

    private void p() throws C0303b, IOException {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = this.f152j.getContentResolver().openInputStream(this.f155m);
                if (inputStreamOpenInputStream instanceof FileInputStream) {
                    this.f156n = (int) ((FileInputStream) inputStreamOpenInputStream).getChannel().size();
                } else {
                    while (-1 != inputStreamOpenInputStream.read()) {
                        this.f156n++;
                    }
                }
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e2) {
            Log.e("Mms/file_attach", "initAttachmentSize, file is not found??");
            StringBuilder sbD = D2.e.d("FileAttachmentModel#initAttachmentSize() ");
            sbD.append(e2.getMessage());
            throw new C0303b(sbD.toString());
        } catch (IOException unused) {
            Log.e("Mms/file_attach", "initAttachmentSize, other exceptions");
        }
    }

    private void q(Context context, Uri uri) {
        Cursor cursorE = O.e(context, context.getContentResolver(), uri, null, null, null, null);
        if (cursorE == null) {
            throw new IllegalArgumentException("Query on " + uri + " returns null result.");
        }
        try {
            if (cursorE.getCount() == 1 && cursorE.moveToFirst()) {
                this.f153k = cursorE.getString(cursorE.getColumnIndexOrThrow("_display_name"));
                return;
            }
            throw new IllegalArgumentException("Query on " + uri + " returns 0 or multiple rows.");
        } finally {
            cursorE.close();
        }
    }

    private void r(Uri uri) {
        this.f153k = uri.getPath();
        if (TextUtils.isEmpty(this.f154l)) {
            int iLastIndexOf = this.f153k.lastIndexOf(".");
            if (iLastIndexOf != -1) {
                String str = this.f153k;
                this.f154l = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(iLastIndexOf + 1, str.length()).toLowerCase());
            }
            if (TextUtils.isEmpty(this.f154l)) {
                this.f154l = "unknown_type";
            }
        }
    }

    public final boolean s() {
        String str = this.f154l;
        return str == null ? this.f153k.toLowerCase().endsWith(".vcf") : str.equalsIgnoreCase("text/x-vCard");
    }

    public g(Context context, Uri uri) throws C0303b, IOException {
        this.f152j = context;
        this.f154l = "text/x-vCard";
        this.f155m = uri;
        try {
            if (uri.getScheme().equals("content")) {
                q(context, uri);
            } else if (uri.getScheme().equals("file")) {
                r(uri);
            }
            String str = this.f153k;
            String strSubstring = str.substring(str.lastIndexOf(47) + 1);
            this.f153k = strSubstring;
            if (strSubstring.startsWith(".") && this.f153k.length() > 1) {
                this.f153k = this.f153k.substring(1);
            }
            p();
        } catch (IllegalArgumentException e2) {
            Log.d("Mms/file_attach", "IllegalArgumentException caught while opening or reading stream", e2);
            throw new C0303b("Type of vcard is unknown.");
        } catch (NullPointerException e4) {
            Log.d("Mms/file_attach", "FileName is null", e4);
            throw new C0303b("Type of vcard is unknown.");
        }
    }

    public g(Context context, String str, Uri uri) throws C0303b, IOException {
        this.f152j = context;
        this.f154l = "text/x-vCard";
        this.f153k = str;
        this.f155m = uri;
        p();
    }
}
