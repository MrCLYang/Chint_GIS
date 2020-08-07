package com.zt.chint_gis.bean;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Time:2020/7/31
 * Author:YCL
 * Description:创建用户Bean
 */
@Entity(tableName = "user_items")//表名
public class UserBean {
    @PrimaryKey@NonNull
    private String UserNumbers;//用户号码
    private String UserName;//用户名
    private String PhoneNumbers;//用户电话
    private String UserAddress;//用户地址
    private String UserType;//用户类型
    private boolean CheckedStatus;//检测状态

    private String GasNumber;//表号
    private String GasType;//表类型
    private String GasAccount;//购入量

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

    public String getPhoneNumbers() {
        return PhoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        PhoneNumbers = phoneNumbers;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getGasNumber() {
        return GasNumber;
    }

    public void setGasNumber(String gasNumber) {
        GasNumber = gasNumber;
    }

    public String getGasType() {
        return GasType;
    }

    public void setGasType(String gasType) {
        GasType = gasType;
    }

    public String getGasAccount() {
        return GasAccount;
    }

    public void setGasAccount(String gasAccount) {
        GasAccount = gasAccount;
    }
}
