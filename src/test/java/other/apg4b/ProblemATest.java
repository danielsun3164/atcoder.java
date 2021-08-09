package other.apg4b;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		execute();
		assertResultIs("Hello, world!");
	}
}
