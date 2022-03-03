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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;



public class TestCasePart2 extends MockTestCase{
   

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
        
        collectionC = new ArrayList<>();
        collectionC = Arrays.asList("a", "b", "b", "c", "c", "c");

        collectionD = new ArrayList<>();
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

        List<Integer> fnialList = new ArrayList<>();
        fnialList.addAll(testBag.uniqueSet());

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
