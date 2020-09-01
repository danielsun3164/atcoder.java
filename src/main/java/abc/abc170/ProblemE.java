package abc.abc170;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;

/**
 * 解説通りに実装したソースコード
 * 
 * Java 11ではTLEが発生するため、Java 1.8.0で提出する<br/>
 * PriorityQueueではTLEが発生するため、独自のMultiSetを実装
 */
public class ProblemE {

	/** 幼稚園の数 */
	private static final int N = 200_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			// 園児ごとのレートと保育園を保存する配列
			int[] rates = new int[n], kindergartens = new int[n];
			// 個々の幼稚園の園児のレート一覧を保存するマップ
			@SuppressWarnings("unchecked")
			MultiSet<Integer>[] kindergartenSets = new MultiSet[N];
			// TLE回避のため、Stream APIを使用しない
			for (int i = 0; i < N; i++) {
				kindergartenSets[i] = new MultiSet<>((x, y) -> y.compareTo(x));
			}
			for (int i = 0; i < n; i++) {
				int a = scanner.nextInt(), b = scanner.nextInt() - 1;
				rates[i] = a;
				kindergartens[i] = b;
				kindergartenSets[b].add(a);
			}
			// 個々の幼稚園の最大レートを保存するセット
			MultiSet<Integer> totalSet = new MultiSet<>();
			for (MultiSet<Integer> set : kindergartenSets) {
				if (!set.isEmpty()) {
					totalSet.add(set.first());
				}
			}
			for (int i = 0; i < q; i++) {
				int c = scanner.nextInt() - 1, d = scanner.nextInt() - 1;
				// 古い幼稚園から削除
				MultiSet<Integer> prevSet = kindergartenSets[kindergartens[c]];
				totalSet.remove(prevSet.first());
				prevSet.remove(rates[c]);
				if (!prevSet.isEmpty()) {
					totalSet.add(prevSet.first());
				}
				// 新しい幼稚園へ追加
				MultiSet<Integer> nextSet = kindergartenSets[d];
				if (!nextSet.isEmpty()) {
					totalSet.remove(nextSet.first());
				}
				nextSet.add(rates[c]);
				totalSet.add(nextSet.first());
				kindergartens[c] = d;
				System.out.println(totalSet.first());
			}
		}
	}

	/**
	 * MultiSetの実装
	 * 
	 * @param <E>
	 */
	private static class MultiSet<E> implements NavigableSet<E>, Cloneable, Serializable {

		/** */
		private static final long serialVersionUID = 1L;

		/** データを格納するマップ */
		TreeMap<E, Integer> treeMap;

		MultiSet() {
			treeMap = new TreeMap<>();
		}

		MultiSet(Comparator<? super E> comparator) {
			treeMap = new TreeMap<>(comparator);
		}

		@Override
		public Comparator<? super E> comparator() {
			return treeMap.comparator();
		}

		@Override
		public E first() {
			return treeMap.firstKey();
		}

		@Override
		public E last() {
			return treeMap.lastKey();
		}

		@Override
		public int size() {
			return treeMap.values().stream().mapToInt(Integer::intValue).sum();
		}

		@Override
		public boolean isEmpty() {
			return treeMap.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return treeMap.containsKey(o);
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public Object[] toArray() {
			return treeMap.keySet().toArray();
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public <T> T[] toArray(T[] a) {
			return treeMap.keySet().toArray(a);
		}

		@Override
		public boolean add(E e) {
			treeMap.put(e, treeMap.getOrDefault(e, 0) + 1);
			return true;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean remove(Object o) {
			if (treeMap.containsKey(o)) {
				int count = treeMap.get(o) - 1;
				if (0 == count) {
					treeMap.remove(o);
				} else {
					treeMap.put((E) o, count);
				}
				return true;
			}
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return treeMap.keySet().containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			if ((null != c) && (!c.isEmpty())) {
				c.forEach(o -> add(o));
				return true;
			}
			return false;
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public boolean retainAll(Collection<?> c) {
			boolean result = false;
			if ((null != c) && (!c.isEmpty())) {
				for (E e : treeMap.keySet()) {
					if (!c.contains(e)) {
						treeMap.remove(e);
						result = true;
					}
				}
			} else {
				result = !treeMap.isEmpty();
				treeMap.clear();
			}
			return result;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			if ((null != c) && (!c.isEmpty())) {
				boolean result = false;
				for (Object o : c) {
					result = result || remove(o);
				}
				return result;
			}
			return false;
		}

		@Override
		public void clear() {
			treeMap.clear();
		}

		@Override
		public E lower(E e) {
			return treeMap.lowerKey(e);
		}

		@Override
		public E floor(E e) {
			return treeMap.floorKey(e);
		}

		@Override
		public E ceiling(E e) {
			return treeMap.ceilingKey(e);
		}

		@Override
		public E higher(E e) {
			return treeMap.higherKey(e);
		}

		@Override
		public E pollFirst() {
			return (null != treeMap.pollFirstEntry()) ? treeMap.pollFirstEntry().getKey() : null;
		}

		@Override
		public E pollLast() {
			return (null != treeMap.pollLastEntry()) ? treeMap.pollLastEntry().getKey() : null;
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public Iterator<E> iterator() {
			return treeMap.keySet().iterator();
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public NavigableSet<E> descendingSet() {
			return treeMap.descendingKeySet();
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public Iterator<E> descendingIterator() {
			return treeMap.descendingKeySet().iterator();
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
			return null;
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public NavigableSet<E> headSet(E toElement, boolean inclusive) {
			return null;
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
			return null;
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public SortedSet<E> subSet(E fromElement, E toElement) {
			return null;
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public SortedSet<E> headSet(E toElement) {
			return null;
		}

		/**
		 * 必要がないため、暫定実装
		 */
		@Override
		public SortedSet<E> tailSet(E fromElement) {
			return null;
		}
	}
}
