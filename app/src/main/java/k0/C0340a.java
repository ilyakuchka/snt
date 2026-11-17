package k0;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import androidx.lifecycle.o;
import androidx.preference.g;
import com.android.mmt.MmsApp;
import com.android.mmt.util.AbstractHandlerC0272d;

/* renamed from: k0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0340a extends androidx.lifecycle.a {

    /* renamed from: b, reason: collision with root package name */
    private o<Integer> f6417b;

    /* renamed from: k0.a$a, reason: collision with other inner class name */
    protected class HandlerC0115a extends AbstractHandlerC0272d {
        public HandlerC0115a(ContentResolver contentResolver) {
            super(contentResolver);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.android.mmt.util.AbstractHandlerC0272d
        protected final void c(int i2, Object obj, Cursor cursor) {
            if (i2 == 1704 && cursor != null) {
                try {
                    int i4 = 0;
                    if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                        i4 = cursor.getInt(0);
                    }
                    if (obj instanceof Boolean) {
                        if (!((Boolean) obj).booleanValue()) {
                            g.c(MmsApp.c()).edit().putInt("last_message_count", i4).apply();
                        } else if (((Integer) C0340a.this.f6417b.e()).intValue() != i4) {
                            C0340a.this.f6417b.n(Integer.valueOf(i4));
                        }
                    }
                } finally {
                    cursor.close();
                }
            }
        }
    }

    public C0340a(Application application) {
        super(application);
        this.f6417b = new o<>(0);
        new HandlerC0115a(application.getContentResolver());
    }
}
