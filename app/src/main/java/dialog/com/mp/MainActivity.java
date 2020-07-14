package dialog.com.mp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

/**
 * @author Gold Bean Lee
 * @time 20161202
 */
public class MainActivity extends Activity {

    private BarChart mBarChart;
    private BarChart mBarChart1;
    private BarChart mBarChart2;
    private BarCharts mBarCharts;

    private String[] color = {"#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBarCharts = new BarCharts();

        // 创建多张图表
        mBarChart = (BarChart) findViewById(R.id.spreadBarChart);
        mBarChart1 = (BarChart) findViewById(R.id.spreadBarChart1);
        mBarChart2 = (BarChart) findViewById(R.id.spreadBarChart2);

        mBarCharts.showBarChart(mBarChart, getBarData(10, 99), true);
        mBarCharts.showBarChart(mBarChart1, getBarData(20, 199), true);
        mBarCharts.showBarChart(mBarChart2, getBarData(20, 199), false);

    }

    /**
     * 这个方法是初始化数据的
     *
     * @param count X 轴的个数
     * @param range Y 轴的数据
     */
    public BarData getBarData(int count, float range) {
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            xValues.add("" + (i + 1) + "");// 设置每个柱壮图的文字描述
        }

        ArrayList<BarEntry> yValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float value = (float) (Math.random() * range/*100以内的随机数*/) + 3;
            yValues.add(new BarEntry(value, i));
        }
        // y轴的数据集合
        BarDataSet barDataSet = new BarDataSet(yValues, "测试图");
        ArrayList<Integer> colors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
//            colors.add(Color.parseColor("#75bfe2"));
            colors.add(Color.parseColor(color[i]));
        }
        barDataSet.setColors(colors);
        // 设置栏阴影颜色
        barDataSet.setBarShadowColor(Color.parseColor("#01000000"));
        ArrayList<BarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(barDataSet);
        barDataSet.setValueTextColor(Color.parseColor("#FF8F9D"));
        // 绘制值
        barDataSet.setDrawValues(true);
        BarData barData = new BarData(xValues, barDataSets);
        return barData;
    }

}
