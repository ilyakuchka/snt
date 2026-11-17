package O0;

import android.R;
import android.content.Context;
import android.net.Uri;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.mmt.transaction.NotificationAssistService;
import z3.C0431a;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f799i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f800j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f801k;

    public /* synthetic */ i(Object obj, Object obj2, int i2) {
        this.f799i = i2;
        this.f800j = obj;
        this.f801k = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f799i) {
            case 0:
                NotificationAssistService.a((NotificationAssistService) this.f800j, (Uri) this.f801k);
                break;
            case 1:
                break;
            default:
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f800j;
                Context context = (Context) this.f801k;
                appCompatImageView.setImageDrawable(C0431a.e(context, R.attr.homeAsUpIndicator));
                appCompatImageView.setContentDescription(context.getResources().getString(com.android.mmt.R.string.actionbar_button_up_description));
                break;
        }
    }
}
