package com.emlynoregan.touchlisp;

public class PresSymbol extends PresBase
{
	String _symbolName;

	public PresSymbol(String aSymbolName)
	{
		_symbolName = aSymbolName;
	}

	public PresSymbol(String aSymbolName, PresNew aNew)
	{
		super(aNew);
		_symbolName = aSymbolName;
	}

	public String get_symbolName() 
	{
		return _symbolName;
	}

	public void set_symbolName(String _symbolName) 
	{
		this._symbolName = _symbolName;
	}
	
	@Override
	public String toString() 
	{
		return _symbolName;
	}

	@Override
	public int get_ViewType() 
	{
		return 4;
	}
}
