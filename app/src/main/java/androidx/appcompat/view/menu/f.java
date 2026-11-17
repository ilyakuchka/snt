package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import w.C0405a;

/* loaded from: classes.dex */
public class f implements A.a {

    /* renamed from: y, reason: collision with root package name */
    private static final int[] f2541y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    private final Context f2542a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f2543b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2544c;
    private boolean d;

    /* renamed from: e, reason: collision with root package name */
    private a f2545e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<h> f2546f;
    private ArrayList<h> g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2547h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<h> f2548i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<h> f2549j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2550k;

    /* renamed from: m, reason: collision with root package name */
    CharSequence f2552m;

    /* renamed from: n, reason: collision with root package name */
    Drawable f2553n;

    /* renamed from: o, reason: collision with root package name */
    View f2554o;

    /* renamed from: v, reason: collision with root package name */
    private h f2559v;

    /* renamed from: x, reason: collision with root package name */
    private boolean f2561x;

    /* renamed from: l, reason: collision with root package name */
    private int f2551l = 0;
    private boolean p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2555q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2556r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f2557s = false;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<h> f2558t = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<l>> u = new CopyOnWriteArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private boolean f2560w = false;

    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    public interface b {
        boolean a(h hVar);
    }

    public f(Context context) {
        boolean z4 = false;
        this.f2542a = context;
        Resources resources = context.getResources();
        this.f2543b = resources;
        this.f2546f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.f2547h = true;
        this.f2548i = new ArrayList<>();
        this.f2549j = new ArrayList<>();
        this.f2550k = true;
        if (resources.getConfiguration().keyboard != 1 && ViewConfiguration.get(context).shouldShowMenuShortcutsWhenKeyboardPresent()) {
            z4 = true;
        }
        this.d = z4;
    }

    private void A(int i2, boolean z4) {
        if (i2 < 0 || i2 >= this.f2546f.size()) {
            return;
        }
        this.f2546f.remove(i2);
        if (z4) {
            x(true);
        }
    }

    private void J(int i2, CharSequence charSequence, int i4, Drawable drawable, View view) {
        Resources resources = this.f2543b;
        if (view != null) {
            this.f2554o = view;
            this.f2552m = null;
            this.f2553n = null;
        } else {
            if (i2 > 0) {
                this.f2552m = resources.getText(i2);
            } else if (charSequence != null) {
                this.f2552m = charSequence;
            }
            if (i4 > 0) {
                Context context = this.f2542a;
                int i5 = C0405a.f7979b;
                this.f2553n = context.getDrawable(i4);
            } else if (drawable != null) {
                this.f2553n = drawable;
            }
            this.f2554o = null;
        }
        x(false);
    }

