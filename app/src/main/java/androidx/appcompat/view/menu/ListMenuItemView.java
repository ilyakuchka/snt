package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.U;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements m.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: i, reason: collision with root package name */
    private h f2469i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f2470j;

    /* renamed from: k, reason: collision with root package name */
    private RadioButton f2471k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f2472l;

    /* renamed from: m, reason: collision with root package name */
    private CheckBox f2473m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f2474n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f2475o;
    private ImageView p;

    /* renamed from: q, reason: collision with root package name */
    private LinearLayout f2476q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f2477r;

    /* renamed from: s, reason: collision with root package name */
    private int f2478s;

    /* renamed from: t, reason: collision with root package name */
    private Context f2479t;
    private boolean u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f2480v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f2481w;

    /* renamed from: x, reason: collision with root package name */
    private LayoutInflater f2482x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f2483y;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        U u = U.u(getContext(), attributeSet, Y1.a.f2127v, R.attr.listMenuViewStyle, 0);
        this.f2477r = u.f(5);
        this.f2478s = u.m(1, -1);
        this.u = u.a(7, false);
        this.f2479t = context;
        this.f2480v = u.f(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f2481w = typedArrayObtainStyledAttributes.hasValue(0);
        u.v();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater a() {
        if (this.f2482x == null) {
            this.f2482x = LayoutInflater.from(getContext());
        }
        return this.f2482x;
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.p;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
        rect.top = this.p.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0  */
    @Override // androidx.appcompat.view.menu.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(h hVar) {
        CompoundButton compoundButton;
        View view;
        int i2;
        ImageView imageView;
        this.f2469i = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        CharSequence charSequenceH = hVar.h(this);
        if (charSequenceH != null) {
            this.f2472l.setText(charSequenceH);
            if (this.f2472l.getVisibility() != 0) {
                this.f2472l.setVisibility(0);
            }
        } else if (this.f2472l.getVisibility() != 8) {
            this.f2472l.setVisibility(8);
        }
        boolean zIsCheckable = hVar.isCheckable();
        if (zIsCheckable || this.f2471k != null || this.f2473m != null) {
            if (this.f2469i.l()) {
                if (this.f2471k == null) {
                    RadioButton radioButton = (RadioButton) a().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                    this.f2471k = radioButton;
                    LinearLayout linearLayout = this.f2476q;
                    if (linearLayout != null) {
                        linearLayout.addView(radioButton, -1);
                    } else {
                        addView(radioButton, -1);
                    }
                }
                compoundButton = this.f2471k;
                view = this.f2473m;
            } else {
                if (this.f2473m == null) {
                    CheckBox checkBox = (CheckBox) a().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                    this.f2473m = checkBox;
                    LinearLayout linearLayout2 = this.f2476q;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(checkBox, -1);
                    } else {
                        addView(checkBox, -1);
                    }
                }
                compoundButton = this.f2473m;
                view = this.f2471k;
            }
            if (zIsCheckable) {
                compoundButton.setChecked(this.f2469i.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                }
            } else {
                CheckBox checkBox2 = this.f2473m;
                if (checkBox2 != null) {
                    checkBox2.setVisibility(8);
                }
                RadioButton radioButton2 = this.f2471k;
                if (radioButton2 != null) {
                    radioButton2.setVisibility(8);
                }
            }
        }
        boolean z4 = hVar.f2580n.u() && hVar.f() != 0;
        hVar.f();
        if (z4) {
            h hVar2 = this.f2469i;
            i2 = hVar2.f2580n.u() && hVar2.f() != 0 ? 0 : 8;
        }
        if (i2 == 0) {
            this.f2474n.setText(this.f2469i.g());
        }
        if (this.f2474n.getVisibility() != i2) {
            this.f2474n.setVisibility(i2);
        }
        Drawable icon = hVar.getIcon();
        Objects.requireNonNull(this.f2469i.f2580n);
        boolean z5 = this.f2483y;
        if ((z5 || this.u) && ((imageView = this.f2470j) != null || icon != null || this.u)) {
            if (imageView == null) {
                ImageView imageView2 = (ImageView) a().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f2470j = imageView2;
                LinearLayout linearLayout3 = this.f2476q;
                if (linearLayout3 != null) {
                    linearLayout3.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (icon != null || this.u) {
                ImageView imageView3 = this.f2470j;
                if (!z5) {
                    icon = null;
                }
                imageView3.setImageDrawable(icon);
                if (this.f2470j.getVisibility() != 0) {
                    this.f2470j.setVisibility(0);
                }
            } else {
                this.f2470j.setVisibility(8);
            }
        }
        setEnabled(hVar.isEnabled());
        boolean zHasSubMenu = hVar.hasSubMenu();
        ImageView imageView4 = this.f2475o;
        if (imageView4 != null) {
            imageView4.setVisibility(zHasSubMenu ? 0 : 8);
        }
        setContentDescription(hVar.getContentDescription());
    }

    public final void c() {
        this.f2483y = true;
        this.u = true;
    }

    public final void d(boolean z4) {
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setVisibility((this.f2481w || !z4) ? 8 : 0);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public final h getItemData() {
        return this.f2469i;
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        Drawable drawable = this.f2477r;
        int i2 = androidx.core.view.o.d;
        setBackground(drawable);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f2472l = textView;
        int i4 = this.f2478s;
        if (i4 != -1) {
            textView.setTextAppearance(this.f2479t, i4);
        }
        this.f2474n = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f2475o = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f2480v);
        }
        this.p = (ImageView) findViewById(R.id.group_divider);
        this.f2476q = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        if (this.f2470j != null && this.u) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2470j.getLayoutParams();
            int i5 = layoutParams.height;
            if (i5 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i5;
            }
        }
        super.onMeasure(i2, i4);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public final boolean prefersCondensedTitle() {
        return false;
    }
}
