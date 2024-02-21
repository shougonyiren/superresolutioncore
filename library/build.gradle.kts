plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("maven-publish")
}

android {
    namespace = "com.lh.super_resolutionimage_core"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.lh.super_resolutionimage_core"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //工具类
    implementation("com.blankj:utilcodex:1.31.1")
//    //kotlinx-coroutines
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")


    implementation("com.google.guava:guava:30.0-android")


    //华为
    implementation ("com.huawei.hiai.hiai-engine:huawei-hiai-vision:11.0.2.300")
    implementation ("com.huawei.hiai.hiai-engine:huawei-hiai-pdk:11.0.2.300")
    implementation ("com.huawei.hiai.hiai-engine:huawei-hiai-nlu:11.0.2.300")
    implementation ("com.huawei.hiai.hiai-engine:huawei-hiai-asr:11.0.2.300")
}

afterEvaluate {
    publishing {
        publications {
            // 创建名为“release”的Maven发布。
            create<MavenPublication>("release") {
                // 为发布版本应用组件。
                from(components["release"])
                // 通常groupId是您的Gitee或GitHub账户地址。
                groupId = "com.github.shougonyiren"
                // 通常artifactId是指待发布项目的名称，也就是别名。
                artifactId ="SuperResolutionImageCore"
                // 通常version是指待发布项目的版本号，这里是写死的，通常我们取项目versionName。
                version = "0.0.1"
            }
//            // 创建名为“debug”的Maven发布。
//            create<MavenPublication>("debug") {
//                // 为发布版本应用组件。
//                from(components["debug"])
//                groupId = "com.github.hirezy"
//                artifactId = "ShapeImageView-debug"
//                version = "1.0.0"
//            }
        }
    }
}
