package com.wlj.date;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateTag extends TagSupport {

    private static final long serialVersionUID = 6464168398214506236L;

    private String value;

    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        long time = Long.valueOf(vv);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = dateformat.format(c.getTime());
        try {
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

}

//public class DateTag extends TagSupport {
//    //定义一个炒鸡长的大数，不知道干嘛的
//    private static final long serialVersionUID = 6464168398214506236L;
//    //定义一个值
//    private String value;
//
//    //重写一个方法
//    @Override
//    public int doStartTag() throws JspException {
//        //这部操作暂时没看懂。是一个强制类型转换？但是value本身就是个string啊。
//        String vv = "" + value;
//        //将String类型转换为long类型
//        long time = Long.valueOf(vv);
//        //定义一个日期类型（getInstance单例模式创建）
//        Calendar calendar = Calendar.getInstance();
//        //setTimeInMillis方法从给定的long值设置日历的当前时间。
//        calendar.setTimeInMillis(time);
//        //SimpleDateFormat设置出一个时间格式
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String s = dateFormat.format(calendar.getTime());
//        //定义一个"yyyy-MM-dd HH:mm:ss"格式的时间
//        try {
//            //继承JspException父类的方法。。在页面打印这个时间？
//            pageContext.getOut().write(s);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //这是一个返回自己的方法。
//        return super.doStartTag();
//
//
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//}