    public final void B(l lVar) {
        Iterator<WeakReference<l>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<l> next = it.next();
            l lVar2 = next.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.u.remove(next);
            }
        }
    }

    public final void C(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(m());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).C(bundle);
            }
        }
        int i4 = bundle.getInt("android:menu:expandedactionview");
        if (i4 <= 0 || (menuItemFindItem = findItem(i4)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public final void D(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).D(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(m(), sparseArray);
        }
    }

    public void E(a aVar) {
        this.f2545e = aVar;
    }

    public final f F() {
        this.f2551l = 1;
        return this;
    }

    final void G(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f2546f.size();
        P();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.f2546f.get(i2);
            if (hVar.getGroupId() == groupId && hVar.l() && hVar.isCheckable()) {
                hVar.q(hVar == menuItem);
            }
        }
        O();
    }

    protected final f H(int i2) {
        J(0, null, i2, null, null);
        return this;
    }

    protected final f I(Drawable drawable) {
        J(0, null, 0, drawable, null);
        return this;
    }

    protected final f K(int i2) {
        J(i2, null, 0, null, null);
        return this;
    }

    protected final f L(CharSequence charSequence) {
        J(0, charSequence, 0, null, null);
        return this;
    }

    protected final f M(View view) {
        J(0, null, 0, null, view);
        return this;
    }

    public final void N(boolean z4) {
        this.f2561x = z4;
    }

    public final void O() {
        this.p = false;
        if (this.f2555q) {
            this.f2555q = false;
            x(this.f2556r);
        }
    }

    public final void P() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.f2555q = false;
        this.f2556r = false;
    }

    protected final MenuItem a(int i2, int i4, int i5, CharSequence charSequence) {
        int i6;
        int i7 = ((-65536) & i5) >> 16;
        if (i7 >= 0) {
            int[] iArr = f2541y;
            if (i7 < 6) {
                int i8 = (iArr[i7] << 16) | (65535 & i5);
                h hVar = new h(this, i2, i4, i5, i8, charSequence, this.f2551l);
                ArrayList<h> arrayList = this.f2546f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        i6 = 0;
                        break;
                    }
                    if (arrayList.get(size).e() <= i8) {
                        i6 = size + 1;
                        break;
                    }
                }
                arrayList.add(i6, hVar);
                x(true);
                return hVar;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i2, int i4, int i5, ComponentName componentName, Intent[] intentArr, Intent intent, int i6, MenuItem[] menuItemArr) {
        int i7;
        PackageManager packageManager = this.f2542a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i6 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i8 = 0; i8 < size; i8++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i9 < 0 ? intent : intentArr[i9]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            h hVar = (h) a(i2, i4, i5, resolveInfo.loadLabel(packageManager));
            hVar.setIcon(resolveInfo.loadIcon(packageManager));
            hVar.setIntent(intent2);
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = hVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(l lVar) {
        c(lVar, this.f2542a);
    }

    public final void c(l lVar, Context context) {
        this.u.add(new WeakReference<>(lVar));
        lVar.c(context, this);
        this.f2550k = true;
    }

    @Override // android.view.Menu
    public final void clear() {
        h hVar = this.f2559v;
        if (hVar != null) {
            f(hVar);
        }
        this.f2546f.clear();
        x(true);
    }

    public final void clearHeader() {
        this.f2553n = null;
        this.f2552m = null;
        this.f2554o = null;
        x(false);
    }

    @Override // android.view.Menu
    public final void close() {
        e(true);
    }

    public final void d() {
        a aVar = this.f2545e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void e(boolean z4) {
        if (this.f2557s) {
            return;
        }
        this.f2557s = true;
        Iterator<WeakReference<l>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<l> next = it.next();
            l lVar = next.get();
            if (lVar == null) {
                this.u.remove(next);
            } else {
                lVar.a(this, z4);
            }
        }
        this.f2557s = false;
    }

    public boolean f(h hVar) {
        boolean zB = false;
        if (!this.u.isEmpty() && this.f2559v == hVar) {
            P();
            Iterator<WeakReference<l>> it = this.u.iterator();
            while (it.hasNext()) {
                WeakReference<l> next = it.next();
                l lVar = next.get();
                if (lVar == null) {
                    this.u.remove(next);
                } else {
                    zB = lVar.b(hVar);
                    if (zB) {
                        break;
                    }
                }
            }
            O();
            if (zB) {
                this.f2559v = null;
            }
        }
        return zB;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i2) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            h hVar = this.f2546f.get(i4);
            if (hVar.getItemId() == i2) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (menuItemFindItem = ((f) hVar.getSubMenu()).findItem(i2)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    boolean g(f fVar, MenuItem menuItem) {
        a aVar = this.f2545e;
        return aVar != null && aVar.a(fVar, menuItem);
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i2) {
        return this.f2546f.get(i2);
    }

    public boolean h(h hVar) {
        boolean zE = false;
        if (this.u.isEmpty()) {
            return false;
        }
        P();
        Iterator<WeakReference<l>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<l> next = it.next();
            l lVar = next.get();
            if (lVar == null) {
                this.u.remove(next);
            } else {
                zE = lVar.e(hVar);
                if (zE) {
                    break;
                }
            }
        }
        O();
        if (zE) {
            this.f2559v = hVar;
        }
        return zE;
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f2561x) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f2546f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    final h i(int i2, KeyEvent keyEvent) {
        ArrayList<h> arrayList = this.f2558t;
        arrayList.clear();
        j(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zT = t();
        for (int i4 = 0; i4 < size; i4++) {
            h hVar = arrayList.get(i4);
            char alphabeticShortcut = zT ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zT && alphabeticShortcut == '\b' && i2 == 67))) {
                return hVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return i(i2, keyEvent) != null;
    }

    final void j(List<h> list, int i2, KeyEvent keyEvent) {
        boolean zT = t();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f2546f.size();
            for (int i4 = 0; i4 < size; i4++) {
                h hVar = this.f2546f.get(i4);
                if (hVar.hasSubMenu()) {
                    ((f) hVar.getSubMenu()).j(list, i2, keyEvent);
                }
                char alphabeticShortcut = zT ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if (((modifiers & 69647) == ((zT ? hVar.getAlphabeticModifiers() : hVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zT && alphabeticShortcut == '\b' && i2 == 67)) && hVar.isEnabled()) {
                        list.add(hVar);
                    }
                }
            }
        }
    }

    public final void k() {
        ArrayList<h> arrayListR = r();
        if (this.f2550k) {
            Iterator<WeakReference<l>> it = this.u.iterator();
            boolean zFlagActionItems = false;
            while (it.hasNext()) {
                WeakReference<l> next = it.next();
                l lVar = next.get();
                if (lVar == null) {
                    this.u.remove(next);
                } else {
                    zFlagActionItems |= lVar.flagActionItems();
                }
            }
            if (zFlagActionItems) {
                this.f2548i.clear();
                this.f2549j.clear();
                int size = arrayListR.size();
                for (int i2 = 0; i2 < size; i2++) {
                    h hVar = arrayListR.get(i2);
                    if (hVar.k()) {
                        this.f2548i.add(hVar);
                    } else {
                        this.f2549j.add(hVar);
                    }
                }
            } else {
                this.f2548i.clear();
                this.f2549j.clear();
                this.f2549j.addAll(r());
            }
            this.f2550k = false;
        }
    }

    public final ArrayList<h> l() {
        k();
        return this.f2548i;
    }

    protected String m() {
        return "android:menu:actionviewstates";
    }

    public final Context n() {
        return this.f2542a;
    }

    public final h o() {
        return this.f2559v;
    }

    public final ArrayList<h> p() {
        k();
        return this.f2549j;
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i2, int i4) {
        return z(findItem(i2), null, i4);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i2, KeyEvent keyEvent, int i4) {
        h hVarI = i(i2, keyEvent);
        boolean z4 = hVarI != null ? z(hVarI, null, i4) : false;
        if ((i4 & 2) != 0) {
            e(true);
        }
        return z4;
    }

    public f q() {
        return this;
    }

    public final ArrayList<h> r() {
        if (!this.f2547h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f2546f.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.f2546f.get(i2);
            if (hVar.isVisible()) {
                this.g.add(hVar);
            }
        }
        this.f2547h = false;
        this.f2550k = true;
        return this.g;
    }

    @Override // android.view.Menu
    public final void removeGroup(int i2) {
        int size = size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i4 = -1;
                break;
            } else if (this.f2546f.get(i4).getGroupId() == i2) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            int size2 = this.f2546f.size() - i4;
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= size2 || this.f2546f.get(i4).getGroupId() != i2) {
                    break;
                }
                A(i4, false);
                i5 = i6;
            }
            x(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i2) {
        int size = size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i4 = -1;
                break;
            } else if (this.f2546f.get(i4).getItemId() == i2) {
                break;
            } else {
                i4++;
            }
        }
        A(i4, true);
    }

    public boolean s() {
        return this.f2560w;
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i2, boolean z4, boolean z5) {
        int size = this.f2546f.size();
        for (int i4 = 0; i4 < size; i4++) {
            h hVar = this.f2546f.get(i4);
            if (hVar.getGroupId() == i2) {
                hVar.r(z5);
                hVar.setCheckable(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z4) {
        this.f2560w = z4;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i2, boolean z4) {
        int size = this.f2546f.size();
        for (int i4 = 0; i4 < size; i4++) {
            h hVar = this.f2546f.get(i4);
            if (hVar.getGroupId() == i2) {
                hVar.setEnabled(z4);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i2, boolean z4) {
        int size = this.f2546f.size();
        boolean z5 = false;
        for (int i4 = 0; i4 < size; i4++) {
            h hVar = this.f2546f.get(i4);
            if (hVar.getGroupId() == i2 && hVar.u(z4)) {
                z5 = true;
            }
        }
        if (z5) {
            x(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f2544c = z4;
        x(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f2546f.size();
    }

    boolean t() {
        return this.f2544c;
    }

    public boolean u() {
        return this.d;
    }

    final void v() {
        this.f2550k = true;
        x(true);
    }

    final void w() {
        this.f2547h = true;
        x(true);
    }

    public final void x(boolean z4) {
        if (this.p) {
            this.f2555q = true;
            if (z4) {
                this.f2556r = true;
                return;
            }
            return;
        }
        if (z4) {
            this.f2547h = true;
            this.f2550k = true;
        }
        if (this.u.isEmpty()) {
            return;
        }
        P();
        Iterator<WeakReference<l>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<l> next = it.next();
            l lVar = next.get();
            if (lVar == null) {
                this.u.remove(next);
            } else {
                lVar.updateMenuView(z4);
            }
        }
        O();
    }

    public final boolean y(MenuItem menuItem, int i2) {
        return z(menuItem, null, i2);
    }

    public final boolean z(MenuItem menuItem, l lVar, int i2) {
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean zJ = hVar.j();
        androidx.core.view.b bVarB = hVar.b();
        boolean z4 = bVarB != null && bVarB.a();
        if (hVar.i()) {
            zJ |= hVar.expandActionView();
            if (zJ) {
                e(true);
            }
        } else if (hVar.hasSubMenu() || z4) {
            if ((i2 & 4) == 0) {
                e(false);
            }
            if (!hVar.hasSubMenu()) {
                hVar.t(new p(this.f2542a, this, hVar));
            }
            p pVar = (p) hVar.getSubMenu();
            if (z4) {
                bVarB.f(pVar);
            }
            if (!this.u.isEmpty()) {
                zG = lVar != null ? lVar.g(pVar) : false;
                Iterator<WeakReference<l>> it = this.u.iterator();
                while (it.hasNext()) {
                    WeakReference<l> next = it.next();
                    l lVar2 = next.get();
                    if (lVar2 == null) {
                        this.u.remove(next);
                    } else if (!zG) {
                        zG = lVar2.g(pVar);
                    }
                }
            }
            zJ |= zG;
            if (!zJ) {
                e(true);
            }
        } else if ((i2 & 1) == 0) {
            e(true);
        }
        return zJ;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2) {
        return a(0, 0, 0, this.f2543b.getString(i2));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f2543b.getString(i2));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i4, int i5, CharSequence charSequence) {
        return a(i2, i4, i5, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i4, int i5, CharSequence charSequence) {
        h hVar = (h) a(i2, i4, i5, charSequence);
        p pVar = new p(this.f2542a, this, hVar);
        hVar.t(pVar);
        return pVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i4, int i5, int i6) {
        return a(i2, i4, i5, this.f2543b.getString(i6));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i4, int i5, int i6) {
        return addSubMenu(i2, i4, i5, this.f2543b.getString(i6));
    }
}
