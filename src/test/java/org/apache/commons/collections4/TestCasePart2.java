/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.commons.collections4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;



public class TestCasePart2 extends MockTestCase{

    @Test
    public void containsAnyNull() {
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
    public void containsAnyTypeInput() {
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
    public void containAnyDataStructure() {
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
   

    private List<Integer> collectionA;
    private List<Integer> collectionB;
    List<Integer> resultList1 = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3);
    List<Integer> reslutList3 = Arrays.asList(1, 2, 3);

    private List<String> collectionC;
    private List<String> collectionD;
    List<String> resultList2 = Arrays.asList("a", "a", "a", "a", "b", "b", "b", "b", "c", "c", "c", "c");
    List<String> resultList4 = Arrays.asList("a", "b", "c");



    @Test
    public void testCollateInt(){

        collectionA = Arrays.asList(1, 2, 2, 3, 3, 3);
        collectionB = Arrays.asList(1, 1, 1, 2, 2, 3);
        int resultSize = 12;

        List<Integer> combinedList = CollectionUtils.collate(collectionA, collectionB);

        System.out.println("SortedList_1 " + collectionA);
        System.out.println("SortedList_2 "+ collectionB);
        System.out.println("CombinedList " + combinedList);

        assertEquals(resultSize, combinedList.size());
        assertEquals(resultList1, combinedList);

    }

    @Test
    public void testCollateString(){

        collectionC = Arrays.asList("a", "b", "b", "c", "c", "c");

        collectionD = Arrays.asList("a", "a", "a", "b", "b", "c");


        List<String> combinedList = CollectionUtils.collate(collectionC, collectionD);
        int resultSize = 12;
        System.out.println(combinedList);

        assertEquals(resultSize, combinedList.size());
        assertEquals(resultList2, combinedList);

    }

    @Test
    public void testuniSetInt(){

        Bag<Integer> testBag = new HashBag<>(resultList1);

        assertEquals(4, testBag.getCount(1));
        assertEquals(4, testBag.getCount(2));
        assertEquals(4, testBag.getCount(3));

        List<Integer> fnialList = new ArrayList<>(testBag.uniqueSet());

        assertEquals(fnialList, reslutList3, "All elements keep only one");
    
        System.out.println(fnialList);

    }

    @Test
    public void testuniSetString(){

        Bag<String> testBag = new HashBag<>(resultList2);

        assertEquals(4, testBag.getCount("a"));
        assertEquals(4, testBag.getCount("b"));
        assertEquals(4, testBag.getCount("c"));

        List<String> fnialList = new ArrayList<>();
        fnialList.addAll(testBag.uniqueSet());

        assertEquals(fnialList, resultList4, "All elements keep only one");
    
    }


}
