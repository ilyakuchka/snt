package Y1;

import D2.e;
import X3.v;
import android.R;
import android.net.Uri;
import android.util.Log;
import android.widget.TextView;
import b3.b;
import f3.c;
import java.lang.reflect.Field;
import t.C0384b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f2106a = {R.attr.elevation, com.android.mmt.R.attr.backgroundLeft, com.android.mmt.R.attr.backgroundRight, com.android.mmt.R.attr.bottomArrow, com.android.mmt.R.attr.bottomLeftArrow, com.android.mmt.R.attr.bottomRightArrow, com.android.mmt.R.attr.contentBackground, com.android.mmt.R.attr.leftArrow, com.android.mmt.R.attr.rightArrow, com.android.mmt.R.attr.titleBackground, com.android.mmt.R.attr.topArrow, com.android.mmt.R.attr.topArrowWithTitle, com.android.mmt.R.attr.topLeftArrow, com.android.mmt.R.attr.topRightArrow};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f2108b = {R.attr.colorBackground, R.attr.textSize, R.attr.textColor, com.android.mmt.R.attr.lineLength, com.android.mmt.R.attr.paintColor, com.android.mmt.R.attr.startPointRadius, com.android.mmt.R.attr.textCircleRadius};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2110c = {com.android.mmt.R.attr.adapter, com.android.mmt.R.attr.entries, com.android.mmt.R.attr.entryIcons, com.android.mmt.R.attr.entrySummaries, com.android.mmt.R.attr.entryValues};
    public static final int[] d = {R.attr.text, com.android.mmt.R.attr.textProvider};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f2113e = {R.attr.orientation, R.attr.descendantFocusability, com.android.mmt.R.attr.fastScrollEnabled, com.android.mmt.R.attr.fastScrollHorizontalThumbDrawable, com.android.mmt.R.attr.fastScrollHorizontalTrackDrawable, com.android.mmt.R.attr.fastScrollVerticalThumbDrawable, com.android.mmt.R.attr.fastScrollVerticalTrackDrawable, com.android.mmt.R.attr.layoutManager, com.android.mmt.R.attr.reverseLayout, com.android.mmt.R.attr.spanCount, com.android.mmt.R.attr.stackFromEnd};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f2114f = {R.attr.icon, R.attr.background, R.attr.maxHeight, R.attr.divider, R.attr.height, R.attr.title, R.attr.logo, R.attr.navigationMode, R.attr.displayOptions, R.attr.subtitle, R.attr.customNavigationLayout, R.attr.titleTextStyle, R.attr.subtitleTextStyle, R.attr.progressBarPadding, R.attr.homeLayout, R.attr.itemPadding, R.attr.backgroundStacked, R.attr.backgroundSplit, com.android.mmt.R.attr.actionBarEmbededTabsBackground, com.android.mmt.R.attr.actionBarStackedBackground, com.android.mmt.R.attr.background, com.android.mmt.R.attr.backgroundSplit, com.android.mmt.R.attr.backgroundStacked, com.android.mmt.R.attr.contentInsetEnd, com.android.mmt.R.attr.contentInsetEndWithActions, com.android.mmt.R.attr.contentInsetLeft, com.android.mmt.R.attr.contentInsetRight, com.android.mmt.R.attr.contentInsetStart, com.android.mmt.R.attr.contentInsetStartWithNavigation, com.android.mmt.R.attr.customNavigationLayout, com.android.mmt.R.attr.customViewAutoFitSystemWindow, com.android.mmt.R.attr.displayOptions, com.android.mmt.R.attr.divider, com.android.mmt.R.attr.elevation, com.android.mmt.R.attr.expandState, com.android.mmt.R.attr.expandSubtitleTextStyle, com.android.mmt.R.attr.expandTitleTextStyle, com.android.mmt.R.attr.height, com.android.mmt.R.attr.hideOnContentScroll, com.android.mmt.R.attr.homeAsUpIndicator, com.android.mmt.R.attr.homeLayout, com.android.mmt.R.attr.icon, com.android.mmt.R.attr.indeterminateProgressStyle, com.android.mmt.R.attr.itemPadding, com.android.mmt.R.attr.logo, com.android.mmt.R.attr.navigationMode, com.android.mmt.R.attr.popupTheme, com.android.mmt.R.attr.progressBarPadding, com.android.mmt.R.attr.progressBarStyle, com.android.mmt.R.attr.resizable, com.android.mmt.R.attr.subtitle, com.android.mmt.R.attr.subtitleTextStyle, com.android.mmt.R.attr.tabIndicator, com.android.mmt.R.attr.title, com.android.mmt.R.attr.titleCenter, com.android.mmt.R.attr.titleTextStyle, com.android.mmt.R.attr.translucentTabIndicator};
    public static final int[] g = {R.attr.layout_gravity};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f2115h = {R.attr.minWidth};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f2116i = {R.attr.background, R.attr.height, R.attr.titleTextStyle, R.attr.subtitleTextStyle, R.attr.backgroundSplit, com.android.mmt.R.attr.actionModeAnim, com.android.mmt.R.attr.background, com.android.mmt.R.attr.backgroundSplit, com.android.mmt.R.attr.closeItemLayout, com.android.mmt.R.attr.expandTitleTextStyle, com.android.mmt.R.attr.height, com.android.mmt.R.attr.subtitleTextStyle, com.android.mmt.R.attr.titleTextStyle};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f2117j = {R.attr.layout, com.android.mmt.R.attr.buttonIconDimen, com.android.mmt.R.attr.buttonPanelSideLayout, com.android.mmt.R.attr.horizontalProgressLayout, com.android.mmt.R.attr.layout, com.android.mmt.R.attr.listItemLayout, com.android.mmt.R.attr.listLayout, com.android.mmt.R.attr.multiChoiceItemLayout, com.android.mmt.R.attr.progressLayout, com.android.mmt.R.attr.showTitle, com.android.mmt.R.attr.singleChoiceItemLayout};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f2118k = {R.attr.src, com.android.mmt.R.attr.srcCompat, com.android.mmt.R.attr.tint, com.android.mmt.R.attr.tintMode};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f2119l = {R.attr.thumb, com.android.mmt.R.attr.tickMark, com.android.mmt.R.attr.tickMarkTint, com.android.mmt.R.attr.tickMarkTintMode};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f2120m = {R.attr.textAppearance, R.attr.drawableTop, R.attr.drawableBottom, R.attr.drawableLeft, R.attr.drawableRight, R.attr.drawableStart, R.attr.drawableEnd};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f2121n = {R.attr.textAppearance, com.android.mmt.R.attr.autoSizeMaxTextSize, com.android.mmt.R.attr.autoSizeMinTextSize, com.android.mmt.R.attr.autoSizePresetSizes, com.android.mmt.R.attr.autoSizeStepGranularity, com.android.mmt.R.attr.autoSizeTextType, com.android.mmt.R.attr.drawableBottomCompat, com.android.mmt.R.attr.drawableEndCompat, com.android.mmt.R.attr.drawableLeftCompat, com.android.mmt.R.attr.drawableRightCompat, com.android.mmt.R.attr.drawableStartCompat, com.android.mmt.R.attr.drawableTint, com.android.mmt.R.attr.drawableTintMode, com.android.mmt.R.attr.drawableTopCompat, com.android.mmt.R.attr.firstBaselineToTopHeight, com.android.mmt.R.attr.fontFamily, com.android.mmt.R.attr.fontVariationSettings, com.android.mmt.R.attr.lastBaselineToBottomHeight, com.android.mmt.R.attr.lineHeight, com.android.mmt.R.attr.textAllCaps, com.android.mmt.R.attr.textLocale};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f2122o = {R.attr.windowIsFloating, R.attr.windowAnimationStyle, com.android.mmt.R.attr.actionBarDivider, com.android.mmt.R.attr.actionBarItemBackground, com.android.mmt.R.attr.actionBarPopupTheme, com.android.mmt.R.attr.actionBarSize, com.android.mmt.R.attr.actionBarSplitStyle, com.android.mmt.R.attr.actionBarStyle, com.android.mmt.R.attr.actionBarTabBarStyle, com.android.mmt.R.attr.actionBarTabStyle, com.android.mmt.R.attr.actionBarTabTextStyle, com.android.mmt.R.attr.actionBarTheme, com.android.mmt.R.attr.actionBarWidgetTheme, com.android.mmt.R.attr.actionButtonStyle, com.android.mmt.R.attr.actionDropDownStyle, com.android.mmt.R.attr.actionMenuTextAppearance, com.android.mmt.R.attr.actionMenuTextColor, com.android.mmt.R.attr.actionModeBackground, com.android.mmt.R.attr.actionModeCloseButtonStyle, com.android.mmt.R.attr.actionModeCloseContentDescription, com.android.mmt.R.attr.actionModeCloseDrawable, com.android.mmt.R.attr.actionModeCopyDrawable, com.android.mmt.R.attr.actionModeCutDrawable, com.android.mmt.R.attr.actionModeFindDrawable, com.android.mmt.R.attr.actionModePasteDrawable, com.android.mmt.R.attr.actionModePopupWindowStyle, com.android.mmt.R.attr.actionModeSelectAllDrawable, com.android.mmt.R.attr.actionModeShareDrawable, com.android.mmt.R.attr.actionModeSplitBackground, com.android.mmt.R.attr.actionModeStyle, com.android.mmt.R.attr.actionModeTheme, com.android.mmt.R.attr.actionModeWebSearchDrawable, com.android.mmt.R.attr.actionOverflowButtonStyle, com.android.mmt.R.attr.actionOverflowMenuStyle, com.android.mmt.R.attr.activityChooserViewStyle, com.android.mmt.R.attr.alertDialogButtonGroupStyle, com.android.mmt.R.attr.alertDialogCenterButtons, com.android.mmt.R.attr.alertDialogStyle, com.android.mmt.R.attr.alertDialogTheme, com.android.mmt.R.attr.autoCompleteTextViewStyle, com.android.mmt.R.attr.borderlessButtonStyle, com.android.mmt.R.attr.buttonBarButtonStyle, com.android.mmt.R.attr.buttonBarNegativeButtonStyle, com.android.mmt.R.attr.buttonBarNeutralButtonStyle, com.android.mmt.R.attr.buttonBarPositiveButtonStyle, com.android.mmt.R.attr.buttonBarStyle, com.android.mmt.R.attr.buttonStyle, com.android.mmt.R.attr.buttonStyleSmall, com.android.mmt.R.attr.checkboxStyle, com.android.mmt.R.attr.checkedTextViewStyle, com.android.mmt.R.attr.colorAccent, com.android.mmt.R.attr.colorBackgroundFloating, com.android.mmt.R.attr.colorButtonNormal, com.android.mmt.R.attr.colorControlActivated, com.android.mmt.R.attr.colorControlHighlight, com.android.mmt.R.attr.colorControlNormal, com.android.mmt.R.attr.colorError, com.android.mmt.R.attr.colorPrimary, com.android.mmt.R.attr.colorPrimaryDark, com.android.mmt.R.attr.colorSwitchThumbNormal, com.android.mmt.R.attr.controlBackground, com.android.mmt.R.attr.dialogCornerRadius, com.android.mmt.R.attr.dialogPreferredPadding, com.android.mmt.R.attr.dialogTheme, com.android.mmt.R.attr.dividerHorizontal, com.android.mmt.R.attr.dividerVertical, com.android.mmt.R.attr.dropDownListViewStyle, com.android.mmt.R.attr.dropdownListPreferredItemHeight, com.android.mmt.R.attr.editTextBackground, com.android.mmt.R.attr.editTextColor, com.android.mmt.R.attr.editTextStyle, com.android.mmt.R.attr.homeAsUpIndicator, com.android.mmt.R.attr.imageButtonStyle, com.android.mmt.R.attr.listChoiceBackgroundIndicator, com.android.mmt.R.attr.listChoiceIndicatorMultipleAnimated, com.android.mmt.R.attr.listChoiceIndicatorSingleAnimated, com.android.mmt.R.attr.listDividerAlertDialog, com.android.mmt.R.attr.listMenuViewStyle, com.android.mmt.R.attr.listPopupWindowStyle, com.android.mmt.R.attr.listPreferredItemHeight, com.android.mmt.R.attr.listPreferredItemHeightLarge, com.android.mmt.R.attr.listPreferredItemHeightSmall, com.android.mmt.R.attr.listPreferredItemPaddingEnd, com.android.mmt.R.attr.listPreferredItemPaddingLeft, com.android.mmt.R.attr.listPreferredItemPaddingRight, com.android.mmt.R.attr.listPreferredItemPaddingStart, com.android.mmt.R.attr.panelBackground, com.android.mmt.R.attr.panelMenuListTheme, com.android.mmt.R.attr.panelMenuListWidth, com.android.mmt.R.attr.popupMenuStyle, com.android.mmt.R.attr.popupWindowStyle, com.android.mmt.R.attr.radioButtonStyle, com.android.mmt.R.attr.ratingBarStyle, com.android.mmt.R.attr.ratingBarStyleIndicator, com.android.mmt.R.attr.ratingBarStyleSmall, com.android.mmt.R.attr.searchViewStyle, com.android.mmt.R.attr.seekBarStyle, com.android.mmt.R.attr.selectableItemBackground, com.android.mmt.R.attr.selectableItemBackgroundBorderless, com.android.mmt.R.attr.spinnerDropDownItemStyle, com.android.mmt.R.attr.spinnerStyle, com.android.mmt.R.attr.switchStyle, com.android.mmt.R.attr.textAppearanceLargePopupMenu, com.android.mmt.R.attr.textAppearanceListItem, com.android.mmt.R.attr.textAppearanceListItemSecondary, com.android.mmt.R.attr.textAppearanceListItemSmall, com.android.mmt.R.attr.textAppearancePopupMenuHeader, com.android.mmt.R.attr.textAppearanceSearchResultSubtitle, com.android.mmt.R.attr.textAppearanceSearchResultTitle, com.android.mmt.R.attr.textAppearanceSmallPopupMenu, com.android.mmt.R.attr.textColorAlertDialogListItem, com.android.mmt.R.attr.textColorSearchUrl, com.android.mmt.R.attr.toolbarNavigationButtonStyle, com.android.mmt.R.attr.toolbarStyle, com.android.mmt.R.attr.tooltipForegroundColor, com.android.mmt.R.attr.tooltipFrameBackground, com.android.mmt.R.attr.viewInflaterClass, com.android.mmt.R.attr.windowActionBar, com.android.mmt.R.attr.windowActionBarOverlay, com.android.mmt.R.attr.windowActionModeOverlay, com.android.mmt.R.attr.windowFixedHeightMajor, com.android.mmt.R.attr.windowFixedHeightMinor, com.android.mmt.R.attr.windowFixedWidthMajor, com.android.mmt.R.attr.windowFixedWidthMinor, com.android.mmt.R.attr.windowMinWidthMajor, com.android.mmt.R.attr.windowMinWidthMinor, com.android.mmt.R.attr.windowNoTitle};
    public static final int[] p = {com.android.mmt.R.attr.allowStacking};

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f2123q = {R.attr.button, com.android.mmt.R.attr.buttonCompat, com.android.mmt.R.attr.buttonTint, com.android.mmt.R.attr.buttonTintMode};

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f2124r = {R.attr.gravity, R.attr.orientation, R.attr.baselineAligned, R.attr.baselineAlignedChildIndex, R.attr.weightSum, com.android.mmt.R.attr.divider, com.android.mmt.R.attr.dividerPadding, com.android.mmt.R.attr.measureWithLargestChild, com.android.mmt.R.attr.showDividers};

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f2125s = {R.attr.dropDownHorizontalOffset, R.attr.dropDownVerticalOffset};

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f2126t = {R.attr.enabled, R.attr.id, R.attr.visible, R.attr.menuCategory, R.attr.orderInCategory, R.attr.checkableBehavior};
    public static final int[] u = {R.attr.icon, R.attr.enabled, R.attr.id, R.attr.checked, R.attr.visible, R.attr.menuCategory, R.attr.orderInCategory, R.attr.title, R.attr.titleCondensed, R.attr.alphabeticShortcut, R.attr.numericShortcut, R.attr.checkable, R.attr.onClick, com.android.mmt.R.attr.actionLayout, com.android.mmt.R.attr.actionProviderClass, com.android.mmt.R.attr.actionViewClass, com.android.mmt.R.attr.alphabeticModifiers, com.android.mmt.R.attr.contentDescription, com.android.mmt.R.attr.iconTint, com.android.mmt.R.attr.iconTintMode, com.android.mmt.R.attr.numericModifiers, com.android.mmt.R.attr.showAsAction, com.android.mmt.R.attr.tooltipText};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f2127v = {R.attr.windowAnimationStyle, R.attr.itemTextAppearance, R.attr.horizontalDivider, R.attr.verticalDivider, R.attr.headerBackground, R.attr.itemBackground, R.attr.itemIconDisabledAlpha, com.android.mmt.R.attr.preserveIconSpacing, com.android.mmt.R.attr.subMenuArrow};

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f2128w = {R.attr.popupBackground, R.attr.popupAnimationStyle, com.android.mmt.R.attr.overlapAnchor};

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f2129x = {com.android.mmt.R.attr.paddingBottomNoButtons, com.android.mmt.R.attr.paddingTopNoTitle};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f2130y = {R.attr.focusable, R.attr.maxWidth, R.attr.inputType, R.attr.imeOptions, com.android.mmt.R.attr.closeIcon, com.android.mmt.R.attr.commitIcon, com.android.mmt.R.attr.defaultQueryHint, com.android.mmt.R.attr.goIcon, com.android.mmt.R.attr.iconifiedByDefault, com.android.mmt.R.attr.layout, com.android.mmt.R.attr.queryBackground, com.android.mmt.R.attr.queryHint, com.android.mmt.R.attr.searchHintIcon, com.android.mmt.R.attr.searchIcon, com.android.mmt.R.attr.submitBackground, com.android.mmt.R.attr.suggestionRowLayout, com.android.mmt.R.attr.voiceIcon};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f2131z = {R.attr.entries, R.attr.popupBackground, R.attr.prompt, R.attr.dropDownWidth, com.android.mmt.R.attr.dropDownMaxWidth, com.android.mmt.R.attr.dropDownMinWidth, com.android.mmt.R.attr.popupTheme, com.android.mmt.R.attr.spinnerModeCompat};

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f2083A = {R.attr.textOn, R.attr.textOff, R.attr.thumb, com.android.mmt.R.attr.showText, com.android.mmt.R.attr.splitTrack, com.android.mmt.R.attr.switchMinWidth, com.android.mmt.R.attr.switchPadding, com.android.mmt.R.attr.switchTextAppearance, com.android.mmt.R.attr.thumbTextPadding, com.android.mmt.R.attr.thumbTint, com.android.mmt.R.attr.thumbTintMode, com.android.mmt.R.attr.track, com.android.mmt.R.attr.trackTint, com.android.mmt.R.attr.trackTintMode};

    /* renamed from: B, reason: collision with root package name */
    public static final int[] f2084B = {R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.android.mmt.R.attr.fontFamily, com.android.mmt.R.attr.fontVariationSettings, com.android.mmt.R.attr.textAllCaps, com.android.mmt.R.attr.textLocale};

    /* renamed from: C, reason: collision with root package name */
    public static final int[] f2085C = {R.attr.gravity, R.attr.minHeight, com.android.mmt.R.attr.buttonGravity, com.android.mmt.R.attr.collapseContentDescription, com.android.mmt.R.attr.collapseIcon, com.android.mmt.R.attr.contentInsetEnd, com.android.mmt.R.attr.contentInsetEndWithActions, com.android.mmt.R.attr.contentInsetLeft, com.android.mmt.R.attr.contentInsetRight, com.android.mmt.R.attr.contentInsetStart, com.android.mmt.R.attr.contentInsetStartWithNavigation, com.android.mmt.R.attr.logo, com.android.mmt.R.attr.logoDescription, com.android.mmt.R.attr.maxButtonHeight, com.android.mmt.R.attr.menu, com.android.mmt.R.attr.navigationContentDescription, com.android.mmt.R.attr.navigationIcon, com.android.mmt.R.attr.popupTheme, com.android.mmt.R.attr.subtitle, com.android.mmt.R.attr.subtitleTextAppearance, com.android.mmt.R.attr.subtitleTextColor, com.android.mmt.R.attr.title, com.android.mmt.R.attr.titleMargin, com.android.mmt.R.attr.titleMarginBottom, com.android.mmt.R.attr.titleMarginEnd, com.android.mmt.R.attr.titleMarginStart, com.android.mmt.R.attr.titleMarginTop, com.android.mmt.R.attr.titleMargins, com.android.mmt.R.attr.titleTextAppearance, com.android.mmt.R.attr.titleTextColor};

    /* renamed from: D, reason: collision with root package name */
    public static final int[] f2086D = {R.attr.theme, R.attr.focusable, com.android.mmt.R.attr.paddingEnd, com.android.mmt.R.attr.paddingStart, com.android.mmt.R.attr.theme};

    /* renamed from: E, reason: collision with root package name */
    public static final int[] f2087E = {R.attr.background, com.android.mmt.R.attr.backgroundTint, com.android.mmt.R.attr.backgroundTintMode};

    /* renamed from: F, reason: collision with root package name */
    public static final int[] f2088F = {R.attr.id, R.attr.layout, R.attr.inflatedId};

    /* renamed from: G, reason: collision with root package name */
    public static final int[] f2089G = {com.android.mmt.R.attr.hasMore};

    /* renamed from: H, reason: collision with root package name */
    public static final int[] f2090H = {com.android.mmt.R.attr.duration, com.android.mmt.R.attr.expandable};

    /* renamed from: I, reason: collision with root package name */
    public static final int[] f2091I = {com.android.mmt.R.attr.gradient_endColor, com.android.mmt.R.attr.gradient_startColor};

    /* renamed from: J, reason: collision with root package name */
    public static final int[] f2092J = {com.android.mmt.R.attr.defaultColor, com.android.mmt.R.attr.indicatorColor, com.android.mmt.R.attr.indicatorMaxHeight, com.android.mmt.R.attr.indicatorNum, com.android.mmt.R.attr.indicatorWidth, com.android.mmt.R.attr.interval};

    /* renamed from: K, reason: collision with root package name */
    public static final int[] f2093K = {com.android.mmt.R.attr.left_bottom_radius, com.android.mmt.R.attr.left_top_radius, com.android.mmt.R.attr.radius, com.android.mmt.R.attr.right_bottom_radius, com.android.mmt.R.attr.right_top_radius};
    public static final int[] L = {com.android.mmt.R.attr.horizontalSpacing, com.android.mmt.R.attr.verticalSpacing};
    public static final int[] M = {com.android.mmt.R.attr.shrinkableIndex};

    /* renamed from: N, reason: collision with root package name */
    public static final int[] f2094N = {com.android.mmt.R.attr.checkMarkCompat};

    /* renamed from: O, reason: collision with root package name */
    public static final int[] f2095O = {com.android.mmt.R.attr.textHandleAndCursorColor};
    public static final int[] P = {R.attr.radius, R.attr.topLeftRadius, R.attr.topRightRadius, R.attr.bottomLeftRadius, R.attr.bottomRightRadius, R.attr.layerType, com.android.mmt.R.attr.miuix_strokeColor, com.android.mmt.R.attr.miuix_strokeWidth};

    /* renamed from: Q, reason: collision with root package name */
    public static final int[] f2096Q = {R.attr.radius, R.attr.topLeftRadius, R.attr.topRightRadius, R.attr.bottomLeftRadius, R.attr.bottomRightRadius, R.attr.layerType, com.android.mmt.R.attr.miuix_strokeColor, com.android.mmt.R.attr.miuix_strokeWidth};

    /* renamed from: R, reason: collision with root package name */
    public static final int[] f2097R = {R.attr.layerType, com.android.mmt.R.attr.miuix_strokeColor, com.android.mmt.R.attr.miuix_strokeWidth};

    /* renamed from: S, reason: collision with root package name */
    public static final int[] f2098S = {R.attr.icon, R.attr.background, R.attr.maxHeight, R.attr.divider, R.attr.height, R.attr.title, R.attr.logo, R.attr.navigationMode, R.attr.displayOptions, R.attr.subtitle, R.attr.customNavigationLayout, R.attr.titleTextStyle, R.attr.subtitleTextStyle, R.attr.progressBarPadding, R.attr.homeLayout, R.attr.itemPadding, R.attr.backgroundStacked, R.attr.backgroundSplit, com.android.mmt.R.attr.actionBarEmbededTabsBackground, com.android.mmt.R.attr.actionBarStackedBackground, com.android.mmt.R.attr.background, com.android.mmt.R.attr.backgroundSplit, com.android.mmt.R.attr.backgroundStacked, com.android.mmt.R.attr.contentInsetEnd, com.android.mmt.R.attr.contentInsetEndWithActions, com.android.mmt.R.attr.contentInsetLeft, com.android.mmt.R.attr.contentInsetRight, com.android.mmt.R.attr.contentInsetStart, com.android.mmt.R.attr.contentInsetStartWithNavigation, com.android.mmt.R.attr.customNavigationLayout, com.android.mmt.R.attr.customViewAutoFitSystemWindow, com.android.mmt.R.attr.displayOptions, com.android.mmt.R.attr.divider, com.android.mmt.R.attr.elevation, com.android.mmt.R.attr.expandState, com.android.mmt.R.attr.expandSubtitleTextStyle, com.android.mmt.R.attr.expandTitleTextStyle, com.android.mmt.R.attr.height, com.android.mmt.R.attr.hideOnContentScroll, com.android.mmt.R.attr.homeAsUpIndicator, com.android.mmt.R.attr.homeLayout, com.android.mmt.R.attr.icon, com.android.mmt.R.attr.indeterminateProgressStyle, com.android.mmt.R.attr.itemPadding, com.android.mmt.R.attr.logo, com.android.mmt.R.attr.navigationMode, com.android.mmt.R.attr.popupTheme, com.android.mmt.R.attr.progressBarPadding, com.android.mmt.R.attr.progressBarStyle, com.android.mmt.R.attr.resizable, com.android.mmt.R.attr.subtitle, com.android.mmt.R.attr.subtitleTextStyle, com.android.mmt.R.attr.tabIndicator, com.android.mmt.R.attr.title, com.android.mmt.R.attr.titleCenter, com.android.mmt.R.attr.titleTextStyle, com.android.mmt.R.attr.translucentTabIndicator};

    /* renamed from: T, reason: collision with root package name */
    public static final int[] f2099T = {com.android.mmt.R.attr.overScrollRange, com.android.mmt.R.attr.scrollRange, com.android.mmt.R.attr.scrollStart};

    /* renamed from: U, reason: collision with root package name */
    public static final int[] f2100U = {R.attr.background, R.attr.height, R.attr.titleTextStyle, R.attr.subtitleTextStyle, R.attr.backgroundSplit, com.android.mmt.R.attr.actionModeAnim, com.android.mmt.R.attr.background, com.android.mmt.R.attr.backgroundSplit, com.android.mmt.R.attr.closeItemLayout, com.android.mmt.R.attr.expandTitleTextStyle, com.android.mmt.R.attr.height, com.android.mmt.R.attr.subtitleTextStyle, com.android.mmt.R.attr.titleTextStyle};

    /* renamed from: V, reason: collision with root package name */
    public static final int[] f2101V = {R.attr.layout, com.android.mmt.R.attr.buttonIconDimen, com.android.mmt.R.attr.buttonPanelSideLayout, com.android.mmt.R.attr.horizontalProgressLayout, com.android.mmt.R.attr.layout, com.android.mmt.R.attr.listItemLayout, com.android.mmt.R.attr.listLayout, com.android.mmt.R.attr.multiChoiceItemLayout, com.android.mmt.R.attr.progressLayout, com.android.mmt.R.attr.showTitle, com.android.mmt.R.attr.singleChoiceItemLayout};

    /* renamed from: W, reason: collision with root package name */
    public static final int[] f2102W = {com.android.mmt.R.attr.checkwidget_backgroundDisableAlpha, com.android.mmt.R.attr.checkwidget_backgroundNormalAlpha, com.android.mmt.R.attr.checkwidget_checkOnAlphaBackgroundColor, com.android.mmt.R.attr.checkwidget_checkOnBackgroundColor, com.android.mmt.R.attr.checkwidget_checkOnForegroundColor, com.android.mmt.R.attr.checkwidget_disableBackgroundColor, com.android.mmt.R.attr.checkwidget_strokeColor, com.android.mmt.R.attr.checkwidget_strokeDisableAlpha, com.android.mmt.R.attr.checkwidget_strokeNormalAlpha, com.android.mmt.R.attr.checkwidget_touchAnimEnable};

    /* renamed from: X, reason: collision with root package name */
    public static final int[] f2103X = {com.android.mmt.R.attr.miuixSelectGroupButtonBackground, com.android.mmt.R.attr.primaryButton};

    /* renamed from: Y, reason: collision with root package name */
    public static final int[] f2104Y = {R.attr.windowAnimationStyle, R.attr.itemTextAppearance, R.attr.horizontalDivider, R.attr.verticalDivider, R.attr.headerBackground, R.attr.itemBackground, R.attr.itemIconDisabledAlpha, com.android.mmt.R.attr.preserveIconSpacing, com.android.mmt.R.attr.subMenuArrow};

    /* renamed from: Z, reason: collision with root package name */
    public static final int[] f2105Z = {R.attr.text, R.attr.drawableTop};

    /* renamed from: a0, reason: collision with root package name */
    public static final int[] f2107a0 = {R.attr.entries, R.attr.popupBackground, R.attr.prompt, R.attr.dropDownWidth, com.android.mmt.R.attr.dropDownMaxWidth, com.android.mmt.R.attr.dropDownMinWidth, com.android.mmt.R.attr.popupTheme, com.android.mmt.R.attr.spinnerModeCompat};

    /* renamed from: b0, reason: collision with root package name */
    public static final int[] f2109b0 = {com.android.mmt.R.attr.contentAutoFitSystemWindow, com.android.mmt.R.attr.contentHeaderBackground, com.android.mmt.R.attr.contextMenuSeparateItemBackground, com.android.mmt.R.attr.immersionButtonMoreBackground, com.android.mmt.R.attr.immersionMenuEnabled, com.android.mmt.R.attr.immersionMenuLayout, com.android.mmt.R.attr.immersionTextColor, com.android.mmt.R.attr.immersionViewItemBackground, com.android.mmt.R.attr.immersionWindowBackground, com.android.mmt.R.attr.startingWindowOverlay, com.android.mmt.R.attr.windowActionBar, com.android.mmt.R.attr.windowActionBarMovable, com.android.mmt.R.attr.windowActionBarOverlay, com.android.mmt.R.attr.windowDisablePreview, com.android.mmt.R.attr.windowExtraPaddingHorizontal, com.android.mmt.R.attr.windowExtraPaddingHorizontalEnable, com.android.mmt.R.attr.windowFixedHeightMajor, com.android.mmt.R.attr.windowFixedHeightMinor, com.android.mmt.R.attr.windowFixedWidthMajor, com.android.mmt.R.attr.windowFixedWidthMinor, com.android.mmt.R.attr.windowFloating, com.android.mmt.R.attr.windowLayoutMode, com.android.mmt.R.attr.windowMaxHeightMajor, com.android.mmt.R.attr.windowMaxHeightMinor, com.android.mmt.R.attr.windowMaxWidthMajor, com.android.mmt.R.attr.windowMaxWidthMinor, com.android.mmt.R.attr.windowSplitActionBar, com.android.mmt.R.attr.windowTranslucentStatus};

    /* renamed from: c0, reason: collision with root package name */
    public static final int[] f2111c0 = {R.attr.orientation, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, com.android.mmt.R.attr.barrierAllowsGoneWidgets, com.android.mmt.R.attr.barrierDirection, com.android.mmt.R.attr.chainUseRtl, com.android.mmt.R.attr.constraintSet, com.android.mmt.R.attr.constraint_referenced_ids, com.android.mmt.R.attr.layout_constrainedHeight, com.android.mmt.R.attr.layout_constrainedWidth, com.android.mmt.R.attr.layout_constraintBaseline_creator, com.android.mmt.R.attr.layout_constraintBaseline_toBaselineOf, com.android.mmt.R.attr.layout_constraintBottom_creator, com.android.mmt.R.attr.layout_constraintBottom_toBottomOf, com.android.mmt.R.attr.layout_constraintBottom_toTopOf, com.android.mmt.R.attr.layout_constraintCircle, com.android.mmt.R.attr.layout_constraintCircleAngle, com.android.mmt.R.attr.layout_constraintCircleRadius, com.android.mmt.R.attr.layout_constraintDimensionRatio, com.android.mmt.R.attr.layout_constraintEnd_toEndOf, com.android.mmt.R.attr.layout_constraintEnd_toStartOf, com.android.mmt.R.attr.layout_constraintGuide_begin, com.android.mmt.R.attr.layout_constraintGuide_end, com.android.mmt.R.attr.layout_constraintGuide_percent, com.android.mmt.R.attr.layout_constraintHeight_default, com.android.mmt.R.attr.layout_constraintHeight_max, com.android.mmt.R.attr.layout_constraintHeight_min, com.android.mmt.R.attr.layout_constraintHeight_percent, com.android.mmt.R.attr.layout_constraintHorizontal_bias, com.android.mmt.R.attr.layout_constraintHorizontal_chainStyle, com.android.mmt.R.attr.layout_constraintHorizontal_weight, com.android.mmt.R.attr.layout_constraintLeft_creator, com.android.mmt.R.attr.layout_constraintLeft_toLeftOf, com.android.mmt.R.attr.layout_constraintLeft_toRightOf, com.android.mmt.R.attr.layout_constraintRight_creator, com.android.mmt.R.attr.layout_constraintRight_toLeftOf, com.android.mmt.R.attr.layout_constraintRight_toRightOf, com.android.mmt.R.attr.layout_constraintStart_toEndOf, com.android.mmt.R.attr.layout_constraintStart_toStartOf, com.android.mmt.R.attr.layout_constraintTop_creator, com.android.mmt.R.attr.layout_constraintTop_toBottomOf, com.android.mmt.R.attr.layout_constraintTop_toTopOf, com.android.mmt.R.attr.layout_constraintVertical_bias, com.android.mmt.R.attr.layout_constraintVertical_chainStyle, com.android.mmt.R.attr.layout_constraintVertical_weight, com.android.mmt.R.attr.layout_constraintWidth_default, com.android.mmt.R.attr.layout_constraintWidth_max, com.android.mmt.R.attr.layout_constraintWidth_min, com.android.mmt.R.attr.layout_constraintWidth_percent, com.android.mmt.R.attr.layout_editor_absoluteX, com.android.mmt.R.attr.layout_editor_absoluteY, com.android.mmt.R.attr.layout_goneMarginBottom, com.android.mmt.R.attr.layout_goneMarginEnd, com.android.mmt.R.attr.layout_goneMarginLeft, com.android.mmt.R.attr.layout_goneMarginRight, com.android.mmt.R.attr.layout_goneMarginStart, com.android.mmt.R.attr.layout_goneMarginTop, com.android.mmt.R.attr.layout_optimizationLevel};

    /* renamed from: d0, reason: collision with root package name */
    public static final int[] f2112d0 = {R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, com.android.mmt.R.attr.barrierAllowsGoneWidgets, com.android.mmt.R.attr.barrierDirection, com.android.mmt.R.attr.chainUseRtl, com.android.mmt.R.attr.constraint_referenced_ids, com.android.mmt.R.attr.layout_constrainedHeight, com.android.mmt.R.attr.layout_constrainedWidth, com.android.mmt.R.attr.layout_constraintBaseline_creator, com.android.mmt.R.attr.layout_constraintBaseline_toBaselineOf, com.android.mmt.R.attr.layout_constraintBottom_creator, com.android.mmt.R.attr.layout_constraintBottom_toBottomOf, com.android.mmt.R.attr.layout_constraintBottom_toTopOf, com.android.mmt.R.attr.layout_constraintCircle, com.android.mmt.R.attr.layout_constraintCircleAngle, com.android.mmt.R.attr.layout_constraintCircleRadius, com.android.mmt.R.attr.layout_constraintDimensionRatio, com.android.mmt.R.attr.layout_constraintEnd_toEndOf, com.android.mmt.R.attr.layout_constraintEnd_toStartOf, com.android.mmt.R.attr.layout_constraintGuide_begin, com.android.mmt.R.attr.layout_constraintGuide_end, com.android.mmt.R.attr.layout_constraintGuide_percent, com.android.mmt.R.attr.layout_constraintHeight_default, com.android.mmt.R.attr.layout_constraintHeight_max, com.android.mmt.R.attr.layout_constraintHeight_min, com.android.mmt.R.attr.layout_constraintHeight_percent, com.android.mmt.R.attr.layout_constraintHorizontal_bias, com.android.mmt.R.attr.layout_constraintHorizontal_chainStyle, com.android.mmt.R.attr.layout_constraintHorizontal_weight, com.android.mmt.R.attr.layout_constraintLeft_creator, com.android.mmt.R.attr.layout_constraintLeft_toLeftOf, com.android.mmt.R.attr.layout_constraintLeft_toRightOf, com.android.mmt.R.attr.layout_constraintRight_creator, com.android.mmt.R.attr.layout_constraintRight_toLeftOf, com.android.mmt.R.attr.layout_constraintRight_toRightOf, com.android.mmt.R.attr.layout_constraintStart_toEndOf, com.android.mmt.R.attr.layout_constraintStart_toStartOf, com.android.mmt.R.attr.layout_constraintTop_creator, com.android.mmt.R.attr.layout_constraintTop_toBottomOf, com.android.mmt.R.attr.layout_constraintTop_toTopOf, com.android.mmt.R.attr.layout_constraintVertical_bias, com.android.mmt.R.attr.layout_constraintVertical_chainStyle, com.android.mmt.R.attr.layout_constraintVertical_weight, com.android.mmt.R.attr.layout_constraintWidth_default, com.android.mmt.R.attr.layout_constraintWidth_max, com.android.mmt.R.attr.layout_constraintWidth_min, com.android.mmt.R.attr.layout_constraintWidth_percent, com.android.mmt.R.attr.layout_editor_absoluteX, com.android.mmt.R.attr.layout_editor_absoluteY, com.android.mmt.R.attr.layout_goneMarginBottom, com.android.mmt.R.attr.layout_goneMarginEnd, com.android.mmt.R.attr.layout_goneMarginLeft, com.android.mmt.R.attr.layout_goneMarginRight, com.android.mmt.R.attr.layout_goneMarginStart, com.android.mmt.R.attr.layout_goneMarginTop};

    public static void a(Throwable th, Throwable th2) {
        c.d(th, "<this>");
        c.d(th2, "exception");
        if (th != th2) {
            b.f4378a.a(th, th2);
        }
    }

    public static void b(StringBuilder sb, int i2) {
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append("?");
            if (i4 < i2 - 1) {
                sb.append(",");
            }
        }
    }

    public static void c(String str, Object... objArr) {
        Log.d("Mms", h(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        Log.e("Mms", h(str, objArr));
    }

    public static void e(TextView textView, TextView textView2) {
        if (C0384b.j("IN") || C0384b.j("ID")) {
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView2 != null) {
                textView2.setText(C0384b.j("IN") ? com.android.mmt.R.string.recommend_tip_9 : com.android.mmt.R.string.recommend_tip_8);
                textView2.setPadding(textView2.getPaddingLeft(), 0, textView2.getPaddingRight(), textView2.getPaddingBottom());
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (textView2 != null) {
            textView2.setText(com.android.mmt.R.string.recommend_tip_9_2);
            textView2.setPadding(textView2.getPaddingLeft(), textView2.getContext().getResources().getDimensionPixelSize(com.android.mmt.R.dimen.recommend_message_padding_top), textView2.getPaddingRight(), textView2.getPaddingBottom());
        }
    }

    public static Object f(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean g(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static String h(String str, Object... objArr) {
        String strB;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (objArr[i2] instanceof String[]) {
                String[] strArr = (String[]) objArr[i2];
                if (strArr.length == 0) {
                    strB = "[]";
                } else {
                    StringBuilder sb = new StringBuilder("[");
                    int length = strArr.length - 1;
                    for (int i4 = 0; i4 < length; i4++) {
                        sb.append(strArr[i4]);
                        sb.append(", ");
                    }
                    strB = C2.c.b(sb, strArr[length], "]");
                }
                objArr[i2] = strB;
            }
        }
        return String.format(str, objArr);
    }

    public static final boolean i(String str) {
        c.d(str, "method");
        return (c.a(str, "GET") || c.a(str, "HEAD")) ? false : true;
    }

    public static final int j(v vVar, int i2) {
        int i4;
        c.d(vVar, "<this>");
        int[] iArrS = vVar.s();
        int i5 = i2 + 1;
        int length = vVar.t().length;
        c.d(iArrS, "<this>");
        int i6 = length - 1;
        int i7 = 0;
        while (true) {
            if (i7 <= i6) {
                i4 = (i7 + i6) >>> 1;
                int i8 = iArrS[i4];
                if (i8 >= i5) {
                    if (i8 <= i5) {
                        break;
                    }
                    i6 = i4 - 1;
                } else {
                    i7 = i4 + 1;
                }
            } else {
                i4 = (-i7) - 1;
                break;
            }
        }
        return i4 >= 0 ? i4 : ~i4;
    }

    public static void k(String str, Object... objArr) {
        Log.v("Mms", h(str, objArr));
    }

    public static void l(String str, Object... objArr) {
        Log.w("Mms", h(str, objArr));
    }

    public static void m(String str) {
        Log.e("Mms", e.c("WARNING!!!! ", str), new RuntimeException());
    }
}
