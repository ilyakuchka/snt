package P3;

import java.io.IOException;

/* loaded from: classes.dex */
public final class l extends RuntimeException {

    /* renamed from: i, reason: collision with root package name */
    private final IOException f1046i;

    /* renamed from: j, reason: collision with root package name */
    private IOException f1047j;

    public l(IOException iOException) {
        super(iOException);
        this.f1046i = iOException;
        this.f1047j = iOException;
    }

    public final void a(IOException iOException) {
        Y1.a.a(this.f1046i, iOException);
        this.f1047j = iOException;
    }

    public final IOException b() {
        return this.f1046i;
    }

    public final IOException c() {
        return this.f1047j;
    }
}
