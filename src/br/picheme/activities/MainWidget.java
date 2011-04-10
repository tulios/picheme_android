package br.picheme.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import br.picheme.R;

public class MainWidget extends TabActivity {
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    Resources res = getApplicationContext().getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec = null;  // Resusable TabSpec for each tab
	    Intent intent = null;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, MurosListActivity.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("muros").
	    			   setIndicator("Muros", res.getDrawable(R.drawable.ic_menu_dialog)).
	    			   setContent(intent);
	    
	    tabHost.addTab(spec);

	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, ConfigActivity.class);
	    spec = tabHost.newTabSpec("configs").
	    			   setIndicator("Configurações", res.getDrawable(R.drawable.ic_menu_settings))
	                  .setContent(intent);
	    
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);
	}
	
}
