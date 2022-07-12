package abc.abc151_200.abc191;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + ".....\n" + ".###.\n" + ".###.\n" + ".###.\n" + ".....", "4");
	}

	@Test
	void case2() {
		check("5 5\n" + ".....\n" + ".###.\n" + ".###.\n" + "..#..\n" + ".....", "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC191/C");
	}
}
