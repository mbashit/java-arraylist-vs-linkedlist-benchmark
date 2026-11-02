# ArrayList vs LinkedList Benchmark (Java)

![Java](https://img.shields.io/badge/Java-Collections-ED8B00?logo=openjdk&logoColor=white) ![JUnit 5](https://img.shields.io/badge/tests-JUnit%205-25A162?logo=junit5&logoColor=white)

A small benchmarking tool that measures how `ArrayList` and `LinkedList` perform on the same workload and prints a side-by-side timing table — a practical look at **Big-O in the real world**.

## What it measures

For each list implementation, 100,000 operations of:

| Operation | ArrayList | LinkedList |
|---|---|---|
| `add(e)` (append) | amortised **O(1)** | **O(1)** |
| `get(i)` (random access) | **O(1)** | **O(n)** |
| `remove(i)` (from the tail) | **O(1)** (no shifting at the end) | **O(1)** (traverses from the nearer end) |

`get(i)` is where the difference is dramatic: `LinkedList` must walk the nodes for every lookup. Both lists are used through the `List<Integer>` interface, so the exact same code drives each implementation.

## Sample output

```
Testing ArrayList...
Method     | Operations      | Time (ms)
---------------------------------------------
add        | 100000          | …
get        | 100000          | …
delete     | 100000          | …
```

## Run

```bash
mvn compile exec:java -Dexec.mainClass=com.example.Main
mvn test   # JUnit 5 tests for each benchmark method
```

## Notes

This is a simple wall-clock benchmark (`System.currentTimeMillis`). For production-grade measurements, a harness such as **JMH** is needed to account for JIT warm-up and GC.
