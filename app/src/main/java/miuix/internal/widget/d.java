package miuix.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.widget.Y;
import com.android.mmt.R;
import java.lang.ref.WeakReference;
import miuix.view.HapticCompat;
import s3.C0382b;
import w3.C0408a;
import z3.C0431a;

/* loaded from: classes.dex */
public class d extends PopupWindow {
    private static final float DIM = 0.3f;
    private static final float OFFSET_X = 8.0f;
    private static final float OFFSET_Y = 8.0f;
    private static final String TAG = "ListPopupWindow";
    private ListAdapter mAdapter;
    private WeakReference<View> mAnchor;
    protected final Rect mBackgroundPadding;
    private C0124d mContentSize;
    protected View mContentView;
    private Context mContext;
    private int mDropDownGravity;
    protected int mElevation;
    private boolean mHasShadow;
    private ListView mListView;
    protected int mMaxAllowedHeight;
    private int mMaxAllowedWidth;
    private int mMinAllowedWidth;
    private int mMinMarginScreen;
    private DataSetObserver mObserver;
    private int mOffsetFromStatusBar;
    private int mOffsetX;
    private boolean mOffsetXSet;
    private int mOffsetY;
    private boolean mOffsetYSet;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    protected FrameLayout mRootView;

    final class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            view.removeOnLayoutChangeListener(this);
            d.this.mContentView.setEnabled(!(d.this.mListView.getAdapter() != null && d.this.mListView.getLastVisiblePosition() == d.this.mListView.getAdapter().getCount() - 1));
        }
    }

    final class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            if (view.getWidth() == 0 || view.getHeight() == 0) {
                return;
            }
            outline.setAlpha(C0431a.f(view.getContext()));
            if (view.getBackground() != null) {
                view.getBackground().getOutline(outline);
            }
        }
    }

    /* renamed from: miuix.internal.widget.d$d, reason: collision with other inner class name */
    private static class C0124d {

        /* renamed from: a, reason: collision with root package name */
        int f7163a;

        /* renamed from: b, reason: collision with root package name */
        int f7164b;

        /* renamed from: c, reason: collision with root package name */
        boolean f7165c;

        C0124d() {
        }

        public final void a(int i2) {
            this.f7163a = i2;
            this.f7165c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int calculateXoffset(View view) {
        int width;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        boolean z4 = true;
        if (Y.b(view)) {
            if (getWidth() + (iArr[0] - this.mOffsetX) + this.mMinMarginScreen > view.getRootView().getWidth()) {
                width = ((view.getRootView().getWidth() - getWidth()) - this.mMinMarginScreen) - iArr[0];
            } else {
                width = 0;
                z4 = false;
            }
        } else {
            if ((((view.getWidth() + iArr[0]) + this.mOffsetX) - getWidth()) - this.mMinMarginScreen < 0) {
                width = (getWidth() + this.mMinMarginScreen) - (view.getWidth() + iArr[0]);
            }
        }
        if (z4) {
            return width;
        }
        boolean z5 = this.mOffsetXSet;
        int i2 = z5 ? this.mOffsetX : 0;
        return (i2 == 0 || z5) ? i2 : Y.b(view) ? i2 - (this.mBackgroundPadding.left - this.mOffsetX) : (this.mBackgroundPadding.right - this.mOffsetX) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateYoffset(View view) {
        int i2 = this.mOffsetYSet ? this.mOffsetY : ((-view.getHeight()) - this.mBackgroundPadding.top) + this.mOffsetY;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        float f4 = iArr[1];
        int i4 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        int iCheckMaxHeight = checkMaxHeight(view);
        int iMin = iCheckMaxHeight > 0 ? Math.min(this.mContentSize.f7164b, iCheckMaxHeight) : this.mContentSize.f7164b;
        if (iMin >= i4 || f4 + i2 + iMin + view.getHeight() <= i4) {
            return i2;
        }
        return i2 - ((this.mOffsetYSet ? view.getHeight() : 0) + iMin);
    }

    public static void changeWindowBackground(View view) {
        WindowManager.LayoutParams layoutParams;
        if (view == null || (layoutParams = (WindowManager.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.flags |= 2;
        layoutParams.dimAmount = DIM;
        ((WindowManager) view.getContext().getSystemService("window")).updateViewLayout(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getAnchor() {
        WeakReference<View> weakReference = this.mAnchor;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareShow$2(AdapterView adapterView, View view, int i2, long j2) {
        int headerViewsCount = i2 - this.mListView.getHeaderViewsCount();
        if (this.mOnItemClickListener == null || headerViewsCount < 0 || headerViewsCount >= this.mAdapter.getCount()) {
            return;
        }
        this.mOnItemClickListener.onItemClick(adapterView, view, headerViewsCount, j2);
    }

    private void measureContentSize(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i4 = 0;
        int i5 = 0;
        int measuredHeight = 0;
        View view = null;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = listAdapter.getItemViewType(i6);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i6, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            measuredHeight += view.getMeasuredHeight();
            if (!this.mContentSize.f7165c) {
                int measuredWidth = view.getMeasuredWidth();
                if (measuredWidth >= i2) {
                    this.mContentSize.a(i2);
                } else if (measuredWidth > i5) {
                    i5 = measuredWidth;
                }
            }
        }
        C0124d c0124d = this.mContentSize;
        if (!c0124d.f7165c) {
            c0124d.a(i5);
        }
        this.mContentSize.f7164b = measuredHeight;
    }

    private boolean shouldSetElevation() {
        return this.mHasShadow;
    }

    private void showWithAnchor(View view) {
        showAsDropDown(view, calculateXoffset(view), calculateYoffset(view), this.mDropDownGravity);
        HapticCompat.performHapticFeedback(view, miuix.view.c.f7461k);
        changeWindowBackground(this.mRootView.getRootView());
    }

    protected int checkMaxHeight(View view) {
        return Math.min(this.mMaxAllowedHeight, (new z3.c(this.mContext).b() - C0408a.a(this.mContext)) - (view == null ? 0 : view.getHeight()));
    }

    protected int computePopupContentWidth() {
        if (!this.mContentSize.f7165c) {
            measureContentSize(this.mAdapter, null, this.mContext, this.mMaxAllowedWidth);
        }
        int iMax = Math.max(this.mContentSize.f7163a, this.mMinAllowedWidth);
        Rect rect = this.mBackgroundPadding;
        return iMax + rect.left + rect.right;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        C0382b.b(this.mContext);
    }

    public void fastShow(View view, ViewGroup viewGroup) {
        setWidth(computePopupContentWidth());
        showWithAnchor(view);
    }

    public int getHorizontalOffset() {
        return this.mOffsetX;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public int getMinMarginScreen() {
        return this.mMinMarginScreen;
    }

    public int getOffsetFromStatusBar() {
        return this.mOffsetFromStatusBar;
    }

    public int getVerticalOffset() {
        return this.mOffsetY;
    }

    protected void prepareContentView(Context context) {
        Drawable drawableE = C0431a.e(this.mContext, R.attr.immersionWindowBackground);
        if (drawableE != null) {
            drawableE.getPadding(this.mBackgroundPadding);
            this.mRootView.setBackground(drawableE);
        }
        setBackgroundDrawable(new ColorDrawable(0));
        setPopupWindowContentView(this.mRootView);
    }

    protected boolean prepareShow(View view, ViewGroup viewGroup) {
        if (view == null) {
            Log.e(TAG, "show: anchor is null");
            return false;
        }
        if (this.mContentView == null) {
            View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.miuix_appcompat_list_popup_list, (ViewGroup) null);
            this.mContentView = viewInflate;
            viewInflate.addOnLayoutChangeListener(new b());
        }
        if (this.mRootView.getChildCount() != 1 || this.mRootView.getChildAt(0) != this.mContentView) {
            this.mRootView.removeAllViews();
            this.mRootView.addView(this.mContentView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.gravity = 16;
        }
        if (shouldSetElevation()) {
            this.mRootView.setElevation(this.mElevation);
            setElevation(this.mElevation);
            setPopupShadowAlpha(this.mRootView);
        }
        ListView listView = (ListView) this.mContentView.findViewById(android.R.id.list);
        this.mListView = listView;
        if (listView == null) {
            Log.e(TAG, "list not found");
            return false;
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: miuix.internal.widget.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i2, long j2) {
                this.f7161i.lambda$prepareShow$2(adapterView, view2, i2, j2);
            }
        });
        this.mListView.setAdapter(this.mAdapter);
        setWidth(computePopupContentWidth());
        int iCheckMaxHeight = checkMaxHeight(view);
        if (iCheckMaxHeight > 0 && this.mContentSize.f7164b > iCheckMaxHeight) {
            setHeight(iCheckMaxHeight);
        }
        ((InputMethodManager) this.mContext.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        return true;
    }

    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
    }

    public void setContentWidth(int i2) {
        this.mContentSize.a(i2);
    }

    public void setDropDownGravity(int i2) {
        this.mDropDownGravity = i2;
    }

    public void setHasShadow(boolean z4) {
        this.mHasShadow = z4;
    }

    public void setHorizontalOffset(int i2) {
        this.mOffsetX = i2;
        this.mOffsetXSet = true;
    }

    public void setMaxAllowedHeight(int i2) {
        this.mMaxAllowedHeight = i2;
    }

    @Override // android.widget.PopupWindow
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    protected void setPopupShadowAlpha(View view) {
        if (C0408a.b(this.mContext)) {
            view.setOutlineProvider(null);
        } else {
            view.setOutlineProvider(new c());
        }
    }

    protected void setPopupWindowContentView(View view) {
        super.setContentView(view);
    }

    public void setVerticalOffset(int i2) {
        this.mOffsetY = i2;
        this.mOffsetYSet = true;
    }

    public void show(View view, ViewGroup viewGroup) {
        if (prepareShow(view, viewGroup)) {
            showWithAnchor(view);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i4, int i5) {
        super.showAsDropDown(view, i2, i4, i5);
        this.mAnchor = new WeakReference<>(view);
        C0382b.c(this.mContext, this);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i2, int i4, int i5) {
        super.showAtLocation(view, i2, i4, i5);
        C0382b.c(this.mContext, this);
    }

    public d(Context context) {
    }
}
