package com.example.jutao.strategymodel;

import com.example.jutao.strategymodel.Factor.CashSuper;

/**
 * 返现收费子类
 */
public class CashReturn extends CashSuper{
  private double  moneyCodition=0.0d;
  private double moneyReturn=0.0d;

  /**
   * @param moneyCodition 返现条件
   * @param moneyReturn   返现值
   * 比如满300返100，则moneyCodition=300，moneyReturn=100
   */
  public CashReturn(double moneyCodition,double moneyReturn){
      this.moneyCodition=moneyCodition;
      this.moneyReturn=moneyReturn;
  }

  @Override public double acceptCash(double money) {
    double result=money;
    if(money>=moneyCodition){
      int floor= (int) (money/moneyCodition);
      result=money-floor*moneyReturn;
    }
    return result;
  }
}
