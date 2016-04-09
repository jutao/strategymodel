package com.example.jutao.strategymodel;

import com.example.jutao.strategymodel.Factor.CashSuper;

/**
 * 正常收费子类
 */
public class CashNormal extends CashSuper {
  @Override public double acceptCash(double money) {
    return money;
  }
}
