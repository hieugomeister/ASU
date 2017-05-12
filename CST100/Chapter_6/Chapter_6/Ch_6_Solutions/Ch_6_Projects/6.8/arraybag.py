"""
File: arraybag.py
Project 6.8
Author: Ken Lambert

Eliminates redundant search during remove.
"""

from arrays import Array
from abstractbag import AbstractBag

class ArrayBag(AbstractBag):
    """An array-based bag implementation."""

    # Class variable
    DEFAULT_CAPACITY = 10

    # Constructor
    def __init__(self, sourceCollection = None):
        """Sets the initial state of self, which includes the
        contents of sourceCollection, if it's present."""
        self._items = Array(ArrayBag.DEFAULT_CAPACITY)
        self._targetIndex = -1
        AbstractBag.__init__(self, sourceCollection)

    # Accessor methods
    def __iter__(self):
        """Supports iteration over a view of self."""
        cursor = 0
        while cursor < len(self):
            yield self._items[cursor]
            cursor += 1

    def __contains__(self, item):
        """Returns True if item is in self or False otherwise."""
        self._targetIndex = 0
        for targetItem in self:
            if item == targetItem: return True
            self._targetIndex += 1
        self._targetIndex = -1
        return False
        
    # Mutator methods
    def clear(self):
        """Makes self become empty."""
        self._size = 0
        self._items = Array(ArrayBag.DEFAULT_CAPACITY)

    def add(self, item):
        """Adds item to self."""
        # Check array memory here and increase it if necessary
        if len(self) == len(self._items):
            temp = Array(2 * len(self))
            for i in range(len(self)):
                temp[i] = self[i]
            self._items = temp
        self._items[len(self)] = item
        self._size += 1

    def remove(self, item):
        """Precondition: item is in self.
        Raises: KeyError if item in not in self.
        Postcondition: item is removed from self."""
        # Check precondition and raise if necessary
        if not item in self:
            raise KeyError(str(item) + " not in bag")
        # Shift items to the left of target up by one position
        for i in range(self._targetIndex, len(self) - 1):
            self._items[i] = self._items[i + 1]
        # Decrement logical size
        self._size -= 1
        # Check array memory here and decrease it if necessary
        if len(self) < len(self._items) // 3 and \
           2 * len(self) >= ArrayBag.DEFAULT_CAPACITY:
            temp = Array(len(self._items) // 2)
            for i in range(len(self)):
                temp[i] = self[i]
            self._items = temp
         
        
