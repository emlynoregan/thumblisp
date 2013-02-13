package com.emlynoregan.touchlisp;

public class PresIntNumber extends PresNumber 
{
	Long _numberIntValue;
	
	public PresIntNumber(int aNumberValue)
	{
		super(0);
		_numberIntValue = (long) aNumberValue;
	}

	public PresIntNumber(Long aNumberValue)
	{
		super(0);
		_numberIntValue = aNumberValue;
	}

	public PresIntNumber(Long aNumberValue, PresNew aNew)
	{
		super(0, aNew);
		_numberIntValue = aNumberValue;
	}

	public double get_numberValue() {
		return _numberIntValue;
	}

	public void set_numberValue(double _numberValue) {
		this._numberIntValue = Math.round(_numberValue);
	}

	public Long get_numberIntValue() {
		return _numberIntValue;
	}

	public void set_numberIntValue(Long _numberIntValue) {
		this._numberIntValue = _numberIntValue;
	}
	
	@Override
	public String toString() 
	{
		return _numberIntValue.toString();
	}

	@Override
	public int get_ViewType() 
	{
		return 2;
	}
}
