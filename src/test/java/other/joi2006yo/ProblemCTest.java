package other.joi2006yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "North\n" + "North\n" + "East\n" + "South\n" + "West", "21");
	}

	@Test
	void case2() {
		check("8\n" + "West\n" + "North\n" + "Left\n" + "South\n" + "Right\n" + "North\n" + "Left\n" + "East", "34");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2006yo/C");
	}
}
