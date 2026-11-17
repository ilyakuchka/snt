package q3;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import miuix.androidbasewidget.widget.CheckedTextView;

/* renamed from: q3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0367a extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayAdapter f7641a;

    /* renamed from: b, reason: collision with root package name */
    private c f7642b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f7643c;

    /* renamed from: q3.a$a, reason: collision with other inner class name */
    final class C0136a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7644a;

        C0136a(int i2) {
            this.f7644a = i2;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.title);
            CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.summary);
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) view.findViewById(R.id.checkbox);
            accessibilityNodeInfo.setClassName(RadioButton.class.getName());
            accessibilityNodeInfo.setClickable(true);
            accessibilityNodeInfo.setCheckable(true);
            if (appCompatRadioButton == null || !appCompatRadioButton.isActivated()) {
                accessibilityNodeInfo.setChecked(false);
            } else {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.setChecked(true);
                accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
            }
            String string = checkedTextView != null ? checkedTextView.getText().toString() : null;
            String string2 = checkedTextView2 != null ? checkedTextView2.getText().toString() : null;
            if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                accessibilityNodeInfo.setContentDescription(string + " " + string2);
            }
            if ((C0367a.this.f7641a instanceof b) && ((b) C0367a.this.f7641a).a()) {
                accessibilityNodeInfo.setContentDescription(C0367a.this.f7641a.getItem(this.f7644a).toString());
            }
        }
    }

    /* renamed from: q3.a$b */
    public interface b {
        boolean a();
    }

    /* renamed from: q3.a$c */
    public interface c {
        boolean a(int i2);
    }

    /* renamed from: q3.a$d */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        FrameLayout f7646a;

        /* renamed from: b, reason: collision with root package name */
        RadioButton f7647b;

        private d() {
        }

        d(C0136a c0136a) {
        }
    }

    public C0367a(Context context, ArrayAdapter arrayAdapter, c cVar) {
        super(context, com.android.mmt.R.layout.miuix_appcompat_simple_spinner_layout_integrated, R.id.text1);
        this.f7643c = LayoutInflater.from(context);
        this.f7641a = arrayAdapter;
        this.f7642b = cVar;
    }

    public final void c(View view, int i2) {
        view.setAccessibilityDelegate(new C0136a(i2));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final int getCount() {
        return this.f7641a.getCount();
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        boolean z4 = false;
        if (view == null || view.getTag(com.android.mmt.R.id.tag_spinner_dropdown_view) == null) {
            view = this.f7643c.inflate(com.android.mmt.R.layout.miuix_appcompat_spinner_dropdown_checkable_item, viewGroup, false);
            d dVar = new d(null);
            dVar.f7646a = (FrameLayout) view.findViewById(com.android.mmt.R.id.spinner_dropdown_container);
            dVar.f7647b = (RadioButton) view.findViewById(R.id.checkbox);
            view.setTag(com.android.mmt.R.id.tag_spinner_dropdown_view, dVar);
        }
        Object tag = view.getTag(com.android.mmt.R.id.tag_spinner_dropdown_view);
        if (tag != null) {
            d dVar2 = (d) tag;
            View dropDownView = this.f7641a.getDropDownView(i2, dVar2.f7646a.getChildAt(0), viewGroup);
            dVar2.f7646a.removeAllViews();
            dVar2.f7646a.addView(dropDownView);
            c cVar = this.f7642b;
            if (cVar != null && cVar.a(i2)) {
                z4 = true;
            }
            dVar2.f7647b.setChecked(z4);
            view.setActivated(z4);
        }
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final Object getItem(int i2) {
        return this.f7641a.getItem(i2);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final long getItemId(int i2) {
        return this.f7641a.getItemId(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return this.f7641a.hasStableIds();
    }
}
