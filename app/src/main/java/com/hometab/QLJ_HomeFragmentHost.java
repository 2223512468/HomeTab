package com.hometab;




import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class QLJ_HomeFragmentHost extends FragmentActivity implements OnCheckedChangeListener {
	private FragmentTabHost mTabHost;
	private RadioGroup radioGroup;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		InitView();
	}
	
	private void InitView() {
		// TODO Auto-generated method stub
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
		mTabHost.getTabWidget().setVisibility(View.GONE);	//����ϵͳ��TabWidget
		
		mTabHost.addTab(mTabHost.newTabSpec("monitor").setIndicator("Home"),
				QLJ_Monitor_Fragment.class, null);

		mTabHost.addTab(mTabHost.newTabSpec("index").setIndicator("Message"),
				QLJ_Index_Fragment.class, null);
		
		mTabHost.addTab(mTabHost.newTabSpec("solution").setIndicator("Profile"),
				QLJ_Solution_Fragment.class, null);

		mTabHost.addTab(mTabHost.newTabSpec("expert").setIndicator("Square"),
				QLJ_Expert_Online_Fragment.class, null);

		mTabHost.addTab(mTabHost.newTabSpec("query").setIndicator("More"),
				QLJ_Query_Fragment.class, null);
		
		mTabHost.addTab(mTabHost.newTabSpec("more").setIndicator("More"),
				QLJ_More_Fragment.class, null);

//		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTabByTag("index");
		((RadioButton) findViewById(R.id.radio_index)).setChecked(true);  
        
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);  
        radioGroup.setOnCheckedChangeListener(this);
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		FragmentManager fm = getSupportFragmentManager();
		QLJ_Index_Fragment index = (QLJ_Index_Fragment) fm.findFragmentByTag("index");
		QLJ_Monitor_Fragment monitor = (QLJ_Monitor_Fragment) fm.findFragmentByTag("monitor");
		QLJ_Solution_Fragment solution = (QLJ_Solution_Fragment) fm.findFragmentByTag("solution");
		QLJ_Expert_Online_Fragment expert = (QLJ_Expert_Online_Fragment) fm.findFragmentByTag("expert");
		QLJ_Query_Fragment query = (QLJ_Query_Fragment) fm.findFragmentByTag("query");
		QLJ_More_Fragment more = (QLJ_More_Fragment) fm.findFragmentByTag("more");

		FragmentTransaction ft = fm.beginTransaction();

		//** Detaches the androidfragment if exists */
		if (index != null)
			ft.detach(index);
		if (monitor != null)
			ft.detach(monitor);
		if (solution != null)
			ft.detach(solution);
		if (expert != null)
			ft.detach(expert);
		if (query != null)
			ft.detach(query);
		if (more != null)
			ft.detach(more);
		
		switch (checkedId) {  
        case R.id.radio_index:  
        	if (index == null) {
				ft.add(android.R.id.tabcontent, new QLJ_Index_Fragment(), "index");
			} else {
				ft.attach(index);
			}
        	mTabHost.setCurrentTabByTag("index");  
            break;  
        case R.id.radio_monotor:  
        	if (monitor == null) {
				ft.add(android.R.id.tabcontent, new QLJ_Monitor_Fragment(), "monitor");
			} else {
				ft.attach(monitor);
			}
        	mTabHost.setCurrentTabByTag("monitor");  
            break;  
        case R.id.radio_solution:  
        	if (solution == null) {
				ft.add(android.R.id.tabcontent, new QLJ_Solution_Fragment(), "solution");
			} else {
				ft.attach(solution);
			}
        	mTabHost.setCurrentTabByTag("solution");  
            break;  
        case R.id.radio_expertOnline:  
        	if (expert == null) {
				ft.add(android.R.id.tabcontent, new QLJ_Query_Fragment(), "expert");
			} else {
				ft.attach(expert);
			}
        	mTabHost.setCurrentTabByTag("expert");  
            break;  
        case R.id.radio_query:  
        	if (query == null) {
				ft.add(android.R.id.tabcontent, new QLJ_Query_Fragment(), "query");
			} else {
				ft.attach(query);
			}
        	mTabHost.setCurrentTabByTag("query");  
            break; 
        case R.id.radio_more:  
        	if (more == null) {
				ft.add(android.R.id.tabcontent, new QLJ_More_Fragment(), "more");
			} else {
				ft.attach(more);
			}
        	mTabHost.setCurrentTabByTag("more");  
            break; 
        }  
	}
}
