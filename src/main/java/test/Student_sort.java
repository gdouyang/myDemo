package test;

import java.util.Arrays;

public class Student_sort implements Comparable<Student_sort> {
	int score;
	String name;

	Student_sort(String name, int score) {
		this.name = name;
		this.score = score;
		String s = "abc";
		s.compareTo("abc");
	}

	public static void main(String[] args) {
		Student_sort[] s = new Student_sort[10];// 多态
		s[0] = new Student_sort("A", 78);
		s[1] = new Student_sort("B", 33);
		s[2] = new Student_sort("C", 22);
		s[3] = new Student_sort("D", 68);
		s[4] = new Student_sort("E", 10);
		s[5] = new Student_sort("F", 79);
		s[6] = new Student_sort("G", 88);
		s[7] = new Student_sort("H", 100);
		s[8] = new Student_sort("I", 0);
		s[9] = new Student_sort("J", 11);
		// for (int i = 0; i < s.length; i++) {
		// for (int j = 0; j < s.length; j++) {
		// if (s[i].compareTo(s[j]) < 0) {
		// Student_sort ss = s[i];
		// s[i] = s[j];
		// s[j] = ss;
		// }
		// }
		// }
		Arrays.sort(s);

		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i].score + "姓名" + s[i].name);
		}
	}

	@Override
	public int compareTo(Student_sort s) {
		System.out.println("aaa");
		int boo = 0;
		if (this.score == s.score) {
			boo = 0;
		} else if (this.score < s.score) {
			boo = -1;
		} else if (this.score > s.score) {
			boo = 1;
		}
		return boo;
	}
}