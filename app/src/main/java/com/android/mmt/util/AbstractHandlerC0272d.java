package com.android.mmt.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;

/* renamed from: com.android.mmt.util.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractHandlerC0272d extends Handler {

    /* renamed from: c, reason: collision with root package name */
    private static Looper f5946c;

    /* renamed from: a, reason: collision with root package name */
    final WeakReference<ContentResolver> f5947a;

    /* renamed from: b, reason: collision with root package name */
    private b f5948b;

    /* renamed from: com.android.mmt.util.d$a */
    protected static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Uri f5949a;

        /* renamed from: b, reason: collision with root package name */
        public AbstractHandlerC0272d f5950b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f5951c;
        public String d;

        /* renamed from: e, reason: collision with root package name */
        public String[] f5952e;

        /* renamed from: f, reason: collision with root package name */
        public String f5953f;
        public Object g;

        /* renamed from: h, reason: collision with root package name */
        public Object f5954h;

        /* renamed from: i, reason: collision with root package name */
        public ContentValues f5955i;

        protected a() {
        }
    }

    /* renamed from: com.android.mmt.util.d$b */
    protected class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ContentResolver contentResolver = AbstractHandlerC0272d.this.f5947a.get();
            if (contentResolver == null) {
                return;
            }
            a aVar = (a) message.obj;
            int i2 = message.what;
            int i4 = message.arg1;
            Uri uriInsert = null;
            if (i4 == 1) {
                try {
                    Cursor cursorQuery = contentResolver.query(aVar.f5949a, aVar.f5951c, aVar.d, aVar.f5952e, aVar.f5953f);
                    if (cursorQuery != null) {
                        cursorQuery.getCount();
                    }
                    uriInsert = cursorQuery;
                } catch (SecurityException e2) {
                    A.g(e2);
                } catch (Exception e4) {
                    Log.w("AsyncQuery", "Exception thrown during handling EVENT_ARG_QUERY", e4);
                }
                aVar.g = uriInsert;
            } else if (i4 != 2) {
                int iUpdate = -1;
                if (i4 == 3) {
                    try {
                        iUpdate = contentResolver.update(aVar.f5949a, aVar.f5955i, aVar.d, aVar.f5952e);
                    } catch (SecurityException e5) {
                        A.g(e5);
                    } catch (Exception e6) {
                        Log.e("AsyncQuery", "exception e", e6);
                    }
                    aVar.g = Integer.valueOf(iUpdate);
                } else if (i4 == 4) {
                    try {
                        iUpdate = contentResolver.delete(aVar.f5949a, aVar.d, aVar.f5952e);
                    } catch (SecurityException e7) {
                        A.g(e7);
                    } catch (Exception e8) {
                        Log.e("AsyncQuery", "exception e", e8);
                    }
                    aVar.g = Integer.valueOf(iUpdate);
                }
            } else {
                try {
                    uriInsert = contentResolver.insert(aVar.f5949a, aVar.f5955i);
                } catch (SecurityException e9) {
                    A.g(e9);
                } catch (Exception e10) {
                    Log.e("AsyncQuery", "exception e", e10);
                }
                aVar.g = uriInsert;
            }
            Message messageObtainMessage = aVar.f5950b.obtainMessage(i2);
            messageObtainMessage.obj = aVar;
            messageObtainMessage.arg1 = message.arg1;
            messageObtainMessage.sendToTarget();
        }
    }

    public AbstractHandlerC0272d(ContentResolver contentResolver) {
        this.f5947a = new WeakReference<>(contentResolver);
        synchronized (AbstractHandlerC0272d.class) {
            if (f5946c == null) {
                HandlerThread handlerThread = new HandlerThread("AsyncQueryWorker");
                handlerThread.start();
                f5946c = handlerThread.getLooper();
            }
        }
        this.f5948b = new b(f5946c);
    }

    public final void a(int i2) {
        this.f5948b.removeMessages(i2);
    }

    protected void b(int i2, Object obj, int i4) {
    }

    protected void c(int i2, Object obj, Cursor cursor) {
    }

    protected void d(int i2) {
    }

    public final void e(int i2, Object obj, Uri uri, String str, String[] strArr) {
        Message messageObtainMessage = this.f5948b.obtainMessage(i2);
        messageObtainMessage.arg1 = 4;
        a aVar = new a();
        aVar.f5950b = this;
        aVar.f5949a = uri;
        aVar.f5954h = obj;
        aVar.d = str;
        aVar.f5952e = strArr;
        messageObtainMessage.obj = aVar;
        this.f5948b.sendMessage(messageObtainMessage);
    }

    public final void f(int i2, Object obj, Uri uri, String[] strArr, String str, String str2) {
        Message messageObtainMessage = this.f5948b.obtainMessage(i2);
        messageObtainMessage.arg1 = 1;
        a aVar = new a();
        aVar.f5950b = this;
        aVar.f5949a = uri;
        aVar.f5951c = strArr;
        aVar.d = str;
        aVar.f5952e = null;
        aVar.f5953f = str2;
        aVar.f5954h = obj;
        messageObtainMessage.obj = aVar;
        this.f5948b.sendMessage(messageObtainMessage);
    }

    public final void g(Uri uri, ContentValues contentValues) {
        Message messageObtainMessage = this.f5948b.obtainMessage(1000);
        messageObtainMessage.arg1 = 3;
        a aVar = new a();
        aVar.f5950b = this;
        aVar.f5949a = uri;
        aVar.f5954h = null;
        aVar.f5955i = contentValues;
        aVar.d = null;
        aVar.f5952e = null;
        messageObtainMessage.obj = aVar;
        this.f5948b.sendMessage(messageObtainMessage);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar = (a) message.obj;
        int i2 = message.what;
        int i4 = message.arg1;
        if (i4 == 1) {
            c(i2, aVar.f5954h, (Cursor) aVar.g);
            return;
        }
        if (i4 == 2) {
            Object obj = aVar.f5954h;
        } else if (i4 != 3) {
            if (i4 != 4) {
                return;
            }
            b(i2, aVar.f5954h, ((Integer) aVar.g).intValue());
        } else {
            Object obj2 = aVar.f5954h;
            ((Integer) aVar.g).intValue();
            d(i2);
        }
    }
}
