/*
 * Copyright (C) 2015 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.twitter.sdk.android.mopub;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.mopub.nativeads.BaseNativeAd;
import com.mopub.nativeads.MoPubAdRenderer;
import com.mopub.nativeads.NativeImageHelper;
import com.mopub.nativeads.NativeRendererHelper;
import com.mopub.nativeads.StaticNativeAd;

public class TwitterStaticNativeAdRenderer implements MoPubAdRenderer<StaticNativeAd> {

    @Override
    public View createAdView(final Activity activity, final ViewGroup parent) {
        return new TwitterStaticNativeAd(activity);
    }

    @Override
    public void renderAdView(final View view, final StaticNativeAd staticNativeAd) {
        update((TwitterStaticNativeAd) view, staticNativeAd);
    }

    @Override
    public boolean supports(final BaseNativeAd nativeAd) {
        return nativeAd instanceof StaticNativeAd;
    }

    private void update(final TwitterStaticNativeAd staticNativeView,
            final StaticNativeAd staticNativeAd) {
        NativeRendererHelper.addTextView(staticNativeView.titleView,
                staticNativeAd.getTitle());
        NativeRendererHelper.addTextView(staticNativeView.textView, staticNativeAd.getText());
        NativeRendererHelper.addTextView(staticNativeView.callToActionView,
                staticNativeAd.getCallToAction());
        NativeImageHelper.loadImageView(staticNativeAd.getMainImageUrl(),
                staticNativeView.mainImageView);
        NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(),
                staticNativeView.iconImageView);
        NativeRendererHelper.addPrivacyInformationIcon(
                staticNativeView.privacyInformationIconImageView,
                staticNativeAd.getPrivacyInformationIconImageUrl(),
                staticNativeAd.getPrivacyInformationIconClickThroughUrl());
    }
}
