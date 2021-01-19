package com.abdhilabs.data.abstraction

abstract class Mapper<in I, out O> {
    abstract fun map(input: I): O
}