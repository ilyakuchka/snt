package c1;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public interface n<Model, Data> {

    public static class a<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final V0.f f4419a;

        /* renamed from: b, reason: collision with root package name */
        public final List<V0.f> f4420b;

        /* renamed from: c, reason: collision with root package name */
        public final W0.d<Data> f4421c;

        public a(V0.f fVar, W0.d<Data> dVar) {
            List<V0.f> listEmptyList = Collections.emptyList();
            Objects.requireNonNull(fVar, "Argument must not be null");
            this.f4419a = fVar;
            Objects.requireNonNull(listEmptyList, "Argument must not be null");
            this.f4420b = listEmptyList;
            Objects.requireNonNull(dVar, "Argument must not be null");
            this.f4421c = dVar;
        }
    }

    a<Data> a(Model model, int i2, int i4, V0.h hVar);

    boolean b(Model model);
}
