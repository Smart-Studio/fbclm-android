# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/juanyanezgc/Developer/AndroidSDK/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#Butterknife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

# Retrofit
-keep class retrofit.** { *; }
-keepclasseswithmembers class * {@retrofit.http.* <methods>; }
-dontwarn retrofit.**

# OKHttp
-keep class com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**
-dontwarn okio.*

# Rx Java
-keep class sun.misc.Unsafe { *; }
-dontwarn rx.**

#Retrolambda
-dontwarn java.lang.invoke.**