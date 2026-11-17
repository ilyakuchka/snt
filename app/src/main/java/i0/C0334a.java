package i0;

import D2.e;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import t.C0384b;

/* renamed from: i0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0334a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f6335a = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");

    /* renamed from: i0.a$a, reason: collision with other inner class name */
    public static final class C0113a implements Telephony.ThreadsColumns {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f6336a = {"_id"};

        /* renamed from: b, reason: collision with root package name */
        private static final Uri f6337b = Uri.parse("content://mms-sms/threadID");

        static {
            Uri.withAppendedPath(Telephony.MmsSms.CONTENT_URI, "conversations");
        }

        public static long a(Context context, Set<String> set) {
            Uri.Builder builderBuildUpon = f6337b.buildUpon();
            Iterator<String> it = set.iterator();
            while (true) {
                boolean zMatches = false;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Pattern pattern = C0334a.f6335a;
                if (!TextUtils.isEmpty(next)) {
                    Matcher matcher = C0334a.f6335a.matcher(next);
                    zMatches = Patterns.EMAIL_ADDRESS.matcher(matcher.matches() ? matcher.group(2) : next).matches();
                }
                if (zMatches) {
                    Matcher matcher2 = C0334a.f6335a.matcher(next);
                    if (matcher2.matches()) {
                        next = matcher2.group(2);
                    }
                }
                builderBuildUpon.appendQueryParameter("recipient", next);
            }
            Cursor cursorR = C0384b.r(context.getContentResolver(), builderBuildUpon.build(), f6336a, null, null, null);
            if (cursorR != null) {
                try {
                    if (cursorR.moveToFirst()) {
                        return cursorR.getLong(0);
                    }
                    Log.e("MmsSmsUtils", "getOrCreateThreadId returned no rows!");
                } finally {
                    cursorR.close();
                }
            }
            StringBuilder sbD = e.d("getOrCreateThreadId failed with ");
            sbD.append(set.toString());
            Log.e("MmsSmsUtils", sbD.toString());
            throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
        }
    }

    static {
        Pattern.compile("\\*[0-9]+");
    }
}
