package org.apache.commons.collections4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void containsAnyTypeInput(){
        final Collection<Double> one = new ArrayList<>(1);
        one.add(1.1415);
        final Collection<Double> two = new ArrayList<>(1);
        two.add(2.1415);
        final Collection<Double> three = new ArrayList<>(1);
        three.add(3.1415);
        final Collection<Double> odds = new ArrayList<>(2);
        odds.add(1.1415);
        odds.add(2.1415);

        assertFalse(CollectionUtils.containsAll(one, odds), "containsAll({1.1415},{1.1415,2.1415}) should return false.");
        assertTrue(CollectionUtils.containsAll(odds, one), "containsAll({1.1415,2.1415},{1.1415}) should return true.");
        assertTrue(CollectionUtils.containsAll(odds, two), "containsAll({1.1415,2.1415},{1.1415}) should return true.");
        assertFalse(CollectionUtils.containsAll(two, odds), "containsAll({1.1415},{1.1415,2.1415}) should return false.");
        assertTrue(CollectionUtils.containsAll(two, two), "containsAll({1.1415,2.1415},{1.1415}) should return true.");
        assertTrue(CollectionUtils.containsAll(odds, odds), "containsAll({1.1415,2.1415},{1.1415}) should return true.");
        assertFalse(CollectionUtils.containsAll(odds, three), "containsAll({1.1415},{1.1415,2.1415}) should return false.");
        assertFalse(CollectionUtils.containsAll(three, odds), "containsAll({1.1415},{1.1415,2.1415}) should return false.");

    }

    @Test
    public void containAnyDataStructure(){
        final Collection<String> oneArr = new ArrayList<>(1);
        oneArr.add("1");
        final Collection<String> twoArr = new ArrayList<>(2);
        twoArr.add("1");
        twoArr.add("2");
        final Collection<String> oneDeque = new ArrayDeque<>(1);
        oneDeque.add("1");
        final Collection<String> twoDeque = new ArrayDeque<>(2);
        twoDeque.add("1");
        twoDeque.add("2");
        final Collection<String> oneLink = new LinkedHashSet<>(1);
        oneLink.add("1");
        final Collection<String> twoLink = new LinkedHashSet<>(2);
        twoLink.add("1");
        twoLink.add("2");

        assertFalse(CollectionUtils.containsAll(oneArr, twoDeque), "containsAll({1},{1, 2}) should return false.");
        assertFalse(CollectionUtils.containsAll(oneArr, twoLink), "containsAll({1},{1, 2}) should return false.");
        assertTrue(CollectionUtils.containsAll(twoDeque, oneArr), "containsAll({1,2},{1}) should return true.");
        assertTrue(CollectionUtils.containsAll(twoLink, oneArr), "containsAll({1,2},{1}) should return true.");
        assertFalse(CollectionUtils.containsAll(oneDeque, twoArr), "containsAll({1},{1, 2}) should return false.");
        assertFalse(CollectionUtils.containsAll(oneDeque, twoLink), "containsAll({1},{1, 2}) should return false.");
        assertTrue(CollectionUtils.containsAll(twoArr, oneDeque), "containsAll({1,2},{1}) should return true.");
        assertTrue(CollectionUtils.containsAll(twoLink, oneDeque), "containsAll({1,2},{1}) should return true.");
        assertFalse(CollectionUtils.containsAll(oneLink, twoDeque), "containsAll({1},{1, 2}) should return false.");
        assertFalse(CollectionUtils.containsAll(oneLink, twoArr), "containsAll({1},{1, 2}) should return false.");
        assertTrue(CollectionUtils.containsAll(twoDeque, oneLink), "containsAll({1,2},{1}) should return true.");
        assertTrue(CollectionUtils.containsAll(twoArr, oneLink), "containsAll({1,2},{1}) should return true.");
        assertTrue(CollectionUtils.containsAll(twoArr, twoDeque), "containsAll({1,2},{1,2}) should return true.");
        assertTrue(CollectionUtils.containsAll(twoArr, twoLink), "containsAll({1,2},{1,2}) should return true.");


        



    }


}
