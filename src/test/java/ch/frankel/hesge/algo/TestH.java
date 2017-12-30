package ch.frankel.hesge.algo;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class TestH {

    @Test
    public void shouldBeIterable() {
        H<LocalDate> h = new H<>();
        LocalDate date1 = LocalDate.of(1970, 1, 1);
        LocalDate date2 = LocalDate.of(2000, 10, 10);
        Iterator<LocalDate> iterator = h.apply(date1, date2);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isSameAs(date1);
        assertThat(iterator.hasNext()).isFalse();
        assertThat(iterator.next()).isSameAs(date2);
    }
}
