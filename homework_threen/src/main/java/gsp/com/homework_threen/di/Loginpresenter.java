package gsp.com.homework_threen.di;

import java.lang.ref.SoftReference;

import gsp.com.homework_threen.data.Shoppingbean;


public class Loginpresenter implements Logincontract.Loginpresenter<Logincontract.Loginview> {
    Logincontract.Loginview loginview;
    private SoftReference<Logincontract.Loginview> softReference;
    private Loginmode loginmode;

    @Override
    public void attachview(Logincontract.Loginview loginview) {
        this.loginview=loginview;
        softReference = new SoftReference<>(loginview);
        loginmode = new Loginmode();
    }

    @Override
    public void detachview(Logincontract.Loginview loginview) {
        softReference.clear();
    }

    @Override
    public void resquesData() {
        loginmode.cantainData(new Logincontract.Loginmodel.Callback() {
            @Override
            public void onCallback(Shoppingbean shoppingbean) {
                loginview.shapeData(shoppingbean);
            }

        });
    }
}
