package miuix.appcompat.internal.app.widget;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b0.C0225b;
import java.util.ArrayList;
import java.util.Iterator;
import miuix.appcompat.app.b;

/* loaded from: classes.dex */
final class q implements b.a {

    /* renamed from: i, reason: collision with root package name */
    Rect f7010i = new Rect();

    /* renamed from: j, reason: collision with root package name */
    ArrayList<View> f7011j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    int f7012k = -1;

    /* renamed from: l, reason: collision with root package name */
    boolean f7013l = true;

    /* renamed from: m, reason: collision with root package name */
    int f7014m = -1;

    /* renamed from: n, reason: collision with root package name */
    int f7015n = -1;

    /* renamed from: o, reason: collision with root package name */
    ViewGroup f7016o = null;
    C0225b p;

    /* renamed from: q, reason: collision with root package name */
    k f7017q;

    public q(C0225b c0225b, k kVar) {
        this.p = c0225b;
        this.f7017q = kVar;
    }

    @Override // miuix.appcompat.app.b.a
    public final void a(int i2) {
        if (i2 == 0) {
            this.f7012k = this.p.j();
            this.f7013l = true;
            ViewGroup viewGroup = this.f7016o;
            if (viewGroup != null) {
                d(viewGroup);
            }
        }
    }

    @Override // miuix.appcompat.app.b.a
    public final void b(int i2) {
    }

    @Override // miuix.appcompat.app.b.a
    public final void c(int i2, float f4, boolean z4, boolean z5) {
        if (f4 == 0.0f) {
            this.f7012k = i2;
            this.f7013l = true;
            ViewGroup viewGroup = this.f7016o;
            if (viewGroup != null) {
                d(viewGroup);
            }
        }
        if (this.f7014m != i2) {
            int i4 = this.f7012k;
            if (i4 < i2) {
                this.f7012k = i2;
            } else {
                int i5 = i2 + 1;
                if (i4 > i5) {
                    this.f7012k = i5;
                }
            }
            this.f7014m = i2;
            this.f7013l = true;
            ViewGroup viewGroup2 = this.f7016o;
            if (viewGroup2 != null) {
                d(viewGroup2);
            }
        }
        if (f4 > 0.0f) {
            if (this.f7013l) {
                this.f7013l = false;
                if (this.f7012k != i2 || i2 >= this.f7017q.c() - 1) {
                    this.f7015n = i2;
                } else {
                    this.f7015n = i2 + 1;
                }
                Fragment fragmentK = this.f7017q.k(this.f7015n, false, true);
                this.f7016o = null;
                if (fragmentK != null && fragmentK.T() != null) {
                    View viewFindViewById = fragmentK.T().findViewById(R.id.list);
                    if (viewFindViewById instanceof ViewGroup) {
                        this.f7016o = (ViewGroup) viewFindViewById;
                    }
                }
            }
            if (this.f7015n == i2) {
                f4 = 1.0f - f4;
            }
            ViewGroup viewGroup3 = this.f7016o;
            if (viewGroup3 != null) {
                int width = viewGroup3.getWidth();
                int height = this.f7016o.getHeight();
                boolean z6 = this.f7015n != i2;
                e(viewGroup3, this.f7011j);
                if (this.f7011j.isEmpty()) {
                    return;
                }
                int top = this.f7011j.get(0).getTop();
                int top2 = Integer.MAX_VALUE;
                Iterator<View> it = this.f7011j.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    View next = it.next();
                    if (top2 != next.getTop()) {
                        top2 = next.getTop();
                        float f5 = ((0.1f - ((f4 * f4) / 0.9f)) * width) + (top2 - top < height ? (r4 * width) / height : width);
                        i6 = f5 > 0.0f ? (int) f5 : 0;
                        if (!z6) {
                            i6 = -i6;
                        }
                    }
                    next.setTranslationX(i6);
                }
            }
        }
    }

    final void d(ViewGroup viewGroup) {
        e(viewGroup, this.f7011j);
        if (this.f7011j.isEmpty()) {
            return;
        }
        Iterator<View> it = this.f7011j.iterator();
        while (it.hasNext()) {
            it.next().setTranslationX(0.0f);
        }
    }

    final void e(ViewGroup viewGroup, ArrayList<View> arrayList) {
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (viewGroup.indexOfChild(next) == -1 && next.getTranslationX() != 0.0f) {
                next.setTranslationX(0.0f);
            }
        }
        arrayList.clear();
        Rect rect = this.f7010i;
        rect.left = viewGroup.getPaddingLeft() + viewGroup.getScrollX();
        rect.top = viewGroup.getPaddingTop() + viewGroup.getScrollY();
        rect.right = (viewGroup.getWidth() - viewGroup.getPaddingRight()) - rect.left;
        rect.bottom = (viewGroup.getHeight() - viewGroup.getPaddingBottom()) - rect.top;
        if (this.f7010i.isEmpty()) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() != 8 || childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
        }
    }
}
