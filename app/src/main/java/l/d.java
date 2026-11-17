package l;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class d extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private int f6457a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f6458b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f6459c;
    private Configuration d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f6460e;

    public d() {
        super(null);
    }

    private void c() {
        if (this.f6458b == null) {
            this.f6458b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f6458b.setTo(theme);
            }
        }
        this.f6458b.applyStyle(this.f6457a, true);
    }

    public final void a(Configuration configuration) {
        if (this.f6460e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final int b() {
        return this.f6457a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.f6460e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.f6460e = super.getResources();
            } else {
                this.f6460e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f6460e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f6459c == null) {
            this.f6459c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f6459c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f6458b;
        if (theme != null) {
            return theme;
        }
        if (this.f6457a == 0) {
            this.f6457a = R.style.Theme_AppCompat_Light;
        }
        c();
        return this.f6458b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        if (this.f6457a != i2) {
            this.f6457a = i2;
            c();
        }
    }

    public d(Context context, int i2) {
        super(context);
        this.f6457a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f6458b = theme;
    }
}
