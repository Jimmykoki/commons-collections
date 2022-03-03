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

import org.apache.commons.collections4.map.FixedSizeMap;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCasePart3 {

    @Test
    public void FixedSizeMapisFullTest(){
        Map<String,Integer> testMap = new HashMap<>();
        testMap.put("Test", 1);
        FixedSizeMap fixedSizeMap = FixedSizeMap.fixedSizeMap(testMap);
        assertTrue(fixedSizeMap.isFull());
    }

    @Test
    public void FixedSizeMapMaxSizeTest(){
        Map<String,Integer> testMap = new HashMap<>();
        testMap.put("Test1", 1);
        testMap.put("Test2", 2);
        testMap.put("Test3", 3);
        FixedSizeMap fixedSizeMap = FixedSizeMap.fixedSizeMap(testMap);
        assertEquals(3,fixedSizeMap.maxSize());
    }


    @Test
    public void SingletonMapTest1(){
        Map<String,Integer> testMap = new HashMap<>();
        testMap.put("Test1", 1);
        Map<String,Integer> result = new SingletonMap<>(testMap);
        assertEquals(testMap, result);
    }

    @Test
    public void Flat3MapTest1(){
        final Flat3Map<Integer, Integer> m = new Flat3Map<>();
        Object obj;
        Integer ONE = Integer.valueOf(1);
        Integer TWO = Integer.valueOf(2);
        Integer THREE = Integer.valueOf(3);
        m.put(ONE, ONE);
        m.put(null, TWO);
        m.put(THREE, THREE);
        obj = m.remove(null);
        assertSame(TWO, obj);
        obj = m.get(ONE);
        assertSame(ONE, obj);
        obj = m.get(THREE);
        assertSame(THREE, obj);
        obj = m.get(null);
        assertNull(obj);
    }

    @Test
    public void Flat3MapTest2(){
        final Flat3Map<Integer, Integer> m = new Flat3Map<>();
        Object obj;
        Integer ONE = Integer.valueOf(1);
        Integer TWO = Integer.valueOf(2);
        Integer THREE = Integer.valueOf(3);
        m.put(null, ONE);
        m.put(TWO, TWO);
        m.put(THREE, THREE);
        obj = m.remove(null);
        assertSame(ONE, obj);
        obj = m.get(TWO);
        assertSame(TWO, obj);
        obj = m.get(THREE);
        assertSame(THREE, obj);
        obj = m.get(null);
        assertNull(obj);
    }



}
