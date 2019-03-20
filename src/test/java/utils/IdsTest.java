package utils;

import com.akademia.kodu.AplikacjaSpring.utils.Ids;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class IdsTest {
@Test
    public void testEmptyGet(){
        int result = Ids.generateNewId(Collections.emptySet());
    assertEquals(0,result);
}

    @Test
    public void testGenerateNewId() {
        Set<Integer> sample = new HashSet<>();
        sample.add(6);
        sample.add(7);
        sample.add(8);
        int result = Ids.generateNewId(sample);
        assertEquals(9,result);
    }
}
