package com.example.deliveryapp

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.ksp.generated.module

@Module
@ComponentScan("com.example.deliveryapp")
class AppModule

val appModule = AppModule().module