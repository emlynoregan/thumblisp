package com.emlynoregan.touchlisp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity 
{
	ListView _lvMain = null;
	PresAdapter _adapter = null;
	List<PresBase> _list = new ArrayList<PresBase>();
	PresList _data;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _lvMain = (ListView)findViewById(R.id.lvMain);
        
        //(define count (lambda (item L) (if L (+ (equal? item (first L)) (count item (rest L))) 0)))
        
        _data = new PresList(false);
        _data.add(new PresSymbol("define"));
        _data.add(new PresSymbol("count"));
        	PresList _subList1 = new PresList(false);
    		_subList1.add(new PresSymbol("lambda"));
        		PresList _subList2 = new PresList(false);
        		_subList2.add(new PresSymbol("item"));
        		_subList2.add(new PresSymbol("L"));
        	_subList1.add(_subList2);
	    		_subList2 = new PresList(false);
	    		_subList2.add(new PresSymbol("if"));
	    		_subList2.add(new PresSymbol("L"));
	    			PresList _subList3 = new PresList(false);
	    			_subList3.add(new PresSymbol("+"));
	    				PresList _subList4 = new PresList(false);
	    				_subList4.add(new PresSymbol("equal?"));
	    				_subList4.add(new PresSymbol("item"));
	    					PresList _subList5 = new PresList(false);
	    					_subList5.add(new PresSymbol("first"));
	    					_subList5.add(new PresSymbol("L"));
	    				_subList4.add(_subList5);
	    			_subList3.add(_subList4);
	    				_subList4 = new PresList(false);
	    				_subList4.add(new PresSymbol("count"));
	    				_subList4.add(new PresSymbol("item"));
	    					_subList5 = new PresList(false);
	    					_subList5.add(new PresSymbol("rest"));
	    					_subList5.add(new PresSymbol("L"));
		    			_subList4.add(_subList5);
		    		_subList3.add(_subList4);
		    	_subList2.add(_subList3);
	    		_subList2.add(new PresIntNumber(0));
		    _subList1.add(_subList2);
		_data.add(_subList1);
        
        DoUpdateActivity();
        
        OnItemClickListener llistener = new OnItemClickListener() 
        {
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) 
			{
				PresBase lelem = (PresBase)_lvMain.getItemAtPosition(position);
				
				if (lelem != null)
				{
					lelem.Click();
					DoUpdateActivity();
				}
			}
		};
		
		_lvMain.setOnItemClickListener(llistener);
    }

    @Override
    protected void onResume() 
    {
    	super.onResume();
    	
    	DoUpdateActivity();
    }
    
    
    void DoUpdateActivity()
    {
    	if (_adapter == null)
    	{
    		_adapter = new PresAdapter(this, _list);
    		
    		_lvMain.setAdapter(_adapter);
    	}
    	
    	// update the data array
    	_list.clear();
    	
    	UpdateList(_data);
    	
    	_adapter.notifyDataSetChanged();
    }

	private void UpdateList(PresList aDataList) 
	{
		if (aDataList != null)
		{
			_list.add(aDataList);
			if (aDataList.get_expanded())
			{
				for (PresBase ldataItem: aDataList)
				{
					if (ldataItem instanceof PresList)
					{
						UpdateList((PresList)ldataItem);
					}
					else
					{
						_list.add(ldataItem);
					}
				}
			}
		}
	}
}
