package org.apache.commons.collections4;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayDeque;
import java.util.ArrayList;

import java.util.Collection;

import java.util.LinkedHashSet;

import org.junit.Test;


public class TestCases_part2 extends MockTestCase{
   
    @Test
    public void containsAnyNull(){
        final Collection<String> emptyArr = new ArrayList<>(0);
        final Collection<String> emptyDeque = new ArrayDeque<>(0);
        final Collection<String> emptyLink = new LinkedHashSet<>(0);
        final String[] emptyStr = {};
        final String[] oddsArr = {"1", "3"};

        assertFalse(CollectionUtils.containsAny(emptyArr, emptyStr), "containsAny({},{}) should return false.");
        assertFalse(CollectionUtils.containsAny(emptyDeque, emptyStr), "containsAny({},{}) should return false.");
        assertFalse(CollectionUtils.containsAny(emptyLink, emptyStr), "containsAny({},{}) should return false.");
        assertFalse(CollectionUtils.containsAny(emptyArr, oddsArr), "containsAny({},{1,3}) should return false.");
        assertFalse(CollectionUtils.containsAny(emptyDeque, oddsArr), "containsAny({},{1,3}) should return false.");
        assertFalse(CollectionUtils.containsAny(emptyLink, oddsArr), "containsAny({},{1,3}) should return false.");
    }

    
}
