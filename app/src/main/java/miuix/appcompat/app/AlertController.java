package miuix.appcompat.app;

import F.b;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.app.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import miuix.appcompat.app.g;
import miuix.appcompat.internal.widget.DialogButtonPanel;
import miuix.appcompat.internal.widget.DialogParentPanel2;
import miuix.appcompat.internal.widget.DialogRootView;
import miuix.appcompat.internal.widget.NestedScrollViewExpander;
import miuix.internal.widget.GroupButton;
import miuix.view.HapticCompat;
import s3.C0381a;
import w3.C0411d;
import z3.C0431a;
import z3.C0432b;

/* loaded from: classes.dex */
final class AlertController {

    /* renamed from: A, reason: collision with root package name */
    private TextView f6622A;

    /* renamed from: B, reason: collision with root package name */
    private TextView f6623B;

    /* renamed from: C, reason: collision with root package name */
    private View f6624C;

    /* renamed from: D, reason: collision with root package name */
    ListAdapter f6625D;

    /* renamed from: F, reason: collision with root package name */
    private final int f6627F;

    /* renamed from: G, reason: collision with root package name */
    int f6628G;

    /* renamed from: H, reason: collision with root package name */
    int f6629H;

    /* renamed from: I, reason: collision with root package name */
    int f6630I;

    /* renamed from: J, reason: collision with root package name */
    int f6631J;

    /* renamed from: K, reason: collision with root package name */
    private final boolean f6632K;
    Handler L;
    private DialogRootView M;

    /* renamed from: N, reason: collision with root package name */
    private DialogParentPanel2 f6633N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f6634O;
    boolean P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f6635Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f6636R;

    /* renamed from: S, reason: collision with root package name */
    private int f6637S;

    /* renamed from: T, reason: collision with root package name */
    private int f6638T;

    /* renamed from: U, reason: collision with root package name */
    private WindowManager f6639U;

    /* renamed from: X, reason: collision with root package name */
    private CharSequence f6642X;

    /* renamed from: Y, reason: collision with root package name */
    private final Thread f6643Y;

    /* renamed from: Z, reason: collision with root package name */
    private boolean f6644Z;

    /* renamed from: a, reason: collision with root package name */
    private final Context f6645a;

    /* renamed from: b, reason: collision with root package name */
    final o f6647b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f6648c;
    private CharSequence d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f6649e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f6650f;
    ListView g;

    /* renamed from: h, reason: collision with root package name */
    private View f6651h;

    /* renamed from: i, reason: collision with root package name */
    private int f6652i;

    /* renamed from: j, reason: collision with root package name */
    private View f6653j;

    /* renamed from: k, reason: collision with root package name */
    private int f6654k;

    /* renamed from: l, reason: collision with root package name */
    private final int f6655l;

    /* renamed from: m, reason: collision with root package name */
    private final int f6656m;

    /* renamed from: n, reason: collision with root package name */
    Button f6657n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f6658o;
    Message p;

    /* renamed from: q, reason: collision with root package name */
    Button f6659q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f6660r;

    /* renamed from: s, reason: collision with root package name */
    Message f6661s;

    /* renamed from: t, reason: collision with root package name */
    Button f6662t;
    private CharSequence u;

    /* renamed from: v, reason: collision with root package name */
    Message f6663v;

    /* renamed from: w, reason: collision with root package name */
    private List<ButtonInfo> f6664w;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f6666y;

    /* renamed from: z, reason: collision with root package name */
    private TextView f6667z;

    /* renamed from: x, reason: collision with root package name */
    private int f6665x = 0;

    /* renamed from: E, reason: collision with root package name */
    int f6626E = -1;

    /* renamed from: V, reason: collision with root package name */
    private Point f6640V = new Point();

    /* renamed from: W, reason: collision with root package name */
    private Point f6641W = new Point();

