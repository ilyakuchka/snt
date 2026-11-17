package com.android.mmt.util;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.android.mmt.MmsApp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.android.mmt.util.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0276h {

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<NetworkCapabilities, c> f5976c = new HashMap<>();
    private static b d = null;

    /* renamed from: e, reason: collision with root package name */
    private static d f5977e = null;

    /* renamed from: a, reason: collision with root package name */
    private ConnectivityManager f5978a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f5979b;

    /* renamed from: com.android.mmt.util.h$b */
    private class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 4) {
                return;
            }
            C0276h.d(C0276h.this, (NetworkCapabilities) message.obj, message.arg1);
        }
    }

    @TargetApi(23)
    /* renamed from: com.android.mmt.util.h$c */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        NetworkCapabilities f5981a;

        /* renamed from: b, reason: collision with root package name */
        Network f5982b;

        /* renamed from: c, reason: collision with root package name */
        ConnectivityManager.NetworkCallback f5983c;

        /* renamed from: com.android.mmt.util.h$c$a */
        final class a extends ConnectivityManager.NetworkCallback {
            a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                Log.d("ConnManagerHelper", "onAvailable" + network);
                if (C0276h.d == null || C0276h.f5977e == null) {
                    Log.e("ConnManagerHelper", "onAvailable sCallbackHandler or sNetworkCallback is null");
                    ConnectivityManager connectivityManager = (ConnectivityManager) MmsApp.c().getSystemService("connectivity");
                    if (connectivityManager != null) {
                        try {
                            connectivityManager.unregisterNetworkCallback(this);
                            Log.d("ConnManagerHelper", "onAvailable unregisterNetworkCallback");
                        } catch (Exception e2) {
                            Log.e("ConnManagerHelper", "onAvailable unregisterNetworkCallback e", e2);
                        }
                    }
                    c.a(c.this);
                    return;
                }
                c.this.f5982b = network;
                int i2 = P0.r.f937c;
                if (C0276h.f5977e != null) {
                    C0276h.f5977e.a();
                }
                C0276h.k(c.this.f5981a, 0, 245000);
                Log.d("ConnManagerHelper", "startUsingNetworkFeature available Network:" + network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                if (network.equals(c.this.f5982b)) {
                    c.a(c.this);
                    Log.d("ConnManagerHelper", "startUsingNetworkFeature lost Network:" + network);
                }
            }
        }

        private c() {
            this.f5983c = new a();
        }

        static void a(c cVar) {
            if (cVar.f5982b != null) {
                cVar.f5982b = null;
            }
            int i2 = P0.r.f937c;
        }
    }

    /* renamed from: com.android.mmt.util.h$d */
    public interface d {
        void a();
    }

    public C0276h(ConnectivityManager connectivityManager, HandlerThread handlerThread, d dVar) {
        this.f5978a = connectivityManager;
        this.f5979b = handlerThread;
        f5977e = dVar;
    }

    static void d(C0276h c0276h, NetworkCapabilities networkCapabilities, int i2) {
        Objects.requireNonNull(c0276h);
        synchronized (f5976c) {
            if (f5976c.get(networkCapabilities) == null) {
                Log.d("ConnManagerHelper", "expireRequest l == null");
                return;
            }
            if (i2 == 0) {
                Log.d("ConnManagerHelper", "expireRequest removeRequestForFeature");
                c0276h.i(networkCapabilities);
            }
            Log.d("ConnManagerHelper", "expireRequest with 0, " + i2);
        }
    }

    public static Network h(int i2) throws NoSuchFieldException {
        NetworkCapabilities networkCapabilitiesA = M2.a.a(C0287t.x(), (int) C0287t.m(i2));
        if (networkCapabilitiesA == null) {
            return null;
        }
        synchronized (f5976c) {
            c cVar = f5976c.get(networkCapabilitiesA);
            if (cVar == null) {
                return null;
            }
            Log.d("ConnManagerHelper", "get current network " + i2 + " " + cVar.f5982b);
            Network network = cVar.f5982b;
            if (network != null) {
                return network;
            }
            return null;
        }
    }

    @TargetApi(23)
    private boolean i(NetworkCapabilities networkCapabilities) {
        c cVarRemove;
        synchronized (f5976c) {
            cVarRemove = f5976c.remove(networkCapabilities);
            b bVar = d;
            if (bVar != null) {
                bVar.removeMessages(4);
                d = null;
                Log.d("ConnManagerHelper", "stopUsingNetworkFeature sCallbackHandler uninit");
            }
        }
        this.f5978a.bindProcessToNetwork(null);
        if (cVarRemove == null) {
            Log.d("ConnManagerHelper", "stopUsingNetworkFeature l == null");
            return false;
        }
        try {
            this.f5978a.unregisterNetworkCallback(cVarRemove.f5983c);
            Log.d("ConnManagerHelper", "removeRequestForFeature unregisterNetworkCallback");
        } catch (Exception e2) {
            Log.e("ConnManagerHelper", "removeRequestForFeature unregisterNetworkCallback e", e2);
        }
        c.a(cVarRemove);
        Log.d("ConnManagerHelper", "stopUsingNetworkFeature return true");
        return true;
    }

    private void j(NetworkCapabilities networkCapabilities, int i2) {
        c cVar = new c();
        cVar.f5981a = networkCapabilities;
        f5976c.put(networkCapabilities, cVar);
        ConnectivityManager.NetworkCallback networkCallback = cVar.f5983c;
        int i4 = P0.r.f937c;
        Log.d("ConnManagerHelper", "requestNetwork call requestNetwork");
        this.f5978a.requestNetwork(new NetworkRequest.Builder().addTransportType(0).addCapability(0).setNetworkSpecifier(Long.toString(C0287t.m(i2))).build(), networkCallback);
        Log.d("ConnManagerHelper", "requestNetworkForFeatureLocked requestNetwork");
        k(networkCapabilities, 0, 90000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(NetworkCapabilities networkCapabilities, int i2, int i4) {
        b bVar = d;
        if (bVar == null || i4 < 0) {
            return;
        }
        bVar.removeMessages(4);
        d.sendMessageDelayed(d.obtainMessage(4, i2, 0, networkCapabilities), i4);
        Log.d("ConnManagerHelper", "sending expire msg with seqNum " + i2 + " and delay " + i4);
    }

    public final void e() {
        this.f5979b = null;
        f5977e = null;
    }

    public final void f() {
        HashMap map;
        c cVar;
        ConnectivityManager connectivityManager;
        synchronized (f5976c) {
            map = (HashMap) f5976c.clone();
            f5976c.clear();
        }
        if (map == null) {
            Log.d("ConnManagerHelper", "clearLegacyRequests maps is empty");
            return;
        }
        StringBuilder sbD = D2.e.d("clearLegacyRequests sLegacyRequests maps.size = ");
        sbD.append(map.size());
        Log.d("ConnManagerHelper", sbD.toString());
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null && (cVar = (c) entry.getValue()) != null && (connectivityManager = this.f5978a) != null) {
                try {
                    connectivityManager.unregisterNetworkCallback(cVar.f5983c);
                    Log.d("ConnManagerHelper", "clearLegacyRequests unregisterNetworkCallback");
                } catch (Exception e2) {
                    Log.e("ConnManagerHelper", "clearLegacyRequests unregisterNetworkCallback e", e2);
                }
                c.a(cVar);
            }
        }
    }

    public final String g(int i2) {
        Network network;
        NetworkCapabilities networkCapabilitiesA = M2.a.a(C0287t.x(), (int) C0287t.m(i2));
        if (networkCapabilitiesA == null) {
            Log.w("ConnManagerHelper", "getApnName netCap is null");
            return null;
        }
        synchronized (f5976c) {
            c cVar = f5976c.get(networkCapabilitiesA);
            if (cVar == null || (network = cVar.f5982b) == null) {
                network = null;
            }
        }
        NetworkInfo networkInfo = this.f5978a.getNetworkInfo(network);
        if (networkInfo != null) {
            return networkInfo.getExtraInfo();
        }
        return null;
    }

    public final int l(int i2) {
        NetworkCapabilities networkCapabilitiesA = M2.a.a(C0287t.x(), (int) C0287t.m(i2));
        if (networkCapabilitiesA == null) {
            Log.d("ConnManagerHelper", "startUsingNetworkFeatureM getNetworkCapabilities return null");
        } else {
            if (this.f5979b != null) {
                synchronized (f5976c) {
                    if (d == null) {
                        d = new b(this.f5979b.getLooper());
                        Log.d("ConnManagerHelper", "startUsingNetworkFeature sCallbackHandler init");
                    }
                    c cVar = f5976c.get(networkCapabilitiesA);
                    if (cVar != null) {
                        Log.d("ConnManagerHelper", "startUsingNetworkFeature renewing request");
                        if (cVar.f5982b != null) {
                            k(cVar.f5981a, 0, 245000);
                            return 0;
                        }
                    } else {
                        Log.d("ConnManagerHelper", "startUsingNetworkFeature requestNetworkForFeatureLocked");
                        j(networkCapabilitiesA, i2);
                    }
                    return 1;
                }
            }
            Log.d("ConnManagerHelper", "startUsingNetworkFeatureM mWorkThread is null");
        }
        return 3;
    }

    public final void m(int i2) throws NoSuchFieldException {
        NetworkCapabilities networkCapabilitiesA = M2.a.a(C0287t.x(), (int) C0287t.m(i2));
        if (networkCapabilitiesA == null) {
            Log.d("ConnManagerHelper", "stopUsingNetworkFeature getNetworkCapabilities return null");
        } else {
            Log.d("ConnManagerHelper", "stopUsingNetworkFeature removeRequestForFeature");
            i(networkCapabilitiesA);
        }
    }
}
