package abc.abc201_250.abc239;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("333", 65287.907678222d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("634", 90086.635834623d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc239/A", TOLERANCE);
	}
}
