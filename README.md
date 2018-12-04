# RxDatePicker

# RxDatePicker
安卓自定义DatePicker日期选择器
 
# 先上图
![22.gif](https://upload-images.jianshu.io/upload_images/10151120-278bae2f92f88e33.gif?imageMogr2/auto-orient/strip)
 
# 框架引入
### 先在 build.gradle(Project:XXXX) 的 repositories 添加:
~~~
repositories {
    maven {
        url "https://jitpack.io"
    }
}
~~~
### 然后在 build.gradle(Module:app) 的 dependencies 添加: 
~~~
dependencies {
	  implementation 'com.github.TaoPaox:RxDatePicker:1.2'
}

~~~
# 使用
~~~
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
 String mNow = sdf.format(new Date());
 mRxDatePicker1 = new RxDatePicker(this, new RxDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                mTvDate.setText(time.split(" ")[0]);
            }
        }, "2010-01-01 00:00", mNow); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        mRxDatePicker1.showSpecificTime(false); // 不显示时和分
        mRxDatePicker1.setIsLoop(false); // 不允许循环滚动
	mRxDatePicker1.show(mTvDate.getText().toString());
~~~
