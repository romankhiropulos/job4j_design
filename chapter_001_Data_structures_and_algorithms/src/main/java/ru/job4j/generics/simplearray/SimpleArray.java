package ru.job4j.generics.simplearray;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    /*

    В этом задании необходимо сделать универсальную обертку над массивом.

    Создать класс:
    public class SimpleArray<T>

    Добавить методы:

    add(T model) - добавляет указанный элемент (model) в первую свободную ячейку;

    set(int index, T model) - заменяет указанным элементом (model) элемент, находящийся по индексу index;

    remove(int index) - удаляет элемент по указанному индексу, все находящиеся справа элементы при этом
    необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);

    get(int index) - возвращает элемент, расположенный по указанному индексу;

    Также, реализуйте интерфейс Iterable<T> - метод iterator() возвращает итератор,
    предназначенный для обхода данной структуры.

    Объект должен принимать количество ячеек. Структура не должна быть динамической.

    Примечание:
    В методах, где используется индекс нужно делать валидацию.
    Индекс должен находиться в рамках добавленных элементов. Например, у вас есть хранилище из 10 элементов.
    Вы добавили 3 элемента. Каким может быть индекс? [0, 2].
    Для проверки индекса используйте метод Objects.checkIndex.

    */
    private final Object[] storage;

    private final int capacity;

    private int indexCounter = -1;

    public SimpleArray(int capacity) {
        this.capacity = capacity;
        storage = new Object[capacity];
    }

    public void add(T element) {
        Objects.checkIndex(indexCounter + 1, capacity);
        indexCounter++;
        storage[indexCounter] = element;
    }
    
    public T get(int position) {
        Objects.checkIndex(position, indexCounter + 1);
        return (T) storage[position];
    }
    
    public void set(int position, T element) {
        Objects.checkIndex(position, indexCounter + 1);
        storage[position] = element;
    }

    public void remove(int position) {
        Objects.checkIndex(position, indexCounter + 1);
        System.arraycopy(storage, position + 1, storage, position, indexCounter - position - 1);
        indexCounter--;
    }

    public int getIndexCounter() {
        return indexCounter + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleItr();
    }

    private class SimpleItr implements Iterator<T> {

        private int point = 0;

        public SimpleItr() {
        }

        @Override
        public boolean hasNext() {
            return point <= indexCounter;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) storage[point++];
        }
    }
}
