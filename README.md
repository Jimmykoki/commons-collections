<!---
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->
<!---
 +======================================================================+
 |****                                                              ****|
 |****      THIS FILE IS GENERATED BY THE COMMONS BUILD PLUGIN      ****|
 |****                    DO NOT EDIT DIRECTLY                      ****|
 |****                                                              ****|
 +======================================================================+
 | TEMPLATE FILE: readme-md-template.md                                 |
 | commons-build-plugin/trunk/src/main/resources/commons-xdoc-templates |
 +======================================================================+
 |                                                                      |
 | 1) Re-generate using: mvn commons-build:readme-md                    |
 |                                                                      |
 | 2) Set the following properties in the component's pom:              |
 |    - commons.componentid (required, alphabetic, lower case)          |
 |    - commons.release.version (required)                              |
 |                                                                      |
 | 3) Example Properties                                                |
 |                                                                      |
 |  <properties>                                                        |
 |    <commons.componentid>math</commons.componentid>                   |
 |    <commons.release.version>1.2</commons.release.version>            |
 |  </properties>                                                       |
 |                                                                      |
 +======================================================================+
--->
Apache Commons Collections
===================

[![Build Status](https://travis-ci.org/apache/commons-collections.svg)](https://travis-ci.org/apache/commons-collections)
[![Coverage Status](https://coveralls.io/repos/apache/commons-collections/badge.svg)](https://coveralls.io/r/apache/commons-collections)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.apache.commons/commons-collections4/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.apache.commons/commons-collections4/)
[![Javadocs](https://javadoc.io/badge/org.apache.commons/commons-collections4/4.4.svg)](https://javadoc.io/doc/org.apache.commons/commons-collections4/4.4)

The Apache Commons Collections package contains types that extend and augment the Java Collections Framework.


# SWE261 SW TEST & DEBUG_Report (Apache Commons Collections)

## Part1: Introduction, Building and Partitioning

### Itroduction to Apache Commons Collections

#### Overview in Collections
The tools we are testing is [Apache Commons Collections package](//https://github.com/apache/commons-collections). The package contains types including new interfaces, implementations and utilities that extend and augment the Java Collections Framework. We can use mutiple data structures it provides and create more efficient arithmetic. It allows programmer to develop applications in a way that ensures performance and also greatly simplifying the code.

This is our github link (https://github.com/Jimmykoki/commons-collections)
Team Name: Whatever
Team Member: Jianlin Li and Yixuan Li

#### Inner Structure in Collections
In order to better understand the internal structure of the Collections, we need to count the number of code lines. In this case, we use a command and the line of code is `130157` .

`find . -name '*.java' | xargs wc -l`

Meanwhile, we have counted number of java files, and the result is `590`.

`find . -name '*.java' | wc -l`

As we have introduced, `Apache Commons Collections4` is a liabrary written by `Java`.

### Building and Running for Collections

#### Fork and Clone
we need to fork and clone the program in author's github(https://github.com/apache/commons-collections), and pull it in our local repositories

#### Setting local running environment
IntelliJ IDEA would be a best choice for us to set up running environment for this project. We use Maven to build,  and excute mvn commnd to start the project. Before that, we also have to config and invoke relative dependencies and plugins in `pom.xml`

#### Start test unit with Junit

In the entire project directory, we can see that all previous test cases created by author have stored in test folder, test results are shown in following figure#1
<center><img src= https://i.imgur.com/U6Ai9vz.png width="60%" height="%" /></center>
<center>Figure#1 Test result</center>



#### Existing test cases in common-collections


First ,we could find the existing testing case is `black-box testing`. When testing, the program is regarded as a black box that cannot be opened. Without considering the internal structure and internal characteristics of the program, we just conducts direct tests.

After that, we need to use `Junit` to run these test cases. `Junit` can support more different styles of testing. When we want to use `Junit`, we need to add    `Junit` to our project. Because `Junit` is already built in the `pom.xml` file, we can open it directly in `IntelliJ IDEA` without additional installation.

##### previous test cases
Test cases are located in the `src/test `folder. This project uses the `Junit` framework to test all test files. Each subfolder is related to a package in `src. ./test/builds` contains builder package tests, I take some screenshots figure#2 as follows:

<center><img src="https://i.imgur.com/kAKFWLo.png" width="60%" height="%"/><img src="https://i.imgur.com/Cm8hAhD.png" width="60%" height="%"/></center>
<center>Figure#2 previous test</center>

##### Sample test case
in `org/apache/commons/collections4/QueueUtilsTest.java`
``` t
@Test
    public void testSynchronizedQueue() {
        final Queue<Object> queue = QueueUtils.synchronizedQueue(new LinkedList<>());
        assertTrue(queue instanceof SynchronizedQueue, "Returned object should be a SynchronizedQueue.");
        try {
            QueueUtils.synchronizedQueue(null);
            fail("Expecting NullPointerException for null queue.");
        } catch (final NullPointerException ex) {
            // expected
        }
    }
```
This test is mainly to test the type of the object. it can judge whether the queue created by `synchronizedQueue` method is a synchronous queue, and We could get the result (true or false) by using `assertTrue`.

in `org/apache/commons/collections4/MapUtilsTest.java
``` t
 @Test
    public void testPredicatedMap() {
        final Predicate<Object> p = getPredicate();
        final Map<Object, Object> map = MapUtils.predicatedMap(new HashMap<>(), p, p);
        assertTrue(map instanceof PredicatedMap);
        try {
            MapUtils.predicatedMap(null, p, p);
            fail("Expecting NullPointerException for null map.");
        } catch (final NullPointerException e) {
            // expected
        }
    }
```
This testing case is to test predicated map, we could use `assertTrue` method to judge whether a map created by `predicatedMap` method is an instance of `PredicatedMap`.



### Partition
#### Introduction to systematic functional testing
`Functional testing`, also known as `black-box testing`, is to treat the test object as a black-box, and perform functional testing on the software product without considering the internal structure and processing process of the software product. Functional testing focuses on the "functional requirements" of a software product.

#### Introduction to partition testing
We divide the entire space of the input into classes such that the union of these classes is the entire space. In most cases there will be few failures in most spaces, and only in very few areas will there be many failures. We can use the partition testing to test each category.

#### Feature we choose for partition testing
There are many classes In `common-collections`, we will choose the `ContainsAny` method in ConllectionUnit class to focus on partition testing.
#### Write new test cases

we put test case in `/src/test/java/org/apache/commons/collections4/TestCasePart2.java `


``` java
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
```

## Part2

### Introduction to Finite State Machines
Finite state machine is a mathematical model that represents a finite number of states and behavior such as transitions and actions between those states.


### Features of Finite State Machines:

Finite state machines generally have the following characteristics:
1. Things can be described by states, and at any time, things are always in a state;
2. The total number of states a thing has is limited;
3. By triggering certain behaviors of things, it can cause things to transition from one state to another;
4. The state of things changes regularly. A state can be transformed to B, B can be transformed to C, but A can not necessarily be transformed to C;
5. The same behavior can change things from multiple states to the same state, but cannot change from the same state to multiple states.

### Create a feature
In our project, we created a feature to operate on any two collections given, we deduplicate and merge them, and finally got a deduplicated list. 
### Create and describe Finite State Machine Model
The specific operation process of this method is as follows:
1. First, the `collate()` method will merge and sort the two `collections` to generate a `sorted collection`
2. At this point we will get a `sorted collection`, but there may be duplicate elements in it
3. Finally, use the `uniqueSet()` method to deduplicate the `sorted collection`, so that we can get a merged `list` after deduplication.
### State Transform Diagram
The following State Transform Diagram shows the transition process between the states of the finite state machine:
<center><img src="https://i.imgur.com/SnavODx.png" width="60%" height="%" /></center>
<center>Figure#1 State Transform Diagram</center>

### Test-Case
The test cases called [TestCases_part2.java](https://github.com/Jimmykoki/commons-collections/blob/master/src/test/java/org/apache/commons/collections4/TestCases_part2.java) are created in `src/test/java/org/apache/commons/collections4/TestCases_part2.java`

For each of the state, we write a test case to check the edge for income data and outcome data:

```java
public class TestCases_part2 extends MockTestCase{
   
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
        assertEquals(resultSize, combinedList.size());
        assertEquals(resultList1, combinedList);
    }

    @Test
    public void testCollateString(){
        collectionC = Arrays.asList("a", "b", "b", "c", "c", "c");
        collectionD = Arrays.asList("a", "a", "a", "b", "b", "c");
        List<String> combinedList = CollectionUtils.collate(collectionC, collectionD);
        int resultSize = 12;
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
```

All unit tests passed, as shown in the following Figure#2

<center><img src= https://i.imgur.com/8hoqtLD.png /></center>
<center>Figure#2 Test result</center>

## Part3

### Introduction to White Box testing(Structural Testing)
**White-box** testing is also known as **Structural testing**. This testing implement coverage testing to inspect every logic path and branch in software. It's able to help developer comprehend the internal logic of the program and reveal error in hidden corners.


### Test coverage tool we use
**Jacoco** can provide code coverage statistics for JVM-based code, and expects to provide lightweight, scalable, and well-documented library files to integrate various build and development tools.
### Previous test 
We notice that `org.apache.commons.collection4.map` has the 87% coverage for class, 82% coverage for method, 87% coverage for line. Thus we add new test cases to cover some of its functionalities.

<img src="https://i.imgur.com/EYN2hJ4.jpg" width="70%" height="%" />

### Add Jacoco into IntelliJ IDEA
In this report, we will show you how to use the **JaCoCo Maven plugin** to generate code coverage reports for Java projects. Declare JaCoCo plugin in the `pom.xml`file.
``` Jacoco Maven Plugin
<plugin>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <version>0.8.2</version>
  <executions>
    <execution>
      <goals>
        <goal>prepare-agent</goal>
      </goals>
    </execution>
  <!-- attached to Maven test phase -->
    <execution>
      <id>report</id>
      <phase>test</phase>
      <goals>
        <goal>report</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

### Coverage for Collections
We want to focus on `org.apache.commons.collections.map`, which has the following coverage, such as line, branch, method coverage. We put it on a table.
|measures|missed|total|coverage|
| :-----:| :----: | :----: |:----:|
|line|274|3162|91%|
|branch|N/A|N/A|78%|
|method|71|898|92%|

We can also view the coverage of the mentioned lines and methods in the IntelliJ IDEA file as shown in the image below:

<img src="https://i.imgur.com/Hi1QAf4.png" width="50%" height="%" />

For `map` folder, we focus on `FixedSizeMap`, which only has 76% methods, 70% lines covered. `SingletonMap` only has 86% methods, 71% lines covered.`Flat3Map` has 90% methods,86% lines covered. Therefore, we design new test cases to improve the coverages of methods and lines in these two files.
### New test case

We put our code in `/src/test/java/org/apache/commons/collections4/TestCases_part3.java/`  ，and we could see the coverage has improved a lot compared to the previous data.

We still query its coverage in IntelliJ IDEA, and compare it with the previous data as shown in the following picture and table:

<img src="https://i.imgur.com/EDEsRDH.jpg" width="50%" height="%" />

|measures|Method before|Method after|line before|line after|
| :-----:| :----: | :----: |:----:|:----:|
|FixedSizeMap|76%|92%|70%|79%|
|SingletonMap|86%|88%|71%|76%|
|Flat3Map|94%|94%|86%|90%|


We write 5 methods to improve these 3 java files.

- First, we improve `isFull()`,` maxSize()` in `FixedSizeMap`. 
``` java
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
```
- Second, we improve `SingletonMap` in `SingletonMap`.
``` java
@Test
    public void SingletonMapTest1(){
        Map<String,Integer> testMap = new HashMap<>();
        testMap.put("Test1", 1);
        Map<String,Integer> result = new SingletonMap<>(testMap);
        assertEquals(testMap, result);
    }
```
- Third, we improve `remove` in `Flat3Map`.

``` java
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
```

## Part4: Continuous Integration

### Introduction to Continuous Integration

#### Overview in CI
Continuous integration (CI) ,was proposed by Grady Booch first on [his 1991 method](https://en.wikipedia.org/wiki/Booch_method), is the practice of automating the integration of code changes from multiple contributors into a single software project.

CI emphasizes that build unit tests immediately after the developer commits the new code, test developers can determine whether the new code and the original code are properly integrated according to the results of the tests. 

![continuous integration](https://i.imgur.com/EmkJYQT.png)
<center>Continuous integration</center>

#### Benefits of CI

- Located errors and problems in a timely manner during testing sessions
- Avoided developers deviating the main branch by check-in to the main source repository frequently
- Reduce unnecessary cost and maintained rapid iteration

### Deploy CI system for projects

#### Introduction to Travis CI

Travis CI is a continuous integration tool that test and deploy projects with ease. Sync the project we create with Travis CI, which is used to assert the new cpde's correctness before integration, can imporve work efficiency in testing session.

Travis CI only supports Github and no other code hosting services. This means, you must meet the following conditions in order to use Travis CI:
- Have a GitHub account
- There is an item under this account
- The project has executable code in it
- The project also contains build or test scripts
- If these conditions are all right, you can start using Travis CI.

When we log in to our Travis CI account, Travis will list all your repositories on Github and the organization you belong to. At this point, select the repository you need Travis to help you build, and turn on the switch next to the repository. Once a repository is activated, Travis listens for all changes in that repository.

#### Sign up for Travis CI

We should first register a Travis CI, we can test this in sync with our project, we created the project and named it `Jimmykoki/commons-collections`, when we register, we can go and choose the project we need to test.

#### Create a file

Travis requires that there must be a `.travis.yml` file in the root directory of the project. This is the configuration file that specifies the behavior of Travis. This file must be saved in the Github repository. Once the code repository has a new Commit, Travis will find this file and execute the commands in it. Therefore, we need to create a `.travis.yml` file in my project. The file contains the following information:

``` yml
language: java

cache:
  directories:
    - ~/.m2

jdk:
  - openjdk8
  - openjdk11
  - openjdk15

script:
  - mvn test
 
after_success:
  - mvn -V --no-transfer-progress clean test jacoco:report coveralls:report -Ptravis-jacoco javadoc:javadoc -Ddoclint=all
```
In the above code, two fields are set. The language field specifies the default runtime environment, which is set to use the `Java` environment. The script field specifies the script to run.
#### Verify changes

When we add `.travis.yml`, we submit it to GitHub again. After a few minutes, the following page will be displayed on our Travis CI, which means we build passes.


<img src="https://i.imgur.com/thfsGyy.png" width="100%" height="%" />


We will add the extension to GitHub, and the extension will appear in the account settings, as shown in the image below:


<img src="https://i.imgur.com/GwHbUX6.png" width="100%" height="%" />

Finally we can find that `build passing` appears in our repository
<img src="https://i.imgur.com/NZ14enM.png" width="20%" height="%" />



### Reference
https://www.mindtheproduct.com/what-the-hell-are-ci-cd-and-devops-a-cheatsheet-for-the-rest-of-us/


## Part5: Testable Design, Mocking

### Testable Design

#### introduction to Testable Design

Testable Design is the ability to test code better. To quote **Roy Osherove**, author of The Art of Unit Testing with Examples in .NET (Manning Publications, 2009), “a given piece of code should be easy and quick to write a unit test against.”

#### Aspects and Goals for what makes a testable design

- Avoided complex `private` methods. Especially, `private` method that would make a certain kind of testing difficult during testing process.
- Avoided the `Singleton`. The `Singleton` enhances the ambiguity of API, and these API mask real dependencies and bring a couple of unnecessary tight coupling between class.
- Avoid `static` methods. Implement of `static` method will be easier to introduce a series of tight coupling, and result in unstable code structure.
- Avoid `new` statement. Instantiating class with new will also cause unclear API and reduce the testability of the code. 

#### common-collections testable design
In this `commons-collections` library, we found a method called `forEach` in `IterableUtils` class, we notice that it's kind of static method. According to above aspects, we could create a new method called `forEachV2`  and make it as `public` method for  testable design.

Orgin method is shown as following code
``` java
static <E> void forEach(final Iterable<E> iterable, final Closure<? super E> closure) {
        IteratorUtils.forEach(emptyIteratorIfNull(iterable), closure);
    }
```
 and new method
 ``` java
public <E> void forEachV2(final Iterable<E> iterable, final Closure<? super E> closure) {
        IteratorUtils.forEach(emptyIteratorIfNull(iterable), closure);
    }
```
we ceate a new unit test and make new method available for testable design, and the test case is stored in `/src/test/java/org/apache/commons/collections4/TestCasePart5.java`
```java
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
```
and the test result is shown in following Figure#1

<center><img src= https://i.imgur.com/GoQHt3m.png /></center>
<center>Figure#1 Test result</center>

#### Introduction to Mocking
The concept of `mock` is actually very simple. We have also introduced it before: the so-called mock is to create a false object of a class, and in the test environment, it is used to replace the real object to achieve two purposes:
- Verify that some methods of this object are called, how many times are called, what are the parameters, etc.
- Specifies the behavior of certain methods of this object, returning a specific value, or performing a specific action

To use Mock, We will use the `Mockito` framework, which is the most widely used mock framework in the Java world.

#### The role of Mocking and Mockito

- `Mockito` is a mocking framework that allows you to test with a concise API. And `Mockito` is easy to learn, it's readable and the validation syntax is concise.
- In object-oriented programming, a mock object is a fake object that simulates the behavior of a real object in a controllable way.
- Programmers often create mock objects to test the behavior of other objects, much like car designers use crash test dummies to simulate the dynamic behavior of people in vehicle crashes.

#### Mock commons-collections
##### Select one to mock

Here we choose to mock `hashCode()` which is in   `AbstractLinkedList`, the original code is as follows:
``` java
public int hashCode() {
        int hashCode = 1;
        for (final E e : this) {
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        }
        return hashCode;
    }

```
The reason we choose this is, firstly, because this feature can be mocked, but it has not been mocked yet, so we think about whether we can try to mock this feature. Secondly, this method involves `hashcode`, and we hope to mock more cases to verify whether it can run successfully.

##### Start Mocking
First, we go to the `pom.xml` file to configure the maven required for `mocking`, as follows, here we use `Mockito (version 4.3.1)`, `Junit (version 5.8.2)`.
``` t
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>4.3.1</version>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.8.2</version>
</dependency>
```
Then the test starts, let's set up and use the `mock` function first.
``` java
 @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
```
Next, we use `Mockito` to test the function. We specifically use the `verify()` method, which can verify that we get the result we need.
``` java
@Test
    void testHashCode() {
        Element element = Mockito.mock(Element.class);
        System.out.println(element.hashCode());
        Mockito.verify(element).hashCode();
    }
```
### Reference
https://livebook.manning.com/book/effective-unit-testing/chapter-7/
https://search.maven.org/artifact/org.mockito/mockito-all/2.0.2-beta/jar
https://search.maven.org/artifact/org.junit.jupiter/junit-jupiter/5.8.2/jar




Documentation
-------------

More information can be found on the [Apache Commons Collections homepage](https://commons.apache.org/proper/commons-collections).
The [Javadoc](https://commons.apache.org/proper/commons-collections/apidocs) can be browsed.
Questions related to the usage of Apache Commons Collections should be posted to the [user mailing list][ml].

Where can I get the latest release?
-----------------------------------
You can download source and binaries from our [download page](https://commons.apache.org/proper/commons-collections/download_collections.cgi).

Alternatively you can pull it from the central Maven repositories:

```xml
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-collections4</artifactId>
  <version>4.4</version>
</dependency>
```

Contributing
------------

We accept Pull Requests via GitHub. The [developer mailing list][ml] is the main channel of communication for contributors.
There are some guidelines which will make applying PRs easier for us:
+ No tabs! Please use spaces for indentation.
+ Respect the code style.
+ Create minimal diffs - disable on save actions like reformat source code or organize imports. If you feel the source code should be reformatted create a separate PR for this change.
+ Provide JUnit tests for your changes and make sure your changes don't break any existing tests by running ```mvn clean test```.

If you plan to contribute on a regular basis, please consider filing a [contributor license agreement](https://www.apache.org/licenses/#clas).
You can learn more about contributing via GitHub in our [contribution guidelines](CONTRIBUTING.md).

License
-------
This code is under the [Apache License v2](https://www.apache.org/licenses/LICENSE-2.0).

See the `NOTICE.txt` file for required notices and attributions.

Donations
---------
You like Apache Commons Collections? Then [donate back to the ASF](https://www.apache.org/foundation/contributing.html) to support the development.

Additional Resources
--------------------

+ [Apache Commons Homepage](https://commons.apache.org/)
+ [Apache Issue Tracker (JIRA)](https://issues.apache.org/jira/browse/COLLECTIONS)
+ [Apache Commons Twitter Account](https://twitter.com/ApacheCommons)
+ `#apache-commons` IRC channel on `irc.freenode.org`

[ml]:https://commons.apache.org/mail-lists.html
