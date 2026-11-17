package miuix.appcompat.internal.app.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.os.MessageQueue;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.mmt.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o0.RunnableC0359b;
import t.C0384b;
import z3.C0432b;

/* loaded from: classes.dex */
public class SearchActionModeView extends FrameLayout implements Animator.AnimatorListener, i, TextWatcher, View.OnClickListener, MessageQueue.IdleHandler {
    public static final int ANIMATION_DURATION = 400;
    private ActionBarContainer mActionBarContainer;
    private int mActionBarLocation;
    private int mActionBarTopMargin;
    private ActionBarView mActionBarView;
    private WeakReference<View> mAnchorView;
    private boolean mAnimateToVisible;
    private WeakReference<View> mAnimateView;
    private int mAnimateViewTranslationYLength;
    private int mAnimateViewTranslationYStart;
    private boolean mAnimationCanceled;
    private List<miuix.view.a> mAnimationListeners;
    private float mAnimationProgress;
    private int mContentOriginPaddingBottom;
    private int mContentOriginPaddingTop;
    private ObjectAnimator mCurrentAnimation;
    private View mDimView;
    private int mInputPaddingRight;
    private int mInputPaddingTop;
    private EditText mInputView;
    private int mInputViewTranslationYLength;
    private int mInputViewTranslationYStart;
    private int[] mLocation;
    private int mOriginalPaddingTop;
    private boolean mRequestAnimation;
    private WeakReference<View> mResultView;
    private int mResultViewOriginMarginBottom;
    private int mResultViewOriginMarginTop;
    private boolean mResultViewSet;
    private ViewGroup mSearchContainer;
    private int mSearchViewHeight;
    private ActionBarContainer mSplitActionBarContainer;
    private int mStatusBarPaddingTop;
    private TextView mTextCancel;
    private int mTextLengthBeforeChanged;

    class a implements miuix.view.a {
        a() {
        }

        @Override // miuix.view.a
        public final void a(boolean z4) {
            if (z4) {
                SearchActionModeView.this.mActionBarContainer.setVisibility(4);
            } else {
                SearchActionModeView.this.mActionBarContainer.setVisibility(0);
            }
        }

        @Override // miuix.view.a
        public final void f(boolean z4, float f4) {
        }

        @Override // miuix.view.a
        public final void g(boolean z4) {
            View viewH;
            if (!z4 || (viewH = SearchActionModeView.this.getActionBarContainer().h()) == null) {
                return;
            }
            viewH.setVisibility(8);
        }
    }

    class b implements miuix.view.a {

        /* renamed from: i, reason: collision with root package name */
        int f6923i = 0;

        /* renamed from: j, reason: collision with root package name */
        int f6924j = 0;

        b() {
        }

