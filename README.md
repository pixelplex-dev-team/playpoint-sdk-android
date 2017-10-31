# PlayPoint SDK for Android

This SDK provides events logging in android file system and send it via request for another application.

## How to use?

  - Add to your App ```AndroidManifest.xml``` activity ```<activity android:name="com.pixelplex.playpointcore.PlayPointActivity" android:exported="true"/>```
  - Override your ```Application``` class and set your app name as application name in Manifest (For example ```android:name=".MyApp"```)
  - In your Application class add ```Logger.initialize(getApplicationContext());``` in ```onCreate()``` method
  
  ## Setting Samples
  
  ### Manifest

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.pixelplex.playpointandroid">

    <application
        android:name=".MyApp"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <activity android:name="com.pixelplex.playpointcore.PlayPointActivity" android:exported="true"/>

    </application>

</manifest>
```