package org.fengpiaohong.sudokugame;

import android.graphics.*;
import android.text.style.*;

public class FGC
{
	//ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
	private static final ForegroundColorSpan hong = new ForegroundColorSpan(Color.rgb(255, 0, 0));
	private static final ForegroundColorSpan lv = new ForegroundColorSpan(Color.rgb(0, 255, 0));
	private static final ForegroundColorSpan lan = new ForegroundColorSpan(Color.rgb(0, 0, 255));
	private static final ForegroundColorSpan cheng = new ForegroundColorSpan(Color.rgb(255, 153, 0));
	private static final ForegroundColorSpan huang = new ForegroundColorSpan(Color.rgb(255, 255, 0));
	private static final ForegroundColorSpan qing = new ForegroundColorSpan(Color.rgb(0, 176, 176));
	private static final ForegroundColorSpan zi = new ForegroundColorSpan(Color.rgb(255, 0, 255));
	private static final ForegroundColorSpan hui = new ForegroundColorSpan(Color.rgb(192, 192, 192));
	private static final ForegroundColorSpan hei = new ForegroundColorSpan(Color.rgb(0, 0, 0));

	public static ForegroundColorSpan get(int i)
	{
		ForegroundColorSpan tmp;
		switch (i)
		{
			case 1:
				tmp = getHong();
				break;
			case 2:
				tmp = getLv();
				break;
			case 3:
				tmp = getLan();
				break;
			case 4:
				tmp = getCheng();
				break;
			case 5:
				tmp = getHuang();
				break;
			case 6:
				tmp = getQing();
				break;
			case 7:
				tmp = getZi();
				break;
			case 8:
				tmp = getHui();
				break;
			case 9:
				tmp = getHei();
				break;
			default:
				tmp = getHei();
				break;
		}
		return tmp;
	}
	public static ForegroundColorSpan getHong()
	{return hong;}
	public static ForegroundColorSpan getLv()
	{return lv;}
	public static ForegroundColorSpan getLan()
	{return lan;}
	public static ForegroundColorSpan getCheng()
	{return cheng;}
	public static ForegroundColorSpan getHuang()
	{return huang;}
	public static ForegroundColorSpan getQing()
	{return qing;}
	public static ForegroundColorSpan getZi()
	{return zi;}
	public static ForegroundColorSpan getHui()
	{return hui;}
	public static ForegroundColorSpan getHei()
	{return hei;}

}