        @Override // miuix.view.a
        public final void a(boolean z4) {
            View contentView = SearchActionModeView.this.getContentView();
            View view = SearchActionModeView.this.mAnchorView != null ? (View) SearchActionModeView.this.mAnchorView.get() : null;
            if (view != null) {
                view.setAlpha(0.0f);
            }
            if (z4) {
                if (contentView != null) {
                    SearchActionModeView.this.mContentOriginPaddingTop = contentView.getPaddingTop();
                    SearchActionModeView.this.mContentOriginPaddingBottom = contentView.getPaddingBottom();
                }
                if (SearchActionModeView.this.mActionBarLocation == Integer.MAX_VALUE) {
                    SearchActionModeView.this.getActionBarContainer().getLocationInWindow(SearchActionModeView.this.mLocation);
                    SearchActionModeView searchActionModeView = SearchActionModeView.this;
                    searchActionModeView.mActionBarLocation = searchActionModeView.mLocation[1];
                }
                SearchActionModeView searchActionModeView2 = SearchActionModeView.this;
                searchActionModeView2.mInputViewTranslationYStart = searchActionModeView2.getActionBarContainer().getHeight();
                SearchActionModeView searchActionModeView3 = SearchActionModeView.this;
                searchActionModeView3.mInputViewTranslationYLength = -searchActionModeView3.mInputViewTranslationYStart;
                if (view != null) {
                    view.getLocationInWindow(SearchActionModeView.this.mLocation);
                    this.f6924j = view.getImportantForAccessibility();
                    view.setImportantForAccessibility(4);
                }
                SearchActionModeView searchActionModeView4 = SearchActionModeView.this;
                searchActionModeView4.mAnimateViewTranslationYStart = (searchActionModeView4.mLocation[1] - SearchActionModeView.this.mActionBarLocation) - SearchActionModeView.this.mContentOriginPaddingTop;
                SearchActionModeView searchActionModeView5 = SearchActionModeView.this;
                searchActionModeView5.mAnimateViewTranslationYLength = searchActionModeView5.mInputViewTranslationYLength;
            } else {
                if (view != null) {
                    view.setImportantForAccessibility(this.f6924j);
                }
                if (SearchActionModeView.this.mDimView != null) {
                    SearchActionModeView.this.mDimView.getVisibility();
                }
                SearchActionModeView searchActionModeView6 = SearchActionModeView.this;
                searchActionModeView6.setContentViewTranslation(searchActionModeView6.mStatusBarPaddingTop);
                SearchActionModeView.this.setContentViewPadding(0, 0);
            }
            View view2 = SearchActionModeView.this.mAnimateView != null ? (View) SearchActionModeView.this.mAnimateView.get() : null;
            View view3 = SearchActionModeView.this.mResultView != null ? (View) SearchActionModeView.this.mResultView.get() : null;
            if (!z4) {
                if (view3 != null) {
                    if (view2 != null) {
                        view2.setImportantForAccessibility(this.f6923i);
                    }
                    view3.setImportantForAccessibility(4);
                    return;
                }
                return;
            }
            if (view3 != null) {
                if (view2 != null) {
                    this.f6923i = view2.getImportantForAccessibility();
                    view2.setImportantForAccessibility(4);
                }
                view3.setImportantForAccessibility(1);
            }
        }

        @Override // miuix.view.a
        public final void f(boolean z4, float f4) {
            if (!z4) {
                f4 = 1.0f - f4;
            }
            View view = SearchActionModeView.this.mAnimateView != null ? (View) SearchActionModeView.this.mAnimateView.get() : null;
            SearchActionModeView.this.setContentViewTranslation((int) (r0.mStatusBarPaddingTop * f4));
            if (view != null) {
                view.setTranslationY((SearchActionModeView.this.mAnimateViewTranslationYLength * f4) + SearchActionModeView.this.mAnimateViewTranslationYStart);
            }
            SearchActionModeView.this.setTranslationY((f4 * SearchActionModeView.this.mInputViewTranslationYLength) + r3.mInputViewTranslationYStart);
        }

        @Override // miuix.view.a
        public final void g(boolean z4) {
            if (!z4) {
                View view = SearchActionModeView.this.mAnimateView != null ? (View) SearchActionModeView.this.mAnimateView.get() : null;
                if (view != null) {
                    view.setTranslationY(0.0f);
                }
            }
            View view2 = SearchActionModeView.this.mAnchorView != null ? (View) SearchActionModeView.this.mAnchorView.get() : null;
            if (view2 != null) {
                view2.setEnabled(!z4);
            }
            if (SearchActionModeView.this.mStatusBarPaddingTop > 0) {
                SearchActionModeView.this.setContentViewTranslation(0);
                SearchActionModeView searchActionModeView = SearchActionModeView.this;
                searchActionModeView.setContentViewPadding(z4 ? searchActionModeView.mStatusBarPaddingTop : 0, 0);
            }
        }
    }

    class c implements miuix.view.a {
        c() {
        }

        @Override // miuix.view.a
        public final void a(boolean z4) {
            if (z4) {
                SearchActionModeView.this.mDimView.setOnClickListener(SearchActionModeView.this);
                SearchActionModeView.this.mDimView.setVisibility(0);
                SearchActionModeView.this.mDimView.setAlpha(0.0f);
            }
        }

        @Override // miuix.view.a
        public final void f(boolean z4, float f4) {
            if (!z4) {
                f4 = 1.0f - f4;
            }
            SearchActionModeView.this.mDimView.setAlpha(f4);
            if (SearchActionModeView.this.shouldAnimateContent()) {
                View view = (View) SearchActionModeView.this.mAnimateView.get();
                SearchActionModeView.this.mDimView.setTranslationY((view != null ? view.getTranslationY() : 0.0f) + (SearchActionModeView.this.mActionBarContainer != null ? SearchActionModeView.this.mContentOriginPaddingTop : 0));
            }
        }

