package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항1. String.split() 반환 테스트")
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");

        actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2. String.substring() 반환 테스트")
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3. String.CharAt 반환 및 StringIndexOutOfBoundsException 테스트")
    void chatAt() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            actual.charAt(6);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
