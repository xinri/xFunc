package org.xinri.framework.hightorder.generalpurpose;

import java.util.function.BiFunction;
import java.util.function.Function;
import javax.annotation.Nonnull;

public final class FunctionUtils {

  private FunctionUtils() {
    throw new IllegalStateException("reflexion not allowed");
  }

  /**
   * Curry the function -> transform biFunction into function to apply
   *
   * @param biFuncToCurry the bi function to curry
   * @return a curry function
   */
  @Nonnull
  public static <U, V, X> Function<U, Function<V, X>> curry(
      @Nonnull BiFunction<U, V, X> biFuncToCurry) {
    return u -> v -> biFuncToCurry.apply(u, v);
  }

  /**
   * Uncurry the function => transform the function into a bi function
   *
   * @param funcToUnCurry function to uncurry
   * @return the bi function.
   */
  @Nonnull
  public static <U, V, X> BiFunction<U, V, X> unCurry(
      @Nonnull Function<U, Function<V, X>> funcToUnCurry) {
    return (u, v) -> funcToUnCurry.apply(u).apply(v);
  }

  /**
   * flip the parameters to apply into a curry function.
   *
   * @param funcToFlip flip the parameters to apply
   * @return a function flipped to apply in the reverse order.
   */
  @Nonnull
  public static <U, V, X> Function<V, Function<U, X>> flip(
      @Nonnull Function<U, Function<V, X>> funcToFlip) {
    return u -> v -> funcToFlip.apply(v).apply(u);
  }
}
