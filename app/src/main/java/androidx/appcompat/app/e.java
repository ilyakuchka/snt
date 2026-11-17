package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
public final class e extends o {

    /* renamed from: k, reason: collision with root package name */
    final AlertController f2320k;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.b f2321a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2322b;

        public a(Context context) {
            this(context, e.f(context, 0));
        }

        public final e a() {
            ListAdapter dVar;
            e eVar = new e(this.f2321a.f2294a, this.f2322b);
            AlertController.b bVar = this.f2321a;
            AlertController alertController = eVar.f2320k;
            View view = bVar.f2297e;
            if (view != null) {
                alertController.f(view);
            } else {
                CharSequence charSequence = bVar.d;
                if (charSequence != null) {
                    alertController.i(charSequence);
                }
                Drawable drawable = bVar.f2296c;
                if (drawable != null) {
                    alertController.g(drawable);
                }
            }
            CharSequence charSequence2 = bVar.f2298f;
            if (charSequence2 != null) {
                alertController.h(charSequence2);
            }
            CharSequence charSequence3 = bVar.g;
            if (charSequence3 != null) {
                alertController.e(-1, charSequence3, bVar.f2299h);
            }
            CharSequence charSequence4 = bVar.f2300i;
            if (charSequence4 != null) {
                alertController.e(-2, charSequence4, bVar.f2301j);
            }
            if (bVar.f2303l != null || bVar.f2304m != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar.f2295b.inflate(alertController.L, (ViewGroup) null);
                if (bVar.f2307q) {
                    dVar = new b(bVar, bVar.f2294a, alertController.M, bVar.f2303l, recycleListView);
                } else {
                    int i2 = bVar.f2308r ? alertController.f2265N : alertController.f2266O;
                    dVar = bVar.f2304m;
                    if (dVar == null) {
                        dVar = new AlertController.d(bVar.f2294a, i2, bVar.f2303l);
                    }
                }
                alertController.f2261H = dVar;
                alertController.f2262I = bVar.f2309s;
                if (bVar.f2305n != null) {
                    recycleListView.setOnItemClickListener(new c(bVar, alertController));
                } else if (bVar.f2310t != null) {
                    recycleListView.setOnItemClickListener(new d(bVar, recycleListView, alertController));
                }
                if (bVar.f2308r) {
                    recycleListView.setChoiceMode(1);
                } else if (bVar.f2307q) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.g = recycleListView;
            }
            View view2 = bVar.f2306o;
            if (view2 != null) {
                alertController.j(view2);
            }
            Objects.requireNonNull(this.f2321a);
            eVar.setCancelable(true);
            Objects.requireNonNull(this.f2321a);
            eVar.setCanceledOnTouchOutside(true);
            Objects.requireNonNull(this.f2321a);
            eVar.setOnCancelListener(null);
            Objects.requireNonNull(this.f2321a);
            eVar.setOnDismissListener(null);
            DialogInterface.OnKeyListener onKeyListener = this.f2321a.f2302k;
            if (onKeyListener != null) {
                eVar.setOnKeyListener(onKeyListener);
            }
            return eVar;
        }

        public final Context b() {
            return this.f2321a.f2294a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f2321a;
            bVar.f2304m = listAdapter;
            bVar.f2305n = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f2321a.f2297e = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f2321a.f2296c = drawable;
            return this;
        }

        public a f(CharSequence charSequence) {
            this.f2321a.f2298f = charSequence;
            return this;
        }

        public a g(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f2321a;
            bVar.f2303l = charSequenceArr;
            bVar.f2310t = onMultiChoiceClickListener;
            bVar.p = zArr;
            bVar.f2307q = true;
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f2321a;
            bVar.f2300i = charSequence;
            bVar.f2301j = onClickListener;
            return this;
        }

        public a i(DialogInterface.OnKeyListener onKeyListener) {
            this.f2321a.f2302k = onKeyListener;
            return this;
        }

        public a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f2321a;
            bVar.g = charSequence;
            bVar.f2299h = onClickListener;
            return this;
        }

        public a k(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f2321a;
            bVar.f2304m = listAdapter;
            bVar.f2305n = onClickListener;
            bVar.f2309s = i2;
            bVar.f2308r = true;
            return this;
        }

        public a l(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f2321a;
            bVar.f2303l = charSequenceArr;
            bVar.f2305n = onClickListener;
            bVar.f2309s = i2;
            bVar.f2308r = true;
            return this;
        }

        public a m(CharSequence charSequence) {
            this.f2321a.d = charSequence;
            return this;
        }

        public a n(View view) {
            this.f2321a.f2306o = view;
            return this;
        }

        public a(Context context, int i2) {
            this.f2321a = new AlertController.b(new ContextThemeWrapper(context, e.f(context, i2)));
            this.f2322b = i2;
        }
    }

    protected e(Context context, int i2) {
        super(context, f(context, i2));
        this.f2320k = new AlertController(getContext(), this, getWindow());
    }

    static int f(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final ListView e() {
        return this.f2320k.g;
    }

    @Override // androidx.appcompat.app.o, android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2320k.c();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2320k.f2254A;
        if (nestedScrollView != null && nestedScrollView.i(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2320k.f2254A;
        if (nestedScrollView != null && nestedScrollView.i(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.appcompat.app.o, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f2320k.i(charSequence);
    }
}
