package apg4b;

public class ProblemEX7 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		boolean c = true;
		if (a) {
			System.out.print("At");
		} else {
			System.out.print("Yo");
		}

		if (!a && b) {
			System.out.print("Bo");
		} else if (!b || c) {
			System.out.print("Co");
		}

		if (a && b && c) {
			System.out.print("foo!");
		} else if (true && false) {
			System.out.print("yeah!");
		} else if (!a || c) {
			System.out.print("der");
		}
		System.out.println();
	}
}
