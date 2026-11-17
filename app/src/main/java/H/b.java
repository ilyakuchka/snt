package H;

import android.widget.ListView;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: z, reason: collision with root package name */
    private final ListView f255z;

    public b(ListView listView) {
        super(listView);
        this.f255z = listView;
    }

    @Override // H.a
    public final boolean a(int i2) {
        ListView listView = this.f255z;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i4 = firstVisiblePosition + childCount;
        if (i2 > 0) {
            if (i4 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i2 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // H.a
    public final void e(int i2) {
        this.f255z.scrollListBy(i2);
    }
}
