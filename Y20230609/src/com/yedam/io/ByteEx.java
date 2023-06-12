package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteEx {
	public static void main(String[] args) {
		try {
			FileInputStream fis =
			 new FileInputStream("C:/temp/sample.jpg");
			FileOutputStream fos = new FileOutputStream("c:/temp/copy.jpg");
			byte[] bytes = new byte[100];
			while(true) {
				int readInt = fis.read(bytes);
				if(readInt == -1) {
					break;
				}
				
				
				fos.write(bytes);
				
			}
			fis.close();
			fos.flush();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException ee) {
			ee.printStackTrace();
		}
		System.out.println("end.");
	}
	public static void read1() {
		try {
			InputStream is = new FileInputStream("c:/temp/data1.dat");
			while(true) {
				int readInt = is.read();
				if(readInt == -1) {
					break;
				}
			System.out.println(readInt);
			}
			is.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void write1() {
		try {
		OutputStream os = new FileOutputStream("c:/temp/data1.dat");
		byte a = 10;
		byte b = 20;
		os.write(a); // 입력
		os.write(b);
		os.flush(); // 캐시 정보 출력, 비우기
		os.close(); //리소스 환원.
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
