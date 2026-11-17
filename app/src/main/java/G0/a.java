package G0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.android.mmt.util.O;
import f0.C0303b;
import java.io.IOException;
import k0.C0341b;

/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: s, reason: collision with root package name */
    private final ArrayMap<String, String> f135s;

    public a(Context context, Uri uri) throws C0303b, C0341b, IOException {
        int iLastIndexOf;
        String string;
        this(context, null, null, uri);
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
                    if (k.w(uri)) {
                        string = cursorE.getString(cursorE.getColumnIndexOrThrow("_data"));
                        this.f171o = cursorE.getString(cursorE.getColumnIndexOrThrow("ct"));
                    } else {
                        String string2 = cursorE.getString(cursorE.getColumnIndexOrThrow("_data"));
                        this.f171o = cursorE.getString(cursorE.getColumnIndexOrThrow("mime_type"));
                        try {
                            String string3 = cursorE.getString(cursorE.getColumnIndexOrThrow("album"));
                            if (!TextUtils.isEmpty(string3)) {
                                this.f135s.put("album", string3);
                            }
                            String string4 = cursorE.getString(cursorE.getColumnIndexOrThrow("artist"));
                            if (!TextUtils.isEmpty(string4)) {
                                this.f135s.put("artist", string4);
                            }
                        } catch (IllegalArgumentException e2) {
                            Log.e("Mms/media", "initFromContentUri: ", e2);
                        }
                        string = string2;
                    }
                    C(string.substring(string.lastIndexOf(47) + 1));
                    if (TextUtils.isEmpty(this.f171o)) {
                        throw new C0303b("Type of media is unknown.");
                    }
                } finally {
                    cursorE.close();
                }
            } else {
                C(uri.getLastPathSegment());
                this.f171o = this.f166j.getContentResolver().getType(uri);
                StringBuilder sbD = D2.e.d("New Audio initFileProviderUri created: mSrc=");
                sbD.append(this.f170n);
                sbD.append(" mContentType=");
                sbD.append(this.f171o);
                sbD.append(" mUri=");
                sbD.append(uri);
                Log.v("Mms/media", sbD.toString());
            }
        } else if (uri.getScheme().equals("file")) {
            String path = uri.getPath();
            C(path != null ? path.substring(path.lastIndexOf(47) + 1) : path);
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(this.f170n);
            if (TextUtils.isEmpty(fileExtensionFromUrl) && (iLastIndexOf = this.f170n.lastIndexOf(46)) >= 0) {
                fileExtensionFromUrl = this.f170n.substring(iLastIndexOf + 1);
            }
            this.f171o = fileExtensionFromUrl != null ? singleton.getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase()) : null;
            if (Log.isLoggable("Mms:app", 2)) {
                StringBuilder sbD2 = D2.e.d("New AudioModel initFromFile created: mSrc=");
                sbD2.append(this.f170n);
                sbD2.append(" mContentType=");
                sbD2.append(this.f171o);
                sbD2.append(" mUri=");
                sbD2.append(uri);
                Log.v("Mms/media", sbD2.toString());
            }
        }
        v();
        ((b) f.d()).a(this.f171o);
    }

    public a(Context context, String str, String str2, Uri uri) throws C0303b {
        super(context, "audio", str, str2, uri);
        this.f135s = new ArrayMap<>();
    }
}
