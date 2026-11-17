package miuix.popupwidget.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class ArrowPopupContentWrapper extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    private Paint f7294i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f7295j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f7296k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f7297l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f7298m;

    public ArrowPopupContentWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Paint paint = new Paint();
        this.f7294i = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f7294i.setAntiAlias(true);
        Resources resources = getResources();
        this.f7295j = BitmapFactory.decodeResource(resources, R.drawable.miuix_appcompat_popup_mask_1);
        this.f7296k = BitmapFactory.decodeResource(resources, R.drawable.miuix_appcompat_popup_mask_2);
        this.f7297l = BitmapFactory.decodeResource(resources, R.drawable.miuix_appcompat_popup_mask_3);
        this.f7298m = BitmapFactory.decodeResource(resources, R.drawable.miuix_appcompat_popup_mask_4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(this.f7295j, getPaddingLeft() + 0, getPaddingTop() + 0, this.f7294i);
        canvas.drawBitmap(this.f7296k, (getWidth() - this.f7296k.getWidth()) - getPaddingRight(), getPaddingTop() + 0, this.f7294i);
        canvas.drawBitmap(this.f7297l, getPaddingLeft() + 0, (getHeight() - this.f7297l.getHeight()) - getPaddingBottom(), this.f7294i);
        canvas.drawBitmap(this.f7298m, (getWidth() - this.f7298m.getWidth()) - getPaddingRight(), (getHeight() - this.f7298m.getHeight()) - getPaddingBottom(), this.f7294i);
        canvas.restore();
    }
}
