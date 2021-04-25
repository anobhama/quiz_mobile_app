package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements LifecycleEventObserver {
    private static final int INIT_FAILED = 2;
    private static final int INIT_SUCCESS = 1;
    private static final int NOT_INITIALIAZED = 0;
    private static Field sHField;
    private static Field sNextServedViewField;
    private static int sReflectedFieldsInitialized = 0;
    private static Field sServedViewField;
    private Activity mActivity;

    ImmLeaksCleaner(Activity activity) {
        this.mActivity = activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0043, code lost:
        r0.isActive();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0053, code lost:
        throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:17:0x0031, B:24:0x003b] */
    public void onStateChanged(LifecycleOwner source, Event event) {
        if (event == Event.ON_DESTROY) {
            if (sReflectedFieldsInitialized == 0) {
                initializeReflectiveFields();
            }
            if (sReflectedFieldsInitialized == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.mActivity.getSystemService("input_method");
                try {
                    Object lock = sHField.get(inputMethodManager);
                    if (lock != null) {
                        synchronized (lock) {
                            try {
                                View servedView = (View) sServedViewField.get(inputMethodManager);
                                if (servedView != null) {
                                    if (!servedView.isAttachedToWindow()) {
                                        sNextServedViewField.set(inputMethodManager, null);
                                    }
                                }
                            } catch (IllegalAccessException e) {
                            } catch (ClassCastException e2) {
                            }
                        }
                    }
                } catch (IllegalAccessException e3) {
                }
            }
        }
    }

    private static void initializeReflectiveFields() {
        try {
            sReflectedFieldsInitialized = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            sServedViewField = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            sNextServedViewField = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            sHField = declaredField3;
            declaredField3.setAccessible(true);
            sReflectedFieldsInitialized = 1;
        } catch (NoSuchFieldException e) {
        }
    }
}
