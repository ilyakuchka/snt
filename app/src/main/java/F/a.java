package F;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: i, reason: collision with root package name */
    private final int f110i;

    /* renamed from: j, reason: collision with root package name */
    private final b f111j;

    /* renamed from: k, reason: collision with root package name */
    private final int f112k;

    public a(int i2, b bVar, int i4) {
        this.f110i = i2;
        this.f111j = bVar;
        this.f112k = i4;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f110i);
        this.f111j.w(this.f112k, bundle);
    }
}
