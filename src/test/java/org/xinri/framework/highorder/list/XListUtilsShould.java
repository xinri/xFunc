package org.xinri.framework.highorder.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Ignore;
import org.junit.Test;

public class XListUtilsShould {

  @Test
  public void return_12_when_fold_left_recursively_list() {
    int result = XListUtils.foldLeftRec(2, x -> y -> (x + y), Arrays.asList(1, 2, 3, 4));
    assertThat(result).isEqualTo(12);
  }

  @Test
  public void return_12_when_fold_left_rec_with_characters_list() {
    int result = XListUtils.foldLeftRec(2, x -> y -> (x + Integer.valueOf(y)), Arrays.asList("1", "2", "3", "4"));
    assertThat(result).isEqualTo(12);
  }

  @Test
  public void return_representation_when_fold_left_recursively_with_character() {
    String result = XListUtils
        .foldLeftRec("0", x -> y -> "( " + x + " + " + y + " )", Arrays.asList("1", "2", "3", "4"));
    assertThat(result).isEqualTo("( ( ( ( 0 + 1 ) + 2 ) + 3 ) + 4 )");
  }

  @Test
  public void return_12_when_fold_left_iteratively_list() {
    int result = XListUtils.foldLeftIt(2, x -> y -> (x + y), Arrays.asList(1, 2, 3, 4));
    assertThat(result).isEqualTo(12);
  }

  @Test
  public void return_12_when_fold_left_it_with_characters_list() {
    int result = XListUtils.foldLeftIt(2, x -> y -> (x + Integer.valueOf(y)), Arrays.asList("1", "2", "3", "4"));
    assertThat(result).isEqualTo(12);
  }

  @Test
  public void return_representation_when_fold_left_iteratively_with_character() {
    String result = XListUtils
        .foldLeftIt("0", x -> y -> "( " + x + " + " + y + " )", Arrays.asList("1", "2", "3", "4"));
    assertThat(result).isEqualTo("( ( ( ( 0 + 1 ) + 2 ) + 3 ) + 4 )");
  }

  @Ignore
  @Test
  public void return_12_when_fold_right_recursively_list() {
    int result = XListUtils.foldRight(2, x -> y -> (x + y), Arrays.asList(1, 2, 3, 4));
    assertThat(result).isEqualTo(12);
  }

  @Ignore
  @Test
  public void return_representation_when_fold_right_recursively_with_character() {
    String result = XListUtils
        .foldRight("0", x -> y -> "( " + x + " + " + y + " )", Arrays.asList("1", "2", "3", "4"));
    assertThat(result).isEqualTo("( 1 + ( 2  + ( 3 + ( 4 + 0 ) ) ) )");
  }
}
