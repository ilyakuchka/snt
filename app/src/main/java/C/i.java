package C;

import C.f;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class i implements E.a<f.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f40a;

    i(String str) {
        this.f40a = str;
    }

    @Override // E.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(f.b bVar) {
        synchronized (f.f30c) {
            q.g<String, ArrayList<E.a<f.b>>> gVar = f.d;
            ArrayList<E.a<f.b>> orDefault = gVar.getOrDefault(this.f40a, null);
            if (orDefault == null) {
                return;
            }
            gVar.remove(this.f40a);
            for (int i2 = 0; i2 < orDefault.size(); i2++) {
                orDefault.get(i2).a(bVar);
            }
        }
    }
}
