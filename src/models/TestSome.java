package models;

import java.util.List;

public class TestSome {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		TestDao test = new TestDao();
		List<String> list = test.getCat();
		
		for(String i: list) {
			System.out.println(i);
		}
		
		
		//test.getResult("家電","炊飯器");
	}

}
