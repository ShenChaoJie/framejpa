package org.frame.persistence.dao;

public abstract class TestAbstract extends Testabc {
    public int a;
	
	public TestAbstract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract void abc();
	
	public int def(){
		return this.b;
	}
	
}
class Testabc{
	public int b;
	
	public int def(){
		return 1;
	}
	
}

class Testmain extends TestAbstract{

	@Override
	public void abc() {
		// TODO Auto-generated method stub
		
	}
	
}
