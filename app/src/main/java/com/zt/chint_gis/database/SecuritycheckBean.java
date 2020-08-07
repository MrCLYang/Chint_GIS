package com.zt.chint_gis.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 代安检的实体bean
 */
@Entity(tableName = "security_check")
public class SecuritycheckBean {


    public String cons_name;//姓名



    @PrimaryKey@NonNull
    public String cons_no;//户号

    public String cons_emread;//用户表号

    public String cons_during_time;//总用时

    public String cons_check_hourse;//入户

    public String cons_check_reason;//原因

    public String cons_check_img;//入户现场的图片地址

    public String cons_frim_number;//整改单据

    public String cons_frim_star;//打分

    public String cons_frim_img;//整改图片

    public String cons_frim_signtype;//整改单据

    public String cons_frim_signimg;//签字图片

    public String cons_state;


    public String errormsg_a;//问题图片

    public String errortext_a;//图片描述

    public String errormsg_b;

    public String errortext_b;

    public String errormsg_c;

    public String errortext_c;

    public String errormsg_d;

    public String errortext_d;

    public String getCons_name() {
        return cons_name;
    }

    public String getCons_no() {
        return cons_no;
    }

    public String getCons_emread() {
        return cons_emread;
    }

    public String getCons_during_time() {
        return cons_during_time;
    }

    public String getCons_check_hourse() {
        return cons_check_hourse;
    }

    public String getCons_check_reason() {
        return cons_check_reason;
    }

    public String getCons_check_img() {
        return cons_check_img;
    }

    public String getCons_frim_number() {
        return cons_frim_number;
    }

    public String getCons_frim_star() {
        return cons_frim_star;
    }

    public String getCons_frim_img() {
        return cons_frim_img;
    }

    public String getCons_frim_signtype() {
        return cons_frim_signtype;
    }

    public String getCons_frim_signimg() {
        return cons_frim_signimg;
    }

    public String getCons_state() {
        return cons_state;
    }

    public String getErrormsg_a() {
        return errormsg_a;
    }

    public String getErrortext_a() {
        return errortext_a;
    }

    public String getErrormsg_b() {
        return errormsg_b;
    }

    public String getErrortext_b() {
        return errortext_b;
    }

    public String getErrormsg_c() {
        return errormsg_c;
    }

    public String getErrortext_c() {
        return errortext_c;
    }

    public String getErrormsg_d() {
        return errormsg_d;
    }

    public String getErrortext_d() {
        return errortext_d;
    }

    public void setCons_name(String cons_name) {
        this.cons_name = cons_name;
    }

    public void setCons_no(String cons_no) {
        this.cons_no = cons_no;
    }

    public void setCons_emread(String cons_emread) {
        this.cons_emread = cons_emread;
    }

    public void setCons_during_time(String cons_during_time) {
        this.cons_during_time = cons_during_time;
    }

    public void setCons_check_hourse(String cons_check_hourse) {
        this.cons_check_hourse = cons_check_hourse;
    }

    public void setCons_check_reason(String cons_check_reason) {
        this.cons_check_reason = cons_check_reason;
    }

    public void setCons_check_img(String cons_check_img) {
        this.cons_check_img = cons_check_img;
    }

    public void setCons_frim_number(String cons_frim_number) {
        this.cons_frim_number = cons_frim_number;
    }

    public void setCons_frim_star(String cons_frim_star) {
        this.cons_frim_star = cons_frim_star;
    }

    public void setCons_frim_img(String cons_frim_img) {
        this.cons_frim_img = cons_frim_img;
    }

    public void setCons_frim_signtype(String cons_frim_signtype) {
        this.cons_frim_signtype = cons_frim_signtype;
    }

    public void setCons_frim_signimg(String cons_frim_signimg) {
        this.cons_frim_signimg = cons_frim_signimg;
    }

    public void setCons_state(String cons_state) {
        this.cons_state = cons_state;
    }

    public void setErrormsg_a(String errormsg_a) {
        this.errormsg_a = errormsg_a;
    }

    public void setErrortext_a(String errortext_a) {
        this.errortext_a = errortext_a;
    }

    public void setErrormsg_b(String errormsg_b) {
        this.errormsg_b = errormsg_b;
    }

    public void setErrortext_b(String errortext_b) {
        this.errortext_b = errortext_b;
    }

    public void setErrormsg_c(String errormsg_c) {
        this.errormsg_c = errormsg_c;
    }

    public void setErrortext_c(String errortext_c) {
        this.errortext_c = errortext_c;
    }

    public void setErrormsg_d(String errormsg_d) {
        this.errormsg_d = errormsg_d;
    }

    public void setErrortext_d(String errortext_d) {
        this.errortext_d = errortext_d;
    }

    @Override
    public String toString() {
        return "SecuritycheckBean{" +
                "id=" +
                ", cons_name='" + cons_name + '\'' +
                ", cons_no='" + cons_no + '\'' +
                ", cons_emread='" + cons_emread + '\'' +
                ", cons_during_time='" + cons_during_time + '\'' +
                ", cons_check_hourse='" + cons_check_hourse + '\'' +
                ", cons_check_reason='" + cons_check_reason + '\'' +
                ", cons_check_img='" + cons_check_img + '\'' +
                ", cons_frim_number='" + cons_frim_number + '\'' +
                ", cons_frim_star='" + cons_frim_star + '\'' +
                ", cons_frim_img='" + cons_frim_img + '\'' +
                ", cons_frim_signtype='" + cons_frim_signtype + '\'' +
                ", cons_frim_signimg='" + cons_frim_signimg + '\'' +
                ", cons_state='" + cons_state + '\'' +
                ", errormsg_a='" + errormsg_a + '\'' +
                ", errortext_a='" + errortext_a + '\'' +
                ", errormsg_b='" + errormsg_b + '\'' +
                ", errortext_b='" + errortext_b + '\'' +
                ", errormsg_c='" + errormsg_c + '\'' +
                ", errortext_c='" + errortext_c + '\'' +
                ", errormsg_d='" + errormsg_d + '\'' +
                ", errortext_d='" + errortext_d + '\'' +
                '}';
    }
}
