package other.abl;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("8 5\n" + "3 6 2\n" + "1 4 7\n" + "3 8 3\n" + "2 2 2\n" + "4 5 1",
				"11222211" + LF + "77772211" + LF + "77333333" + LF + "72333333" + LF + "72311333");
	}

	@Test
	void case2() {
		check("200000 1\n" + "123 456 7", "641437905");
	}
}
