package com.zt.chint_gis.bean;

/**
 * Time:2020/7/31
 * Author:YCL
 * Description:创建用户Bean
 */
public class UserBean {
    private String UserNumbers;//用户号码
    private String UserName;//用户名
    private String UserAddress;//用户地址
    private boolean CheckedStatus;//检测状态

    public String getUserNumbers() {
        return UserNumbers;
    }

    public void setUserNumbers(String userNumbers) {
        UserNumbers = userNumbers;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    public boolean isCheckedStatus() {
        return CheckedStatus;
    }

    public void setCheckedStatus(boolean checkedStatus) {
        CheckedStatus = checkedStatus;
    }
}
