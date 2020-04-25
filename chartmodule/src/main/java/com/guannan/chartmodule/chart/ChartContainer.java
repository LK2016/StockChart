package com.guannan.chartmodule.chart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.guannan.chartmodule.inter.ChartGestureListener;
import com.guannan.chartmodule.helper.ChartTouchHelper;
import com.guannan.chartmodule.inter.PressChangeListener;
import com.guannan.chartmodule.utils.DisplayUtils;

/**
 * @author guannan
 * @date on 2020-04-21 11:54
 * @des TODO
 */
public class ChartContainer extends LinearLayout implements ChartGestureListener {

  private Context mContext;

  private PressChangeListener mPressChangeListener;

  public ChartContainer(Context context) {
    this(context, null);
  }

  public ChartContainer(Context context,
      @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ChartContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.mContext = context;
    setOrientation(VERTICAL);
    setLayoutParams(
        new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    ChartTouchHelper chartTouchHelper = new ChartTouchHelper(this);
    chartTouchHelper.setChartGestureListener(this);
  }

  public void addChildChart(BaseChartView childView, float height) {
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            DisplayUtils.dip2px(mContext, height));
    addView(childView, params);
  }

  public void setPressChangeListener(PressChangeListener listener) {
    this.mPressChangeListener = listener;
  }

  @Override
  public void onChartGestureStart(MotionEvent me,
      ChartTouchHelper.ChartGesture lastPerformedGesture) {

  }

  @Override
  public void onChartGestureEnd(MotionEvent me,
      ChartTouchHelper.ChartGesture lastPerformedGesture) {

  }

  @Override
  public void onChartLongPressed(MotionEvent me) {

  }

  @Override
  public void onChartDoubleTapped(MotionEvent me) {

  }

  @Override
  public void onChartSingleTapped(MotionEvent me) {

  }

  @Override
  public void onChartFling(float distanceX) {
    if (mPressChangeListener != null) {
      mPressChangeListener.onChartFling(distanceX);
    }
  }

  @Override
  public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

  }

  @Override
  public void onChartTranslate(MotionEvent me, float dX) {
    if (mPressChangeListener != null) {
      mPressChangeListener.onChartTranslate(me, dX);
    }
  }
}
