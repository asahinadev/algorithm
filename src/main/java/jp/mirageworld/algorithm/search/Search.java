package jp.mirageworld.algorithm.search;

import java.util.List;

public interface Search<T extends Comparable<? super T>> {

	int apply(List<T> list, T target);

	boolean check(List<T> list, T target);

}