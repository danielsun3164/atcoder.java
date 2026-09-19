package abc.abc201_250.abc241;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答1Test extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "2 1 6 3 1", "11");
	}

	@Test
	void case2() {
		check("10 1000000000000\n" + "260522 914575 436426 979445 648772 690081 933447 190629 703497 47202",
				"826617499998784056");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc241/E");
	}
}
