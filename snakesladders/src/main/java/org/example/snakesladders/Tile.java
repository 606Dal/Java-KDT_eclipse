package org.example.snakesladders;

public class Tile {
	
	private int num;
    private String desc; // 타일 내용
    private String type; // 사다리 or 뱀
    private int moving;
    
	public Tile(int num, String desc, String type, int moving) {
		this.num = num;
		this.desc = desc;
		this.type = type;
		this.moving = moving;
	}

	public Tile(int num) {
		this.num = num;
	}

	// getter, setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMoving() {
		return moving;
	}

	public void setMoving(int moving) {
		this.moving = moving;
	}

	@Override
	public String toString() {
		return "Tile [num=" + num + ", desc=" + desc + ", type=" + type + ", moving=" + moving + "]";
	}
    

}
