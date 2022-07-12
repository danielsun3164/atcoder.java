package abc.abc151_200.abc167;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + ")\n" + "(()", "Yes");
	}

	@Test
	void case2() {
		check("2\n" + ")(\n" + "()", "No");
	}

	@Test
	void case3() {
		check("4\n" + "((()))\n" + "((((((\n" + "))))))\n" + "()()()", "Yes");
	}

	@Test
	void case4() {
		check("3\n" + "(((\n" + ")\n" + ")", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC167/F");
	}
}
