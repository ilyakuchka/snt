package miuix.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.o;
import com.android.mmt.R;
import java.util.Objects;
import miuix.appcompat.app.AlertController;
import miuix.view.HapticCompat;

/* loaded from: classes.dex */
public class g extends o {

    /* renamed from: k, reason: collision with root package name */
    final AlertController f6683k;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.AlertParams f6684a;

        /* renamed from: b, reason: collision with root package name */
        private final int f6685b;

        public a(Context context) {
            this(context, g.j(context, 0));
        }

        public final g A() {
            g gVarA = a();
            gVarA.show();
            return gVarA;
        }

        public final g a() {
            g gVar = new g(this.f6684a.mContext, this.f6685b);
            this.f6684a.apply(gVar.f6683k);
            gVar.setCancelable(this.f6684a.mCancelable);
            if (this.f6684a.mCancelable) {
                gVar.setCanceledOnTouchOutside(true);
            }
            gVar.setOnCancelListener(this.f6684a.mOnCancelListener);
            gVar.setOnDismissListener(this.f6684a.mOnDismissListener);
            gVar.setOnShowListener(this.f6684a.mOnShowListener);
            DialogInterface.OnKeyListener onKeyListener = this.f6684a.mOnKeyListener;
            if (onKeyListener != null) {
                gVar.setOnKeyListener(onKeyListener);
            }
            return gVar;
        }

        public final a b(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public final a c(boolean z4) {
            this.f6684a.mCancelable = z4;
            return this;
        }

        public final a d(CharSequence charSequence) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mIsChecked = false;
            alertParams.mCheckBoxMessage = charSequence;
            return this;
        }

        public final a e(View view) {
            this.f6684a.mCustomTitleView = view;
            return this;
        }

        public final a f() {
            this.f6684a.mIconId = R.drawable.ic_sms_mms_not_delivered;
            return this;
        }

        public final a g(Drawable drawable) {
            this.f6684a.mIcon = drawable;
            return this;
        }

        public final a h() {
            TypedValue typedValue = new TypedValue();
            this.f6684a.mContext.getTheme().resolveAttribute(android.R.attr.alertDialogIcon, typedValue, true);
            this.f6684a.mIconId = typedValue.resourceId;
            return this;
        }

        public final a i(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public final a j(int i2) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mMessage = alertParams.mContext.getText(i2);
            return this;
        }

        public final a k(CharSequence charSequence) {
            this.f6684a.mMessage = charSequence;
            return this;
        }

        public final a l(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mCheckedItems = zArr;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public final a m(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i2);
            this.f6684a.mNegativeButtonListener = onClickListener;
            return this;
        }

        public final a n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public final a o(DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(android.R.string.ok);
            this.f6684a.mNeutralButtonListener = onClickListener;
            return this;
        }

        public final a p(DialogInterface.OnCancelListener onCancelListener) {
            this.f6684a.mOnCancelListener = onCancelListener;
            return this;
        }

        public final a q(DialogInterface.OnDismissListener onDismissListener) {
            this.f6684a.mOnDismissListener = onDismissListener;
            return this;
        }

        public final a r(DialogInterface.OnKeyListener onKeyListener) {
            this.f6684a.mOnKeyListener = onKeyListener;
            return this;
        }

        public final a s(DialogInterface.OnShowListener onShowListener) {
            this.f6684a.mOnShowListener = onShowListener;
            return this;
        }

        public final a t(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i2);
            this.f6684a.mPositiveButtonListener = onClickListener;
            return this;
        }

        public final a u(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public final a v(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i2;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public final a w(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i2;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public final a x(int i2) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mTitle = alertParams.mContext.getText(i2);
            return this;
        }

        public final a y(CharSequence charSequence) {
            this.f6684a.mTitle = charSequence;
            return this;
        }

        public final a z(View view) {
            AlertController.AlertParams alertParams = this.f6684a;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            return this;
        }

        public a(Context context, int i2) {
            this.f6684a = new AlertController.AlertParams(new ContextThemeWrapper(context, g.j(context, i2)));
            this.f6685b = i2;
        }
    }

    public interface b {
    }

    protected g(Context context) {
        this(context, 0);
    }

    static int j(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.miuiAlertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.o, android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Objects.requireNonNull(this.f6683k);
        if (keyEvent.getKeyCode() == 82) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final Button e(int i2) {
        return this.f6683k.e(i2);
    }

    public final ListView f() {
        return this.f6683k.g;
    }

    public final boolean g() {
        return this.f6683k.h();
    }

    public final void k(int i2, CharSequence charSequence) {
        this.f6683k.i(i2, charSequence, null);
    }

    public final void l(View view) {
        this.f6683k.s(view);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View decorView = getWindow().getDecorView();
        if (decorView != null && this.f6683k.P) {
            HapticCompat.performHapticFeedbackAsync(decorView, miuix.view.c.f7461k);
        }
        if (decorView == null) {
            return;
        }
        androidx.core.view.o.k(decorView, decorView.getContext().getResources().getString(R.string.miuix_appcompat_show_dialog_description));
    }

    @Override // androidx.appcompat.app.o, android.app.Dialog
    protected final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        this.f6683k.g();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Objects.requireNonNull(this.f6683k);
    }

    @Override // android.app.Dialog
    protected final void onStart() {
        super.onStart();
        Objects.requireNonNull(this.f6683k);
    }

    @Override // androidx.appcompat.app.o, android.app.Dialog
    protected final void onStop() {
        super.onStop();
        Objects.requireNonNull(this.f6683k);
    }

    @Override // androidx.appcompat.app.o, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f6683k.q(charSequence);
    }

    protected g(Context context, int i2) {
        super(context, j(context, i2));
        if (context == null || context.getClass() != ContextThemeWrapper.class) {
            context = getContext();
        }
        this.f6683k = new AlertController(context, this, getWindow());
    }
}
