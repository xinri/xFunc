package org.xinri.framework.highorder.generalpurpose;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.Test;

public class XFunctionUtilsShould {

  @Test
  public void return_16_when_apply_with_curry_function() {
    // given
    BiFunction<Integer,String, Integer> biFunc =
        (num, value) -> (num) + Integer.valueOf(value);

    // when
    Integer result = XFunctionUtils.curry(biFunc).apply(5).apply("11");

    // when and then
    assertThat(result).isEqualTo(16);
  }

  @Test
  public void retun_16_when_apply_with_uncurry_function() {
    // given
    Function<Integer, Function<String, Integer>> func =
        num -> value -> (num) + Integer.valueOf(value);

    // when
    Integer result = XFunctionUtils.unCurry(func).apply(5, "11");

    // when and then
    assertThat(result).isEqualTo(16);
  }

  @Test
  public void return_16_when_apply_with_flip_function() {
    // given
    Function<Integer, Function<String, Integer>> func =
        num -> value -> (num) + Integer.valueOf(value);

    // when
    Integer result = XFunctionUtils.flip(func).apply("11").apply(5);

    // when and then
    assertThat(result).isEqualTo(16);
  }
}
