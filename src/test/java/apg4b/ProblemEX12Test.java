package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX12Test extends TestBase {

	@Test
	void case1() {
		in.input("1+1+1-1");
		ProblemEX12.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("1-1-1-1-1-1");
		ProblemEX12.main(null);
		assertResultIs("-4");
	}

	@Test
	void case3() {
		in.input("1");
		ProblemEX12.main(null);
		assertResultIs("1");
	}

	@Test
	void case4() {
		in.input("1-1-1+1+1+1+1-1+1-1+1-1+1");
		ProblemEX12.main(null);
		assertResultIs("3");
	}
}
