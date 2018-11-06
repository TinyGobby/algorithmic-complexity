/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.io.*;

/*
To build:
cd test
mvn clean install

To run:
java -jar target/benchmarks.jar -rf csv

Output will be in test/jmh-result.csv

To see samples with various other code blocks:
http://hg.openjdk.java.net/code-tools/jmh/file/06c8e8aa576b/jmh-samples/src/main/java/org/openjdk/jmh/samples/
 */
public class MyBenchmark {

    @State(Scope.Benchmark)
    public static class MyState {

        // Update parameters to set array sizes, each parameter will be listed on a separate line in the results
        @Param({"1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "9000", "10000",
                // Logarithmic array sizes, discard or comment out as necessary
                "1", "10", "100", "1000", "10000", "100000", "1000000"})
        public int arraySize;

        @Setup(Level.Iteration)
        public void doSetup() {
            for (int i = 0; i < arraySize; i++) {
                list.add((int) (Math.random() * 1000));
            }
        }
        @TearDown(Level.Iteration)
        public void doTearDown() {
            list.clear();
        }
        public ArrayList<Integer> list = new ArrayList<Integer>();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS) // NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS...
    @Fork(value = 1)
    @Warmup(iterations = 20, time = 5, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 100, time = 5, timeUnit = TimeUnit.MILLISECONDS)
    public void testMethod(MyState state) {
        // Code to be tested goes here, or uncomment the below to test ArrayList methods:

//        state.list.get(state.list.size()-1); // Last
//        Collections.reverse(state.list); // Reverse
        Collections.shuffle(state.list); // Shuffle
//        Collections.sort(state.list); // Sort
    }
}
