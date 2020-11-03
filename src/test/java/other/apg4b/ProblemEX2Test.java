package other.apg4b;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemEX2Test extends TestBase {

	@Test
	void case1() {
		ProblemEX2.main(null);
		assertResultIs("いつも2525" + LF + "AtCoderくん");
	}
}
