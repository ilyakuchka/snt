package androidx.lifecycle;

import androidx.lifecycle.g;
import androidx.savedstate.SavedStateRegistry;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SavedStateHandleController implements i {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3666a;

    /* renamed from: androidx.lifecycle.SavedStateHandleController$1, reason: invalid class name */
    class AnonymousClass1 implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f3667a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SavedStateRegistry f3668b;

        @Override // androidx.lifecycle.i
        public final void g(k kVar, g.b bVar) throws NoSuchMethodException, SecurityException {
            if (bVar == g.b.ON_START) {
                this.f3667a.c(this);
                this.f3668b.e(a.class);
            }
        }
    }

    static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public final void a(androidx.savedstate.b bVar) throws NoSuchMethodException, SecurityException {
            if (!(bVar instanceof x)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            w wVarQ = ((x) bVar).q();
            SavedStateRegistry savedStateRegistryE = bVar.e();
            Iterator it = ((HashSet) wVarQ.c()).iterator();
            while (it.hasNext()) {
                SavedStateHandleController.h(wVarQ.b((String) it.next()), bVar.a());
            }
            if (((HashSet) wVarQ.c()).isEmpty()) {
                return;
            }
            savedStateRegistryE.e(a.class);
        }
    }

    static void h(u uVar, g gVar) {
        boolean z4;
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) uVar.b();
        if (savedStateHandleController == null || (z4 = savedStateHandleController.f3666a)) {
            return;
        }
        if (z4) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        savedStateHandleController.f3666a = true;
        gVar.a(savedStateHandleController);
        throw null;
    }

    @Override // androidx.lifecycle.i
    public final void g(k kVar, g.b bVar) {
        if (bVar == g.b.ON_DESTROY) {
            this.f3666a = false;
            kVar.a().c(this);
        }
    }
}
