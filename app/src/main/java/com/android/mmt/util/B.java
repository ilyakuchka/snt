package com.android.mmt.util;

import android.content.Context;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class B {
    public static boolean a(Context context, int i2) throws NoSuchMethodException, SecurityException {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
            declaredMethod.setAccessible(true);
            ServiceState serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(i2));
            if (serviceState != null) {
                Method declaredMethod2 = ServiceState.class.getDeclaredMethod("getDataRoamingType", new Class[0]);
                declaredMethod2.setAccessible(true);
                if (((Integer) declaredMethod2.invoke(serviceState, new Object[0])).intValue() == 2) {
                    Log.d("Mms: PhoneStateHelper", "isDomesticRoaming = true");
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
