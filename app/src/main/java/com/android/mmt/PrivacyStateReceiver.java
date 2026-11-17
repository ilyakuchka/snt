package com.android.mmt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

/* loaded from: classes.dex */
public class PrivacyStateReceiver extends BroadcastReceiver {

    final class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f4476a;

        a(Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f4476a = pendingResult;
        }

        @Override // android.os.AsyncTask
        protected final Void doInBackground(Void[] voidArr) {
            this.f4476a.finish();
            return null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            Log.v("PrivacyStateReceiver", "return because intent is null");
        } else {
            new a(context, goAsync()).execute(new Void[0]);
        }
    }
}
