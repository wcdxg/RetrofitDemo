package com.example.retrofitlib.retrofit.view;

import com.imageim.yimirror.bean.AdInfoBean;
import com.imageim.yimirror.bean.ShopConfigInfoBean;

/**
 * Created by Yuaihen.
 * on 2019/7/5
 */
public interface BannerView extends BaseView {

    void setBanner(AdInfoBean adInfoBean);

    void setToken(String token);

    void setShopConfig(ShopConfigInfoBean shopConfig);
}
