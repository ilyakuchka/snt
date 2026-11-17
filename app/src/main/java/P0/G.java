package P0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.android.mmt.MmsApp;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class G extends ContextWrapper {
    private static G d;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0164j f895a;

    /* renamed from: b, reason: collision with root package name */
    private float f896b;

    /* renamed from: c, reason: collision with root package name */
    private float f897c;

    private G() throws Resources.NotFoundException {
        super(MmsApp.c().getApplicationContext());
        this.f897c = getResources().getDimensionPixelSize(R.dimen.message_body_text_font_size);
        h();
    }

    public static void a(InterfaceC0164j interfaceC0164j) {
        G g = d;
        if (g == null || g.f895a != interfaceC0164j) {
            return;
        }
        g.f895a = null;
    }

    public static G b() {
        if (d == null) {
            d = new G();
        }
        return d;
    }

    public static boolean d() {
        return d != null;
    }

    private void h() throws Resources.NotFoundException {
        float f4 = getResources().getConfiguration().fontScale;
        if (f4 == 0.0f) {
            f4 = 1.0f;
        }
        float f5 = this.f897c * f4;
        Context applicationContext = MmsApp.c().getApplicationContext();
        float dimension = applicationContext.getResources().getDimension(R.dimen.min_scale_font_size);
        float dimension2 = applicationContext.getResources().getDimension(R.dimen.max_scale_font_size);
        float f6 = f5 != 0.0f ? f5 < dimension ? dimension : f5 > dimension2 ? dimension2 : f5 : 0.0f;
        SharedPreferences.Editor editorEdit = androidx.preference.g.c(applicationContext).edit();
        editorEdit.putFloat("message_font_size", f6);
        editorEdit.apply();
    }

    public final float c() {
        return this.f896b;
    }

    public final void e(InterfaceC0164j interfaceC0164j, Activity activity) {
        this.f895a = interfaceC0164j;
        this.f896b = 0.0f;
    }

    public final void f() {
        h();
    }

    public final void g() {
        float f4 = this.f897c;
        Context applicationContext = MmsApp.c().getApplicationContext();
        SharedPreferences sharedPreferencesC = androidx.preference.g.c(applicationContext);
        float dimension = applicationContext.getResources().getDimension(R.dimen.min_scale_font_size);
        float dimension2 = applicationContext.getResources().getDimension(R.dimen.max_scale_font_size);
        float f5 = sharedPreferencesC.getFloat("message_font_size", f4);
        float f6 = 0.0f;
        if (f5 != 0.0f) {
            if (f5 >= dimension) {
                dimension = f5 > dimension2 ? dimension2 : f5;
            }
            f6 = dimension;
        }
        if (this.f896b != f6) {
            this.f896b = f6;
            InterfaceC0164j interfaceC0164j = this.f895a;
            if (interfaceC0164j != null) {
                interfaceC0164j.d(f6);
            }
        }
    }
}
