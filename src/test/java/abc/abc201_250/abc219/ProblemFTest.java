package abc.abc201_250.abc219;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("RDRUL\n" + "2", "7");
	}

	@Test
	void case2() {
		check("LR\n" + "1000000000000", "2");
	}

	@Test
	void case3() {
		check("UUURRDDDRRRUUUURDLLUURRRDDDDDDLLLLLLU\n" + "31415926535", "219911485785");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc219/F");
	}
}
