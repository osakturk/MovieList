package com.example.moviecase.di.qualifiers

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
//ViewModel'ları daggerla injectable hale getiriyoruz
//Her viewModel için bir annotation oluşturmak yerine, generic annotation yapısı oluşturuldu
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)