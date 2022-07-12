package abc.abc151_200.abc151;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 5\n" + "1 WA\n" + "1 AC\n" + "2 WA\n" + "2 AC\n" + "2 WA", "2 2");
	}

	@Test
	void case2() {
		check("100000 3\n" + "7777 AC\n" + "7777 AC\n" + "7777 AC", "1 0");
	}

	@Test
	void case3() {
		check("6 0", "0 0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC151/C");
	}
}
