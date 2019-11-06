package org.xinri.framework.highorder.generalpurpose;

import java.util.function.BiFunction;
import java.util.function.Function;
import javax.annotation.Nonnull;

public final class XFunctionUtils {

  private XFunctionUtils() {
    throw new IllegalStateException("reflexion not allowed");
  }

  /**
   * Curry the function -> transform biFunction into function to apply
   *
   * @param biFuncToCurry the bi function to curry
   * @return a curry function
   */
  @Nonnull
  public static <R, T, U> Function<R, Function<T, U>> curry(
      @Nonnull BiFunction<R, T, U> biFuncToCurry) {
    return t -> u -> biFuncToCurry.apply(t, u);
  }

  /**
   * Uncurry the function => transform the function into a bi function
   *
   * @param funcToUnCurry function to uncurry
   * @return the bi function.
   */
  @Nonnull
  public static <R, T, U> BiFunction<R, T, U> unCurry(
      @Nonnull Function<R, Function<T, U>> funcToUnCurry) {
    return (t, u) -> funcToUnCurry.apply(t).apply(u);
  }

  /**
   * flip the parameters to apply into a curry function.
   *
   * @param funcToFlip flip the parameters to apply
   * @return a function flipped to apply in the reverse order.
   */
  @Nonnull
  public static <R, T, U> Function<T, Function<R, U>> flip(
      @Nonnull Function<R, Function<T, U>> funcToFlip) {
    return t -> u -> funcToFlip.apply(u).apply(t);
  }
}
