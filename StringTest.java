package edu.tanvir.irfan;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "0123456789";		
//		
//		System.out.println(s.substring(0));
//		System.out.println(s.substring(2));
//		System.out.println(s.substring(10));	//no problem even if the index is outside of boundary
//		
//		System.out.println(s.substring(0,8));
//		System.out.println(s.substring(0,5));
//		
//		System.out.println(s.substring(5,8));
//		System.out.println(s.substring(5,18));	// none of the beginIndex and endIndex can be outside of boundary
		
		char [] cs = {'A','1','2','3','4','5','6','7','8','9'};
		
		s = new String(cs,0,9);
		System.out.println(s);
		
		s = new String(cs,0,10);
		System.out.println(s);
		
		System.out.println(s.codePointBefore(1));
		
		System.out.println("abc".compareTo("ABC"));
		System.out.println("ABC".compareTo("ABC"));
		System.out.println("ab".compareTo("aB"));
	}

}
