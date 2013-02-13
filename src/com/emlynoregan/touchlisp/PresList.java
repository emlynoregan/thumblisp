package com.emlynoregan.touchlisp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PresList extends PresBase implements List<PresBase>
{
	ArrayList<PresBase> _list = new ArrayList<PresBase>();
	Boolean _expanded;
	
	public PresList(Boolean aExpanded)
	{
		_expanded = aExpanded;
	}
	
	public PresList(Boolean aExpanded, PresNew aNew)
	{
		super(aNew);
		_expanded = aExpanded;
	}
	
	public Boolean get_expanded() {
		return _expanded;
	}

	public void set_expanded(Boolean _expanded) {
		this._expanded = _expanded;
	}

	public ArrayList<PresBase> get_list() {
		return _list;
	}

	public void set_list(ArrayList<PresBase> _list) {
		this._list = _list;
	}

	public boolean add(PresBase object) 
	{
		boolean retval = _list.add(object);
		if (retval)
			object.set_parent(this);
		return retval;
	}

	public void add(int location, PresBase object) 
	{
		_list.add(location, object);
		object.set_parent(this);
	}

	public boolean addAll(Collection<? extends PresBase> arg0) 
	{
		boolean retval = _list.addAll(arg0);
		if (retval)
			for (PresBase elem : arg0)
				elem.set_parent(this);
		return retval;
	}

	public boolean addAll(int arg0, Collection<? extends PresBase> arg1) 
	{
		boolean retval = _list.addAll(arg0, arg1);
		if (retval)
			for (PresBase elem : arg1)
				elem.set_parent(this);
		return retval;
	}

	public void clear() 
	{
		for (PresBase elem : _list)
		{
			elem.set_parent(null);
		}
		_list.clear();
	}

	public boolean contains(Object object) 
	{
		return _list.contains(object);
	}

	public boolean containsAll(Collection<?> arg0) 
	{
		return _list.containsAll(arg0);
	}

	public PresBase get(int location) 
	{
		return _list.get(location);
	}

	public int indexOf(Object object) 
	{
		return _list.indexOf(object);
	}

	public boolean isEmpty() 
	{
		return _list.isEmpty();
	}

	public Iterator<PresBase> iterator() 
	{
		return _list.iterator();
	}

	public int lastIndexOf(Object object) 
	{
		return _list.lastIndexOf(object);
	}

	public ListIterator<PresBase> listIterator() 
	{
		return _list.listIterator();
	}

	public ListIterator<PresBase> listIterator(int location) 
	{
		return _list.listIterator(location);
	}

	public PresBase remove(int location) 
	{
		PresBase retval = _list.remove(location);
		if (retval != null)
			retval.set_parent(null);
		return retval;
	}

	public boolean remove(Object object) 
	{
		boolean retval;

		if (object instanceof PresBase)
		{
			PresBase elem = (PresBase)object;
			elem.set_parent(null);
		}
		retval = _list.remove(object);
		
		return retval;
	}

	public boolean removeAll(Collection<?> arg0) 
	{
		boolean retval;

		if (arg0 != null)
		{
			for (Object object: arg0)
			{
				if (object instanceof PresBase)
				{
					PresBase elem = (PresBase)object;
					elem.set_parent(null);
				}
			}
		}
		retval = _list.removeAll(arg0);
		
		return retval;
	}

	public boolean retainAll(Collection<?> arg0) 
	{
		boolean retval;

		for (PresBase elem : _list)
		{
			if (!arg0.contains(elem))
			{
				elem.set_parent(null);
			}
		}
		
		retval = _list.retainAll(arg0);
		
		return retval;
	}

	public PresBase set(int location, PresBase object) 
	{
		PresBase retval = _list.set(location, object);
		
		if (retval != null)
			retval.set_parent(this);
		
		return retval;
	}

	public int size() {
		return _list.size();
	}

	public List<PresBase> subList(int start, int end) 
	{
		return _list.subList(start, end);
	}

	public Object[] toArray() 
	{
		return _list.toArray();
	}

	public <T> T[] toArray(T[] array) 
	{
		return _list.toArray(array);
	}
	
	@Override
	public String toString() 
	{
		StringBuilder lout = new StringBuilder();
		
		lout.append("(");
		
		for (PresBase elem : _list)
		{
			if (lout.length() > 1)
				lout.append(" ");
			lout.append(elem.toString());
		}
		
		lout.append(")");
		
		return lout.toString();
	}

	@Override
	public int get_ViewType() 
	{
		return 3;
	}
	
	@Override
	public void Click() 
	{
		_expanded = !_expanded;
	}
}
