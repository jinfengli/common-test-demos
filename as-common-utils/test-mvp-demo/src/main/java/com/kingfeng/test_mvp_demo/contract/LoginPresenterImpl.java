package com.kingfeng.test_mvp_demo.contract;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractorImpl.OnLoginFinishedListener {

//    private LoginPresenter presenter;
    private LoginView userLoginView;
    private LoginInteractorImpl interactor;

//    private Handler mHandler = new Handler();

    /**
     * Presenter 完成 Model 和view的交互，那么肯定需要两者的实现类。
     * 大致就是从View中获取需要的参数，交给Model去执行业务方法，执行的过程中需要的反馈，以及结果，再让View进行做对应的显示。
     *
     * @param userLoginView
     */
    public LoginPresenterImpl(LoginView userLoginView) {
        this.userLoginView = userLoginView;
//        this.presenter =  new LoginPresenterImpl(userLoginView);
        interactor = new LoginInteractorImpl();
    }


    public void login() {
//        userLoginView.showLoading();
//        presenter.login(userLoginView.getUserName(), userLoginView.getPassword(), new onLoginListener() {
//            @Override
//            public void loginSuccess(final User user) {
//                //需要在UI线程执行
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        userLoginView.toMainActivity(user);
//                        userLoginView.hideLoading();
//                    }
//                });
//            }
//
//            @Override
//            public void loginFailed() {
//                //需要在UI线程执行
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        userLoginView.showFailedError();
//                        userLoginView.hideLoading();
//                    }
//                });
//            }
//        });


        userLoginView.showLoading();
    }

    @Override
    public void login(final String username, final String password) {
        if(userLoginView != null) {
            userLoginView.showLoading();
        }

        interactor.login(username, password, this);




       /* // 这里面模拟进行网络请求
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("123".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    Log.e("LoginPresenter", "presenter" + username);
                    userLoginView.toMainActivity(user);

//                    loginListener.loginSuccess(user);
                } else {
//                    loginListener.loginFailed();
                    userLoginView.showFailedError();
                }
            }
        }.start();

        userLoginView.hideLoading();*/

    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

    @Override
    public void onUsernameError() {
        if (userLoginView != null) {
            userLoginView.setUserNameError();
            userLoginView.hideLoading();
        }
    }

    @Override
    public void onPasswordError() {
        if (userLoginView != null) {
            userLoginView.setPasswordError();
            userLoginView.hideLoading();
        }
    }

    @Override
    public void onSuccess() {
        if(userLoginView != null) {
            userLoginView.toMainActivity();
        }
        userLoginView.hideLoading();
    }
}
