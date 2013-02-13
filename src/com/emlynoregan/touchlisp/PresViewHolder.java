package com.emlynoregan.touchlisp;

import android.view.View;
import android.widget.TextView;

class PresViewHolder
{
	public TextView txtMain;

	public PresViewHolder(View convertView)
	{
		txtMain = (TextView)convertView.findViewById(R.id.txtMain);
		convertView.setTag(this);
	}
}

