extra.apply {
    set("compose_ui_version", "1.2.0")
}

plugins {
    id ("com.android.application") version "7.4.2" apply false
    id ("com.android.library") version "7.4.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.0" apply false
    `kotlin-dsl`
}