package abc.abc151_200.abc200;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "123 223 123 523 200 2000", "4");
	}

	@Test
	void case2() {
		check("5\n" + "1 2 3 4 5", "0");
	}

	@Test
	void case3() {
		check("8\n" + "199 100 200 400 300 500 600 200", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc200/C");
	}
}
