package ch01.ex10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class Collections {

    // Collection, default
    @SuppressWarnings("unchecked")
    static <T> boolean addAll(Collection<? super T> c, T... elements) {
        return false;
    }

    // Deque, default
    static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return null;
    }

    // List, default
    static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        return 0;
    }

    // List, default
    static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        return 0;
    }

    // Collection, default
    static <E> Collection<E> checkedCollection(Collection<E> c, Class<E> type) {
        return null;
    }

    // List, default
    static <E> List<E> checkedList(List<E> list, Class<E> type) {
        return null;
    }

    // Map, default
    static <K, V> Map<K, V> checkedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
        return null;
    }

    // NavigableMap, default
    static <K, V> NavigableMap<K, V> checkedNavigableMap(NavigableMap<K, V> m, Class<K> keyType, Class<V> valueType) {
        return null;
    }

    // NavigableSet, default
    static <E> NavigableSet<E> checkedNavigableSet(NavigableSet<E> s, Class<E> type) {
        return null;
    }

    // Queue, default
    static <E> Queue<E> checkedQueue(Queue<E> queue, Class<E> type) {
        return null;
    }

    // Set, default
    static <E> Set<E> checkedSet(Set<E> s, Class<E> type) {
        return null;
    }

    // SortedMap, default
    static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
        return null;
    }

    // SortedSet, default
    static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s, Class<E> type) {
        return null;
    }

    // List, default
    static <T> void copy(List<? super T> dest, List<? extends T> src) {
    }

    // Collection, default
    static boolean disjoint(Collection<?> c1, Collection<?> c2) {
        return false;
    }

    // Enumeration, static
    static <T> Enumeration<T> emptyEnumeration() {
        return null;
    }

    // Iterator, static
    static <T> Iterator<T> emptyIterator() {
        return null;
    }

    // List, static
    static <T> List<T> emptyList() {
        return null;
    }

    // ListIterator, static
    static <T> ListIterator<T> emptyListIterator() {
        return null;
    }

    // Map, static
    static <K, V> Map<K, V> emptyMap() {
        return null;
    }

    // NavigableMap, static
    static <K, V> NavigableMap<K, V> emptyNavigableMap() {
        return null;
    }

    // NavigableSet, static
    static <E> NavigableSet<E> emptyNavigableSet() {
        return null;
    }

    // Set, static
    static <T> Set<T> emptySet() {
        return null;
    }

    // SortedMap, static
    static <K, V> SortedMap<K, V> emptySortedMap() {
        return null;
    }

    // SortedSet, static
    static <E> SortedSet<E> emptySortedSet() {
        return null;
    }

    // Collection, default
    static <T> Enumeration<T> enumeration(Collection<T> c) {
        return null;
    }

    // List, default
    static <T> void fill(List<? super T> list, T obj) {
    }

    // Collection, default
    static int frequency(Collection<?> c, Object o) {
        return 0;
    }

    // List, default
    static int indexOfSubList(List<?> source, List<?> target) {
        return 0;
    }

    // List, default
    static int lastIndexOfSubList(List<?> source, List<?> target) {
        return 0;
    }

    // Enumeration, default
    static <T> ArrayList<T> list(Enumeration<T> e) {
        return null;
    }

    // Collection, default
    static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        return null;
    }

    // Collection, default
    static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
        return null;
    }

    // Collection, default
    static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) {
        return null;
    }

    // Collection, default
    static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp) {
        return null;
    }

    // Object, default
    static <T> List<T> nCopies(int n, T o) {
        return null;
    }

    // Map, default
    static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return null;
    }

    // List, default
    static <T> boolean replaceAll(List<T> list, T oldVal, T newVal) {
        return false;
    }

    // List, default
    static void reverse(List<?> list) {
    }

    // Comparator, static
    static <T> Comparator<T> reverseOrder() {
        return null;
    }

    // Comparator, default
    static <T> Comparator<T> reverseOrder(Comparator<T> cmp) {
        return null;
    }

    // List, default
    static void rotate(List<?> list, int distance) {
    }

    // List, default
    static void shuffle(List<?> list) {
    }

    // List, default
    static void shuffle(List<?> list, Random rnd) {
    }

    // Object, default
    static <T> Set<T> singleton(T o) {
        return null;
    }

    // Object, default
    static <T> List<T> singletonList(T o) {
        return null;
    }

    // Object, default
    static <K, V> Map<K, V> singletonMap(K key, V value) {
        return null;
    }

    // List, default
    static <T extends Comparable<? super T>> void sort(List<T> list) {
    }

    // List, default
    static <T> void sort(List<T> list, Comparator<? super T> c) {
    }

    // List, default
    static void swap(List<?> list, int i, int j) {
    }

    // Collection, default
    static <T> Collection<T> synchronizedCollection(Collection<T> c) {
        return null;
    }

    // List, default
    static <T> List<T> synchronizedList(List<T> list) {
        return null;
    }

    // Map, default
    static <K, V> Map<K, V> synchronizedMap(Map<K, V> m) {
        return null;
    }

    // NavigableMap, default
    static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> m) {
        return null;
    }

    // NavigableSet, default
    static <T> NavigableSet<T> synchronizedNavigableSet(NavigableSet<T> s) {
        return null;
    }

    // Set, default
    static <T> Set<T> synchronizedSet(Set<T> s) {
        return null;
    }

    // SortedMap, default
    static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> m) {
        return null;
    }

    // SortedSet, default
    static <T> SortedSet<T> synchronizedSortedSet(SortedSet<T> s) {
        return null;
    }

    // Collection, default
    static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c) {
        return null;
    }

    // List, default
    static <T> List<T> unmodifiableList(List<? extends T> list) {
        return null;
    }

    // Map, default
    static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m) {
        return null;
    }

    // NavigableMap, default
    static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> m) {
        return null;
    }

    // NavigableSet, default
    static <T> NavigableSet<T> unmodifiableNavigableSet(NavigableSet<T> s) {
        return null;
    }

    // Set, default
    static <T> Set<T> unmodifiableSet(Set<? extends T> s) {
        return null;
    }

    // SortedMap, default
    static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> m) {
        return null;
    }

    // SortedSet, default
    static <T> SortedSet<T> unmodifiableSortedSet(SortedSet<T> s) {
        return null;
    }

}
