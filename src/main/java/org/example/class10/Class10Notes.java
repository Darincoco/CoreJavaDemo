package org.example.class10;

public class Class10Notes {
/*
1. Exception handling
    @ExceptionHandler -> local
    @ControllerAdvice -> global
    @ResponseStatus -> ResponseStatusExceptionResolver class
    No annotation -> DefaultHandlerExceptionResolver


2. Validation (use jakarta)
    @NotBlank: not empty("")
    @NotNull: not null, but can blank
    @Min() - @Max()
    @Email: in a email format
    @Pattern(reg expression)
    @Validated: based on the annotations asked in the class object


3. Cache:
    Cache miss/ Cache hit
    @EnableCache
    @Cacheable()
    CacheManager

    Eviction Policy
        LRU cache(least recent used) -> LinkedHashMap, LinkedList + HashMap
        LFU cache(least frequent used)
        No-eviction: when fulled, new cache come in and dropped directly
        Random
        Most recently used


4.
 */
}
