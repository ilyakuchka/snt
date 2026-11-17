package G0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.android.mmt.util.O;
import f0.C0303b;
import java.io.IOException;
import k0.C0341b;

/* loaded from: classes.dex */
public final class s extends m {
    public s(Context context, Uri uri, n nVar) throws C0303b, C0341b, IOException {
        int iLastIndexOf;
        String string;
        this(context, null, null, uri, nVar);
        if (uri.getScheme().equals("content")) {
            String authority = uri.getAuthority();
            if ("media".equals(authority) || "mms".equals(authority)) {
                Cursor cursorE = O.e(this.f166j, this.f166j.getContentResolver(), uri, null, null, null, null);
                if (cursorE == null) {
                    throw new C0303b("Bad URI: " + uri);
                }
                try {
                    if (!cursorE.moveToFirst()) {
                        throw new C0303b("Nothing found: " + uri);
                    }
                    try {
                        string = cursorE.getString(cursorE.getColumnIndexOrThrow("_data"));
                    } catch (IllegalArgumentException unused) {
                        string = uri.toString();
                    }
                    C(string.substring(string.lastIndexOf(47) + 1));
                    if ("mms".equals(uri.getHost())) {
                        this.f171o = cursorE.getString(cursorE.getColumnIndexOrThrow("ct"));
                    } else {
                        this.f171o = cursorE.getString(cursorE.getColumnIndexOrThrow("mime_type"));
                    }
                    if (TextUtils.isEmpty(this.f171o)) {
                        throw new C0303b("Type of media is unknown.");
                    }
                    if (this.f171o.equals("video/mp4") && !TextUtils.isEmpty(this.f170n)) {
                        int iLastIndexOf2 = this.f170n.lastIndexOf(".");
                        if (iLastIndexOf2 != -1) {
                            try {
                                String strSubstring = this.f170n.substring(iLastIndexOf2 + 1);
                                if (!TextUtils.isEmpty(strSubstring) && (strSubstring.equalsIgnoreCase("3gp") || strSubstring.equalsIgnoreCase("3gpp") || strSubstring.equalsIgnoreCase("3g2"))) {
                                    this.f171o = "video/3gpp";
                                }
                            } catch (IndexOutOfBoundsException unused2) {
                            }
                        }
                    }
                    if (Log.isLoggable("Mms:app", 2)) {
                        Log.v("Mms/media", "New VideoModel initFromContentUri created: mSrc=" + this.f170n + " mContentType=" + this.f171o + " mUri=" + uri);
                    }
                } finally {
                    cursorE.close();
                }
            } else {
                C(uri.getLastPathSegment());
                this.f171o = this.f166j.getContentResolver().getType(uri);
                StringBuilder sbD = D2.e.d("New VideoModel initFileProviderUri created: mSrc=");
                sbD.append(this.f170n);
                sbD.append(" mContentType=");
                sbD.append(this.f171o);
                sbD.append(" mUri=");
                sbD.append(uri);
                Log.v("Mms/media", sbD.toString());
            }
        } else if (uri.getScheme().equals("file")) {
            C(uri.getPath());
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(this.f170n);
            if (TextUtils.isEmpty(fileExtensionFromUrl) && (iLastIndexOf = this.f170n.lastIndexOf(46)) >= 0) {
                fileExtensionFromUrl = this.f170n.substring(iLastIndexOf + 1);
            }
            this.f171o = fileExtensionFromUrl == null ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
            if (Log.isLoggable("Mms:app", 2)) {
                StringBuilder sbD2 = D2.e.d("New VideoModel initFromFile created: mSrc=");
                sbD2.append(this.f170n);
                sbD2.append(" mContentType=");
                sbD2.append(this.f171o);
                sbD2.append(" mUri=");
                sbD2.append(uri);
                Log.v("Mms/media", sbD2.toString());
            }
        }
        v();
        ((b) f.d()).c(this.f171o);
    }

    @Override // G0.k
    protected final boolean x() {
        return true;
    }

    public s(Context context, String str, String str2, Uri uri, n nVar) throws C0303b {
        super(context, "video", str, str2, uri);
    }
}
