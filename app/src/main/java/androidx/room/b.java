package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.MultiInstanceInvalidationService;
import androidx.room.a;

/* loaded from: classes.dex */
public abstract class b extends Binder implements IInterface {
    public b() {
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        if (i2 == 1) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            int iB = ((MultiInstanceInvalidationService.b) this).B(a.AbstractBinderC0075a.A(parcel.readStrongBinder()), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(iB);
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i4);
                }
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            ((MultiInstanceInvalidationService.b) this).A(parcel.readInt(), parcel.createStringArray());
            return true;
        }
        parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
        a aVarA = a.AbstractBinderC0075a.A(parcel.readStrongBinder());
        int i5 = parcel.readInt();
        MultiInstanceInvalidationService.b bVar = (MultiInstanceInvalidationService.b) this;
        synchronized (MultiInstanceInvalidationService.this.f4279k) {
            MultiInstanceInvalidationService.this.f4279k.unregister(aVarA);
            MultiInstanceInvalidationService.this.f4278j.remove(Integer.valueOf(i5));
        }
        parcel2.writeNoException();
        return true;
    }
}
