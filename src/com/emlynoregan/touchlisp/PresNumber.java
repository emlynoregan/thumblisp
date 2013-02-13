package com.emlynoregan.touchlisp;

public class PresNumber extends PresBase 
{
	Double _numberValue;

	public PresNumber(double aNumberValue)
	{
		_numberValue = aNumberValue;
	}

	public PresNumber(double aNumberValue, PresNew aNew)
	{
		super(aNew);
		_numberValue = aNumberValue;
	}

	public double get_numberValue() {
		return _numberValue;
	}

	public void set_numberValue(double _numberValue) {
		this._numberValue = _numberValue;
	}
	
	@Override
	public String toString() 
	{
		return _numberValue.toString();
	}

	@Override
	public int get_ViewType() 
	{
		return 1;
	}
}
