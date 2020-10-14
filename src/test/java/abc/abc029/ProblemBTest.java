package abc.abc029;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("january\n" + "february\n" + "march\n" + "april\n" + "may\n" + "june\n" + "july\n" + "august\n"
				+ "september\n" + "october\n" + "november\n" + "december", "8");
	}

	@Test
	void case2() {
		check("rrrrrrrrrr\n" + "srrrrrrrrr\n" + "rsr\n" + "ssr\n" + "rrs\n" + "srsrrrrrr\n" + "rssrrrrrr\n" + "sss\n"
				+ "rrr\n" + "srr\n" + "rsrrrrrrrr\n" + "ssrrrrrrrr", "11");
	}
}
