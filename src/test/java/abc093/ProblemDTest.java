package abc093;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("8\n" + "1 4\n" + "10 5\n" + "3 3\n" + "4 11\n" + "8 9\n" + "22 40\n" + "8 36\n"
				+ "314159265 358979323");
		ProblemD.main(null);
		assertResultIs("1" + LF + "12" + LF + "4" + LF + "11" + LF + "14" + LF + "57" + LF + "31" + LF + "671644785");
	}
}
