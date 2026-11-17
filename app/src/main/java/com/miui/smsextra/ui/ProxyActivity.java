package com.miui.smsextra.ui;

import N2.b;
import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import miuix.appcompat.app.h;

/* loaded from: classes.dex */
public class ProxyActivity extends h {
    @Override // miuix.appcompat.app.h, android.app.Activity, android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
        throw null;
    }

    @Override // miuix.appcompat.app.h, android.app.Activity, android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
        throw null;
    }

    @Override // androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, android.app.Activity
    protected final void onActivityResult(int i2, int i4, Intent intent) {
        super.onActivityResult(i2, i4, intent);
        throw null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // miuix.appcompat.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        throw null;
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        throw null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
        super.onContentChanged();
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onContextItemSelected(MenuItem menuItem) {
        super.onContextItemSelected(menuItem);
        throw null;
    }

    @Override // android.app.Activity
    public final void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
        throw null;
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TextUtils.isEmpty(getIntent().getStringExtra("delegate_activity_name"))) {
            int i2 = b.f732b;
        }
        finish();
    }

    @Override // android.app.Activity
    public final CharSequence onCreateDescription() {
        throw null;
    }

    @Override // android.app.Activity
    public final void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onCreateNavigateUpTaskStack(taskStackBuilder);
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        throw null;
    }

    @Override // miuix.appcompat.app.h, android.app.Activity, android.view.Window.Callback
    public final View onCreatePanelView(int i2) {
        throw null;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        super.onGenericMotionEvent(motionEvent);
        throw null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        super.onKeyDown(i2, keyEvent);
        throw null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        super.onKeyLongPress(i2, keyEvent);
        throw null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        super.onKeyUp(i2, keyEvent);
        throw null;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        throw null;
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        super.onMenuItemSelected(i2, menuItem);
        throw null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuOpened(int i2, Menu menu) {
        super.onMenuOpened(i2, menu);
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onNavigateUp() {
        super.onNavigateUp();
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onNavigateUpFromChild(Activity activity) {
        super.onNavigateUpFromChild(activity);
        throw null;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        throw null;
    }

    @Override // android.app.Activity
    public final void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        throw null;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
        throw null;
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        throw null;
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onPostResume() {
        super.onPostResume();
    }

    @Override // android.app.Activity
    public final void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onPrepareNavigateUpTaskStack(taskStackBuilder);
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        throw null;
    }

    @Override // androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        throw null;
    }

    @Override // miuix.appcompat.app.h, android.app.Activity
    protected final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onResume() {
        super.onResume();
    }

    @Override // miuix.appcompat.app.h, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onStateNotSaved() {
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onStop() {
        super.onStop();
    }

    @Override // miuix.appcompat.app.h, android.app.Activity
    protected final void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        super.onTrackballEvent(motionEvent);
        throw null;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        throw null;
    }

    @Override // android.app.Activity
    public final void onUserInteraction() {
        super.onUserInteraction();
        throw null;
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        throw null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        throw null;
    }

    @Override // miuix.appcompat.app.h, android.app.Activity, android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        throw null;
    }

    @Override // androidx.fragment.app.ActivityC0219o
    public final void x(Fragment fragment) {
    }
}
