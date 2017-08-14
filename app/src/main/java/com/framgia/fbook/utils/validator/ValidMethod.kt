package com.framgia.fbook.utils.validator

/**
 * Created by le.quang.dao on 17/03/2017.
 */

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ValidMethod(val type: IntArray)
