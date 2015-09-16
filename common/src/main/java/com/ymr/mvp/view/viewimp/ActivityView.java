package com.ymr.mvp.view.viewimp;

import android.app.Activity;
import android.content.Intent;

import com.ymr.common.ui.BaseUI;
import com.ymr.mvp.view.IView;

/**
 * Created by ymr on 15/9/16.
 */
public abstract class ActivityView<T extends Activity & BaseUI & IView> extends BaseView {

    private final T mView;

    public ActivityView(T iView) {
        super(iView);
        mView = iView;
    }

    @Override
    public boolean isCurrView() {
        return mView.isResume();
    }

    @Override
    public boolean exist() {
        return true;
    }

    @Override
    public Activity getActivity() {
        return mView;
    }

    @Override
    public void gotoActivity(Intent intent) {
        mView.startActivity(intent);
    }

}
