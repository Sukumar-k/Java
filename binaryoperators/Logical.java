package binaryoperators;

public class Logical {

	public static void main(String[] args) {
		int a=1;
		int b=2;
		boolean result=a<b && a==1;
		System.out.println(result);
		System.out.println(a<5 || b==5);
		System.out.println(a<=4 && a==b);
		System.out.println(a==b || b!=2);
		System.out.println(!true);
		System.out.println(!(1<2));

	}

}
