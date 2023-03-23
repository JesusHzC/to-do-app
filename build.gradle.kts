extra.apply {
    set("compose_ui_version", "1.2.0")
    set("dagger_hilt_version", "2.44")
    set("navigation_version", "2.5.3")
    set("retrofit_version", "2.9.0")
    set("okhttp_version", "4.10.0")
    set("room_version", "2.4.3")
}

plugins {
    id("com.android.application") version "7.4.2" apply false
    id("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    `kotlin-dsl`
}