package G;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: G.a$a, reason: collision with other inner class name */
    final class C0007a extends InputConnectionWrapper {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f132a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0007a(InputConnection inputConnection, b bVar) {
            super(inputConnection, false);
            this.f132a = bVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
            if (this.f132a.a(G.b.f(inputContentInfo), i2, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i2, bundle);
        }
    }

    public interface b {
        boolean a(G.b bVar, int i2, Bundle bundle);
    }

    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, b bVar) {
        if (editorInfo != null) {
            return new C0007a(inputConnection, bVar);
        }
        throw new IllegalArgumentException("editorInfo must be non-null");
    }
}
