package com.airwallet;

import android.app.Application;

 
import com.facebook.react.ReactApplication;
import io.invertase.firebase.RNFirebasePackage;
import io.invertase.firebase.messaging.RNFirebaseMessagingPackage;
import io.invertase.firebase.auth.RNFirebaseAuthPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.github.wumke.RNExitApp.RNExitAppPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.hieuvp.fingerprint.ReactNativeFingerprintScannerPackage;
import com.rnbiometrics.ReactNativeBiometricsPackage;
import com.rnfingerprint.FingerprintAuthPackage;
import com.goldenowl.twittersignin.TwitterSigninPackage;
import org.reactnative.camera.RNCameraPackage;
import org.devio.rn.splashscreen.SplashScreenReactPackage;
import com.horcrux.svg.SvgPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.smixx.fabric.FabricPackage;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.reactnative.androidsdk.FBSDKPackage;
import com.facebook.appevents.AppEventsLogger;

import com.centaurwarchief.smslistener.SmsListenerPackage;
import com.babisoft.ReactNativeLocalization.ReactNativeLocalizationPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private static CallbackManager mCallbackManager = CallbackManager.Factory.create();

  protected static CallbackManager getCallbackManager() {
    return mCallbackManager;
  }

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new RNFirebasePackage(),
            new RNFirebaseMessagingPackage(),
            new RNFirebaseAuthPackage(),
          new RNDeviceInfo(),
          new RNExitAppPackage(),
          new SmsListenerPackage(),
          new LottiePackage(),
          new ReactNativeFingerprintScannerPackage(),
          new ReactNativeBiometricsPackage(),
          new FingerprintAuthPackage(),
          new TwitterSigninPackage(),
          new RNCameraPackage(),
          new SplashScreenReactPackage(),
          new SvgPackage(),
          new VectorIconsPackage(),
          new FBSDKPackage(mCallbackManager),
          new ReactNativeLocalizationPackage(),
          new FabricPackage() 
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    // FacebookSdk.setApplicationId("245759276063469");
    // FacebookSdk.sdkInitialize(this);
    AppEventsLogger.activateApp(this);
    Fabric.with(this, new Crashlytics());
    // SoLoader.init(this, /* native exopackage */ false);
  }
}
