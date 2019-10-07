package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX12Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("1+1+1-1");
		ProblemEX12.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("1-1-1-1-1-1");
		ProblemEX12.main(null);
		assertResultIs("-4");
	}

	@Test
	void test_Case3() {
		in.input("1");
		ProblemEX12.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case4() {
		in.input("1-1-1+1+1+1+1-1+1-1+1-1+1");
		ProblemEX12.main(null);
		assertResultIs("3");
	}
}
