package com.android.mmt.ui;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import x0.C0416c;

/* loaded from: classes.dex */
final class A extends AsyncTask<Void, Set<Long>, Void> {

    /* renamed from: a, reason: collision with root package name */
    private Set<Long> f4652a;

    /* renamed from: b, reason: collision with root package name */
    private ContentResolver f4653b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f4654c;
    final /* synthetic */ Set d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0269z f4655e;

    A(C0269z c0269z, Context context, Set set) {
        this.f4655e = c0269z;
        this.f4654c = context;
        this.d = set;
    }

    private void a(ArrayList<ContentProviderOperation> arrayList, Set<Long> set) throws RemoteException, OperationApplicationException {
        try {
            this.f4653b.applyBatch("mms-sms", arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        publishProgress(new HashSet(set));
        arrayList.clear();
        set.clear();
    }

    @Override // android.os.AsyncTask
    protected final Void doInBackground(Void[] voidArr) throws RemoteException, OperationApplicationException {
        HashSet hashSet = new HashSet();
        Iterator<Long> it = this.f4652a.iterator();
        while (it.hasNext()) {
            C0416c.v(it.next().longValue());
        }
        HashSet hashSet2 = new HashSet();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Long l2 = (Long) it2.next();
            arrayList.add(C0416c.v(l2.longValue()).B());
            hashSet2.add(l2);
            if (arrayList.size() > 50) {
                a(arrayList, hashSet2);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        a(arrayList, hashSet2);
        return null;
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Void r12) {
        this.f4655e.f5811z0 = null;
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        Context context = this.f4654c;
        this.f4652a = this.d;
        this.f4653b = context.getContentResolver();
    }

    @Override // android.os.AsyncTask
    protected final void onProgressUpdate(Set<Long>[] setArr) {
        Set<Long>[] setArr2 = setArr;
        super.onProgressUpdate(setArr2);
        Iterator<Long> it = setArr2[0].iterator();
        while (it.hasNext()) {
            C0416c c0416cV = C0416c.v(it.next().longValue());
            c0416cV.c0(false);
            c0416cV.W(true);
        }
    }
}
