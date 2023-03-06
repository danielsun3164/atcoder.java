package other.past201912_open;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10\n" + "9\n" + "10\n" + "3\n" + "100\n" + "100\n" + "90\n" + "80\n" + "10\n" + "30\n" + "10",
				"up 1" + LF + "down 7" + LF + "up 97" + LF + "stay" + LF + "down 10" + LF + "down 10" + LF + "down 70"
						+ LF + "up 20" + LF + "down 20");
	}
}
