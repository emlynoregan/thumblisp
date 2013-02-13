package com.emlynoregan.touchlisp;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PresAdapter extends BaseAdapter
{
	LayoutInflater _inflater;
	List<PresBase> _list;

	public PresAdapter(Context aContext, List<PresBase> aList)
	{
		super();
        _inflater = LayoutInflater.from(aContext);
        _list = aList;
	}

	public int getCount() 
	{
		return _list.size();
	}

	public Object getItem(int arg0) 
	{
		return _list.get(arg0);
	}

	public long getItemId(int position) 
	{
		return _list.get(position).get_id();
	}
	
	@Override
	public boolean hasStableIds() 
	{
		return true;
	}
	
	@Override
	public int getViewTypeCount() 
	{
		return 5;
	}
	
	@Override
	public int getItemViewType(int position) 
	{
		return _list.get(position).get_ViewType();
	}

	public View getView(int position, View convertView, ViewGroup parent) 
	{
		// Get the element
		PresBase lelem = _list.get(position);

		// Inflate the layout if necessary
		if (convertView == null || convertView.getId() != lelem.get_layout())
		{
			convertView = _inflater.inflate(lelem.get_layout(), parent, false);
			convertView.setId(lelem.get_layout());
		}

		// ViewHolder pattern to speed up looking up elements in the view
		PresViewHolder lviewHolder = (PresViewHolder)convertView.getTag();
		
		if (lviewHolder == null)
		{
			lviewHolder = new PresViewHolder(convertView);
		}
		
		// Now actually update the view
		
		lelem.UpdateView(lviewHolder);
		
		return convertView;
	}

}
