package com.example.singleton_annotation_and_scopes_compose.qualifiers

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class EmailQualifier()
