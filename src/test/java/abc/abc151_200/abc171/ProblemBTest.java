package abc.abc151_200.abc171;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "50 100 80 120 80", "210");
	}

	@Test
	void case2() {
		check("1 1\n" + "1000", "1000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC171/B");
	}
}
