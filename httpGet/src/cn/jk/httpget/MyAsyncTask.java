package cn.jk.httpget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;

public class MyAsyncTask extends AsyncTask<String, Void, byte[]> {
	private ImageView imageView;
	public  byte[] image = new byte[]{};
	
	
	public MyAsyncTask(ImageView imageView){
		this.imageView = imageView;
	}
	
	@SuppressWarnings("null")
	@Override
	protected byte[] doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		
		String urlSrc = arg0[0];
		
		if(urlSrc.endsWith("jpg")||urlSrc.endsWith("png")){
			
			HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(urlSrc);
            HttpResponse httpResponse;
			try {
				 httpResponse = httpClient.execute(httpGet);
				 HttpEntity httpEntity = httpResponse.getEntity();
		            if(httpEntity != null && httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
		            {
		                image = EntityUtils.toByteArray(httpEntity);
		            }
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally
            {
                httpClient.getConnectionManager().shutdown();
            }
			
			return image;
           
		}else{
			     
			try {
				URL url = new URL(urlSrc);
			     System.out.println(urlSrc);
				URLConnection urlConnection = url
						.openConnection();
				InputStream is = urlConnection
						.getInputStream();
				InputStreamReader isr = new InputStreamReader(
						is, "utf-8");
				BufferedReader btr = new BufferedReader(isr);
				String line;
				while ((line = btr.readLine()) != null) {
					System.out.println(line);
					image=line.getBytes();
				}
				
				

				btr.close();
				isr.close();
				is.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return image;
	}
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		System.out.println("do onPreExecute");
		super.onPreExecute();
	}
	
	
	@Override
	protected void onPostExecute(byte[] result) {
		// TODO Auto-generated method stub
		System.out.println("do onPostExecute");
		super.onPostExecute(result);
		 Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
         //    �������ǵ�ImageView�ؼ�
		 
         imageView.setImageBitmap(bitmap);
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
		
		System.out.println("do onProgressUpdate");
	}

}