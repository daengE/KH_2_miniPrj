package mini.util;

public class StringTest {
	
	public static int getStrLength(int formatSize, String str) {
		return formatSize - (getByteLength(str) - str.length());
	}
	
	public static int getByteLength(String str) {
		int length=0;
		if (str!=null) {
			try {
				length = str.getBytes("euc-kr").length;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return length;
	}
}
//https://dev-handbook.tistory.com/8 참고..
