package Q0;

import android.R;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: Q0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0169b<D> extends RecyclerView.x implements View.OnClickListener, View.OnLongClickListener, S0.b {

    /* renamed from: B, reason: collision with root package name */
    protected boolean f1087B;

    /* renamed from: C, reason: collision with root package name */
    protected CheckBox f1088C;

    /* renamed from: D, reason: collision with root package name */
    protected View f1089D;

    /* renamed from: E, reason: collision with root package name */
    protected D f1090E;

    /* renamed from: F, reason: collision with root package name */
    private int f1091F;

    /* renamed from: G, reason: collision with root package name */
    protected InterfaceC0031b f1092G;

    /* renamed from: H, reason: collision with root package name */
    protected a f1093H;

    /* renamed from: Q0.b$a */
    public interface a {
        void g(int i2, boolean z4);
    }

    /* renamed from: Q0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0031b<D> {
        /* JADX WARN: Incorrect return type in method signature: (Landroid/view/View;ITD;)Z */
        void a(View view, int i2, Object obj);

        void b(Object obj);
    }

    public ViewOnClickListenerC0169b(View view, InterfaceC0031b interfaceC0031b, a aVar) {
        super(view);
        this.f1087B = false;
        this.f1089D = view;
        view.setOnClickListener(this);
        this.f1089D.setOnLongClickListener(this);
        this.f1092G = interfaceC0031b;
        this.f1093H = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(int i2, Object obj, boolean z4, boolean z5) {
        this.f1091F = h() - i2;
        this.f1090E = obj;
        this.f1087B = z4;
        if (z4) {
            C();
        }
        if (z5 || this.f1088C == null) {
            return;
        }
        E(z4, 1.0f);
    }

    protected final void C() {
        View viewFindViewById = this.f4055i.findViewById(R.id.checkbox);
        if (viewFindViewById instanceof ViewStub) {
            CheckBox checkBox = (CheckBox) ((ViewStub) viewFindViewById).inflate();
            this.f1088C = checkBox;
            checkBox.setClickable(false);
            this.f1088C.setVisibility(8);
        }
    }

    protected final int D() {
        int iH = h();
        return iH >= 1 ? h() - this.f1091F : iH;
    }

    protected void E(boolean z4, float f4) {
    }

    protected void F(boolean z4, boolean z5) {
        this.f1089D.setActivated(z4);
        if (!this.f1087B) {
            CheckBox checkBox = this.f1088C;
            if (checkBox != null) {
                checkBox.setEnabled(false);
                return;
            }
            return;
        }
        C();
        this.f1088C.setEnabled(true);
        if (z5) {
            this.f1088C.performClick();
        } else {
            this.f1088C.setChecked(z4);
        }
    }

    @Override // S0.b
    public final void a(boolean z4) {
        CheckBox checkBox;
        if (z4 || (checkBox = this.f1088C) == null) {
            return;
        }
        checkBox.setVisibility(8);
    }

    @Override // S0.b
    public final void b(boolean z4) {
        E(z4, 0.0f);
    }

    @Override // S0.b
    public final void c(boolean z4, float f4) {
        E(z4, f4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1087B && this.f1093H != null) {
            C();
            this.f1093H.g(D(), !this.f1088C.isChecked());
            F(this.f1087B && !this.f1088C.isChecked(), true);
        } else {
            InterfaceC0031b interfaceC0031b = this.f1092G;
            if (interfaceC0031b != null) {
                D();
                interfaceC0031b.b(this.f1090E);
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.f1087B) {
            return true;
        }
        InterfaceC0031b interfaceC0031b = this.f1092G;
        if (interfaceC0031b != null) {
            interfaceC0031b.a(view, D(), this.f1090E);
        }
        return false;
    }
}
