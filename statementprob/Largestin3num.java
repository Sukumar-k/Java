package statementprob;

public class Largestin3num {

	public static void main(String[] args) {
		int number1=20;
		int number2=30;
		int number3=10;
		
		if(number1>number2 && number1>number3) {
			System.out.println("Number1 is greater");
		}
		else if(number2>number1 && number2>number3) {
			System.out.println("Number2 is greater");
		}
		else if(number3>number1 && number3>number2) {
			System.out.println("Number3 is greater");
		}

	}

}
