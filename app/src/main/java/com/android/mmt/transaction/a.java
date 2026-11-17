package com.android.mmt.transaction;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Network;
import android.os.SystemClock;
import android.util.Log;
import f0.C0303b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import t.C0384b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4591a;

    /* renamed from: b, reason: collision with root package name */
    private static long f4592b;

    /* renamed from: c, reason: collision with root package name */
    private static PendingIntent f4593c;
    private static IntentFilter d;

    /* renamed from: e, reason: collision with root package name */
    private static HttpURLConnection f4594e;

    /* renamed from: f, reason: collision with root package name */
    private static BroadcastReceiver f4595f;

    /* renamed from: com.android.mmt.transaction.a$a, reason: collision with other inner class name */
    final class C0089a extends BroadcastReceiver {
        C0089a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("com.xiaomi.mms.http_timeout".equals(intent.getAction())) {
                long longExtra = intent.getLongExtra("mmstag", -1L);
                Log.d("Mms:transaction", "[HttpUtils] HTTP timeout alarm. tag = " + longExtra + " sAlarmTag = " + a.f4592b);
                new Thread(new b(longExtra)).start();
            }
        }
    }

    static {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        String language = locale.getLanguage();
        if (language == null) {
            language = null;
        } else if ("iw".equals(language)) {
            language = "he";
        } else if ("in".equals(language)) {
            language = "id";
        } else if ("ji".equals(language)) {
            language = "yi";
        }
        if (language != null) {
            sb.append(language);
            String country = locale.getCountry();
            if (country != null) {
                sb.append("-");
                sb.append(country);
            }
        }
        if (!Locale.US.equals(locale)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("en-US");
        }
        f4591a = sb.toString();
        f4592b = 0L;
        f4593c = null;
        d = new IntentFilter("com.xiaomi.mms.http_timeout");
        f4594e = null;
        f4595f = new C0089a();
    }

    private static synchronized void c(Context context) {
        if (Log.isLoggable("Mms:transaction", 2)) {
            Log.v("Mms:transaction", "HttpUtils: cancelTimeoutAlarm");
        }
        if (f4593c != null) {
            try {
                context.unregisterReceiver(f4595f);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ((AlarmManager) context.getSystemService("alarm")).cancel(f4593c);
            f4593c = null;
        }
    }

    private static void d(int i2) throws C0303b {
        if (1 != i2 && 2 != i2) {
            throw new C0303b(D2.e.b("Invalid method ", i2));
        }
    }

    private static void e(Exception exc, String str) throws IOException {
        Log.e("Mms:transaction", "Url: " + str + "\n" + exc.getMessage());
        IOException iOException = new IOException(exc.getMessage());
        iOException.initCause(exc);
        throw iOException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:98:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static byte[] f(Context context, long j2, String str, byte[] bArr, int i2, boolean z4, String str2, int i4, Network network) throws Throwable {
        IOException e2;
        SocketException e4;
        ProtocolException e5;
        MalformedURLException e6;
        C0303b e7;
        String str3;
        if (str == null) {
            throw new IllegalArgumentException("URL must not be null.");
        }
        if (Log.isLoggable("Mms:transaction", 2)) {
            Log.v("Mms:transaction", "httpConnection: params list");
            Log.v("Mms:transaction", "\ttoken\t\t= " + j2);
            Log.v("Mms:transaction", "\turl\t\t= " + str);
            StringBuilder sb = new StringBuilder();
            sb.append("\tmethod\t\t= ");
            sb.append(i2 == 1 ? "POST" : i2 == 2 ? "GET" : "UNKNOWN");
            Log.v("Mms:transaction", sb.toString());
            Log.v("Mms:transaction", "\tisProxySet\t= " + z4);
            Log.v("Mms:transaction", "\tproxyHost\t= " + str2);
            str3 = "\tproxyPort\t= " + i4;
            Log.v("Mms:transaction", str3);
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                h(context);
                d(i2);
                Proxy proxy = Proxy.NO_PROXY;
                if (z4) {
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str2, i4));
                }
                URL url = new URL(str);
                HttpURLConnection httpURLConnection2 = network != null ? (HttpURLConnection) network.openConnection(url, proxy) : (HttpURLConnection) url.openConnection(proxy);
                try {
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setConnectTimeout(180000);
                    httpURLConnection2.setReadTimeout(k0.d.g());
                    httpURLConnection2.setRequestProperty("Accept", "*/*, application/vnd.wap.mms-message, application/vnd.wap.sic");
                    httpURLConnection2.setRequestProperty("Accept-Language", f4591a);
                    String strT = k0.d.t();
                    String strU = k0.d.u();
                    if (strU != null) {
                        Log.i("Mms:transaction", "HTTP: xWapProfileUrl=" + strU + ";xWapProfileTagName=" + strT);
                        httpURLConnection2.setRequestProperty(strT, strU);
                    }
                    if (1 == i2) {
                        if (bArr == null || bArr.length < 1) {
                            Log.e("Mms:transaction", "HTTP: empty pdu");
                            throw new IllegalArgumentException("HTTP: empty pdu");
                        }
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setRequestProperty("Content-Type", "application/vnd.wap.mms-message");
                        if (Log.isLoggable("Mms:transaction", 2)) {
                            g(httpURLConnection2.getRequestProperties());
                        }
                        httpURLConnection2.setFixedLengthStreamingMode(bArr.length);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } else if (2 == i2) {
                        if (Log.isLoggable("Mms:transaction", 2)) {
                            g(httpURLConnection2.getRequestProperties());
                        }
                        httpURLConnection2.setRequestMethod("GET");
                    }
                    synchronized (c.class) {
                        f4594e = httpURLConnection2;
                    }
                    int responseCode = httpURLConnection2.getResponseCode();
                    String responseMessage = httpURLConnection2.getResponseMessage();
                    Log.d("Mms:transaction", "HTTP: " + responseCode + " responseMessage " + responseMessage);
                    if (Log.isLoggable("Mms:transaction", 2)) {
                        g(httpURLConnection2.getHeaderFields());
                    }
                    if (responseCode / 100 != 2) {
                        throw new IOException("HTTP error: responseCode:" + responseCode + responseMessage);
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int i5 = bufferedInputStream.read(bArr2);
                        if (i5 <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i5);
                    }
                    bufferedInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("HTTP: response size=");
                    sb2.append(byteArray != null ? byteArray.length : 0);
                    Log.d("Mms:transaction", sb2.toString());
                    httpURLConnection2.disconnect();
                    c(context);
                    return byteArray;
                } catch (C0303b e8) {
                    e7 = e8;
                    e(e7, str);
                    throw null;
                } catch (MalformedURLException e9) {
                    e6 = e9;
                    e(e6, str);
                    throw null;
                } catch (ProtocolException e10) {
                    e5 = e10;
                    e(e5, str);
                    throw null;
                } catch (SocketException e11) {
                    e4 = e11;
                    e(e4, str);
                    throw null;
                } catch (IOException e12) {
                    e2 = e12;
                    e(e2, str);
                    throw null;
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection = str3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                c(context);
                throw th;
            }
        } catch (C0303b e13) {
            e7 = e13;
        } catch (MalformedURLException e14) {
            e6 = e14;
        } catch (ProtocolException e15) {
            e5 = e15;
        } catch (SocketException e16) {
            e4 = e16;
        } catch (IOException e17) {
            e2 = e17;
        } catch (Throwable th2) {
            th = th2;
            if (httpURLConnection != null) {
            }
            c(context);
            throw th;
        }
    }

    private static void g(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value != null) {
                    for (String str : value) {
                        sb.append(key);
                        sb.append('=');
                        sb.append(str);
                        sb.append('\n');
                    }
                }
            }
            StringBuilder sbD = D2.e.d("HTTP: headers\n");
            sbD.append(sb.toString());
            Log.v("Mms:transaction", sbD.toString());
        }
    }

    private static synchronized void h(Context context) {
        if (Log.isLoggable("Mms:transaction", 2)) {
            Log.v("Mms:transaction", "[HttpUtils] startAlarmForTimeout for 180000");
        }
        Intent intent = new Intent("com.xiaomi.mms.http_timeout");
        intent.addFlags(268435456);
        long j2 = f4592b + 1;
        f4592b = j2;
        intent.putExtra("mmstag", j2);
        f4593c = PendingIntent.getBroadcast(context, 0, intent, 201326592);
        ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + 180000, f4593c);
        C0384b.t(context, f4595f, d);
    }
}
