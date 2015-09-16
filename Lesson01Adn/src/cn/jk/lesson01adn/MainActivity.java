package cn.jk.lesson01adn;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	 private TextView allNetWork;    
     private Button scan;    
     private Button start;    
     private Button stop;    
     private Button check;    
     private WifiAdmin mWifiAdmin;    
     // 扫描结果列表    
     private List<ScanResult> list;    
     private ScanResult mScanResult;    
     private StringBuffer sb=new StringBuffer();    
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jk01 = "hello_JK";
        System.out.println(jk01);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