        @Override // miuix.view.a
        public final void g(boolean z4) {
            if (z4) {
                if (SearchActionModeView.this.mInputView.getText().length() > 0) {
                    SearchActionModeView.this.mDimView.setVisibility(8);
                }
            } else {
                SearchActionModeView.this.mDimView.setVisibility(8);
                SearchActionModeView.this.mDimView.setAlpha(1.0f);
                SearchActionModeView.this.mDimView.setTranslationY(0.0f);
            }
        }
    }

    class d implements miuix.view.a {
        d() {
        }

        @Override // miuix.view.a
        public final void a(boolean z4) {
            if (z4) {
                SearchActionModeView.this.mInputView.getText().clear();
                SearchActionModeView.this.mInputView.addTextChangedListener(SearchActionModeView.this);
                SearchActionModeView.this.mTextCancel.setTranslationX(SearchActionModeView.this.mTextCancel.getWidth());
            }
        }

        @Override // miuix.view.a
        public final void f(boolean z4, float f4) {
            if (!z4) {
                f4 = 1.0f - f4;
            }
            SearchActionModeView searchActionModeView = SearchActionModeView.this;
            searchActionModeView.setPadding(searchActionModeView.getPaddingLeft(), (int) ((SearchActionModeView.this.mInputPaddingTop * f4) + (SearchActionModeView.this.mStatusBarPaddingTop * f4) + SearchActionModeView.this.mOriginalPaddingTop), SearchActionModeView.this.getPaddingRight(), SearchActionModeView.this.getPaddingBottom());
            SearchActionModeView.this.getLayoutParams().height = SearchActionModeView.this.mSearchViewHeight + ((int) (SearchActionModeView.this.mStatusBarPaddingTop * f4));
            SearchActionModeView.this.requestLayout();
            int i2 = SearchActionModeView.this.mInputPaddingRight;
            float f5 = 1.0f - f4;
            if (S2.d.i(SearchActionModeView.this.mTextCancel)) {
                f5 = f4 - 1.0f;
            }
            SearchActionModeView.this.mTextCancel.setTranslationX(SearchActionModeView.this.mTextCancel.getWidth() * f5);
            if (SearchActionModeView.this.mSearchContainer.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) SearchActionModeView.this.mSearchContainer.getLayoutParams()).setMarginEnd((int) (((SearchActionModeView.this.mTextCancel.getWidth() - i2) * f4) + i2));
            }
            SearchActionModeView.this.mSearchContainer.requestLayout();
        }

        @Override // miuix.view.a
        public final void g(boolean z4) {
            if (z4) {
                return;
            }
            SearchActionModeView.this.mInputView.removeTextChangedListener(SearchActionModeView.this);
        }
    }

    class e implements miuix.view.a {
        e() {
        }

        @Override // miuix.view.a
        public final void a(boolean z4) {
        }

        @Override // miuix.view.a
        public final void f(boolean z4, float f4) {
            if (!z4) {
                f4 = 1.0f - f4;
            }
            ActionBarContainer splitActionBarContainer = SearchActionModeView.this.getSplitActionBarContainer();
            if (splitActionBarContainer != null) {
                splitActionBarContainer.setTranslationY(f4 * splitActionBarContainer.getHeight());
            }
        }

        @Override // miuix.view.a
        public final void g(boolean z4) {
        }
    }

    public SearchActionModeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLocation = new int[2];
        this.mActionBarLocation = Integer.MAX_VALUE;
        setAlpha(0.0f);
        this.mSearchViewHeight = context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_search_view_default_height);
        this.mInputPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_search_mode_bg_padding_top);
        this.mInputPaddingRight = shouldHideCancelText() ? 0 : context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_search_mode_bg_padding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getContentView() {
        ViewGroup viewGroupN = C0384b.n(this);
        if (viewGroupN != null) {
            return viewGroupN.findViewById(android.R.id.content);
        }
        return null;
    }

    private MessageQueue getMessageQueue() {
        return Looper.myQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAnimationEnd$0() {
        setResultViewMargin(this.mAnimateToVisible);
    }

    private void queueIdleHandler() {
        removeIdleHandler();
        getMessageQueue().addIdleHandler(this);
    }

    private void removeIdleHandler() {
        getMessageQueue().removeIdleHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldAnimateContent() {
        return (this.mAnchorView == null || this.mAnimateView == null) ? false : true;
    }

    private boolean shouldHideCancelText() {
        String language = Locale.getDefault().getLanguage();
        return ("zh".equalsIgnoreCase(language) || "en".equalsIgnoreCase(language)) ? false : true;
    }

    @Override // miuix.appcompat.internal.app.widget.i
    public void addAnimationListener(miuix.view.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.mAnimationListeners == null) {
            this.mAnimationListeners = new ArrayList();
        }
        this.mAnimationListeners.add(aVar);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        View view;
        if ((editable == null ? 0 : editable.length()) == 0) {
            View view2 = this.mDimView;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            K3.a.a(getContext()).c(this.mInputView);
            return;
        }
        if (this.mTextLengthBeforeChanged != 0 || (view = this.mDimView) == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // miuix.appcompat.internal.app.widget.i
    public void animateToVisibility(boolean z4) {
        if (this.mAnimateToVisible == z4) {
            this.mRequestAnimation = false;
            return;
        }
        pollViews();
        this.mAnimateToVisible = z4;
        this.mCurrentAnimation = makeAnimation();
        createAnimationListeners();
        if (z4) {
            setOverlayMode(true);
        }
        notifyAnimationStart(z4);
        if (shouldAnimateContent()) {
            requestLayout();
            this.mRequestAnimation = true;
        } else {
            this.mCurrentAnimation.start();
        }
        if (this.mAnimateToVisible) {
            return;
        }
        this.mInputView.clearFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mInputView.getWindowToken(), 0);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        this.mTextLengthBeforeChanged = charSequence == null ? 0 : charSequence.length();
    }

    @Override // miuix.appcompat.internal.app.widget.i
    public void closeMode() {
        ObjectAnimator objectAnimator = this.mCurrentAnimation;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    protected void createAnimationListeners() {
        if (this.mAnimationListeners == null) {
            this.mAnimationListeners = new ArrayList();
        }
        this.mAnimationListeners.add(new d());
        if (shouldAnimateContent()) {
            this.mAnimationListeners.add(new b());
            this.mAnimationListeners.add(new a());
            this.mAnimationListeners.add(new e());
        }
        if (getDimView() != null) {
            this.mAnimationListeners.add(new c());
        }
    }

    protected void finishAnimation() {
        ObjectAnimator objectAnimator = this.mCurrentAnimation;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.mCurrentAnimation = null;
        }
    }

    protected ActionBarContainer getActionBarContainer() {
        if (this.mActionBarContainer == null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) C0384b.n(this);
            if (actionBarOverlayLayout != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= actionBarOverlayLayout.getChildCount()) {
                        break;
                    }
                    View childAt = actionBarOverlayLayout.getChildAt(i2);
                    if (childAt.getId() == R.id.action_bar_container && (childAt instanceof ActionBarContainer)) {
                        this.mActionBarContainer = (ActionBarContainer) childAt;
                        break;
                    }
                    i2++;
                }
            }
            ActionBarContainer actionBarContainer = this.mActionBarContainer;
            if (actionBarContainer != null) {
                int i4 = ((ViewGroup.MarginLayoutParams) actionBarContainer.getLayoutParams()).topMargin;
                this.mActionBarTopMargin = i4;
                if (i4 > 0) {
                    setPadding(getPaddingLeft(), this.mOriginalPaddingTop + this.mActionBarTopMargin, getPaddingRight(), getPaddingBottom());
                }
            }
        }
        return this.mActionBarContainer;
    }

    protected ActionBarView getActionBarView() {
        ViewGroup viewGroupN;
        if (this.mActionBarView == null && (viewGroupN = C0384b.n(this)) != null) {
            this.mActionBarView = (ActionBarView) viewGroupN.findViewById(R.id.action_bar);
        }
        return this.mActionBarView;
    }

    public float getAnimationProgress() {
        return this.mAnimationProgress;
    }

    protected View getDimView() {
        ViewGroup viewGroupN;
        if (this.mDimView == null && (viewGroupN = C0384b.n(this)) != null) {
            ViewStub viewStub = (ViewStub) viewGroupN.findViewById(R.id.search_mask_vs);
            if (viewStub != null) {
                this.mDimView = viewStub.inflate();
            } else {
                this.mDimView = viewGroupN.findViewById(R.id.search_mask);
            }
        }
        return this.mDimView;
    }

    public EditText getSearchInput() {
        return this.mInputView;
    }

    protected ActionBarContainer getSplitActionBarContainer() {
        ViewGroup viewGroupN;
        if (this.mSplitActionBarContainer == null && (viewGroupN = C0384b.n(this)) != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= viewGroupN.getChildCount()) {
                    break;
                }
                View childAt = viewGroupN.getChildAt(i2);
                if (childAt.getId() == R.id.split_action_bar && (childAt instanceof ActionBarContainer)) {
                    this.mSplitActionBarContainer = (ActionBarContainer) childAt;
                    break;
                }
                i2++;
            }
        }
        return this.mSplitActionBarContainer;
    }

    @Override // miuix.appcompat.internal.app.widget.i
    public void initForMode(ActionMode actionMode) {
    }

    @Override // miuix.appcompat.internal.app.widget.i
    public void killMode() {
        finishAnimation();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.mActionBarContainer = null;
        this.mActionBarView = null;
        List<miuix.view.a> list = this.mAnimationListeners;
        if (list != null) {
            list.clear();
            this.mAnimationListeners = null;
        }
        this.mSplitActionBarContainer = null;
    }

    protected ObjectAnimator makeAnimation() {
        ObjectAnimator objectAnimator = this.mCurrentAnimation;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.mCurrentAnimation = null;
            removeIdleHandler();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "AnimationProgress", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(this);
        int i2 = C0432b.f8169a;
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfFloat.setInterpolator(obtainInterpolator());
        return objectAnimatorOfFloat;
    }

    public void notifyAnimationEnd(boolean z4) {
        List<miuix.view.a> list = this.mAnimationListeners;
        if (list == null) {
            return;
        }
        Iterator<miuix.view.a> it = list.iterator();
        while (it.hasNext()) {
            it.next().g(z4);
        }
    }

    public void notifyAnimationStart(boolean z4) {
        List<miuix.view.a> list = this.mAnimationListeners;
        if (list == null) {
            return;
        }
        Iterator<miuix.view.a> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(z4);
        }
    }

    public void notifyAnimationUpdate(boolean z4, float f4) {
        List<miuix.view.a> list = this.mAnimationListeners;
        if (list == null) {
            return;
        }
        Iterator<miuix.view.a> it = list.iterator();
        while (it.hasNext()) {
            it.next().f(z4, f4);
        }
    }

    public TimeInterpolator obtainInterpolator() {
        return new DecelerateInterpolator(2.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.mAnimationCanceled = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.mAnimationCanceled) {
            return;
        }
        this.mCurrentAnimation = null;
        notifyAnimationEnd(this.mAnimateToVisible);
        if (this.mAnimateToVisible) {
            K3.a.a(getContext()).c(this.mInputView);
        } else {
            K3.a.a(getContext()).b(this.mInputView);
        }
        if (Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
            setResultViewMargin(this.mAnimateToVisible);
        } else {
            post(new RunnableC0359b(this, 3));
        }
        setContentViewTranslation(0);
        setContentViewPadding(this.mAnimateToVisible ? this.mStatusBarPaddingTop : 0, 0);
        if (this.mAnimateToVisible) {
            return;
        }
        setOverlayMode(false);
        WeakReference<View> weakReference = this.mAnchorView;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        setAlpha(0.0f);
        killMode();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.mAnimationCanceled = false;
        if (this.mAnimateToVisible) {
            setAlpha(1.0f);
            return;
        }
        View viewH = getActionBarContainer().h();
        if (viewH != null) {
            viewH.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.search_mask) {
            this.mTextCancel.performClick();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mTextCancel = (TextView) findViewById(R.id.search_text_cancel);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.search_container);
        this.mSearchContainer = viewGroup;
        viewGroup.setForceDarkAllowed(false);
        if (shouldHideCancelText()) {
            this.mTextCancel.setVisibility(8);
            int iMax = Math.max(getPaddingStart(), getPaddingEnd());
            setPaddingRelative(iMax, getPaddingTop(), iMax, getPaddingBottom());
        }
        this.mInputView = (EditText) findViewById(android.R.id.input);
        this.mOriginalPaddingTop = getPaddingTop();
        View contentView = getContentView();
        if (contentView != null) {
            this.mContentOriginPaddingTop = contentView.getPaddingTop();
            this.mContentOriginPaddingBottom = contentView.getPaddingBottom();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        if (this.mRequestAnimation) {
            WeakReference<View> weakReference = this.mAnimateView;
            View view = weakReference != null ? weakReference.get() : null;
            if (this.mAnimateToVisible && shouldAnimateContent() && view != null) {
                view.setTranslationY(this.mAnimateViewTranslationYStart);
            }
            queueIdleHandler();
            this.mRequestAnimation = false;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    protected void pollViews() {
        getActionBarView();
        getActionBarContainer();
        getSplitActionBarContainer();
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        this.mCurrentAnimation.start();
        return false;
    }

    public void rePaddingAndRelayout(Rect rect) {
        int i2 = this.mStatusBarPaddingTop;
        int i4 = rect.top;
        if (i2 != i4) {
            setStatusBarPaddingTop(i4);
            setPadding(getPaddingLeft(), this.mOriginalPaddingTop + this.mStatusBarPaddingTop + this.mInputPaddingTop, getPaddingRight(), getPaddingBottom());
            getLayoutParams().height = this.mSearchViewHeight + this.mStatusBarPaddingTop;
            requestLayout();
        }
    }

    public void removeAnimationListener(miuix.view.a aVar) {
        List<miuix.view.a> list;
        if (aVar == null || (list = this.mAnimationListeners) == null) {
            return;
        }
        list.remove(aVar);
    }

    public void setAnchorView(View view) {
        if (view != null) {
            this.mAnchorView = new WeakReference<>(view);
        }
    }

    public void setAnimateView(View view) {
        if (view != null) {
            this.mAnimateView = new WeakReference<>(view);
        }
    }

    public void setAnimationProgress(float f4) {
        this.mAnimationProgress = f4;
        notifyAnimationUpdate(this.mAnimateToVisible, f4);
    }

    protected void setContentViewPadding(int i2, int i4) {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setPadding(contentView.getPaddingLeft(), i2 + this.mContentOriginPaddingTop, contentView.getPaddingRight(), i4 + this.mContentOriginPaddingBottom);
        }
    }

    protected void setContentViewTranslation(int i2) {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setTranslationY(i2);
        }
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.mTextCancel.setOnClickListener(onClickListener);
    }

    protected void setOverlayMode(boolean z4) {
        ((ActionBarOverlayLayout) C0384b.n(this)).z(z4);
    }

    public void setResultView(View view) {
        if (view != null) {
            this.mResultView = new WeakReference<>(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.mResultViewOriginMarginTop = marginLayoutParams.topMargin;
                this.mResultViewOriginMarginBottom = marginLayoutParams.bottomMargin;
                this.mResultViewSet = true;
            }
        }
    }

    protected void setResultViewMargin(boolean z4) {
        int measuredHeight;
        int i2;
        WeakReference<View> weakReference = this.mResultView;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || !this.mResultViewSet) {
            return;
        }
        if (z4) {
            measuredHeight = (getMeasuredHeight() - this.mStatusBarPaddingTop) - this.mActionBarTopMargin;
            i2 = 0;
        } else {
            measuredHeight = this.mResultViewOriginMarginTop;
            i2 = this.mResultViewOriginMarginBottom;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = measuredHeight;
        marginLayoutParams.bottomMargin = i2;
        view.setLayoutParams(marginLayoutParams);
    }

    public void setStatusBarPaddingTop(int i2) {
        this.mStatusBarPaddingTop = i2;
    }
}
