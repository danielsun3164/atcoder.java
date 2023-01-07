package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem008Test extends TestBase {

	@Test
	void case1() {
		check("10\n" + "attcordeer", "4");
	}

	@Test
	void case2() {
		check("41\n" + "btwogablwetwoiehocghiewobadegwhoihegnldir", "2");
	}

	@Test
	void case3() {
		check("140\n"
				+ "aaaaaaaaaaaaaaaaaaaattttttttttttttttttttccccccccccccccccccccooooooooooooooooooooddddddddddddddddddddeeeeeeeeeeeeeeeeeeeerrrrrrrrrrrrrrrrrrrr",
				"279999993");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/008");
	}
}
