package qinchenpu.leetcode.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMethod1();
		testMethod2();
		testMethod3();
		testMethod4();
		testMethod5();
		testMethod6();
		
		List<String> list = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		Byte aByte = 100;

	}

	private static void testMethod1() {
		Integer integerA = new Integer(100);
		Integer integerB = new Integer(100);
		System.out.println(integerA == integerB);
	}

	private static void testMethod2() {
		Integer integerA = new Integer(100);
		int integerB = 100;
		System.out.println(integerA == integerB);
	}

	private static void testMethod3() {
		Integer integerA = 100;
		int integerB = 100;
		System.out.println(integerA == integerB);
	}

	private static void testMethod4() {
		Integer integerA = new Integer(100);;
		Integer integerB = 100;
		System.out.println(integerA == integerB);
	}

	private static void testMethod5() {
		Integer integerA = 100;
		Integer integerB = 100;
		System.out.println(integerA == integerB);
	}
	private static void testMethod6() {
		Integer integerA = 200;
		Integer integerB = 200;
		System.out.println(integerA == integerB);
	}

}
