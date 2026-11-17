package com.android.mmt.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.android.mmt.R;
import com.android.mmt.ui.PrivacyPolicyPreferenceActivity;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class B0 extends AsyncTask<Void, Object, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f4677a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PrivacyPolicyPreferenceActivity.a f4678b;

    B0(PrivacyPolicyPreferenceActivity.a aVar, Context context) {
        this.f4678b = aVar;
        this.f4677a = context;
    }

    @Override // android.os.AsyncTask
    protected final Void doInBackground(Void[] voidArr) throws JSONException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.v("PolicyFragment", "request to close privacy authority");
        PrivacyPolicyPreferenceActivity.a aVar = this.f4678b;
        int i2 = PrivacyPolicyPreferenceActivity.a.f5321u0;
        Objects.requireNonNull(aVar);
        int i4 = -1;
        try {
            Log.d("PolicyFragment", "request network data to close privacy authority");
            if (!TextUtils.isEmpty(null)) {
                i4 = new JSONObject((String) null).getInt("code");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Log.v("PolicyFragment", "auth status is " + i4);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sbD = D2.e.d("request close privacy auth time: ");
        sbD.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
        sbD.append("ms");
        Log.d("PolicyFragment", sbD.toString());
        publishProgress(Integer.valueOf(i4));
        return null;
    }

    @Override // android.os.AsyncTask
    protected final void onCancelled(Void r2) {
        this.f4678b.f5324s0 = null;
        super.onCancelled(r2);
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Void r12) {
        this.f4678b.f5324s0 = null;
    }

    @Override // android.os.AsyncTask
    protected final void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
        if (((Integer) objArr[0]).intValue() != 0) {
            this.f4678b.f5323r0.x0(true);
            Toast.makeText(this.f4678b.f5325t0, R.string.toast_failed_to_close_priv_auth, 1).show();
            return;
        }
        androidx.preference.g.c(this.f4677a).edit().putBoolean("privacy_authority", false).apply();
        this.f4678b.f5323r0.x0(false);
        Log.d("PolicyFragment", "Privacy authority is " + String.valueOf(androidx.preference.g.c(this.f4677a).getBoolean("privacy_authority", true)));
    }
}
