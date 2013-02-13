package com.emlynoregan.touchlisp;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;

public abstract class PresBase 
{
	PresBase _parent = null;
	long _id = 0;

	static long _nextId = 0;
	
	public PresBase()
	{
        _id = _nextId++;
	}
	public PresBase(PresNew aNew)
	{
		_parent = aNew.get_parent();
        _id = _nextId++;
	}
	
	public long get_id()
	{
		return _id;
	}

	public Integer get_level()
	{
		Integer retval;
		
		if (_parent != null)
			retval = _parent.get_level() + 1;
		else
			retval = 0;
		
		return retval;
	}
	
	public PresBase get_parent() 
	{
		return _parent;
	}

	public void set_parent(PresBase _parent) 
	{
		this._parent = _parent;
	}

	@Override
	public String toString() 
	{
		return super.toString();
	}

	public abstract int get_ViewType();
	
	public int get_layout()
	{
		return R.layout.presitem;
	}
	
	public void UpdateView(PresViewHolder aViewHolder) 
	{
		aViewHolder.txtMain.setText(this.toString());

		int llevel = this.get_level();
		
	    MarginLayoutParams marginParams = new MarginLayoutParams(aViewHolder.txtMain.getLayoutParams());
	    marginParams.setMargins(llevel * 20, 0, 0, 0);
	    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
	    
	    aViewHolder.txtMain.setLayoutParams(layoutParams);	
	    
//	    int lcolor = (int) Math.floor(256 * 2 / Math.pow(3, llevel+1));
	    ((View)aViewHolder.txtMain.getParent()).setBackgroundColor((int)0xFFFFFFFF - llevel * 30);
	}
	
	public void Click() 
	{
		// default. Do nothing
	}
}
