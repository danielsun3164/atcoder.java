package abc.abc201_250.abc245;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 2\n" + "4 5", "4");
	}

	@Test
	void case2() {
		check("3 2\n" + "1 2\n" + "2 1", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc245/F");
	}
}
