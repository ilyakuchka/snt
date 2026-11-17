package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: androidx.room.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0075a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4283a = 0;

        /* renamed from: androidx.room.a$a$a, reason: collision with other inner class name */
        private static class C0076a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f4284a;

            C0076a(IBinder iBinder) {
                this.f4284a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4284a;
            }

            @Override // androidx.room.a
            public final void t(String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    parcelObtain.writeStringArray(strArr);
                    if (!this.f4284a.transact(1, parcelObtain, null, 1)) {
                        int i2 = AbstractBinderC0075a.f4283a;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static a A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0076a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    void t(String[] strArr) throws RemoteException;
}
