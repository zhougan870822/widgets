# widgets
android 常用的一些组件的自定义实现
ListView 的BaseListAdapter,SimpleListAdapter,
RecycleView的BaseRecyclerAdapter(可以上拉加载更多),
自定义RecycleView的分割线DividerItem


用发:

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.zhougan870822:widgets:tag'
	}
