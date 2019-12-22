package ACSL;
public class ClassesAndObjects {

	public static void main(String args[]) {
		
		System.out.println(cat(123, 456));
	}
	public static int pig(int i, int j) {
		
		int k = i + j + 4;
		return k;
		
	}
	
	public static String cat(int i, int j) {
		
		String st = "" + i + j;
		
		return st;
		
	}

}
