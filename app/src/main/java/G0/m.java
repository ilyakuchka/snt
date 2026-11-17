package G0;

import android.content.Context;
import android.net.Uri;
import f0.C0303b;

/* loaded from: classes.dex */
public abstract class m extends k {
    public m(Context context, Uri uri) throws C0303b {
        super(context, "img", null, null, uri);
    }

    public m(Context context, String str, String str2, String str3, Uri uri) throws C0303b {
        super(context, str, str2, str3, uri);
    }

    public m(Context context, String str, String str2, byte[] bArr) {
        super(context, str, str2, bArr);
    }
}
