package model;

public enum UserType {
	ADMIN("系统管理员",0);
	private int index;
	private String name;
	private UserType(String name,int index){
	this.name=name;
	this.index=index;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString(){
		return this.name;
	}

}
