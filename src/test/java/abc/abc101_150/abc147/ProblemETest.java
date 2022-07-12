package abc.abc101_150.abc147;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "1 2\n" + "3 4\n" + "3 4\n" + "2 1", "0");
	}

	@Test
	void case2() {
		check("2 3\n" + "1 10 80\n" + "80 10 1\n" + "1 2 3\n" + "4 5 6", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC147/E");
	}
}
