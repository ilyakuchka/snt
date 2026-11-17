package K3;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import w3.AbstractC0410c;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final AbstractC0410c<a> f335b = new C0014a();

    /* renamed from: a, reason: collision with root package name */
    private InputMethodManager f336a;

    /* renamed from: K3.a$a, reason: collision with other inner class name */
    final class C0014a extends AbstractC0410c<a> {
        C0014a() {
        }

        @Override // w3.AbstractC0410c
        protected final a a(Object obj) {
            return new a((Context) obj);
        }
    }

    a(Context context) {
        this.f336a = (InputMethodManager) context.getApplicationContext().getSystemService("input_method");
    }

    public static a a(Context context) {
        return f335b.b(context);
    }

    public final void b(EditText editText) {
        this.f336a.hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
    }

    public final void c(EditText editText) {
        editText.requestFocus();
        this.f336a.viewClicked(editText);
        this.f336a.showSoftInput(editText, 0);
    }
}
