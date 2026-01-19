package qinchenpu.leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

import static java.util.concurrent.Executors.*;

/**
 * 请用java写代码实现如下的linux命令：cat /home/a.log | grep 'abc' | sort | uniq
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/CHENPU/Desktop/a.txt");
//		File file = new File("/home/a.log");
		bufferReader(file); // 字符流
		inputStreamReader(file); // 字节流

		ExecutorService catchTheradPool = newCachedThreadPool();
		ExecutorService fixedTheradPool = newFixedThreadPool(5);
		ExecutorService scheduledTheradPool = newScheduledThreadPool(5);
		ExecutorService singleTheradPool = newSingleThreadExecutor();
	}

	private static void inputStreamReader(File file) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		List<String> list = new ArrayList<String>();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			list.add(str);
		}
		// 筛选包含有字符串“abc”的行,并排序去重
		list = list.stream().filter(e -> e.contains("abc")).sorted().distinct().collect(Collectors.toList());
		list.forEach(System.out::println);
		bufferedReader.close();
		inputStreamReader.close();

		File file2 = new File("C:/Users/CHENPU/Desktop/a.log");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
		for (String string : list) {
			bufferedWriter.write(string + "\t\n");
		}
		bufferedWriter.close();
	}

	private static void bufferReader(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> list = new ArrayList<String>();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			list.add(str);
		}
		bufferedReader.close();
		fileReader.close();
		// 筛选包含有字符串“abc”的行,并排序去重
		list = list.stream().filter(e -> e.contains("abc")).sorted().distinct().collect(Collectors.toList());
		list.forEach(System.out::println);

		File file2 = new File("C:/Users/CHENPU/Desktop/a.log");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
		for (String string : list) {
			bufferedWriter.write(string + "\t\n");
		}
		bufferedWriter.close();
	}

}
