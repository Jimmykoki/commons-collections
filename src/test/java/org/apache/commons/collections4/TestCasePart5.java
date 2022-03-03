package org.apache.commons.collections4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestCasePart5 {


    @Test
    public void testIterableUnitForeach(){

        final List<Integer> listA = new ArrayList<>();
        listA.add(1);

        final List<Integer> listB = new ArrayList<>();
        listB.add(2);

        final Closure<List<Integer>> testClosure = ClosureUtils.invokerClosure("clear");
        final Collection<List<Integer>> col = new ArrayList<>();
        col.add(listA);
        col.add(listB);
        IterableUtils iterableUtils =  new IterableUtils();
        iterableUtils.forEachV2(col, testClosure);
        assertTrue(listA.isEmpty() && listB.isEmpty());
        try {
            IterableUtils.forEach(col, null);
            fail("expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }
        IterableUtils.forEach(null, testClosure);

        // null should be OK
        col.add(null);
        IterableUtils.forEach(col, testClosure);
    }
}
