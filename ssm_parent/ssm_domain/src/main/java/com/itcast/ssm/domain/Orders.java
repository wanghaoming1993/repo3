package com.itcast.ssm.domain;

import com.itcast.ssm.utils.DateUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable{
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private Integer peopleCount;
    private String orderDesc;
    private  Integer payType;
    private String payTypeStr;
    private Integer orderStatus;
    private String orderStatusStr;
    private Product product;
    private Member member;
    private List<Traveller> list;

    public List<Traveller> getList() {
        return list;
    }

    public void setList(List<Traveller> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime!=null){
            orderTimeStr = DateUtils.toString(orderTime, "yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
       if (payType!=null){
           if (payType==0){
               payTypeStr="支付宝";
           }
           if (payType==1){
               payTypeStr="微信";
           }
           if (payType==2){
               payTypeStr="其他";
           }
       }
       return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
       if (orderStatus!=null){
           if (orderStatus==0){
               orderStatusStr="未支付";
           }
           if (orderStatus==1){
               orderStatusStr="支付";
           }
       }
       return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", product=" + product +
                ", member=" + member +
                ", list=" + list +
                '}';
    }
}
