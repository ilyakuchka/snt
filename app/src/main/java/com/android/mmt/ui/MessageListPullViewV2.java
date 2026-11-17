package com.android.mmt.ui;

import P0.C0167m;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.mmt.R;
import r.C0374g;

/* loaded from: classes.dex */
public final class MessageListPullViewV2 extends C0167m {

    /* renamed from: k1, reason: collision with root package name */
    private View f5000k1;

    /* renamed from: l1, reason: collision with root package name */
    private ProgressBar f5001l1;

    /* renamed from: m1, reason: collision with root package name */
    private TextView f5002m1;

    /* renamed from: n1, reason: collision with root package name */
    private boolean f5003n1;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f5004o1;

    /* renamed from: p1, reason: collision with root package name */
    private boolean f5005p1;

    /* renamed from: q1, reason: collision with root package name */
    private int f5006q1;

    /* renamed from: r1, reason: collision with root package name */
    private int f5007r1;

    /* renamed from: s1, reason: collision with root package name */
    private int f5008s1;

    /* renamed from: t1, reason: collision with root package name */
    private int f5009t1;
    private float u1;
    private int v1;
    private b w1;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageListPullViewV2.this.n0(0);
        }
    }

    public interface b {
    }

    public MessageListPullViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5001l1 = null;
        this.f5002m1 = null;
        this.f5003n1 = false;
        this.f5004o1 = false;
        this.f5005p1 = false;
        this.f5006q1 = 0;
        this.f5007r1 = -1;
        this.f5008s1 = 0;
        this.f5009t1 = 0;
        this.u1 = 0.0f;
        this.v1 = 1;
        this.w1 = null;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.q1(1);
        u0(linearLayoutManager);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, Y1.a.f2089G, 0, 0);
            try {
                this.f5004o1 = typedArrayObtainStyledAttributes.getBoolean(0, this.f5004o1);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        if (this.f5004o1) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.message_list_more_head, (ViewGroup) this, false);
            this.f5000k1 = viewInflate;
            this.f5001l1 = (ProgressBar) viewInflate.findViewById(R.id.progressbar);
            this.f5002m1 = (TextView) this.f5000k1.findViewById(R.id.content);
        }
        this.f5006q1 = 0;
        View view = this.f5000k1;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f5006q1 = this.f5000k1.getMeasuredHeight();
            K0(this.f5000k1);
            O1();
        }
    }

    private void R1(int i2) {
        if (!this.f5004o1 || this.v1 == i2) {
            return;
        }
        this.v1 = i2;
        if (i2 == 4) {
            this.f5001l1.setVisibility(0);
        } else {
            this.f5001l1.setVisibility(8);
        }
        int iB = C0374g.b(this.v1);
        if (iB == 1) {
            this.f5002m1.setText(R.string.msglist_continue_to_pull_for_more);
            this.f5001l1.setProgress(0);
        } else if (iB == 2) {
            this.f5002m1.setText(R.string.msglist_release_to_more);
        } else if (iB == 3) {
            this.f5002m1.setText(R.string.msglist_more_refreshing);
        } else if (iB == 4) {
            this.f5002m1.setText(R.string.msglist_no_more_to_refresh);
        }
        invalidate();
    }

    public final void O1() {
        if (this.f5004o1) {
            R1(2);
        }
        postDelayed(new a(), 200L);
        this.f5000k1.setPadding(0, (this.f5006q1 * (-1)) + 1, 0, 0);
    }

    public final void P1(boolean z4) {
        this.f5005p1 = z4;
    }

    public final void Q1(b bVar) {
        if (this.f5004o1) {
            this.w1 = bVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0134  */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f5004o1) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            float f4 = 0.0f;
            if (actionMasked == 1) {
                this.f5003n1 = false;
                this.u1 = 0.0f;
                this.f5009t1 = 0;
                if (this.f5004o1 && this.v1 == 3) {
                    R1(4);
                    this.f5000k1.setPadding(0, 0, 0, 0);
                    b bVar = this.w1;
                    if (bVar != null) {
                        ((r) bVar).c2();
                    }
                } else {
                    this.f5000k1.setPadding(0, -this.f5006q1, 0, 0);
                }
            } else if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.f5007r1 = -1;
                        if (this.f5003n1) {
                            int actionIndex = motionEvent.getActionIndex();
                            this.f5007r1 = motionEvent.getPointerId(actionIndex);
                            this.f5008s1 = (int) motionEvent.getY(actionIndex);
                        }
                    } else if (actionMasked == 6 && this.f5003n1) {
                        int action = (motionEvent.getAction() & 65280) >> 8;
                        if (motionEvent.getPointerId(action) == this.f5007r1) {
                            int i2 = action == 0 ? 1 : 0;
                            this.f5007r1 = motionEvent.getPointerId(i2);
                            this.f5008s1 = (int) motionEvent.getY(i2);
                        }
                    }
                }
            } else if (!this.f5003n1) {
                if (M0() == N0()) {
                    if (this.f5004o1 && this.f5005p1 && this.v1 == 2) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(this.f5007r1);
                        if (iFindPointerIndex == -1) {
                            this.f5007r1 = motionEvent.getPointerId(0);
                            iFindPointerIndex = 0;
                        }
                        this.f5008s1 = (int) motionEvent.getY(iFindPointerIndex);
                        this.f5009t1 = 0;
                        this.f5003n1 = true;
                    }
                }
            } else if (this.f5003n1) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f5007r1);
                if (iFindPointerIndex2 == -1) {
                    this.f5007r1 = motionEvent.getPointerId(0);
                    iFindPointerIndex2 = 0;
                }
                int y2 = (int) motionEvent.getY(iFindPointerIndex2);
                int i4 = this.f5009t1;
                int i5 = y2 - this.f5008s1;
                int iSignum = (int) (Math.signum(i5) * 1.0f);
                for (int i6 = 0; i6 < Math.abs(i5); i6++) {
                    float fPow = iSignum / ((((float) Math.pow(Math.abs((i4 + this.u1) + f4) / 2000.0f, 3.0d)) * 98.0f) + 2.0f);
                    if (Math.abs(fPow) < 0.001d) {
                        break;
                    }
                    f4 += fPow;
                }
                float f5 = f4 + this.u1;
                int i7 = (int) f5;
                this.u1 = f5 - i7;
                int i8 = i4 + i7;
                this.f5009t1 = i8;
                if (i8 > 0) {
                    if (this.f5004o1) {
                        if (i8 >= this.f5006q1 * 3.0f) {
                            R1(3);
                        } else {
                            R1(2);
                        }
                    }
                    n0(0);
                    this.f5000k1.setPadding(0, (-this.f5006q1) + this.f5009t1, 0, 0);
                }
                this.f5008s1 = y2;
            }
        } else if (this.f5004o1 && !this.f5005p1) {
            R1(5);
        } else if (!this.f5003n1) {
            if ((M0() == N0()) && this.f5004o1 && this.v1 == 2) {
                this.f5008s1 = (int) motionEvent.getY(0);
                this.f5009t1 = 0;
                this.f5003n1 = true;
                this.f5007r1 = motionEvent.getPointerId(0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
    }
}
