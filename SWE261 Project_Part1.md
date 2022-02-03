
## Part-1

### Project-Relevant

- **Purpose**:The tools we are testing is [The Apache Commons Collections package](//https://github.com/apache/commons-collections). The package contains types that extend and augment the Java Collections Framework. It allows us to develop applications in a way that ensures performance while also greatly simplifying the code.

- **Language**: Java

- **Number of class**: 590

  `find . -name '*.java' | wc -l`

- **Lines of Codes:** 130157

  `find . -name '*.java' | xargs wc -l`

- **Number of Packages(Apache Commons Collections 4.4 API)**: 19

### Previous-Test-Case

- The previous test is in [connections-tests](//https://github.com/apache/commons-collections)

- Current test cases covering the following aspect:![]()
<img src="https://i.imgur.com/Udn8H0A.png" width="50%" height="%" />

- Build
You can download source and binaries from our [download page](https://commons.apache.org/proper/commons-collections/download_collections.cgi).
 Specific steps are as follows:
 1.Copy the repository to local
 2.Use IntelliJ IDEA to import the project as a maven project 
 3.Open the pom.xml file and select Maven and then select Reload Project

- Run

```xml
 <dependency>
   <groupId>org.apache.commons</groupId>
   <artifactId>commons-collections4</artifactId>
   <version>4.4</version>
 </dependency>
```



### New-Test-Case

- We will explore the main need for systematic functional testing and partition testing and then summarize the following point:

  If we systematically test some cases from each part, and since we test different densities, it may cause some errors.

- Now, the feature that we choose for partitioning is static void reverse(List<?> list). Its function is to reverse the order of all elements of a list, we will use four test cases to test our partitions and boundaries, and use J-unit to test the case on IntelliJ IDEA.



