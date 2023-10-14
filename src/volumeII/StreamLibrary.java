package volumeII;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLibrary {
    /**
     * A stream seems superficially similar to a collection, allowing you to transform
     * and retrieve data. But there are significant differences:
     * 1. A stream does not store its elements. They may be stored in an underlying
     * collection or generated on demand.
     * 2. Stream operations don’t mutate their source. For example, the filter method
     * does not remove elements from a new stream, but it yields a new stream in
     * which they are not present.
     * 3. Stream operations are lazy when possible. This means they are not executed
     * until their result is needed. For example, if you only ask for the first five long
     * words instead of all, the filter method will stop filtering after the fifth match.
     * As a consequence, you can even have infinite streams!
     *
     * Use Arrays.stream(array, from, to) to make a stream from array elements between
     * positions from (inclusive) and to (exclusive).
     *
     * */
    public static void main(){

        String contents = "her get they country those young food make" +
                " him on always an carry below began soon quick idia " +
                "began air do line look should she last most last move" +
                " boy life let follow or left find in high found between" +
                " earth white great ask river each first use it me";
        List<String> words = Arrays.asList(contents.split(" "));
        System.out.println("total words count: " + words.size());

        Stream<String> wordss = Stream.of(contents.split(" "));
        // split returns a String[] array


        long count = words.parallelStream().filter(w->w.length()>4).count();
        System.out.println(count);

        List<Integer> numberSequence = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9});
        List<Integer> squares = numberSequence.stream().map(n -> n*n).toList();
        System.out.println(squares);

        /**
         * Suppose you map the letters method on a stream of strings:
         * Stream<Stream<String>> result = words.stream().map(w -> letters(w));
         * 1.3 The filter, map, and flatMap Methods 9
         * From the Library of Hristo Dimov Hristov
         * ptg18360597
         * You will get a stream of streams, like [. . . ["y", "o", "u", "r"], ["b", "o", "a", "t"], . . .].
         * To flatten it out to a stream of letters [. . . "y", "o", "u", "r", "b", "o", "a", "t", . . .],
         * use the flatMap method instead of map:
         * Stream<String> flatResult = words.stream().flatMap(w -> letters(w))
         *  // Calls letters on each word and flattens the results
         *
         *  The call stream.limit(n) returns a new stream that ends after n elements (or
         * when the original stream ends, if it is shorter)
         *
         * The call stream.skip(n) does the exact opposite: It discards the first n elements.
         * */
        List<Integer> cubes = numberSequence.stream().map(n -> n*n*n).toList();
        System.out.println(cubes);

        List<Integer> cubes1 = numberSequence.stream().map(n -> n*n*n).limit(6).toList();
        System.out.println(cubes1);

        List<Integer> cubes2 = numberSequence.stream().map(n -> n*n*n).skip(6).toList();
        System.out.println(cubes2);

        List<Integer> concated = Stream.concat(cubes1.stream(),cubes2.stream()).toList();
        /** sum and average of a list */
        System.out.println("sum: " + concated.stream().mapToInt(Integer::intValue).sum());
        System.out.println("average: " + concated.stream().mapToInt(Integer::intValue).average().orElse(0));

        /**
         * The distinct method returns a stream that yields elements from the original stream,
         * in the same order, except that duplicates are suppressed. The stream must
         * obviously remember the elements that it has already seen.
         * */
        Stream<String> uniqueWords
                = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        // Only one "merrily" is retained
        System.out.println(uniqueWords.toList());

        /** sort method:*/
        Stream<String> longestFirst =
                words.stream().sorted(Comparator.comparing(String::length).reversed());
        System.out.println(longestFirst.toList());

        /**
         *  the peek method yields another stream with the same elements as the
         * original, but a function is invoked every time an element is retrieved. That is
         * handy for debugging:
         * */
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> {
                    if(e > 20) System.out.println("Fetching " + e);
                })
                .limit(12).toArray();

        /**
         * . Reductions are terminal operations.
         * They reduce the stream to a non-stream value that can be used in your program.
         * There is a twist—these methods return an Optional<T> value that either wraps the
         * answer or indicates that there is none (because the stream happened to be empty).
         * */
        System.out.println("count "+ words.stream().count());
        System.out.println("min "+ words.stream().min(String::compareToIgnoreCase).get());
        System.out.println("max "+ words.stream().max(String::compareToIgnoreCase).orElse(""));

        /**
         * The findFirst returns the first value in a nonempty collection. It is often useful
         * when combined with filter. For example, here we find the first word that
         * starts with the letter w, if it exists:
         * */
        Optional<String> startsWithW = words.stream().map(String::toLowerCase).filter(s -> s.startsWith("w")).findFirst();
        System.out.println(startsWithW.orElse(""));

        /** findAny() (instead of findFirst())*/
        Optional<String> startsWithA = words.stream().map(String::toLowerCase).filter(s -> s.startsWith("a")).findAny();
        System.out.println(startsWithA.orElse(""));

        /**
         * • boolean anyMatch(Predicate<? super T> predicate)
         * • boolean allMatch(Predicate<? super T> predicate)
         * • boolean noneMatch(Predicate<? super T> predicate)
         * returns true if any, all, or none of the elements of this stream match the given
         * predicate.
         * */

        /**
         * OPTIONAL:
         * The key to using Optional effectively is to use a method that either produces an
         * alternative if the value is not present, or consumes the value only if it is present.
         * Let us look at the first strategy. Often, there is a default that you want to use when
         * there was no match, perhaps the empty string:
         * String result = optionalString.orElse("");
         *  // The wrapped string, or "" if none
         *
         *  The ifPresent method accepts a function. If the optional value exists, it is passed
         * to that function. Otherwise, nothing happens.
         * optionalValue.ifPresent(v -> Process v);
         * For example, if you want to add the value to a set if it is present, call
         * optionalValue.ifPresent(v -> results.add(v));
         * or simply
         * optionalValue.ifPresent(results::add)
         *
         * The get method gets the wrapped element of an Optional value if it exists, or throws
         * a NoSuchElementException if it doesn’t. Therefore,
         * Optional<T> optionalValue = . . .;
         * optionalValue.get().someMethod();
         *
         * So far, we have discussed how to consume an Optional object someone else created.
         * If you want to write a method that creates an Optional object, there are several
         * static methods for that purpose, including Optional.of(result) and Optional.empty().
         *
         * collecting the stream result : .toArray(), .toList(), .toSet(), .forEach(),
         *
         * */

        /**
         * Map:
         * Suppose you have a Stream<Person> and want to collect the elements into a map so
         * that later you can look up people by their IDs. The Collectors.toMap method has
         * two function arguments that produce the map’s keys and values. For example,
         * Map<Integer, String> idToName = people.collect(
         *  Collectors.toMap(Person::getId, Person::getName));
         * In the common case when the values should be the actual elements, use
         * Function.identity() for the second function.
         * Map<Integer, Person> idToPerson = people.collect(
         *  Collectors.toMap(Person::getId, Function.identity()));
         * */

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
//        Map<String, String> languageNames = locales.collect(
//                Collectors.toMap(
//                        Locale::getDisplayLanguage,
//                        l -> l.getDisplayLanguage(l),
//                        (existingValue, newValue) -> existingValue));
//
//        System.out.println("Locale");
//        System.out.println(languageNames);

