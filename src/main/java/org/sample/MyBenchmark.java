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
                "11000", "12000", "13000", "14000", "15000", "16000", "17000", "18000", "19000", "20000",
                "21000", "22000", "23000", "24000", "25000", "26000", "27000", "28000", "29000", "30000",
                "31000", "32000", "33000", "34000", "35000", "36000", "37000", "38000", "39000", "40000",
                "41000", "42000", "43000", "44000", "45000", "46000", "47000", "48000", "49000", "50000",
                "51000", "52000", "53000", "54000", "55000", "56000", "57000", "58000", "59000", "60000",
                "61000", "62000", "63000", "64000", "65000", "66000", "67000", "68000", "69000", "70000",
                "71000", "72000", "73000", "74000", "75000", "76000", "77000", "78000", "79000", "80000",
                "81000", "82000", "83000", "84000", "85000", "86000", "87000", "88000", "89000", "90000",
                "91000", "92000", "93000", "94000", "95000", "96000", "97000", "98000", "99000", "100000",
                // Logarithmic array sizes, discard or comment out as necessary
                "101000", "102000", "103000", "104000", "105000", "106000", "107000", "108000", "109000", "100000",
                "111000", "112000", "113000", "114000", "115000", "116000", "117000", "118000", "119000", "120000",
                "121000", "122000", "123000", "124000", "125000", "126000", "127000", "128000", "129000", "130000",
                "131000", "132000", "133000", "134000", "135000", "136000", "137000", "138000", "139000", "140000",
                "141000", "142000", "143000", "144000", "145000", "146000", "147000", "148000", "149000", "150000",
                "151000", "152000", "153000", "154000", "155000", "156000", "157000", "158000", "159000", "160000",
                "161000", "162000", "163000", "164000", "165000", "166000", "167000", "168000", "169000", "170000",
                "171000", "172000", "173000", "174000", "175000", "176000", "177000", "178000", "179000", "180000",
                "181000", "182000", "183000", "184000", "185000", "186000", "187000", "188000", "189000", "190000",
                "191000", "192000", "193000", "194000", "195000", "196000", "197000", "198000", "199000", "1100000",
                // Logarithmic array sizes, discard or comment out as necessary
                "201000", "202000", "203000", "204000", "205000", "206000", "207000", "208000", "209000", "200000",
                "211000", "212000", "213000", "214000", "215000", "216000", "217000", "218000", "219000", "220000",
                "221000", "222000", "223000", "224000", "225000", "226000", "227000", "228000", "229000", "230000",
                "231000", "232000", "233000", "234000", "235000", "236000", "237000", "238000", "239000", "240000",
                "241000", "242000", "243000", "244000", "245000", "246000", "247000", "248000", "249000", "250000",
                "251000", "252000", "253000", "254000", "255000", "256000", "257000", "258000", "259000", "260000",
                "261000", "262000", "263000", "264000", "265000", "266000", "267000", "268000", "269000", "270000",
                "271000", "272000", "273000", "274000", "275000", "276000", "277000", "278000", "279000", "280000",
                "281000", "282000", "283000", "284000", "285000", "286000", "287000", "288000", "289000", "290000",
                "291000", "292000", "293000", "294000", "295000", "296000", "297000", "298000", "299000", "300000",
                // Logarithmic array sizes, discard or comment out as necessary
                "301000", "302000", "303000", "304000", "305000", "306000", "307000", "308000", "309000", "300000",
                "311000", "312000", "313000", "314000", "315000", "316000", "317000", "318000", "319000", "320000",
                "321000", "322000", "323000", "324000", "325000", "326000", "327000", "328000", "329000", "330000",
                "331000", "332000", "333000", "334000", "335000", "336000", "337000", "338000", "339000", "340000",
                "341000", "342000", "343000", "344000", "345000", "346000", "347000", "348000", "349000", "350000",
                "351000", "352000", "353000", "354000", "355000", "356000", "357000", "358000", "359000", "360000",
                "361000", "362000", "363000", "364000", "365000", "366000", "367000", "368000", "369000", "370000",
                "371000", "372000", "373000", "374000", "375000", "376000", "377000", "378000", "379000", "380000",
                "381000", "382000", "383000", "384000", "385000", "386000", "387000", "388000", "389000", "390000",
                "391000", "392000", "393000", "394000", "395000", "396000", "397000", "398000", "399000", "400000",
                // Logarithmic array sizes, discard or comment out as necessary
                "401000", "402000", "403000", "404000", "405000", "406000", "407000", "408000", "409000", "400000",
                "411000", "412000", "413000", "414000", "415000", "416000", "417000", "418000", "419000", "420000",
                "421000", "422000", "423000", "424000", "425000", "426000", "427000", "428000", "429000", "430000",
                "431000", "432000", "433000", "434000", "435000", "436000", "437000", "438000", "439000", "440000",
                "441000", "442000", "443000", "444000", "445000", "446000", "447000", "448000", "449000", "450000",
                "451000", "452000", "453000", "454000", "455000", "456000", "457000", "458000", "459000", "460000",
                "461000", "462000", "463000", "464000", "465000", "466000", "467000", "468000", "469000", "470000",
                "471000", "472000", "473000", "474000", "475000", "476000", "477000", "478000", "479000", "480000",
                "481000", "482000", "483000", "484000", "485000", "486000", "487000", "488000", "489000", "490000",
                "491000", "492000", "493000", "494000", "495000", "496000", "497000", "498000", "499000", "500000",
                // Logarithmic array sizes, discard or comment out as necessary
                "501000", "502000", "503000", "504000", "505000", "506000", "507000", "508000", "509000", "500000",
                "511000", "512000", "513000", "514000", "515000", "516000", "517000", "518000", "519000", "520000",
                "521000", "522000", "523000", "524000", "525000", "526000", "527000", "528000", "529000", "530000",
                "531000", "532000", "533000", "534000", "535000", "536000", "537000", "538000", "539000", "540000",
                "541000", "542000", "543000", "544000", "545000", "546000", "547000", "548000", "549000", "550000",
                "551000", "552000", "553000", "554000", "555000", "556000", "557000", "558000", "559000", "560000",
                "561000", "562000", "563000", "564000", "565000", "566000", "567000", "568000", "569000", "570000",
                "571000", "572000", "573000", "574000", "575000", "576000", "577000", "578000", "579000", "580000",
                "581000", "582000", "583000", "584000", "585000", "586000", "587000", "588000", "589000", "590000",
                "591000", "592000", "593000", "594000", "595000", "596000", "597000", "598000", "599000", "600000",
                // Logarithmic array sizes, discard or comment out as necessary
                "601000", "602000", "603000", "604000", "605000", "606000", "607000", "608000", "609000", "600000",
                "611000", "612000", "613000", "614000", "615000", "616000", "617000", "618000", "619000", "620000",
                "621000", "622000", "623000", "624000", "625000", "626000", "627000", "628000", "629000", "630000",
                "631000", "632000", "633000", "634000", "635000", "636000", "637000", "638000", "639000", "640000",
                "641000", "642000", "643000", "644000", "645000", "646000", "647000", "648000", "649000", "650000",
                "651000", "652000", "653000", "654000", "655000", "656000", "657000", "658000", "659000", "660000",
                "661000", "662000", "663000", "664000", "665000", "666000", "667000", "668000", "669000", "670000",
                "671000", "672000", "673000", "674000", "675000", "676000", "677000", "678000", "679000", "680000",
                "681000", "682000", "683000", "684000", "685000", "686000", "687000", "688000", "689000", "690000",
                "691000", "692000", "693000", "694000", "695000", "696000", "697000", "698000", "699000", "700000",
                // Logarithmic array sizes, discard or comment out as necessary
                "701000", "702000", "703000", "704000", "705000", "706000", "707000", "708000", "709000", "700000",
                "711000", "712000", "713000", "714000", "715000", "716000", "717000", "718000", "719000", "720000",
                "721000", "722000", "723000", "724000", "725000", "726000", "727000", "728000", "729000", "730000",
                "731000", "732000", "733000", "734000", "735000", "736000", "737000", "738000", "739000", "740000",
                "741000", "742000", "743000", "744000", "745000", "746000", "747000", "748000", "749000", "750000",
                "751000", "752000", "753000", "754000", "755000", "756000", "757000", "758000", "759000", "760000",
                "761000", "762000", "763000", "764000", "765000", "766000", "767000", "768000", "769000", "770000",
                "771000", "772000", "773000", "774000", "775000", "776000", "777000", "778000", "779000", "780000",
                "781000", "782000", "783000", "784000", "785000", "786000", "787000", "788000", "789000", "790000",
                "791000", "792000", "793000", "794000", "795000", "796000", "797000", "798000", "799000", "800000",
                // Logarithmic array sizes, discard or comment out as necessary
                "801000", "802000", "803000", "804000", "805000", "806000", "807000", "808000", "809000", "800000",
                "811000", "812000", "813000", "814000", "815000", "816000", "817000", "818000", "819000", "820000",
                "821000", "822000", "823000", "824000", "825000", "826000", "827000", "828000", "829000", "830000",
                "831000", "832000", "833000", "834000", "835000", "836000", "837000", "838000", "839000", "840000",
                "841000", "842000", "843000", "844000", "845000", "846000", "847000", "848000", "849000", "850000",
                "851000", "852000", "853000", "854000", "855000", "856000", "857000", "858000", "859000", "860000",
                "861000", "862000", "863000", "864000", "865000", "866000", "867000", "868000", "869000", "870000",
                "871000", "872000", "873000", "874000", "875000", "876000", "877000", "878000", "879000", "880000",
                "881000", "882000", "883000", "884000", "885000", "886000", "887000", "888000", "889000", "890000",
                "891000", "892000", "893000", "894000", "895000", "896000", "897000", "898000", "899000", "900000",
                // Logarithmic array sizes, discard or comment out as necessary
                "901000", "902000", "903000", "904000", "905000", "906000", "907000", "908000", "909000", "900000",
                "911000", "912000", "913000", "914000", "915000", "916000", "917000", "918000", "919000", "920000",
                "921000", "922000", "923000", "924000", "925000", "926000", "927000", "928000", "929000", "930000",
                "931000", "932000", "933000", "934000", "935000", "936000", "937000", "938000", "939000", "940000",
                "941000", "942000", "943000", "944000", "945000", "946000", "947000", "948000", "949000", "950000",
                "951000", "952000", "953000", "954000", "955000", "956000", "957000", "958000", "959000", "960000",
                "961000", "962000", "963000", "964000", "965000", "966000", "967000", "968000", "969000", "970000",
                "971000", "972000", "973000", "974000", "975000", "976000", "977000", "978000", "979000", "980000",
                "981000", "982000", "983000", "984000", "985000", "986000", "987000", "988000", "989000", "990000",
                "991000", "992000", "993000", "994000", "995000", "996000", "997000", "998000", "999000", "1000000",

        })
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
//        Collections.shuffle(state.list); // Shuffle
        Collections.sort(state.list); // Sort
    }
}
