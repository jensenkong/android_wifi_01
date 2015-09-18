package jk.cn.httppost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
  
	private Button btn;
	
	private String  urlScr = "http://www.eptison.com/";
	//private String  urlScr = "http://fanyi.youdao.com/openapi.do";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new Mylisener());
	}

    public class Mylisener implements OnClickListener{
    	
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		
    		new AsyncTask<String, Void, Void>() {

				@Override
				protected Void doInBackground(String... arg0) {
					// TODO Auto-generated method stub
					try {
						URL url = new URL(arg0[0]);
						HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
						httpConnection.setDoInput(true);
						httpConnection.setDoOutput(true);
						httpConnection.setRequestMethod("POST");
						//OutputStreamWriter oStreamWriter = new OutputStreamWriter(httpConnection.getOutputStream(),"utf-8");
					    //BufferedWriter bufferedWriter = new BufferedWriter(oStreamWriter);
					    //bufferedWriter.write("keyfrom=testapp1111&key=1442666767&type=data&doctype=json&version=1.1&q=new");
					   // bufferedWriter.flush();
					    InputStream is = httpConnection
								.getInputStream();
						InputStreamReader isr = new InputStreamReader(
								is, "utf-8");
						BufferedReader btr = new BufferedReader(isr);
						String line;
						while ((line = btr.readLine()) != null) {
							System.out.println(line);
						}
						btr.close();
						isr.close();
						is.close();
						
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return null;
				}
    			
			}.execute(urlScr);
    		
    	}
    }

	
}
