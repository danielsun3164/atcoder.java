package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem016Test extends TestBase {

	@Test
	void case1() {
		check("227\n" + "21 47 56", "5");
	}

	@Test
	void case2() {
		check("9999\n" + "1 5 10", "1004");
	}

	@Test
	void case3() {
		check("998244353\n" + "314159 265358 97932", "3333");
	}

	@Test
	void case4() {
		check("100000000\n" + "10001 10002 10003", "9998");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/016");
	}
}
