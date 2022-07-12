package abc.abc051_100.abc058;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 3 4\n" + "1 3 6", "60");
	}

	@Test
	void case2() {
		check("6 5\n" + "-790013317 -192321079 95834122 418379342 586260100 802780784\n"
				+ "-253230108 193944314 363756450 712662868 735867677", "835067060");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC071/D");
	}
}
