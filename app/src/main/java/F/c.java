package F;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f126a;

    static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        final c f127a;

        a(c cVar) {
            this.f127a = cVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            F.b bVarA = this.f127a.a(i2);
            if (bVarA == null) {
                return null;
            }
            return bVarA.Z();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            Objects.requireNonNull(this.f127a);
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final boolean performAction(int i2, int i4, Bundle bundle) {
            return this.f127a.d(i2, i4, bundle);
        }
    }

    static class b extends a {
        b(c cVar) {
            super(cVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo findFocus(int i2) {
            F.b bVarB = this.f127a.b(i2);
            if (bVarB == null) {
                return null;
            }
            return bVarB.Z();
        }
    }

    /* renamed from: F.c$c, reason: collision with other inner class name */
    static class C0005c extends b {
        C0005c(c cVar) {
            super(cVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            Objects.requireNonNull(this.f127a);
        }
    }

    public c() {
        this.f126a = new C0005c(this);
    }

    public F.b a(int i2) {
        return null;
    }

    public F.b b(int i2) {
        return null;
    }

    public final Object c() {
        return this.f126a;
    }

    public boolean d(int i2, int i4, Bundle bundle) {
        return false;
    }

    public c(Object obj) {
        this.f126a = obj;
    }
}
