package other.apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX12Test extends TestBase {

	@Test
	void case1() {
		check("1+1+1-1", "2");
	}

	@Test
	void case2() {
		check("1-1-1-1-1-1", "-4");
	}

	@Test
	void case3() {
		check("1", "1");
	}

	@Test
	void case4() {
		check("1-1-1+1+1+1+1-1+1-1+1-1+1", "3");
	}
}
