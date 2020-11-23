package other.joi2007yo;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("MRL", "JOI");
	}

	@Test
	void case2() {
		check("FURDWLD", "CROATIA");
	}

	@Test
	void case3() {
		check("ABC", "XYZ");
	}
}
