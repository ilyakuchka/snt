package miuix.appcompat.widget;

import android.R;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import miuix.androidbasewidget.widget.CheckedTextView;

/* loaded from: classes.dex */
final class b extends View.AccessibilityDelegate {
    b() {
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.text1);
        accessibilityNodeInfo.setClassName(Checkable.class.getName());
        accessibilityNodeInfo.setCheckable(true);
        if (checkedTextView != null) {
            accessibilityNodeInfo.setChecked(checkedTextView.isChecked());
            if (!checkedTextView.isChecked()) {
                accessibilityNodeInfo.setClickable(true);
            } else {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
            }
        }
    }
}
