package abc.abc201_250.abc209;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "4 2 4", "2");
	}

	@Test
	void case2() {
		check("3\n" + "100 100 100", "6");
	}

	@Test
	void case3() {
		check("15\n"
				+ "804289384 846930887 681692778 714636916 957747794 424238336 719885387 649760493 596516650 189641422 25202363 350490028 783368691 102520060 44897764",
				"54537651");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc209/F");
	}
}
