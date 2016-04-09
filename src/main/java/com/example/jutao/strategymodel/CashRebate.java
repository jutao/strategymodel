package com.example.jutao.strategymodel;

import com.example.jutao.strategymodel.Factor.CashSuper;

/**
 * 打折收费子类
 */
public class CashRebate extends CashSuper{
  private double moneyRebate=1d;
  public CashRebate(double moneyRebate){
    this.moneyRebate=moneyRebate;
  }
  @Override public double acceptCash(double money) {
    return money*moneyRebate;
  }
}
