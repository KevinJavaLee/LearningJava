package com.kevin.day13;

class Father {

	{
		System.out.println("22222222222");
	}
	static {
		System.out.println("11111111111");
	}


	//构造函数
	public Father() {
		System.out.println("33333333333");

	}

}

public class Son extends Father {
	static {
		System.out.println("44444444444");
	}
	{
		System.out.println("55555555555");
	}
	//构造函数
	public Son() {
		System.out.println("66666666666");
	}


	public static void main(String[] args) { // 由父及子 静态先行
		System.out.println("77777777777");
		System.out.println("************************");
		new Son();
		System.out.println("************************");

//		new Son();
//		System.out.println("************************");
//		new Father();
	}

}
