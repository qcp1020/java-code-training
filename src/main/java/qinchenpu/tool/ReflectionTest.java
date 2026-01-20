package qinchenpu.tool;

import java.util.Calendar;

public class ReflectionTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String str = "123";
		Class<? extends String> class1 = str.getClass();
		Class<? extends String> class2 = str.getClass();
		Class<String> class3 = String.class;
		try {
			Class<?> class4 = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Calendar calendar = Calendar.getInstance();
		Class<Calendar> class4 = Calendar.class;
		Calendar calendar2 = class4.newInstance();
		System.out.println(calendar.equals(calendar2));
		
	}

}
