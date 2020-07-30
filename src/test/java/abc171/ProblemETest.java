package abc171;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "20 11 9 24");
		ProblemE.main(null);
		assertResultIs("26 5 7 22");
	}
}
