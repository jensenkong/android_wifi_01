package cn.jk.httpget;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	 private ImageView imageView;
	 
	 private String urls = "http://fanyi.youdao.com/openapi.do?keyfrom=testapp1111&key=1442666767&type=data&doctype=json&version=1.1&q=new";
	// private String urls = "http://www.eptison.com/";
	 //private String urls = "https://gdp.alicdn.com/imgextra/i3/360260087/TB2zfnofXXXXXXZXpXXXXXXXXXX_!!360260087.jpg";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    imageView = (ImageView)findViewById(R.id.imageView);
		findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						new MyAsyncTask(imageView).execute(urls);
					}
				});
	}

}
