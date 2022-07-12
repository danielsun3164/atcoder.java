package abc.abc101_150.abc148;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "ip cc", "icpc");
	}

	@Test
	void case2() {
		check("8\n" + "hmhmnknk uuuuuuuu", "humuhumunukunuku");
	}

	@Test
	void case3() {
		check("5\n" + "aaaaa aaaaa", "aaaaaaaaaa");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC148/B");
	}
}
