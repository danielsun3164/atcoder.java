package abc.abc151_200.abc160;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 開催中に作成したコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			Queue<Integer> redQueue = new PriorityQueue<>(Collections.reverseOrder()),
					greenQueue = new PriorityQueue<>(Collections.reverseOrder()),
					colorlessQueue = new PriorityQueue<>(Collections.reverseOrder());
			IntStream.range(0, a).forEach(i -> redQueue.add(scanner.nextInt()));
			IntStream.range(0, b).forEach(i -> greenQueue.add(scanner.nextInt()));
			IntStream.range(0, c).forEach(i -> colorlessQueue.add(scanner.nextInt()));
			redQueue.add(0);
			greenQueue.add(0);
			colorlessQueue.add(0);
			int red = 0, green = 0, colorless = 0;
			long answer = 0L;
			while (red + green + colorless < x + y) {
				int redNow = redQueue.peek();
				int greenNow = greenQueue.peek();
				int colorlessNow = colorlessQueue.peek();
				if ((red < x) && (green < y)) {
					if ((redNow >= greenNow) && (redNow >= colorlessNow)) {
						red++;
						answer += redQueue.poll();
					} else if ((greenNow >= redNow) && (greenNow >= colorlessNow)) {
						green++;
						answer += greenQueue.poll();
					} else {
						colorless++;
						answer += colorlessQueue.poll();
					}
				} else if (red == x) {
					// 赤のリンゴをこれ以上食べない
					if (greenNow >= colorlessNow) {
						green++;
						answer += greenQueue.poll();
					} else {
						colorless++;
						answer += colorlessQueue.poll();
					}
				} else {
					// 緑のリンゴをこれ以上食べない
					if (redNow >= colorlessNow) {
						red++;
						answer += redQueue.poll();
					} else {
						colorless++;
						answer += colorlessQueue.poll();
					}
				}
			}
			System.out.println(answer);
		}
	}
}
