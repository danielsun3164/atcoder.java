package abc.abc201_250.abc237;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答Test extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "10 8 12 5\n" + "1 2\n" + "1 3\n" + "2 3\n" + "3 4", "3");
	}

	@Test
	void case2() {
		check("2 1\n" + "0 10\n" + "1 2", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc237/E");
	}
}
