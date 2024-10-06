package com.example;

public class Person {
	// フィールド変数
	String name;
	int age;
	
	// 引数なしのコンストラクタ
	public Person() {
		this.name = "名無し";
		this.age = 0;
	}
	
	// 引数が2つのコンストラクタ
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void speak() {
		System.out.println(this.name + "さんの年齢は" + this.age + "歳です。");
	}
}