//        Map<String, Set<String>> countryLanguageSets = locales.collect(
//                Collectors.toMap(
//        Locale::getDisplayCountry,
//                l -> Collections.singleton(l.getDisplayLanguage()),
//                (a, b) ->
//                { // Union of a and b
//                    Set<String> union = new HashSet<>(a);
//                    union.addAll(b);
//                    return union;
//                }));
//        System.out.println("languages: " );
//        for(String s : countryLanguageSets.keySet()) System.out.println(s +": "+countryLanguageSets.get(s));

        /**
         * GROUPING
         * In the preceding section, you saw how to collect all languages in a given country.
         * But the process was a bit tedious. You had to generate a singleton set for each
         * map value and then specify how to merge the existing and new values. Forming
         * groups of values with the same characteristic is very common, and the groupingBy
         * method supports it directly.
         * Let’s look at the problem of grouping locales by country. First, form this map:
         * */
        Map<String, List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry));
        countryToLocales.keySet().forEach(i -> System.out.println(countryToLocales.get(i)));

        /**
         * PARTITIONING
         * When the classifier function is a predicate function (that is, a function returning
         * a boolean value), the stream elements are partitioned into two lists: those where
         * the function returns true and the complement. In this case, it is more efficient to use
         * partitioningBy instead of groupingBy. For example, here we split all locales into those
         * that use English and all others:
         * */
        Stream<Locale> locales1 = Stream.of(Locale.getAvailableLocales());
        Map<Boolean , List<Locale>> englishAndOtherLocales = locales1.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));

        /**
         * The groupingBy method yields a map whose values are lists. If you want to process
         * those lists in some way, supply a “downstream collector.” For example, if you
         * want sets instead of lists, you can use the Collectors.toSet collector that you saw in
         * the previous section:
         * Map<String, Set<Locale>> countryToLocaleSet = locales.collect(
         *  groupingBy(Locale::getCountry, toSet()));
         * */

        /**
         * Several collectors are provided for reducing grouped elements to numbers:
         *
         * • counting produces a count of the collected elements. For example,
         *      Map<String, Long> countryToLocaleCounts = locales.collect(
         *      groupingBy(Locale::getCountry, counting()));
         *      counts how many locales there are for each country.
         * • summing(Int|Long|Double) takes a function argument, applies the function to the
         *      downstream elements, and produces their sum. For example,
         *      Map<String, Integer> stateToCityPopulation = cities.collect(
         *      groupingBy(City::getState, summingInt(City::getPopulation)));
         *      computes the sum of populations per state in a stream of cities.
         *      1.11 Downstream Collectors 29
         * • maxBy and minBy take a comparator and produce maximum and minimum of the
         *      downstream elements. For example,
         *      Map<String, Optional<City>> stateToLargestCity = cities.collect(
         *      groupingBy(City::getState,
         *      maxBy(Comparator.comparing(City::getPopulation))));
         *      produces the largest city per state.
         * */

        /**
         * The reduce method is a general mechanism for computing a value from a
         * stream. The simplest form takes a binary function and keeps applying it, starting
         * with the first two elements. It’s easy to explain this if the function is the sum:
         * */
        Optional<Integer> processed = numberSequence.stream().limit(6).reduce((x,y)-> x+y);
        System.out.println(numberSequence);
        System.out.println(processed.orElse(0));

        /**
         * Now suppose you have a stream of objects and want to form the sum of some
         * property, such as all lengths in a stream of strings. You can’t use the simple form
         * of reduce. It requires a function (T, T) -> T, with the same types for the arguments
         * and the result. But in this situation, you have two types: The stream elements have
         * type String, and the accumulated result is an integer. There is a form of reduce that
         * can deal with this situation.
         * First, you supply an “accumulator” function (total, word) -> total + word.length(). That
         * function is called repeatedly, forming the cumulative total. But when the computation is parallelized, there will be multiple computations of this kind, and you
         * need to combine their results. You supply a second function for that purpose.
         * The complete call is
         * int result = words.reduce(0,
         *  (total, word) -> total + word.length(),
         *  (total1, total2) -> total1 + total2);
         * */











    }
}
