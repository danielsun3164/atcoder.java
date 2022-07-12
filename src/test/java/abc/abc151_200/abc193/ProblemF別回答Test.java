package abc.abc151_200.abc193;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("2\n" + "BB\n" + "BW", "2");
	}

	@Test
	void case2() {
		check("3\n" + "BBB\n" + "BBB\n" + "W?W", "4");
	}

	@Test
	void case3() {
		check("5\n" + "?????\n" + "?????\n" + "?????\n" + "?????\n" + "?????", "40");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC193/F");
	}
}
