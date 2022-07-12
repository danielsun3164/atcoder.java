package abc.abc151_200.abc170;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 5 2\n" + "3 2 3 4\n" + ".....\n" + ".@..@\n" + "..@..", "5");
	}

	@Test
	void case2() {
		check("1 6 4\n" + "1 1 1 6\n" + "......", "2");
	}

	@Test
	void case3() {
		check("3 3 1\n" + "2 1 2 3\n" + ".@.\n" + ".@.\n" + ".@.", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC170/F");
	}
}
