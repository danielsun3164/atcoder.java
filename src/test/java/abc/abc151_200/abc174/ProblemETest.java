package abc.abc151_200.abc174;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "7 9", "4");
	}

	@Test
	void case2() {
		check("3 0\n" + "3 4 5", "5");
	}

	@Test
	void case3() {
		check("10 10\n"
				+ "158260522 877914575 602436426 24979445 861648772 623690081 433933447 476190629 262703497 211047202",
				"292638192");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC174/E");
	}
}
