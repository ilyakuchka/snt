package v;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import w.C0405a;

/* loaded from: classes.dex */
public final class m implements Iterable<Intent> {

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<Intent> f7958i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private final Context f7959j;

    public interface a {
        Intent g();
    }

    private m(Context context) {
        this.f7959j = context;
    }

    public static m g(Context context) {
        return new m(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m d(Activity activity) {
        Intent intentG = activity instanceof a ? ((a) activity).g() : null;
        if (intentG == null) {
            intentG = C0396c.a(activity);
        }
        if (intentG != null) {
            ComponentName component = intentG.getComponent();
            if (component == null) {
                component = intentG.resolveActivity(this.f7959j.getPackageManager());
            }
            int size = this.f7958i.size();
            try {
                Intent intentB = C0396c.b(this.f7959j, component);
                while (intentB != null) {
                    this.f7958i.add(size, intentB);
                    intentB = C0396c.b(this.f7959j, intentB.getComponent());
                }
                this.f7958i.add(intentG);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e2);
            }
        }
        return this;
    }

    public final void h() {
        if (this.f7958i.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f7958i;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        Context context = this.f7959j;
        int i2 = C0405a.f7979b;
        context.startActivities(intentArr, null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.f7958i.iterator();
    }
}