    /* renamed from: a0, reason: collision with root package name */
    private final View.OnClickListener f6646a0 = new View.OnClickListener() { // from class: miuix.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2 = miuix.view.c.d;
            AlertController alertController = AlertController.this;
            if (view == alertController.f6657n) {
                Message message = alertController.p;
                messageObtain = message != null ? Message.obtain(message) : null;
                i2 = miuix.view.c.f7455c;
            } else if (view == alertController.f6659q) {
                Message message2 = alertController.f6661s;
                if (message2 != null) {
                    messageObtain = Message.obtain(message2);
                }
            } else if (view == alertController.f6662t) {
                Message message3 = alertController.f6663v;
                if (message3 != null) {
                    messageObtain = Message.obtain(message3);
                }
            } else {
                if (alertController.f6664w != null && !AlertController.this.f6664w.isEmpty()) {
                    Iterator it = AlertController.this.f6664w.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ButtonInfo buttonInfo = (ButtonInfo) it.next();
                        if (view == buttonInfo.mButton) {
                            messageObtain = buttonInfo.mMsg;
                            break;
                        }
                    }
                }
                if ((view instanceof GroupButton) && ((GroupButton) view).a()) {
                    i2 = miuix.view.c.f7455c;
                }
            }
            HapticCompat.performHapticFeedbackAsync(view, i2);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController.this.L.sendEmptyMessage(-1651327837);
        }
    };

    /* renamed from: miuix.appcompat.app.AlertController$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$miuix$appcompat$app$AlertController$AlertParams$ItemType;

        static {
            int[] iArr = new int[AlertParams.ItemType.values().length];
            $SwitchMap$miuix$appcompat$app$AlertController$AlertParams$ItemType = iArr;
            try {
                iArr[AlertParams.ItemType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$miuix$appcompat$app$AlertController$AlertParams$ItemType[AlertParams.ItemType.CHOICE_SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$miuix$appcompat$app$AlertController$AlertParams$ItemType[AlertParams.ItemType.CHOICE_MULTI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static class AlertParams {
        ListAdapter mAdapter;
        CharSequence mCheckBoxMessage;
        boolean[] mCheckedItems;
        CharSequence mComment;
        final Context mContext;
        Cursor mCursor;
        View mCustomTitleView;
        boolean mHapticFeedbackEnabled;
        Drawable mIcon;
        final LayoutInflater mInflater;
        boolean mIsChecked;
        String mIsCheckedColumn;
        boolean mIsMultiChoice;
        boolean mIsSingleChoice;
        CharSequence[] mItems;
        a mItemsProvider;
        String mLabelColumn;
        CharSequence mMessage;
        DialogInterface.OnClickListener mNegativeButtonListener;
        CharSequence mNegativeButtonText;
        DialogInterface.OnClickListener mNeutralButtonListener;
        CharSequence mNeutralButtonText;
        DialogInterface.OnCancelListener mOnCancelListener;
        DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        DialogInterface.OnClickListener mOnClickListener;
        g.b mOnDialogShowAnimListener;
        DialogInterface.OnDismissListener mOnDismissListener;
        AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        DialogInterface.OnKeyListener mOnKeyListener;
        OnPrepareListViewListener mOnPrepareListViewListener;
        DialogInterface.OnShowListener mOnShowListener;
        DialogInterface.OnClickListener mPositiveButtonListener;
        CharSequence mPositiveButtonText;
        boolean mPreferLandscape;
        CharSequence mTitle;
        View mView;
        int mViewLayoutResId;
        int mIconId = 0;
        int mIconAttrId = 0;
        int mCheckedItem = -1;
        boolean mCancelable = true;
        List<ButtonInfo> mExtraButtonList = new ArrayList();

        private enum ItemType {
            DEFAULT,
            CHOICE_SINGLE,
            CHOICE_MULTI
        }

        interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        AlertParams(Context context) {
            this.mContext = context;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void createListView(final AlertController alertController) {
            int i2;
            ItemType itemType;
            ListAdapter listAdapter;
            final ListView listView = (ListView) this.mInflater.inflate(alertController.f6628G, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                listAdapter = this.mCursor == null ? new ArrayAdapter<CharSequence>(this.mContext, alertController.f6629H, R.id.text1, this.mItems) { // from class: miuix.appcompat.app.AlertController.AlertParams.2
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i4, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i4, view, viewGroup);
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null && zArr[i4]) {
                            listView.setItemChecked(i4, true);
                        }
                        view2.setForceDarkAllowed(false);
                        C0381a.a((TextView) view2.findViewById(R.id.text1));
                        AlertParams.setAccessibilityDelegate(view2, ItemType.CHOICE_MULTI, AlertParams.this.mItemsProvider);
                        return view2;
                    }
                } : new CursorAdapter(this.mContext, this.mCursor, false) { // from class: miuix.appcompat.app.AlertController.AlertParams.3
                    private final int mIsCheckedIndex;
                    private final int mLabelIndex;

                    {
                        Cursor cursor = getCursor();
                        this.mLabelIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                        this.mIsCheckedIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                    }

                    @Override // android.widget.CursorAdapter
                    public void bindView(View view, Context context, Cursor cursor) {
                        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.text1);
                        checkedTextView.setText(cursor.getString(this.mLabelIndex));
                        listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.mIsCheckedIndex) == 1);
                        C0381a.a(checkedTextView);
                        AlertParams.setAccessibilityDelegate(view, ItemType.CHOICE_MULTI, AlertParams.this.mItemsProvider);
                    }

                    @Override // android.widget.CursorAdapter
                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        View viewInflate = AlertParams.this.mInflater.inflate(alertController.f6629H, viewGroup, false);
                        viewInflate.setForceDarkAllowed(false);
                        return viewInflate;
                    }
                };
            } else {
                if (this.mIsSingleChoice) {
                    i2 = alertController.f6630I;
                    itemType = ItemType.CHOICE_SINGLE;
                } else {
                    i2 = alertController.f6631J;
                    itemType = ItemType.DEFAULT;
                }
                int i4 = i2;
                final ItemType itemType2 = itemType;
                if (this.mCursor != null) {
                    listAdapter = new SimpleCursorAdapter(this.mContext, i4, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1}) { // from class: miuix.appcompat.app.AlertController.AlertParams.4
                        @Override // android.widget.CursorAdapter, android.widget.Adapter
                        public View getView(int i5, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i5, view, viewGroup);
                            C0381a.a((TextView) view2.findViewById(R.id.text1));
                            AlertParams.setAccessibilityDelegate(view2, itemType2, AlertParams.this.mItemsProvider);
                            return view2;
                        }
                    };
                } else {
                    ListAdapter listAdapter2 = this.mAdapter;
                    ListAdapter listAdapter3 = listAdapter2;
                    if (listAdapter2 == null) {
                        CheckedItemAdapter checkedItemAdapter = new CheckedItemAdapter(this.mContext, i4, R.id.text1, this.mItems);
                        checkedItemAdapter.setItemsProvider(this.mItemsProvider);
                        checkedItemAdapter.setItemType(itemType2);
                        listAdapter3 = checkedItemAdapter;
                    }
                    listAdapter = listAdapter3;
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(listView);
            }
            alertController.f6625D = listAdapter;
            alertController.f6626E = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: miuix.appcompat.app.AlertController.AlertParams.5
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j2) {
                        AlertParams.this.mOnClickListener.onClick(alertController.f6647b, i5);
                        if (AlertParams.this.mIsSingleChoice) {
                            return;
                        }
                        alertController.f6647b.dismiss();
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: miuix.appcompat.app.AlertController.AlertParams.6
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j2) {
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null) {
                            zArr[i5] = listView.isItemChecked(i5);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController.f6647b, i5, listView.isItemChecked(i5));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                listView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                listView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                listView.setChoiceMode(2);
            }
            alertController.g = listView;
        }

        private static androidx.core.view.a getDefaultAccessibilityDelegateCompat(final ItemType itemType) {
            return new androidx.core.view.a() { // from class: miuix.appcompat.app.AlertController.AlertParams.1
                @Override // androidx.core.view.a
                public void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
                    super.onInitializeAccessibilityNodeInfo(view, bVar);
                    int i2 = AnonymousClass2.$SwitchMap$miuix$appcompat$app$AlertController$AlertParams$ItemType[itemType.ordinal()];
                    if (i2 == 1) {
                        bVar.a(16);
                        return;
                    }
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return;
                        }
                        bVar.E(CheckBox.class.getName());
                        bVar.a(16);
                        return;
                    }
                    bVar.C(true);
                    bVar.E(RadioButton.class.getName());
                    if (view instanceof miuix.androidbasewidget.widget.CheckedTextView) {
                        boolean zIsChecked = ((miuix.androidbasewidget.widget.CheckedTextView) view).isChecked();
                        bVar.D(zIsChecked);
                        bVar.F(!zIsChecked);
                        if (zIsChecked) {
                            bVar.y(b.a.d);
                        }
                    }
                }
            };
        }

        static void setAccessibilityDelegate(View view, ItemType itemType, a aVar) {
            androidx.core.view.a defaultAccessibilityDelegateCompat;
            if (aVar != null) {
                defaultAccessibilityDelegateCompat = aVar.a();
            } else {
                Log.i("AlertController", "type=" + itemType);
                defaultAccessibilityDelegateCompat = getDefaultAccessibilityDelegateCompat(itemType);
            }
            if (defaultAccessibilityDelegateCompat != null) {
                androidx.core.view.o.j(view, defaultAccessibilityDelegateCompat);
            }
        }

        void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i2 = this.mIconId;
                if (i2 != 0) {
                    alertController.m(i2);
                }
                int i4 = this.mIconAttrId;
                if (i4 != 0) {
                    alertController.m(alertController.f(i4));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.mComment;
            if (charSequence3 != null) {
                alertController.k(charSequence3);
            }
            CharSequence charSequence4 = this.mPositiveButtonText;
            if (charSequence4 != null) {
                alertController.i(-1, charSequence4, this.mPositiveButtonListener);
            }
            CharSequence charSequence5 = this.mNegativeButtonText;
            if (charSequence5 != null) {
                alertController.i(-2, charSequence5, this.mNegativeButtonListener);
            }
            CharSequence charSequence6 = this.mNeutralButtonText;
            if (charSequence6 != null) {
                alertController.i(-3, charSequence6, this.mNeutralButtonListener);
            }
            if (this.mExtraButtonList != null) {
                alertController.f6664w = new ArrayList(this.mExtraButtonList);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                createListView(alertController);
            }
            View view2 = this.mView;
            if (view2 != null) {
                alertController.s(view2);
            } else {
                int i5 = this.mViewLayoutResId;
                if (i5 != 0) {
                    alertController.r(i5);
                }
            }
            CharSequence charSequence7 = this.mCheckBoxMessage;
            if (charSequence7 != null) {
                alertController.j(this.mIsChecked, charSequence7);
            }
            alertController.P = this.mHapticFeedbackEnabled;
            alertController.p(this.mPreferLandscape);
        }
    }

    private static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = -1651327837;
        private final WeakReference<DialogInterface> mDialog;

        ButtonHandler(DialogInterface dialogInterface) {
            this.mDialog = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DialogInterface dialogInterface = this.mDialog.get();
            int i2 = message.what;
            if (i2 != MSG_DISMISS_DIALOG) {
                ((DialogInterface.OnClickListener) message.obj).onClick(dialogInterface, i2);
            } else if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        private a mItemsProvider;
        private AlertParams.ItemType mType;

        public CheckedItemAdapter(Context context, int i2, int i4, CharSequence[] charSequenceArr) {
            super(context, i2, i4, charSequenceArr);
            this.mType = AlertParams.ItemType.DEFAULT;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i2, view, viewGroup);
            C0381a.a((TextView) view2.findViewById(R.id.text1));
            AlertParams.setAccessibilityDelegate(view2, this.mType, this.mItemsProvider);
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public void setItemType(AlertParams.ItemType itemType) {
            this.mType = itemType;
        }

        public void setItemsProvider(a aVar) {
            this.mItemsProvider = aVar;
        }
    }

    public AlertController(Context context, o oVar, Window window) {
        this.f6645a = context;
        this.f6647b = oVar;
        this.f6648c = window;
        this.L = new ButtonHandler(oVar);
        this.f6639U = (WindowManager) context.getSystemService("window");
        w();
        this.f6638T = context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.fake_landscape_screen_minor_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, Y1.a.f2101V, R.attr.alertDialogStyle, 0);
        this.f6627F = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f6628G = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        this.f6629H = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.f6630I = typedArrayObtainStyledAttributes.getResourceId(10, 0);
        this.f6631J = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f6632K = typedArrayObtainStyledAttributes.getBoolean(9, true);
        typedArrayObtainStyledAttributes.recycle();
        oVar.a().v(1);
        this.f6635Q = context.getResources().getBoolean(com.android.mmt.R.bool.treat_as_land);
        this.f6655l = context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_dialog_max_width);
        this.f6656m = context.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_dialog_max_width_land);
        this.f6643Y = Thread.currentThread();
    }

    public static void a(AlertController alertController) {
        if (!(alertController.f6643Y == Thread.currentThread())) {
            StringBuilder sbD = D2.e.d("dialog is created in thread:");
            sbD.append(alertController.f6643Y);
            sbD.append(", but onConfigurationChanged is called from different thread:");
            sbD.append(Thread.currentThread());
            sbD.append(", so this onConfigurationChanged call should be ignore");
            Log.w("AlertController", sbD.toString());
            return;
        }
        if (alertController.f6648c.getDecorView().isAttachedToWindow()) {
            alertController.f6635Q = alertController.f6645a.getApplicationContext().getResources().getBoolean(com.android.mmt.R.bool.treat_as_land);
            alertController.f6638T = alertController.f6645a.getApplicationContext().getResources().getDimensionPixelSize(com.android.mmt.R.dimen.fake_landscape_screen_minor_size);
            alertController.w();
            alertController.u();
            alertController.t(false);
        }
    }

    static boolean d(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (d(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void t(boolean z4) {
        ListAdapter listAdapter;
        int i2;
        boolean z5;
        CharSequence charSequence;
        if (z4 || this.f6644Z) {
            ViewGroup viewGroup = (ViewGroup) this.f6633N.findViewById(com.android.mmt.R.id.topPanel);
            ViewGroup viewGroup2 = (ViewGroup) this.f6633N.findViewById(com.android.mmt.R.id.contentPanel);
            ViewGroup viewGroup3 = (ViewGroup) this.f6633N.findViewById(com.android.mmt.R.id.buttonPanel);
            if (viewGroup2 != null) {
                FrameLayout frameLayout = (FrameLayout) viewGroup2.findViewById(R.id.custom);
                if (this.g != null) {
                    viewGroup2.removeView(viewGroup2.findViewById(com.android.mmt.R.id.contentView));
                    viewGroup2.removeView(frameLayout);
                    if (this.g.getParent() != null) {
                        ((ViewGroup) this.g.getParent()).removeView(this.g);
                    }
                    this.g.setMinimumHeight(C0431a.d(this.f6645a, com.android.mmt.R.attr.dialogListPreferredItemHeight));
                    ListView listView = this.g;
                    int i4 = androidx.core.view.o.d;
                    listView.setNestedScrollingEnabled(true);
                    viewGroup2.addView(this.g, 0, new ViewGroup.MarginLayoutParams(-1, -2));
                    ((NestedScrollViewExpander) viewGroup2).a(this.g);
                } else {
                    ViewGroup viewGroup4 = (ViewGroup) viewGroup2.findViewById(com.android.mmt.R.id.contentView);
                    if (viewGroup4 != null) {
                        this.f6622A = (TextView) viewGroup4.findViewById(com.android.mmt.R.id.message);
                        this.f6623B = (TextView) viewGroup4.findViewById(com.android.mmt.R.id.comment);
                        TextView textView = this.f6622A;
                        if (textView == null || (charSequence = this.f6649e) == null) {
                            ((ViewGroup) viewGroup4.getParent()).removeView(viewGroup4);
                        } else {
                            textView.setText(charSequence);
                            TextView textView2 = this.f6623B;
                            if (textView2 != null) {
                                CharSequence charSequence2 = this.f6650f;
                                if (charSequence2 != null) {
                                    textView2.setText(charSequence2);
                                } else {
                                    textView2.setVisibility(8);
                                }
                            }
                        }
                    }
                    if (frameLayout != null) {
                        View view = this.f6653j;
                        if (view != null && view.getParent() != null) {
                            ((ViewGroup) this.f6653j.getParent()).removeView(this.f6653j);
                            this.f6653j = null;
                        }
                        View viewInflate = this.f6651h;
                        if (viewInflate == null) {
                            if (this.f6652i != 0) {
                                viewInflate = LayoutInflater.from(this.f6645a).inflate(this.f6652i, (ViewGroup) frameLayout, false);
                                this.f6653j = viewInflate;
                            } else {
                                viewInflate = null;
                            }
                        }
                        z5 = viewInflate != null;
                        if (!z5 || !d(viewInflate)) {
                            this.f6648c.setFlags(131072, 131072);
                        }
                        if (z5) {
                            if (viewInflate.getParent() != null) {
                                ((ViewGroup) viewInflate.getParent()).removeView(viewInflate);
                            }
                            frameLayout.addView(viewInflate);
                        } else {
                            ((ViewGroup) frameLayout.getParent()).removeView(frameLayout);
                        }
                    } else {
                        z5 = false;
                    }
                    NestedScrollViewExpander nestedScrollViewExpander = (NestedScrollViewExpander) viewGroup2;
                    if (!z5) {
                        frameLayout = null;
                    }
                    nestedScrollViewExpander.a(frameLayout);
                }
            }
            if (viewGroup3 != null) {
                Button button = (Button) viewGroup3.findViewById(R.id.button1);
                this.f6657n = button;
                button.setOnClickListener(this.f6646a0);
                C0381a.a(this.f6657n);
                if (TextUtils.isEmpty(this.f6658o)) {
                    this.f6657n.setVisibility(8);
                    i2 = 0;
                } else {
                    this.f6657n.setText(this.f6658o);
                    this.f6657n.setVisibility(0);
                    this.f6657n.setForceDarkAllowed(false);
                    i2 = 1;
                }
                Button button2 = (Button) viewGroup3.findViewById(R.id.button2);
                this.f6659q = button2;
                button2.setOnClickListener(this.f6646a0);
                C0381a.a(this.f6659q);
                if (TextUtils.isEmpty(this.f6660r)) {
                    this.f6659q.setVisibility(8);
                } else {
                    this.f6659q.setText(this.f6660r);
                    this.f6659q.setVisibility(0);
                    i2++;
                    this.f6659q.setForceDarkAllowed(false);
                }
                Button button3 = (Button) viewGroup3.findViewById(R.id.button3);
                this.f6662t = button3;
                button3.setOnClickListener(this.f6646a0);
                C0381a.a(this.f6662t);
                if (TextUtils.isEmpty(this.u)) {
                    this.f6662t.setVisibility(8);
                } else {
                    this.f6662t.setText(this.u);
                    this.f6662t.setVisibility(0);
                    i2++;
                    this.f6662t.setForceDarkAllowed(false);
                }
                List<ButtonInfo> list = this.f6664w;
                if (list != null && !list.isEmpty()) {
                    for (ButtonInfo buttonInfo : this.f6664w) {
                        if (buttonInfo.mButton != null) {
                            ViewParent parent = buttonInfo.mButton.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(buttonInfo.mButton);
                            }
                        }
                    }
                    for (ButtonInfo buttonInfo2 : this.f6664w) {
                        if (buttonInfo2.mButton == null) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                            buttonInfo2.mButton = new GroupButton(this.f6645a, null, buttonInfo2.mStyle);
                            buttonInfo2.mButton.setText(buttonInfo2.mText);
                            buttonInfo2.mButton.setOnClickListener(this.f6646a0);
                            buttonInfo2.mButton.setLayoutParams(layoutParams);
                            buttonInfo2.mButton.setMaxLines(2);
                            buttonInfo2.mButton.setGravity(17);
                        }
                        if (buttonInfo2.mMsg == null) {
                            buttonInfo2.mMsg = this.L.obtainMessage(buttonInfo2.mWhich, buttonInfo2.mOnClickListener);
                        }
                        if (buttonInfo2.mButton.getVisibility() != 8) {
                            i2++;
                            C0381a.a(buttonInfo2.mButton);
                            buttonInfo2.mButton.setForceDarkAllowed(false);
                            GroupButton unused = buttonInfo2.mButton;
                        }
                        viewGroup3.addView(buttonInfo2.mButton);
                    }
                }
                if (i2 == 0) {
                    viewGroup3.setVisibility(8);
                } else {
                    ((DialogButtonPanel) viewGroup3).a(this.f6634O);
                    viewGroup3.invalidate();
                }
            }
            if (viewGroup != null) {
                ImageView imageView = (ImageView) this.f6648c.findViewById(R.id.icon);
                View view2 = this.f6624C;
                if (view2 != null) {
                    if (view2.getParent() != null) {
                        ((ViewGroup) this.f6624C.getParent()).removeView(this.f6624C);
                    }
                    viewGroup.addView(this.f6624C, 0, new ViewGroup.LayoutParams(-1, -2));
                    this.f6648c.findViewById(com.android.mmt.R.id.alertTitle).setVisibility(8);
                    imageView.setVisibility(8);
                } else if ((!TextUtils.isEmpty(this.d)) && this.f6632K) {
                    TextView textView3 = (TextView) this.f6648c.findViewById(com.android.mmt.R.id.alertTitle);
                    this.f6667z = textView3;
                    textView3.setText(this.d);
                    int i5 = this.f6665x;
                    if (i5 != 0) {
                        imageView.setImageResource(i5);
                    } else {
                        Drawable drawable = this.f6666y;
                        if (drawable != null) {
                            imageView.setImageDrawable(drawable);
                        } else {
                            this.f6667z.setPadding(imageView.getPaddingLeft(), imageView.getPaddingTop(), imageView.getPaddingRight(), imageView.getPaddingBottom());
                            imageView.setVisibility(8);
                        }
                    }
                    if (this.f6649e != null && viewGroup.getVisibility() != 8) {
                        TextView textView4 = this.f6667z;
                        textView4.setPadding(textView4.getPaddingLeft(), textView4.getPaddingTop(), textView4.getPaddingRight(), 0);
                    }
                } else {
                    this.f6648c.findViewById(com.android.mmt.R.id.alertTitle).setVisibility(8);
                    imageView.setVisibility(8);
                    viewGroup.setVisibility(8);
                }
            }
            if ((viewGroup == null || viewGroup.getVisibility() == 8) ? false : true) {
                View viewFindViewById = (this.f6649e == null && this.g == null) ? null : viewGroup.findViewById(com.android.mmt.R.id.titleDividerNoCustom);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(0);
                }
            }
            ListView listView2 = this.g;
            if (listView2 != null && (listAdapter = this.f6625D) != null) {
                listView2.setAdapter(listAdapter);
                int i6 = this.f6626E;
                if (i6 > -1) {
                    listView2.setItemChecked(i6, true);
                    listView2.setSelection(i6);
                }
            }
            CheckBox checkBox = (CheckBox) this.f6633N.findViewById(R.id.checkbox);
            if (checkBox != null) {
                if (this.f6642X == null) {
                    checkBox.setVisibility(8);
                    return;
                }
                checkBox.setVisibility(0);
                checkBox.setChecked(this.f6636R);
                checkBox.setText(this.f6642X);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4  */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u() throws Resources.NotFoundException {
        ?? r02;
        ?? r03;
        int dimensionPixelSize;
        ?? r4;
        WindowManager windowManager = this.f6639U;
        if (windowManager == null) {
            r02 = 0;
        } else {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            r02 = (rotation == 1 || rotation == 3) ? (char) 2 : (char) 1;
        }
        if (this.f6635Q) {
            r03 = true;
        } else {
            if (r02 == 2) {
                if ((Settings.Secure.getInt(this.f6645a.getContentResolver(), "synergy_mode", 0) == 1) != false) {
                    this.f6639U.getDefaultDisplay().getRealSize(this.f6641W);
                    Point point = this.f6641W;
                    if (point.x > point.y) {
                    }
                }
                r03 = true;
            }
            r03 = false;
        }
        this.f6634O = false;
        boolean z4 = this.f6644Z;
        int i2 = com.android.mmt.R.layout.miuix_appcompat_alert_dialog_content;
        if (z4) {
            int size = !TextUtils.isEmpty(this.f6660r) ? 1 : 0;
            if (!TextUtils.isEmpty(this.u)) {
                size++;
            }
            if (!TextUtils.isEmpty(this.f6658o)) {
                size++;
            }
            List<ButtonInfo> list = this.f6664w;
            if (list != null) {
                size += list.size();
            }
            if (size == 0) {
                r4 = false;
                if (r4 == true) {
                    dimensionPixelSize = v() ? this.f6655l : r03 != false ? this.f6635Q ? this.f6638T : this.f6637S : -1;
                } else {
                    i2 = com.android.mmt.R.layout.miuix_appcompat_alert_dialog_content_land;
                    this.f6634O = true;
                    dimensionPixelSize = this.f6656m;
                }
            } else {
                C0411d.c(this.f6645a, this.f6640V);
                Point point2 = this.f6640V;
                int i4 = point2.x;
                int i5 = point2.y;
                if (i4 >= this.f6656m && i4 * 2 > i5 && this.f6644Z) {
                    r4 = true;
                }
                if (r4 == true) {
                }
            }
        }
        if (this.f6654k != i2) {
            this.f6654k = i2;
            DialogParentPanel2 dialogParentPanel2 = this.f6633N;
            if (dialogParentPanel2 != null) {
                this.M.removeView(dialogParentPanel2);
            }
            DialogParentPanel2 dialogParentPanel22 = (DialogParentPanel2) LayoutInflater.from(this.f6645a).inflate(this.f6654k, (ViewGroup) this.M, false);
            this.f6633N = dialogParentPanel22;
            this.M.addView(dialogParentPanel22);
        }
        C0411d.c(this.f6645a, this.f6640V);
        if (!v() && dimensionPixelSize == -1) {
            dimensionPixelSize = this.f6640V.x - (this.f6645a.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_dialog_width_margin) * 2);
        }
        int i6 = C0432b.f8169a;
        this.f6648c.setGravity(81);
        this.f6648c.getAttributes().verticalMargin = (this.f6645a.getResources().getDimensionPixelSize(com.android.mmt.R.dimen.miuix_appcompat_dialog_bottom_margin) * 1.0f) / this.f6640V.y;
        this.f6648c.addFlags(2);
        this.f6648c.setDimAmount(0.3f);
        this.f6648c.setLayout(dimensionPixelSize, -2);
        this.f6648c.setBackgroundDrawableResource(com.android.mmt.R.color.miuix_appcompat_transparent);
    }

    private boolean v() {
        return this.f6645a.getApplicationContext().getResources().getConfiguration().screenWidthDp >= 376;
    }

    private void w() {
        Configuration configuration = this.f6645a.getResources().getConfiguration();
        int iMin = (int) ((configuration.densityDpi / 160.0f) * Math.min(configuration.screenWidthDp, configuration.screenHeightDp));
        if (iMin > 0) {
            this.f6637S = iMin;
            return;
        }
        Point point = new Point();
        this.f6639U.getDefaultDisplay().getSize(point);
        this.f6637S = Math.min(point.x, point.y);
    }

    public final Button e(int i2) {
        if (i2 == -3) {
            return this.f6662t;
        }
        if (i2 == -2) {
            return this.f6659q;
        }
        if (i2 == -1) {
            return this.f6657n;
        }
        List<ButtonInfo> list = this.f6664w;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (ButtonInfo buttonInfo : this.f6664w) {
            if (buttonInfo.mWhich == i2) {
                return buttonInfo.mButton;
            }
        }
        return null;
    }

    public final int f(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f6645a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public final void g() throws Resources.NotFoundException {
        this.f6647b.setContentView(this.f6627F);
        DialogRootView dialogRootView = (DialogRootView) this.f6648c.findViewById(com.android.mmt.R.id.dialog_root_view);
        this.M = dialogRootView;
        dialogRootView.a(new f(this));
        u();
        t(true);
    }

    public final boolean h() {
        boolean zIsChecked = ((CheckBox) this.f6648c.findViewById(R.id.checkbox)).isChecked();
        this.f6636R = zIsChecked;
        return zIsChecked;
    }

    public final void i(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.L.obtainMessage(i2, onClickListener) : null;
        if (i2 == -3) {
            this.u = charSequence;
            this.f6663v = messageObtainMessage;
        } else if (i2 == -2) {
            this.f6660r = charSequence;
            this.f6661s = messageObtainMessage;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f6658o = charSequence;
            this.p = messageObtainMessage;
        }
    }

    public final void j(boolean z4, CharSequence charSequence) {
        this.f6636R = z4;
        this.f6642X = charSequence;
    }

    public final void k(CharSequence charSequence) {
        this.f6650f = charSequence;
        TextView textView = this.f6623B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void l(View view) {
        this.f6624C = view;
    }

    public final void m(int i2) {
        this.f6666y = null;
        this.f6665x = i2;
    }

    public final void n(Drawable drawable) {
        this.f6666y = drawable;
        this.f6665x = 0;
    }

    public final void o(CharSequence charSequence) {
        this.f6649e = charSequence;
        TextView textView = this.f6622A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    final void p(boolean z4) {
        this.f6644Z = z4;
    }

    public final void q(CharSequence charSequence) {
        this.d = charSequence;
        TextView textView = this.f6667z;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void r(int i2) {
        this.f6651h = null;
        this.f6652i = i2;
    }

    public final void s(View view) {
        this.f6651h = view;
        this.f6652i = 0;
    }

    static class ButtonInfo {
        private GroupButton mButton;
        private Message mMsg;
        private final DialogInterface.OnClickListener mOnClickListener;
        private final int mStyle;
        private final CharSequence mText;
        private final int mWhich;

        ButtonInfo(CharSequence charSequence, int i2, Message message) {
            this.mText = charSequence;
            this.mStyle = i2;
            this.mMsg = message;
            this.mOnClickListener = null;
            this.mWhich = 0;
        }

        ButtonInfo(CharSequence charSequence, int i2, DialogInterface.OnClickListener onClickListener, int i4) {
            this.mText = charSequence;
            this.mStyle = i2;
            this.mMsg = null;
            this.mOnClickListener = onClickListener;
            this.mWhich = i4;
        }
    }
}
