package org.xinri.framework.highorder.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class XListUtils {

  private XListUtils() {
    throw new IllegalStateException("reflexion not allowed");
  }


  public static <T, U> U foldLeftRec(U neutralValue, Function<U, Function<T, U>> acc,
      List<T> listToApply) {

    if (listToApply.isEmpty()) {
      return neutralValue;
    }

    return foldLeftRec(acc.apply(neutralValue).apply(listToApply.get(0)),
        acc, listToApply.subList(1, listToApply.size()));
  }

  public static <T, U> U foldLeftIt(U neutralValue, Function<U, Function<T, U>> acc, List<T> listToApply) {

    U result = neutralValue;

    for (T element : listToApply) {
      result = acc.apply(result).apply(element);
    }

    return result;
  }

  /**
   * A fold right cannot be done with a tail recursion
   * @param neutralValue the neutral value that will be execute at the end
   * @param acc the accumulator
   * @param listToApply the list to apply
   * @return the accumulate value using the fold right method
   */
  public static <T, U> U foldRight(U neutralValue, Function<U, Function<T, U>> acc, List<T> listToApply) {

    List<T> reverseList = new ArrayList<>(listToApply);
    Collections.reverse(reverseList);

    U result = neutralValue;

    for (T element : reverseList) {
      result = acc.apply(result).apply(element);
    }

    return result;
  }
}
